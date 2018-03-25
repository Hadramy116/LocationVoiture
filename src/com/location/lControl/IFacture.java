package com.location.lControl;

import java.util.List;

import com.location.data.Facture;

public interface IFacture {
	
	public void addFacture(Facture f);
	public void  deleteFacture(int id);
	public List<Facture> getFactures();
	public Facture getFactById(int id);
	public Facture getFactureByLocId(int id);
	public void imprimerFacture(Facture f);
	
}
