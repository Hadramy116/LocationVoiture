package com.location.data;

public class Location {

	///PROPRIETE
	private int idLocation;
	private int prix;
	private String dateDebut;
	private String dateFin;
	private Voiture voitureConserner;
	private Utilisateur userConserner;
	public final static int remisePrix = 2000;
	
	//CONSTRUCTOR DEFAULT
	public Location() {
		
	}

	///INITIALISATION 
	public Location(int idLoc,int prix, String dateDebut, String dateFin,
			Voiture v,Utilisateur user) {
		this.idLocation = idLoc;
		this.prix = prix;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.voitureConserner = v;
		this.userConserner = user;
	}
	
	///SETTER//&&//GETTER

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setStringFin(String dateFin) {
		this.dateFin =dateFin;
	}

	public Voiture getVoitureConserner() {
		return voitureConserner;
	}

	public void setVoitureConserner(Voiture voitureConserner) {
		this.voitureConserner = voitureConserner;
	}

	public Utilisateur getUserConserner() {
		return userConserner;
	}

	public void setUserConserner(Utilisateur userConserner) {
		this.userConserner = userConserner;
	}
}