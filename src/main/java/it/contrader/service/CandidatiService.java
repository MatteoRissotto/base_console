package it.contrader.service;


import java.util.List;
import it.contrader.converter.CandidatiConverter;
import it.contrader.dao.CandidatiDAO;
import it.contrader.dto.CandidatiDTO;

public class CandidatiService {


	private CandidatiDAO candidatidao;
	private CandidatiConverter candidaticonverter;
	
	//Istanzio DAO  e Converter specifici.
	public CandidatiService(){
		this.candidatidao = new CandidatiDAO();
		this.candidaticonverter = new CandidatiConverter();
	}
	

	public List<CandidatiDTO> getAll() {
		// Ottiene una lista di entit� e le restituisce convertendole in DTO
		return candidaticonverter.toDTOList(candidatidao.getAll());
	}


	public CandidatiDTO read(int id) {
		// Ottiene un'entit� e la restituisce convertendola in DTO
		return candidaticonverter.toDTO(candidatidao.read(id));
	}


	public boolean insert(CandidatiDTO dto) {
		// Converte un DTO in entit� e lo passa al DAO per l'inserimento
		return candidatidao.insert(candidaticonverter.toEntity(dto));
	}


	public boolean update(CandidatiDTO dto) {
		// Converte un userDTO in entit� e lo passa allo userDAO per la modifica
		return candidatidao.update(candidaticonverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return candidatidao.delete(id);
	}
}
