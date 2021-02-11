package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Candidati;

public class CandidatiDAO {

	private final String QUERY_ALL = "SELECT * FROM Candidati";
	private final String QUERY_CREATE = "INSERT INTO Candidati (idStaff, nome, cognome,email,provenienza,telefono,titoloStudio,titoloLaurea,dataCandidatura, rangeCandidatura,candidatiTramite,colloquioConoscitivo, idoneit�,codiceFiscale) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM Candidati WHERE idCandidati=?";
	private final String QUERY_UPDATE = "UPDATE Candidati SET idStaff = ?, nome = ?, cognome = ?,email = ?,provenienza = ?,telefono = ?,titoloStudio = ?,titoloLaurea = ?,dataCandidatura = ?, rangeCandidatura = ?,candidatiTramite = ?,colloquioConoscitivo = ?, idoneit� = ?,codiceFiscale = ?  WHERE idCandidati=?";
	private final String QUERY_DELETE = "DELETE FROM Candidati WHERE idCandidati=?";

	public CandidatiDAO() {

	}
	
	public List<Candidati> getAll() {
		  List<Candidati> candidatiList = new ArrayList<>();
		  Connection connection = ConnectionSingleton.getInstance();
		  try {
		   Statement statement = connection.createStatement();
		   ResultSet resultSet = statement.executeQuery(QUERY_ALL);
		   Candidati candidati;
		   while (resultSet.next()) {
		    int id = resultSet.getInt("idCandidati");
		    int idStaff = resultSet.getInt("idStaff");
		    String nome = resultSet.getString("nome");
		    String cognome = resultSet.getString("cognome");
		    String email = resultSet.getString("email");
		    String luogoProvenienza = resultSet.getString("provenienza");
		    int numero_telefono = resultSet.getInt("telefono");
		    String titoloStudio = resultSet.getString("titoloStudio");
		    String titoloLaurea = resultSet.getString("titoloLaurea");
		    String dataCandidatura = resultSet.getString("dataCandidatura");
		    String rangeCandidatura = resultSet.getString("rangeCandidatura");
		    boolean colloquioConoscitivo = resultSet.getBoolean("colloquioConoscitivo");
		    String candidatiTramite = resultSet.getString("candidatiTramite");
		    boolean idoneita = resultSet.getBoolean("idoneit�");
		    String codiceFiscale = resultSet.getString("codiceFiscale");
		    String usertype = resultSet.getString("usertype");
		    candidati = new Candidati(idStaff, nome, cognome, email, luogoProvenienza, numero_telefono,
		      titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo,
		      candidatiTramite, idoneita, codiceFiscale, usertype);
		    candidati.setIdCandidati(id);
		    candidatiList.add(candidati);
		   }
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return candidatiList;
		 }

	public boolean insert(Candidati c) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, c.getIdStaff());
			preparedStatement.setString(2, c.getNome());
			preparedStatement.setString(3, c.getCognome());
			preparedStatement.setInt(4, c.getIdStaff());
			preparedStatement.setString(5, c.getEmail());
			preparedStatement.setString(6, c.getLuogoProvenienza());
			preparedStatement.setInt(7, c.getNumero_telefono());
			preparedStatement.setString(8, c.getTitoloStudio());
			preparedStatement.setString(9, c.getTitoloLaurea());
			preparedStatement.setString(10, c.getDataCandidatura());
			preparedStatement.setString(11, c.getRangeCandidatura());
			preparedStatement.setString(12, c.getCandidatiTramite());
			preparedStatement.setBoolean(13, c.getColloquioConoscitivo());
			preparedStatement.setBoolean(14, c.getIdoneita());
			preparedStatement.setString(12, c.getCodiceFiscale());

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Candidati read(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			int idCandidati = resultSet.getInt("idCandidati");
			int idStaff = resultSet.getInt("idStaff");
			String nome = resultSet.getString("nome");
			String cognome = resultSet.getString("cognome");
			String email = resultSet.getString("email");
			String luogoProvenienza = resultSet.getString("provenienza");
			int numero_telefono = resultSet.getInt("telefono");
			String titoloStudio = resultSet.getString("titoloStudio");
			String titoloLaurea = resultSet.getString("titoloLaurea");
			String dataCandidatura = resultSet.getString("dataCandidatura");
			String rangeCandidatura = resultSet.getString("rangeCandidatura");
			boolean colloquioConoscitivo = resultSet.getBoolean("colloquioConoscitivo");
			String candidatiTramite = resultSet.getString("candidatiTramite");
			boolean idoneita = resultSet.getBoolean("idoneit�");
			;
			String codiceFiscale = resultSet.getString("codiceFiscale");
			String usertype = resultSet.getString("usertype");

			Candidati candidati = new Candidati(idStaff, nome, cognome, email, luogoProvenienza, numero_telefono,
					titoloStudio, titoloLaurea, dataCandidatura, rangeCandidatura, colloquioConoscitivo,
					candidatiTramite, idoneita, codiceFiscale, usertype);
			candidati.setIdCandidati(idCandidati);

			return candidati;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Candidati c) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (c.getIdCandidati() == 0)
			return false;

