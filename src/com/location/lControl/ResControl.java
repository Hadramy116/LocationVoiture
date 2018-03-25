package com.location.lControl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.data.ConnexionDB;
import com.location.data.Facture;
import com.location.data.Location;
import com.location.data.Reservation;
import com.location.data.Utilisateur;
import com.location.data.Voiture;

public class ResControl implements IReservation{

	private Connection dbCon = ConnexionDB.getDbConnexion();
	private List<Reservation> allRes = new ArrayList<Reservation>();
	private Reservation res = new Reservation() ;
	private UtilisateurControl ctrlU = new UtilisateurControl();
	private Utilisateur user = new Utilisateur();
	private VoitureControl ctrlV = new VoitureControl();
	private Voiture  v = new Voiture();
	private Location loc = new Location();
	private LocationControl ctrlL = new LocationControl();
	private long nbJour;
	 
	 
	
	@Override
	public void addRes(Reservation res) {
		
		String sql = "INSERT INTO `reservation`( `username`, `userage`, "
				+ "`marqueVoiture`, `matriculVoiture`, `userPhone`,"
				+ " `dateDebut`, `dateFin`,`idUser`, `idVoiture`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setString(1, res.getUser().getName());
			ps.setInt(2, res.getUser().getAge());
			ps.setString(3, res.getVoiturRes().getMarque());
			ps.setString(4, res.getVoiturRes().getMatricul());
			ps.setInt(5, res.getUser().getPhone());
			
			java.sql.Date dateD = new java.sql.Date(res.getDateDebut().getTime());
			java.sql.Date dateF = new java.sql.Date(res.getDateFin().getTime());
			
			ps.setDate(6,dateD);
			ps.setDate(7,dateF);
			
			ps.setInt(8, res.getUser().getIdUser());
			ps.setInt(9, res.getVoiturRes().getIdVoiture());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void annulerRes(int id) {
		String sql = "DELETE FROM `locationvoiture`.`reservation` WHERE"
				+ " `reservation`.`idRes` = ?";
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
	public void validerRes(Reservation res) {
		
		nbJour = ctrlL.calculeLocNbjour(res.getDateDebut(),res.getDateFin());
		loc = new Location(0, 0, res.getDateDebut().toString(), res.getDateDebut().toString(),
				res.getVoiturRes(), res.getUser());
		loc.setPrix(ctrlL.calculePrixLoc(loc, (int) nbJour));
		ctrlL.addLocation(loc);
	}

	@Override
	public List<Reservation> getRes() {
		
		String sql = "SELECT * FROM `reservation`";
			
			try {
				PreparedStatement ps = dbCon.prepareStatement(sql);
				ResultSet rs;
				rs = ps.executeQuery();
				while(rs.next()){
					user = ctrlU.getUserByName(rs.getString(2));
					v = ctrlV.getVoitureByMatricul(rs.getString(5));
					res = new Reservation(
								rs.getInt(1),
								user,
								v,
								rs.getDate(7),
								rs.getDate(8));
					allRes.add(res);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return allRes;
	}

	@Override
	public Reservation getResById(int id) {
		String sql = "SELECT * FROM `reservation` WHERE `idRes`=?";
				
				try {
					PreparedStatement ps = dbCon.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs;
					rs = ps.executeQuery();
					if(rs.next()){
						user = ctrlU.getUserById(rs.getInt(9));
						v = ctrlV.getVoitureByMatricul(rs.getString(5));
		
						res = new Reservation();
						res.setIdRes(rs.getInt(1));
						res.setUser(user);
						res.setVoiturRes(v);
						res.setDateDebut(rs.getDate(7));
						res.setDateFin(rs.getDate(8));
						
					}
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return res;
	}

	@Override
	public List<Reservation> findRes(String mc) {
		
		String  sql = "SELECT * FROM `reservation` WHERE (username"
				+ " like ? )or"
				+ "(marqueVoiture like ?) or"
				+ "(matriculVoiture like ?)";
		
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setString(1, "%"+mc+"%");
			ps.setString(2, "%"+mc+"%");
			ps.setString(3, "%"+mc+"%");
			
			ResultSet rs;
			rs = ps.executeQuery();
			while(rs.next()){
				user = ctrlU.getUserByName(rs.getString(2));
				v = ctrlV.getVoitureByMatricul(rs.getString(5));
				res = new Reservation(
							rs.getInt(1),
							user,
							v,
							rs.getDate(7),
							rs.getDate(8));
				allRes.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allRes;
	}

}
