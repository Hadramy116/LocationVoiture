package com.location.data;

public class Utilisateur {
	//USER PROPRIETE
	private int idUser;//Auto_increment
	private String name;
	private String prenom;
	private int age;
	private String permis;
	private boolean fidel;
	private int nni;
	private String login;
	private String  password;
	private int isAdmin;
	private int phone;


	///Constructeur par defaut
	public Utilisateur() {
		
	}
	
	///Constricteur Initialization
	
	public Utilisateur(int idUser, String name, String prenom, int age, String permis,
			boolean fidel, int nni,int isAdmin, String login, 
			String password, int phone) {

		this.idUser = idUser;
		this.name = name;
		this.prenom = prenom;
		this.age = age;
		this.permis = permis;
		this.fidel = fidel;
		this.nni = nni;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
		this.phone = phone;
	}
	
	///SETTER//&&///GETTER

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPermis() {
		return permis;
	}

	public void setPermis(String permis) {
		this.permis = permis;
	}

	public boolean isFidel() {
		return fidel;
	}

	public void setFidel(boolean fidel) {
		this.fidel = fidel;
	}

	public int getNni() {
		return nni;
	}

	public void setNni(int nni) {
		this.nni = nni;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
