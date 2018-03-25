package com.location.lControl;

import java.util.List;

import com.location.data.Utilisateur;

public interface IUtilisateuer {
	
	public boolean addUser(Utilisateur user);
	public List<Utilisateur> getUsers();
	public Utilisateur getUserById(int id);
	public Utilisateur getUserByName(String name);
	public void deleteUser(int id);
	public void updateUser(Utilisateur user, int id);
	public List<Utilisateur> findUser(String mc);
	public Utilisateur autenficateUser(String login, String password);
	public Utilisateur getUserByLogin(String login);
	
}
