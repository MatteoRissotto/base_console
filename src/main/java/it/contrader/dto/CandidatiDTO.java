package it.contrader.dto;


public class CandidatiDTO{
	private int idCandidati;
	private int idStaff;
	private String nome;
	private String cognome;
	private String email;
	private String luogoProvenienza;
	private int numero_telefono;
	private String titoloStudio;
	private String titoloLaurea;
	private String dataCandidatura;
	private String rangeCandidatura;
	private boolean colloquioConoscitivo;
	private String candidatiTramite;
	private boolean idoneita;
	private String codiceFiscale;
	private String usertype;
	
	public CandidatiDTO() {
		
	}
	public CandidatiDTO(int id_S,String name,String cog,String Email,String luogo,int numero,String titolo_s,String titolo_l,String data, 
			String range,boolean collo_cono,String candidati,boolean idonei,String codice, String usertype ) {
		
		this.usertype=usertype;
		idStaff=id_S;
		nome=name;
		cognome=cog;
		email=Email;
		luogoProvenienza=luogo;
		numero_telefono=numero;
		titoloStudio=titolo_s;
		titoloLaurea=titolo_l;
		dataCandidatura=data;
		rangeCandidatura= range;
		colloquioConoscitivo= collo_cono;
		candidatiTramite=candidati;
		idoneita=idonei;
		codiceFiscale=codice;
		
	}
	public CandidatiDTO(int idCandidati,int id_S,String name,String cog,String Email,String luogo,int numero,String titolo_s,String titolo_l,String data, 
			String range,boolean collo_cono,String candidati,boolean idonei,String codice, String usertype ) {
		this.idCandidati=idCandidati;
		this.usertype=usertype;
		idStaff=id_S;
		nome=name;
		cognome=cog;
		email=Email;
		luogoProvenienza=luogo;
		numero_telefono=numero;
		titoloStudio=titolo_s;
		titoloLaurea=titolo_l;
		dataCandidatura=data;
		rangeCandidatura= range;
		colloquioConoscitivo= collo_cono;
		candidatiTramite=candidati;
		idoneita=idonei;
		codiceFiscale=codice;
		
	}
	
	
	public void setUsertype(String usertype) {
		this.usertype=usertype;
	}
	
	public String getUsertype() {
		return usertype;
		
	}
	
	
	
	
	
	public void setIdCandidati(int idCandidati) {
		this.idCandidati=idCandidati;
	}
	
	public int getIdCandidati() {
		return idCandidati;
		
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLuogoProvenienza() {
		return luogoProvenienza;
	}

	public void setLuogoProvenienza(String luogoProvenienza) {
		this.luogoProvenienza = luogoProvenienza;
	}

	public int getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(int numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	public String getTitoloStudio() {
		return titoloStudio;
	}

	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}

	public String getTitoloLaurea() {
		return titoloLaurea;
	}

	public void setTitoloLaurea(String titoloLaurea) {
		this.titoloLaurea = titoloLaurea;
	}

	public String getDataCandidatura() {
		return dataCandidatura;
	}

	public void setDataCandidatura(String dataCandidatura) {
		this.dataCandidatura = dataCandidatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidatiTramite == null) ? 0 : candidatiTramite.hashCode());
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + (colloquioConoscitivo ? 1231 : 1237);
		result = prime * result + ((dataCandidatura == null) ? 0 : dataCandidatura.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idCandidati;
		result = prime * result + idStaff;
		result = prime * result + (idoneita ? 1231 : 1237);
		result = prime * result + ((luogoProvenienza == null) ? 0 : luogoProvenienza.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero_telefono;
		result = prime * result + ((rangeCandidatura == null) ? 0 : rangeCandidatura.hashCode());
		result = prime * result + ((titoloLaurea == null) ? 0 : titoloLaurea.hashCode());
		result = prime * result + ((titoloStudio == null) ? 0 : titoloStudio.hashCode());
		result = prime * result + ((usertype == null) ? 0 : usertype.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatiDTO other = (CandidatiDTO) obj;
		if (candidatiTramite == null) {
			if (other.candidatiTramite != null)
				return false;
		} else if (!candidatiTramite.equals(other.candidatiTramite))
			return false;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (colloquioConoscitivo != other.colloquioConoscitivo)
			return false;
		if (dataCandidatura == null) {
			if (other.dataCandidatura != null)
				return false;
		} else if (!dataCandidatura.equals(other.dataCandidatura))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idCandidati != other.idCandidati)
			return false;
		if (idStaff != other.idStaff)
			return false;
		if (idoneita != other.idoneita)
			return false;
		if (luogoProvenienza == null) {
			if (other.luogoProvenienza != null)
				return false;
		} else if (!luogoProvenienza.equals(other.luogoProvenienza))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero_telefono != other.numero_telefono)
			return false;
		if (rangeCandidatura == null) {
			if (other.rangeCandidatura != null)
				return false;
		} else if (!rangeCandidatura.equals(other.rangeCandidatura))
			return false;
		if (titoloLaurea == null) {
			if (other.titoloLaurea != null)
				return false;
		} else if (!titoloLaurea.equals(other.titoloLaurea))
			return false;
		if (titoloStudio == null) {
			if (other.titoloStudio != null)
				return false;
		} else if (!titoloStudio.equals(other.titoloStudio))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}
	public String getRangeCandidatura() {
		return rangeCandidatura;
	}

	public void setRangeCandidatura(String rangeCandidatura) {
		this.rangeCandidatura = rangeCandidatura;
	}

	public boolean getColloquioConoscitivo() {
		return colloquioConoscitivo;
	}

	public void setColloquioConoscitivo(boolean colloquioConoscitivo) {
		this.colloquioConoscitivo = colloquioConoscitivo;
	}

	public String getCandidatiTramite() {
		return candidatiTramite;
	}

	public void setCandidatiTramite(String candidatiTramite) {
		this.candidatiTramite = candidatiTramite;
	}

	public boolean getIdoneita() {
		return idoneita;
	}

	public void setIdoneita(boolean idoneita) {
		this.idoneita = idoneita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	
	
	@Override
	public String toString() {
		return  idCandidati + "\t"  + idStaff +"\t\t" +   nome + "\t\t" + cognome + "\t\t" + email + "\t"  + luogoProvenienza +"\t\t" +   numero_telefono + "\t\t" + titoloStudio +"\t\t" +   titoloLaurea + "\t\t" + dataCandidatura + "\t\t" + rangeCandidatura + "\t"  + colloquioConoscitivo +"\t\t" +   candidatiTramite + "\t\t"  + idoneita +"\t\t" +   codiceFiscale + "\t\t" +   usertype + "\t\t";
	}
}
