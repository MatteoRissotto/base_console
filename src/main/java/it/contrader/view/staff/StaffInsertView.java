
package it.contrader.view.staff;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StaffInsertView extends AbstractView{

	private Request request;
	
	private int idStaff;
	private String nome;
	private String cognome;
	private String email;
	private String posizione;
	private int numeroTelefono;
	private String dataAssunzione;
	private String sede;
	private int oreSettimanali;
	private String codiceFiscale;

	private final String mode = "INSERT";

	public StaffInsertView() {
	}
	
	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Staff", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci idStaff dell'utente:");
			idStaff = getInt();
			System.out.println("Inserisci nome del membro dello staff che ha seguito il corso:");
			nome= getInput();
			System.out.println("Inserisci cognome del membro dello staff che ha seguito il corso:");
			cognome = getInput();
			System.out.println("Inserisci l'email del menbro dello staff che ha seguito il corso:");
			email= getInput();
			System.out.println("Inserisci la posizione  del membro dello staff che ha seguito il corso:");
			posizione = getInput();
			System.out.println("Inserisci numero di telefono del membro dello staff che ha seguito il corso:");
			numeroTelefono = getInt();
			System.out.println("Inserisci dataAssunzione del membro dello staff che ha seguito il corso:");
			dataAssunzione = getInput();
			System.out.println("Inserisci sede del membro dello staff che ha seguito il corso:");
			sede = getInput();
			System.out.println("Inserisci oreSettimanali del membro dello staff che ha seguito il corso:");
			oreSettimanali = getInt();
			System.out.println("Inserisci codiceFiscale del membro dello staff che ha seguito il corso:");
			codiceFiscale = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idStaff", idStaff);
		request.put("nome", nome);
		request.put("cognome", cognome);
		request.put("email", email);
		request.put("posizione", posizione);
		request.put("numero_Telefono", numeroTelefono);
		request.put("data_Assunzione", dataAssunzione);
		request.put("sede", sede);
		request.put("oreSettimanali", oreSettimanali);
		request.put("codiceFiscal", codiceFiscale);

		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Staff", "doControl", request);
	}

}
