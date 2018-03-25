package com.location.lControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;






import com.location.data.ConnexionDB;
import com.location.data.Location;
import com.location.data.Utilisateur;
import com.location.data.Voiture;

public class LocationControl implements ILocation {
	
	Connection dbCon = ConnexionDB.getDbConnexion();
	private UtilisateurControl ctrlU =  new UtilisateurControl();
	private Utilisateur user = new Utilisateur();
	private Voiture voiture = new Voiture();
	private VoitureControl ctrlV = new VoitureControl();
	private Location loc = new Location();
	private List<Location> allLoc = new ArrayList<Location>();

	@Override
	public void addLocation(Location loc) {
		
		String sql = "INSERT INTO `location`( `dateDebut`,"
				+ " `dateFin`, `idVoiture`, `idUser`, `prix`)"
				+ "VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setString(1, loc.getDateDebut());
			ps.setString(2, loc.getDateFin());
			ps.setInt(3, loc.getVoitureConserner().getIdVoiture());
			ps.setInt(4, loc.getUserConserner().getIdUser());
			ps.setInt(5, loc.getPrix());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLocation(int id) {
		String sql = "DELETE FROM `locationvoiture`.`location` WHERE"
				+ " `location`.`idLocation` = ?";
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Location> getLocations() {
		
		String sql = "SELECT * FROM `location`";
		
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();
			while(rs.next()){
				voiture = ctrlV.getVoitureById(rs.getInt(6));
				user = ctrlU.getUserById(rs.getInt(4));
				loc = new Location(
						rs.getInt(1),
						rs.getInt(5),
						rs.getString(2),
						rs.getString(3),
						voiture,
						user);
				allLoc.add(loc);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allLoc;
	}

	@Override
	public Location getLocationById(int id) {
		
		String sql = "SELECT * FROM `location` WHERE `idLocation`=?";
		
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()){
				voiture = ctrlV.getVoitureById(rs.getInt(6));
				user = ctrlU.getUserById(rs.getInt(4));
				loc = new Location(
						rs.getInt(1),
						rs.getInt(5),
						rs.getString(2),
						rs.getString(3),
						voiture,
						user);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loc;
	}

	@Override
	public List<Location> getLocByUserId(int id) {
		
		String sql = "SELECT * FROM `location` WHERE `idUser`=?";
		
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while(rs.next()){
				voiture = ctrlV.getVoitureById(rs.getInt(6));
				user = ctrlU.getUserById(rs.getInt(4));
				loc = new Location(
						rs.getInt(1),
						rs.getInt(5),
						rs.getString(2),
						rs.getString(3),
						voiture,
						user);
				allLoc.add(loc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allLoc;
	}
	
	public List<Location> getLocationByVoitureId(int id){

		String sql = "SELECT * FROM `location` WHERE `idVoiture`=?";
		
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while(rs.next()){
				voiture = ctrlV.getVoitureById(rs.getInt(4));
				user = ctrlU.getUserById(rs.getInt(5));
				loc = new Location(
						rs.getInt(1),
						rs.getInt(6),
						rs.getString(2),
						rs.getString(3),
						voiture,
						user);
				allLoc.add(loc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allLoc;
	}
	
	@Override
	public int calculePrixLoc(Location loc,int nbjour) {
		if(loc.getUserConserner().isFidel() == true){
			loc.setPrix((loc.getVoitureConserner().getPrix()-Location.remisePrix)* nbjour);
			return loc.getPrix();
		}else{
			loc.setPrix(nbjour * loc.getVoitureConserner().getPrix());
			return  loc.getPrix();
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public long calculeLocNbjour(Date debut, Date fin) {
		
		long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
		//debut-date
		Calendar calendar1 = new GregorianCalendar();
		calendar1.set(Calendar.YEAR, debut.getYear());
		calendar1.set(Calendar.MONTH, debut.getMonth());
		calendar1.set(Calendar.DAY_OF_MONTH, debut.getDay());
		Date date1 = calendar1.getTime();
		//fin-date
		Calendar calendar2 = new GregorianCalendar();
		calendar2.set(Calendar.YEAR, fin.getYear());
		calendar2.set(Calendar.MONTH, fin.getMonth());
		calendar2.set(Calendar.DAY_OF_MONTH, fin.getDate());
		Date date2 = calendar2.getTime();
		// Différence
		long diff = Math.abs(date2.getTime() - date1.getTime());
		long numberOfDay = (long)diff/CONST_DURATION_OF_DAY;
		return numberOfDay;
	}

	

	
}
