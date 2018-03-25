package com.location.lControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.data.ConnexionDB;
import com.location.data.Utilisateur;

public class UtilisateurControl implements IUtilisateuer{
	
	Connection bdCon = ConnexionDB.getDbConnexion();
	List<Utilisateur> users = new ArrayList<Utilisateur>();
	Utilisateur user = new Utilisateur();

	@SuppressWarnings("unused")
	@Override
	public boolean addUser(Utilisateur _user) {
		String sql = "INSERT INTO `utilisateur`"
				+ "(`name`, `prenom`, `age`, "
				+ "`permis`, `fidel`, `nni`, "
				+ "`isAdmin`, `login`, `password`,`phone`)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
		user = this.getUserByLogin(_user.getLogin());
	
		if(_user == null)
			return false;
		else if(user.getLogin() == null){
			try {
				PreparedStatement ps = bdCon.prepareStatement(sql);
				ps.setString(1, _user.getName());
				ps.setString(2, _user.getPrenom());
				ps.setInt(3, _user.getAge());
				ps.setString(4, _user.getPermis());
				ps.setBoolean(5, _user.isFidel());
				ps.setInt(6, _user.getNni());
				ps.setInt(7, _user.getIsAdmin());
				ps.setString(8, _user.getLogin());
				ps.setString(9, _user.getPassword());
				ps.setInt(10, _user.getPhone());
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		} else
			return false;
	}

	@Override
	public List<Utilisateur> getUsers() {
		String sql = "SELECT * FROM `utilisateur`";
		
		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();
			while(rs.next()){
				user = new Utilisateur(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getInt(4),
							rs.getString(5),
							rs.getBoolean(6),
							rs.getInt(7),
							rs.getInt(8),
							rs.getString(9),
							rs.getString(10),
							rs.getInt(11));
				user.setIdUser(rs.getInt(1));
				users.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public Utilisateur getUserById(int id) {
		String sql = "SELECT * FROM `utilisateur` WHERE `idUser`=?";
		
		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()){
				user = new Utilisateur(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getBoolean(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11));
			}
			ps.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return user;
	}
	@Override
	public Utilisateur getUserByLogin(String login) {
		String sql = "SELECT * FROM `utilisateur` WHERE `login`=?";
		
		if(login == null){
			return  null;
		}
		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ps.setString(1, login);
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()){
				user = new Utilisateur(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getBoolean(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11));
				user.setIdUser(rs.getInt(1));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	 return user;
	}

	@Override
	public Utilisateur getUserByName(String name) {
		String sql = "SELECT * FROM `utilisateur` WHERE `name`=?";
		
		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()){
				user = new Utilisateur(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getBoolean(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return user;
	}

	@Override
	public void deleteUser(int id) {
		String sql = "DELETE FROM `locationvoiture`.`utilisateur` WHERE"
				+ " `utilisateur`.`idUser` = ?";
		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void updateUser(Utilisateur _user, int id) {
		String sql= "UPDATE `utilisateur` SET `"
					+ "name`=?,`prenom`=?,`age`=?"
					+ ",`permis`=?,`fidel`=?,`nni`=?,"
					+ "`isAdmin`=?,`login`=?"
					+ ",`password`=?,`phone`=? WHERE `idUser`=?";
		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ps.setString(1, _user.getName());
			ps.setString(2, _user.getPrenom());
			ps.setInt(3, _user.getAge());
			ps.setString(4,_user.getPermis());
			ps.setBoolean(5, _user.isFidel());
			ps.setInt(6,_user.getNni());
			ps.setInt(7, _user.getIsAdmin());
			ps.setString(8,_user.getLogin());
			ps.setString(9,_user.getPassword());
			ps.setInt(10, _user.getPhone());
			
			ps.setInt(11, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> findUser(String mc) {
		String sql = "SELECT * FROM `utilisateur` WHERE (`name` LIKE ?) or "
				+ "(`prenom` LIKE ?) or  (`login` LIKE ?)";
		
		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ps.setString(1, "%"+mc+"%");
			ps.setString(2, "%"+mc+"%");
			ps.setString(3, "%"+mc+"%");
			
			ResultSet rs;
			rs = ps.executeQuery();
			while(rs.next()){
				user = new Utilisateur(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getBoolean(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11));
				users.add(user);
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return users;
	}

	@Override
	public Utilisateur autenficateUser(String login, String password) {
		
		String sql = "SELECT `isAdmin`,`login`,`password` FROM `utilisateur` "
				+ "WHERE `login` LIKE ? and `password` LIKE ?";
		

		try {
			PreparedStatement ps = bdCon.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs;
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				user = this.getUserByLogin(rs.getString(2));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(login.equals(user.getLogin()) && password.equals(user.getPassword())){
			return user;
		}else{
			return null;
		}
	}

}
