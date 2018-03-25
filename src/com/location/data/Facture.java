package com.location.data;


public class Facture {

	//PROPRIETES
	private int idFacture;
	private Location loc;
	//CONSTRUCTEUR PAR DEFAUT
	public Facture() {
	
	}

	//CONSTRUCTEUR INITIALISATON
	public Facture(int idFacture ,Location loc) {
		this.idFacture = idFacture;
		this.loc = loc;
	}
	
	
	///SETTER//AND//GETTER
	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}


	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	

}
