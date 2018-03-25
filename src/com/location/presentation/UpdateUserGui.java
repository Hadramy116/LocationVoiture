package com.location.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.location.data.ConnexionDB;
import com.location.data.Utilisateur;
import com.location.lControl.UtilisateurControl;



public class UpdateUserGui extends JFrame {
	

	UtilisateurControl ctrlU = new UtilisateurControl();

	private JPanel contentPane;
	private JTextField name;
	private JTextField prenom;
	private JTextField age;
	private JTextField phone;
	private JTextField nni;
	private JTextField permis;
	private JTextField login;
	private JPasswordField password;
	private JPasswordField confime;
	private int idUser;
	
	private Utilisateur userObj = new Utilisateur();

	public UpdateUserGui(Utilisateur userObj) {
		
		this.userObj = userObj;
		idUser = userObj.getIdUser();
		
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(230, 230, 250));
		panel.setBounds(0, 101, 877, 219);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(230, 230, 250), new Color(230, 230, 250)));
		panel.setBackground(new Color(0, 102, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(new Color(230, 230, 250));
		lblNom.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblNom.setBounds(20, 31, 46, 14);
		panel.add(lblNom);
		
		name = new JTextField();
		name.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		name.setBackground(new Color(230, 230, 250));
		name.setBounds(90, 28, 166, 20);
		panel.add(name);
		name.setColumns(10);
		name.setText(userObj.getName());
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblPrenom.setForeground(new Color(230, 230, 250));
		lblPrenom.setBounds(20, 62, 67, 14);
		panel.add(lblPrenom);
		
		prenom = new JTextField();
		prenom.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		prenom.setBackground(new Color(230, 230, 250));
		prenom.setBounds(90, 59, 166, 20);
		panel.add(prenom);
		prenom.setColumns(10);
		prenom.setText(userObj.getPrenom());
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(230, 230, 250));
		lblAge.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblAge.setBounds(20, 87, 46, 27);
		panel.add(lblAge);
		
		age = new JTextField();
		age.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		age.setBackground(new Color(230, 230, 250));
		age.setBounds(90, 89, 166, 20);
		panel.add(age);
		age.setColumns(10);
		age.setText(Integer.toString(userObj.getAge()));
		
		JLabel lblPermisNumero = new JLabel("Permis numero");
		lblPermisNumero.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblPermisNumero.setForeground(new Color(230, 230, 250));
		lblPermisNumero.setBounds(447, 31, 132, 14);
		panel.add(lblPermisNumero);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblTelephone.setForeground(new Color(230, 230, 250));
		lblTelephone.setBounds(20, 130, 78, 14);
		panel.add(lblTelephone);
		
		phone = new JTextField();
		phone.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		phone.setBackground(new Color(230, 230, 250));
		phone.setBounds(90, 127, 166, 20);
		panel.add(phone);
		phone.setColumns(10);
		phone.setText(Integer.toString(userObj.getPhone()));
		
		JLabel lblNni = new JLabel("NNI");
		lblNni.setForeground(new Color(230, 230, 250));
		lblNni.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblNni.setBounds(20, 165, 46, 14);
		panel.add(lblNni);
		
		nni = new JTextField();
		nni.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		nni.setBackground(new Color(230, 230, 250));
		nni.setBounds(90, 162, 166, 20);
		panel.add(nni);
		nni.setColumns(10);
		nni.setText(Integer.toString(userObj.getNni()));
		
		permis = new JTextField();
		permis.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		permis.setBackground(new Color(230, 230, 250));
		permis.setBounds(583, 29, 181, 20);
		panel.add(permis);
		permis.setColumns(10);
		permis.setText(userObj.getPermis());
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblLogin.setForeground(new Color(230, 230, 250));
		lblLogin.setBounds(466, 87, 72, 27);
		panel.add(lblLogin);
		
		login = new JTextField();
		login.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		login.setBackground(new Color(230, 230, 250));
		login.setBounds(583, 91, 181, 20);
		panel.add(login);
		login.setColumns(10);
		login.setText(userObj.getLogin());
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblPassword.setForeground(new Color(230, 230, 250));
		lblPassword.setBounds(466, 117, 86, 14);
		panel.add(lblPassword);
		
		JLabel lblConfirme = new JLabel("Confirme");
		lblConfirme.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblConfirme.setForeground(new Color(230, 230, 250));
		lblConfirme.setBounds(466, 142, 86, 14);
		panel.add(lblConfirme);
		
		password = new JPasswordField();
		password.setBackground(new Color(230, 230, 250));
		password.setBounds(583, 117, 181, 20);
		panel.add(password);
		password.setText(userObj.getPassword());
		
		confime = new JPasswordField();
		confime.setBackground(new Color(230, 230, 250));
		confime.setBounds(583, 142, 181, 20);
		panel.add(confime);
		confime.setText(userObj.getPassword());
		
		JButton btnValider = new JButton("valider");
		btnValider.setBounds(476, 173, 128, 23);
		panel.add(btnValider);
		btnValider.setBackground(new Color(230, 230, 250));
		
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String uname = name.getText().trim();
				String uprenom  = prenom.getText().trim();
				String uage = age.getText().trim();
				String uphone	= phone.getText().trim();
				String unni	= nni.getText().trim();
				String upermis	= permis.getText().trim();
				String ulogin	= login.getText().trim();
				String upass = password.getText().trim();
				String uconf = confime.getText().trim();
				
				
				if(uname.isEmpty() || uphone.isEmpty() || ulogin.isEmpty() || upass.isEmpty()){
					JOptionPane.showMessageDialog(null, 
							"Veullez remplire les champs obligatoires :(");
				}else if(!(upass.equals(uconf))){
					JOptionPane.showMessageDialog(null, "verfiez le mots de passe :(");
				}else
					if(ConnexionDB.etatConnexion){
						userObj.setName(uname);
						userObj.setPrenom(uprenom);
						userObj.setAge(Integer.parseInt(uage));
						userObj.setPhone(Integer.parseInt(uphone));
						userObj.setNni(Integer.parseInt(unni));
						userObj.setPermis(upermis);
						userObj.setLogin(ulogin);
						userObj.setPassword(upass);
						userObj.setIsAdmin(0);
						userObj.setFidel(false);
						userObj.setIdUser(0);
						
						ctrlU.updateUser(userObj, idUser);
						
						JOptionPane.showMessageDialog(null, "saved");
						
					}else{
						JOptionPane.showMessageDialog(null, "connexion echouer :(","warning",JOptionPane.ERROR_MESSAGE);
					}
				}
		});
		
		JButton btnViderLeFormulaire = new JButton("vider le formulaire");
		btnViderLeFormulaire.setBounds(628, 173, 147, 23);
		panel.add(btnViderLeFormulaire);
		btnViderLeFormulaire.setBackground(new Color(230, 230, 250));
		
		btnViderLeFormulaire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				name.setText("");
				prenom.setText("");
				age.setText("");
				phone.setText("");
				nni.setText("");
				permis.setText("");
				login.setText("");
				password.setText("");
				confime.setText("");
				
			}
		});
		
		JLabel lblNouvelleUtilisateur = new JLabel("Modifier voter profile");
		lblNouvelleUtilisateur.setIcon(new ImageIcon("C:\\Users\\EL Hadramy Ahmed\\Downloads\\Add User Male-100 (1).png"));
		lblNouvelleUtilisateur.setForeground(new Color(230, 230, 250));
		lblNouvelleUtilisateur.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 24));
		lblNouvelleUtilisateur.setBounds(30, 11, 798, 79);
		contentPane.add(lblNouvelleUtilisateur);
		
		
		this.setVisible(true);
	}
}