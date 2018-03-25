package com.location.lControl;

import java.util.List;

import com.location.data.Voiture;

public interface IVoiture {
	
	public void addVoiture(Voiture v);
	public List<Voiture> getVoiture();
	public List<Voiture> getVoitureByMarque(String marque);
	public Voiture getVoitureByMatricul(String matricul);
	public Voiture getVoitureById(int id);
	public List<Voiture> findVoiture(String mc);
	public void updateVoiture(Voiture v,int id);
	public void deleteVoiture(int id);
	public String getEtat();
}
