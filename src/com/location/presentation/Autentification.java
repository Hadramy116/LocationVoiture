package com.location.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.SystemColor;

import javax.swing.UIManager;

import com.location.data.ConnexionDB;
import com.location.data.Utilisateur;
import com.location.lControl.UtilisateurControl;

import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.chrono.JapaneseDate;


@SuppressWarnings("serial")
public class Autentification extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	Utilisateur  user;
	UtilisateurControl ctrlUser = new UtilisateurControl();

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autentification frame = new Autentification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	public Autentification() {
		setVisible(true);
		setAutoRequestFocus(false);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(230, 230, 250));
		setTitle("LOCATION VOITURE");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Car_32px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(SystemColor.menu);
		lblUsername.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblUsername.setBounds(114, 160, 112, 23);
		contentPane.add(lblUsername);
		
		JTextField userName = new JTextField();
		userName.setForeground(new Color(0, 0, 0));
		userName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		userName.setBackground(new Color(255, 255, 255));
		userName.setBounds(239, 160, 214, 23);
		contentPane.add(userName);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(238, 194, 214, 20);
		contentPane.add(passwordField);
		
	
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.menu);
		lblPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblPassword.setBounds(114, 194, 98, 17);
		contentPane.add(lblPassword);
		
		JButton btnConnecter = new JButton("Connecter");
		btnConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String _login = userName.getText();
				String _password  = passwordField.getText();
				if(ConnexionDB.etatConnexion){
					Utilisateur user  = ctrlUser.autenficateUser(_login,_password);
					JOptionPane pane = new JOptionPane();
				
					if(user ==  null){
						pane.showMessageDialog(null,"Username ou password incorrect");
					}else{
						if(user.getIsAdmin() == 0){
							
							new ClientGUI(user);
							Autentification.this.setVisible(false);
						}else if(user.getIsAdmin() == 1){
							new AdminGui(user);
							Autentification.this.setVisible(false);
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Etablir la connexion");
				}
				
			}
		});
		btnConnecter.setBackground(new Color(255, 255, 255));
		btnConnecter.setIcon(new ImageIcon("C:\\Users\\EL Hadramy Ahmed\\Downloads\\Login Rounded Down-20.png"));
		btnConnecter.setBounds(337, 225, 116, 23);
		contentPane.add(btnConnecter);
		
		JButton btnNewButton = new JButton("inscrie");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\EL Hadramy Ahmed\\Downloads\\BlueArrow.gif"));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Inscription();
				close();
				
			}
		});
		btnNewButton.setBounds(239, 225, 88, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblLocationVoiture = new JLabel("LOCATION VOITURE");
		lblLocationVoiture.setBackground(new Color(255, 255, 255));
		lblLocationVoiture.setIcon(new ImageIcon("C:\\Users\\EL Hadramy Ahmed\\Downloads\\Car Rental-50.png"));
		lblLocationVoiture.setForeground(UIManager.getColor("OptionPane.background"));
		lblLocationVoiture.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
		lblLocationVoiture.setBounds(103, 90, 440, 62);
		contentPane.add(lblLocationVoiture);
		
		JLabel lblMotsDePasse = new JLabel("Mots de passe oublirer ?");
		lblMotsDePasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
			}
		});
		lblMotsDePasse.setForeground(new Color(210, 105, 30));
		lblMotsDePasse.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 14));
		lblMotsDePasse.setBounds(238, 264, 171, 14);
		contentPane.add(lblMotsDePasse);
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, textPane, passwordField, lblUsername, lblPassword, btnConnecter, btnNewButton, lblLocationVoiture, lblMotsDePasse}));
	}
	
	public void close(){
		this.setVisible(false);
	}
}