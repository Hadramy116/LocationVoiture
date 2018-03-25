package com.location.lControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.data.ConnexionDB;
import com.location.data.Voiture;

public class VoitureControl implements IVoiture{

	Connection dbCon = ConnexionDB.getDbConnexion();
	List<Voiture> voitures = new ArrayList<Voiture>();
	Voiture voiture;
	
	public void addVoiture(Voiture v) {
		
		String sql = "INSERT INTO `voiture`( `marque`,"
				+ " `model`, `matricul`, `color`, "
				+ "`kilometrage`, `carburant`, `boiteVitess`, "
				+ "`prix`, `image`, `etat`, `assurence`)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
	
			try {
				PreparedStatement ps = dbCon.prepareStatement(sql);
				ps.setString(1, v.getMarque());
				ps.setString(2, v.getModel());
				ps.setString(3, v.getMatricul());
				ps.setString(4, v.getColor());
				ps.setInt(5, v.getKilometrage());
				ps.setString(6, v.getCarburant());
				ps.setString(7,v.getBoiteVitess());
				ps.setInt(8, v.getPrix());
				ps.setString(9, v.getImage());
				ps.setString(10, v.getEtat());
				ps.setString(11, v.getAssurence());
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public List<Voiture> getVoiture() {
		
		String sql = "SELECT * FROM `voiture`";
		
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();
			while(rs.next()){
				voiture = new Voiture(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6),
								rs.getString(7),
								rs.getString(8),
								rs.getInt(9),
								rs.getString(10),
								rs.getString(11),
								rs.getString(12)
							);
				voitures.add(voiture);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return voitures;
	}

	@Override
	public List<Voiture> getVoitureByMarque(String marque) {
		
		String sql = "SELECT * FROM `voiture` WHERE `marque`=?";
				
				try {
					PreparedStatement ps = dbCon.prepareStatement(sql);
					ps.setString(1, marque);
					ResultSet rs;
					rs = ps.executeQuery();
					while(rs.next()){
						voiture = new Voiture(
										rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getInt(6),
										rs.getString(7),
										rs.getString(8),
										rs.getInt(9),
										rs.getString(10),
										rs.getString(11),
										rs.getString(12)
									);
						voitures.add(voiture);
					}
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return voitures;
	}

	@Override
	public Voiture getVoitureById(int id) {
		String sql = "SELECT * FROM `voiture` WHERE `idVoiture`=?";
			
			try {
				PreparedStatement ps = dbCon.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs;
				rs = ps.executeQuery();
				if(rs.next()){
					voiture = new Voiture(
									rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getInt(6),
									rs.getString(7),
									rs.getString(8),
									rs.getInt(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12)
					);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return voiture;
	}
	
	@Override
	public Voiture getVoitureByMatricul(String matricul) {
		
		String sql = "SELECT * FROM `voiture` WHERE `matricul` like ?";
		
			try {
				PreparedStatement ps = dbCon.prepareStatement(sql);
				ps.setString(1, matricul);
				ResultSet rs;
				rs = ps.executeQuery();
				if(rs.next()){
					voiture = new Voiture(
									rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getInt(6),
									rs.getString(7),
									rs.getString(8),
									rs.getInt(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12)
								);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return voiture;
	}

	@Override
	public List<Voiture> findVoiture(String mc) {
		String sql = "SELECT * FROM `voiture` WHERE (`marque` LIKE ?) or "
				+ "(`model` LIKE ?) or  (`matricul` LIKE ?)";
		
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setString(1, "%"+mc+"%");
			ps.setString(2, "%"+mc+"%");
			ps.setString(3, "%"+mc+"%");
			
			ResultSet rs;
			rs = ps.executeQuery();
			while(rs.next()){
				voiture = new Voiture(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6),
								rs.getString(7),
								rs.getString(8),
								rs.getInt(9),
								rs.getString(10),
								rs.getString(11),
								rs.getString(12)
							);
				voitures.add(voiture);
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return voitures;
	}

	@Override
	public void updateVoiture(Voiture v,int id) {
		
		String sql= "UPDATE `voiture` SET "
				+ "`marque`=?,`model`=?,`matricul`=?,"
				+ "`color`=?,`kilometrage`=?,`carburant`=?,`boiteVitess`=?,"
				+ "`prix`=?,`image`=? ,`etat`=? ,`assurence`=?"
				+ "WHERE `idVoiture`=?";
		try {
			PreparedStatement ps = dbCon.prepareStatement(sql);
			ps.setString(1, v.getMarque());
			ps.setString(2, v.getModel());
			ps.setString(3, v.getMatricul());
			ps.setString(4,v.getColor());
			ps.setInt(5, v.getKilometrage());
			ps.setString(6, v.getCarburant());
			ps.setString(7,v.getBoiteVitess());
			ps.setInt(8,v.getPrix());
			ps.setString(9,v.getImage());
			ps.setString(10,v.getEtat());
			ps.setString(11,v.getAssurence());
			
			ps.setInt(12, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteVoiture(int id) {
		
		String sql = "DELETE FROM `locationvoiture`.`voiture` WHERE"
				+ " `voiture`.`idVoiture` = ?";
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
	public String getEtat() {
		return null;
	}

}
