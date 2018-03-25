package com.location.lControl;

import java.util.Date;
import java.util.List;

import com.location.data.Location;

public interface ILocation {
	
	public void addLocation(Location loc);
	public void deleteLocation(int id);
	public List<Location> getLocations();
	public List<Location> getLocByUserId(int id);
	public List<Location> getLocationByVoitureId(int id);
	public Location getLocationById(int id);
	public long calculeLocNbjour(Date  debut,Date fin);
	public int calculePrixLoc(Location loc, int nbjour);
	
}
