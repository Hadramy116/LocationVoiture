package com.location.data;

public class Voiture {
	//VOITURE PROPRIETES
	private int idVoiture;//Auto_increment
	private String marque;
	private String model;
	private String matricul;
	private String color;
	private int kilometrage;
	private String carburant;
	private String boiteVitess;
	private int prix;
	private String image;
	private String etat;
	private String assurence;
	
		//Constructeur par defaut
	public Voiture() {
		
		
	}
	
	//Constructure Initialisation
	public Voiture(int idVoiture, String marque, String model, String matricul, String color,
			int kilometrage,
			String carburant, String boiteVitess, int prix, String image,
			String etat, String assurence) {
		
		this.idVoiture = idVoiture;
		this.marque = marque;
		this.model = model;
		this.matricul = matricul;
		this.color = color;
		this.setKilometrage(kilometrage);
		this.carburant = carburant;
		this.boiteVitess = boiteVitess;
		this.prix = prix;
		this.image = image;
		this.etat = etat;
		this.assurence = assurence;
	}
	
	////SETTER///&&//GETTER
	
	public int getIdVoiture() {
		return idVoiture;
	}
	
	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}
	
	public String getMarque() {
		return marque;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getMatricul() {
		return matricul;
	}
	
	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getCarburant() {
		return carburant;
	}
	
	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}
	
	public String getBoiteVitess() {
		return boiteVitess;
	}
	
	public void setBoiteVitess(String boiteVitess) {
		this.boiteVitess = boiteVitess;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getEtat() {
		return etat;
	}
	
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public String getAssurence() {
		return assurence;
	}
	
	public void setAssurence(String assurence) {
		this.assurence = assurence;
	}
}///FIN VOITURE
