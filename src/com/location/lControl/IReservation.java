package com.location.lControl;

import java.util.List;

import com.location.data.Reservation;

public interface IReservation {
	
	public void addRes(Reservation res);
	public List<Reservation> findRes(String mc);
	public void annulerRes(int id);
	public void validerRes(Reservation res);
	public List<Reservation> getRes();
	public Reservation getResById(int id);

}
