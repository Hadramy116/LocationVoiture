package com.location.data;

import java.util.Date;


public class Reservation {
	
	private int idRes;
	private Utilisateur user ;
	private Voiture voiturRes;
	private Date  dateDebut;
	private Date  dateFin;
	
	
	public Reservation() {
		
	}
	
	public Reservation(int idRes, Utilisateur user,
			Voiture v,
			Date dateDebut, Date dateFin) {
		this.idRes = idRes;
		this.user = user;
		this.voiturRes = v;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}


	public int getIdRes() {
		return idRes;
	}


	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}


	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public Voiture getVoiturRes() {
		return voiturRes;
	}


	public void setVoiturRes(Voiture voiturRes) {
		this.voiturRes = voiturRes;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