		Candidati candidatileggi = read(c.getIdCandidati());
		if (!candidatileggi.equals(c)) {
			try {
				// Fill the userToUpdate object
				if (c.getIdStaff() == 0) {
					c.setIdStaff(candidatileggi.getIdStaff());
				}

				if (c.getNome() == null || c.getNome().equals("")) {
					c.setNome(candidatileggi.getNome());
				}

				if (c.getCognome() == null || c.getCognome().equals("")) {
					c.setCognome(candidatileggi.getCognome());
				}
				if (c.getEmail() == null || c.getEmail().equals("")) {
					c.setEmail(candidatileggi.getEmail());
				}

				if (c.getLuogoProvenienza() == null || c.getLuogoProvenienza().equals("")) {
					c.setLuogoProvenienza(candidatileggi.getLuogoProvenienza());
				}

				if (c.getNumero_telefono() == 0) {
					c.setNumero_telefono(candidatileggi.getNumero_telefono());
				}
				if (c.getTitoloStudio() == null || c.getTitoloStudio().equals("")) {
					c.setTitoloStudio(candidatileggi.getTitoloStudio());
				}

				if (c.getTitoloLaurea() == null || c.getTitoloLaurea().equals("")) {
					c.setTitoloLaurea(candidatileggi.getTitoloLaurea());
				}

				if (c.getDataCandidatura() == null || c.getDataCandidatura().equals("")) {
					c.setDataCandidatura(candidatileggi.getDataCandidatura());
				}
				if (c.getRangeCandidatura() == null || c.getRangeCandidatura().equals("")) {
					c.setRangeCandidatura(candidatileggi.getRangeCandidatura());
				}

				if (c.getCandidatiTramite() == null || c.getCandidatiTramite().equals("")) {
					c.setCandidatiTramite(candidatileggi.getCandidatiTramite());
				}

				if (c.getColloquioConoscitivo() == false) {
					c.setColloquioConoscitivo(candidatileggi.getColloquioConoscitivo());
				}
				if (c.getIdoneita()== false) {
					c.setIdoneita(candidatileggi.getIdoneita());
				}

				if (c.getCodiceFiscale() == null || c.getCodiceFiscale().equals("")) {
					c.setCodiceFiscale(candidatileggi.getCodiceFiscale());
				}

				

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, c.getIdStaff());
				preparedStatement.setString(2, c.getNome());
				preparedStatement.setString(3, c.getCognome());
				preparedStatement.setString(4, c.getEmail());
				preparedStatement.setString(5, c.getLuogoProvenienza());
				preparedStatement.setInt(6, c.getNumero_telefono());
				preparedStatement.setString(7, c.getTitoloStudio());
				preparedStatement.setString(8, c.getTitoloLaurea());
				preparedStatement.setString(9, c.getDataCandidatura());
				preparedStatement.setString(10, c.getRangeCandidatura());
				preparedStatement.setString(11, c.getCandidatiTramite());
				preparedStatement.setBoolean(12, c.getColloquioConoscitivo());
				preparedStatement.setBoolean(13, c.getIdoneita());
				preparedStatement.setString(14, c.getCodiceFiscale());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}
