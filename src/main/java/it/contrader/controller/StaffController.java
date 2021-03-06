package it.contrader.controller;

import java.util.List;

import it.contrader.dto.StaffDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.StaffService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class StaffController implements Controller {

	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "staff.";
	
	private StaffService staffService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public StaffController() {
		this.staffService = new StaffService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e pu� essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalit� corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		 int idStaff = 0;
		 String nome;
		 String cognome;
		 String email;
		 String posizione;
		 String data_assunzione = null;
		 int numero_telefono;
		 String sede;
		 int ore_settimanali;
		 String codiceFiscale;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			idStaff = Integer.parseInt(request.get("idstaff").toString());
			StaffDTO staffDto = staffService.read(idStaff);
			request.put("staff", staffDto);
			MainDispatcher.getInstance().callView(sub_package + "StaffRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			
			nome= request.get("nome").toString();
			cognome= request.get("cognome").toString();
			email = request.get("email").toString();
			posizione = request.get("posizione").toString();
            data_assunzione=request.get("data_assunzione").toString();
			numero_telefono= Integer.parseInt(request.get("numero_telefono").toString());
			sede= request.get("sede").toString();
			ore_settimanali= Integer.parseInt(request.get("ore_settimanali").toString());
			codiceFiscale = request.get("codiceFiscale").toString();
			
			//costruisce l'oggetto user da inserire
			StaffDTO stafftoinsert = new StaffDTO(idStaff, nome,cognome,email,posizione,data_assunzione,numero_telefono,sede,ore_settimanali,codiceFiscale);
			//invoca il service
			staffService.insert(stafftoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "StaffInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idStaff = Integer.parseInt(request.get("idStaff").toString());
			//Qui chiama il service
			staffService.delete(idStaff);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StaffDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idStaff = Integer.parseInt(request.get("idStaff").toString());
			nome= request.get("nome").toString();
			cognome= request.get("cognome").toString();
			email = request.get("email").toString();
			posizione = request.get("posizione").toString();
			numero_telefono= Integer.parseInt(request.get("numero_telefono").toString());
			sede= request.get("sede").toString();
			ore_settimanali= Integer.parseInt(request.get("ore_settimanali").toString());
			codiceFiscale = request.get("codiceFiscale").toString();
			
			//costruisce l'oggetto user da inserire
			StaffDTO stafftoupdate = new StaffDTO(idStaff, nome,cognome,email,posizione,data_assunzione,numero_telefono,sede,ore_settimanali,codiceFiscale);
			//invoca il service
			staffService.insert(stafftoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StaffUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "STAFFLIST":
			List<StaffDTO> staff1 = staffService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("staff", staff1);
			MainDispatcher.getInstance().callView("Staff", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "StaffRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "StaffInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "StaffUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "StaffDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
