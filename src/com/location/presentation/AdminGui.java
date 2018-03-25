package com.location.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.Icon;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import net.sourceforge.jdatepicker.util.JDatePickerUtil;

import javax.swing.JFileChooser;

import com.location.data.Facture;
import com.location.data.Location;
import com.location.data.Reservation;
import com.location.data.Utilisateur;
import com.location.data.Voiture;
import com.location.lControl.FactureControl;
import com.location.lControl.LocationControl;
import com.location.lControl.ResControl;
import com.location.lControl.UtilisateurControl;
import com.location.lControl.VoitureControl;



public class AdminGui extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField carburant;
	private JTextField matricule;
	private JTextField color;
	private JTextField bt_vitess;
	private JTextField prix;
	private JTextField etat;
	private JTextField assurence;
	private JTextField name;
	private JTextField prenom;
	private JTextField age;
	private JTextField phone;
	private JTextField nni;
	private JTextField permis;
	private JTextField login;
	private JPasswordField password;
	private JTextField search_user;
	private JTextField isFidel;
	private JTextField isAdmin;
	private JTextField resSearch;
	//private JTable voitureTable;
	private int idRowSelected;
	private String photoSelected ;
	
	private Utilisateur user =  new Utilisateur();
	private Voiture voiture = new Voiture();
	private VoitureControl ctrlV = new VoitureControl();
	private UtilisateurControl	ctrlU = new UtilisateurControl();
	private LocationControl ctrlLoc = new LocationControl();
	private Location loc = new Location();
	private Reservation res = new Reservation();
	private ResControl ctrlRes = new ResControl();
	private Facture fact = new Facture();
	private FactureControl ctrlFact = new FactureControl();
	
	public AdminGui(Utilisateur _user) {
		
		this.user = _user;
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 607);
		setBackground(new Color(230, 230, 250));
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Car_32px.png"));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setBackground(new Color(0, 102, 204));
		tabbedPane.setBounds(10, 32, 986, 525);
		contentPane.add(tabbedPane);
		
		JPanel voiture_p = new JPanel();
		voiture_p.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("consultez les voitures",
		new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Car_32px.png")
		, voiture_p, null);
		voiture_p.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 204));
		panel_1.setBounds(12, 385, 957, 100);
		voiture_p.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(12, 12, 933, 87);

       

		JTable listVoiture = new JTable();
		listVoiture.setFillsViewportHeight(true);
		listVoiture.setShowHorizontalLines(true);
		listVoiture.setShowVerticalLines(false);
		listVoiture.setGridColor(Color.WHITE);
		listVoiture.setForeground(Color.WHITE);
		listVoiture.setBackground(new Color(0, 102, 204));
		listVoiture.setSurrendersFocusOnKeystroke(true);
		listVoiture.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listVoiture.setColumnSelectionAllowed(true);
		listVoiture.getTableHeader().setBackground(new Color(0, 102, 204));
		listVoiture.getTableHeader().setBorder(null);
		listVoiture.getTableHeader().setForeground(Color.WHITE);
		listVoiture.setForeground(new Color(25, 25, 112));
		//jTable2.setRowHeight(30);



		 DefaultTableModel model_voiture = new DefaultTableModel();
		 
		 model_voiture.addColumn("Id");
		 model_voiture.addColumn("Marque");
		 model_voiture.addColumn("Model");
		 model_voiture.addColumn("Matricule");
		 model_voiture.addColumn("Color");
		 model_voiture.addColumn("Kilometrage");
		 model_voiture.addColumn("Carburant");
		 model_voiture.addColumn("bVitess");
		 model_voiture.addColumn("Prix");
		 model_voiture.addColumn("photo");
		 model_voiture.addColumn("Etat");
		 model_voiture.addColumn("Asserance");
		 
		 for(Voiture v : ctrlV.getVoiture()){
			 model_voiture.addRow(new Object[]{
					 v.getIdVoiture(),
					 v.getMarque(),
					 v.getModel(),
					 v.getMatricul(),
					 v.getColor(),
					 v.getKilometrage(),
					 v.getCarburant(),
					 v.getBoiteVitess(),
					 v.getPrix(),
					 v.getImage(),
					 v.getEtat(),
					 v.getAssurence()
			 });
		 }
		 
		 listVoiture.setModel(model_voiture);
        jScrollPane1.setViewportView(listVoiture);
       panel_1.add(jScrollPane1);
       
       JPanel panel_5 = new JPanel();
       panel_5.setLayout(null);
       panel_5.setForeground(new Color(230, 230, 250));
       panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(230, 230, 250), new Color(230, 230, 250)));
       panel_5.setBackground(new Color(0, 102, 204));
       panel_5.setBounds(12, 11, 959, 359);
       voiture_p.add(panel_5);
       
       JLabel lblMarque = new JLabel("Marque");
       lblMarque.setForeground(new Color(230, 230, 250));
       lblMarque.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblMarque.setBounds(20, 31, 67, 20);
       panel_5.add(lblMarque);
       
       JLabel lblModel = new JLabel("Model");
       lblModel.setForeground(new Color(230, 230, 250));
       lblModel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblModel.setBounds(20, 62, 67, 14);
       panel_5.add(lblModel);
       
       carburant = new JTextField();
       carburant.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
       carburant.setColumns(10);
       carburant.setBackground(new Color(230, 230, 250));
       carburant.setBounds(108, 190, 166, 20);
       panel_5.add(carburant);
       
       JLabel lblMatricule = new JLabel("Matricule");
       lblMatricule.setForeground(new Color(230, 230, 250));
       lblMatricule.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblMatricule.setBounds(20, 87, 93, 27);
       panel_5.add(lblMatricule);
       
       matricule = new JTextField();
       matricule.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
       matricule.setColumns(10);
       matricule.setBackground(new Color(230, 230, 250));
       matricule.setBounds(108, 91, 166, 20);
       panel_5.add(matricule);
       
       JLabel lblBoiteDeVitess = new JLabel("Boite de vitess");
       lblBoiteDeVitess.setForeground(new Color(230, 230, 250));
       lblBoiteDeVitess.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblBoiteDeVitess.setBounds(447, 31, 132, 14);
       panel_5.add(lblBoiteDeVitess);
       
       JLabel lblColor = new JLabel("Color");
       lblColor.setForeground(new Color(230, 230, 250));
       lblColor.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblColor.setBounds(20, 130, 78, 14);
       panel_5.add(lblColor);
       
       color = new JTextField();
       color.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
       color.setColumns(10);
       color.setBackground(new Color(230, 230, 250));
       color.setBounds(108, 128, 166, 20);
       panel_5.add(color);
       
       JLabel lblKilometrage = new JLabel("kilometrage");
       lblKilometrage.setForeground(new Color(230, 230, 250));
       lblKilometrage.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblKilometrage.setBounds(20, 165, 93, 14);
       panel_5.add(lblKilometrage);
       
       JTextField kilometrage = new JTextField();
       kilometrage.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
       kilometrage.setColumns(10);
       kilometrage.setBackground(new Color(230, 230, 250));
       kilometrage.setBounds(108, 162, 166, 20);
       panel_5.add(kilometrage);
       
       bt_vitess = new JTextField();
       bt_vitess.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
       bt_vitess.setColumns(10);
       bt_vitess.setBackground(new Color(230, 230, 250));
       bt_vitess.setBounds(583, 29, 181, 20);
       panel_5.add(bt_vitess);
       
       JLabel lblPrix = new JLabel("prix");
       lblPrix.setForeground(new Color(230, 230, 250));
       lblPrix.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblPrix.setBounds(449, 56, 72, 27);
       panel_5.add(lblPrix);
       
       prix = new JTextField();
       prix.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
       prix.setColumns(10);
       prix.setBackground(new Color(230, 230, 250));
       prix.setBounds(583, 56, 181, 20);
       panel_5.add(prix);
       
       JLabel lblEtat = new JLabel("Etat");
       lblEtat.setForeground(new Color(230, 230, 250));
       lblEtat.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblEtat.setBounds(447, 93, 86, 14);
       panel_5.add(lblEtat);
       
       JLabel lblAssurence = new JLabel("Assurence");
       lblAssurence.setForeground(new Color(230, 230, 250));
       lblAssurence.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblAssurence.setBounds(447, 116, 86, 14);
       panel_5.add(lblAssurence);
       
       etat = new JTextField();
       etat.setBackground(new Color(230, 230, 250));
       etat.setBounds(583, 87, 181, 20);
       panel_5.add(etat);
       
       assurence = new JTextField();
       assurence.setBackground(new Color(230, 230, 250));
       assurence.setBounds(583, 116, 181, 20);
       panel_5.add(assurence);
      
       
       JButton vider_form_btn = new JButton("vider form");
       vider_form_btn.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		matricule.setText("");
       		color.setText("");
       		kilometrage.setText("");
       		carburant.setText("");
       		bt_vitess.setText("");
       		etat.setText("");
       		assurence.setText("");
       		prix.setText("");
       	}
       });
       vider_form_btn.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Delete_26px.png"));
       vider_form_btn.setBackground(new Color(0, 102, 204));
       vider_form_btn.setBounds(642, 312, 86, 33);
       panel_5.add(vider_form_btn);
       
       search = new JTextField();
       search.setBounds(10, 314, 158, 34);
       panel_5.add(search);
       search.setColumns(10);
       
       JButton btnSearch = new JButton("");
       btnSearch.setBounds(178, 314, 55, 34);
       panel_5.add(btnSearch);
       btnSearch.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Search_32px.png"));
       btnSearch.setForeground(Color.LIGHT_GRAY);
       btnSearch.setBackground(new Color(0, 102, 204));
       
       JComboBox comboBox = new JComboBox();
       comboBox.setModel(new DefaultComboBoxModel(new String[] {"Toyota","Mecedesse","Rang rover"}));
       comboBox.setBounds(108, 34, 166, 20);
       panel_5.add(comboBox);
       
       JComboBox comboBox_1 = new JComboBox();
       comboBox_1.setModel( new DefaultComboBoxModel(new String[] {
    		 "v8","Avencis","rang-sport","......"
       }));
       comboBox_1.setBounds(108, 62, 166, 20);
       panel_5.add(comboBox_1);
       
       JLabel lblCarburant = new JLabel("Carburant");
       lblCarburant.setForeground(new Color(230, 230, 250));
       lblCarburant.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblCarburant.setBounds(20, 195, 93, 14);
       panel_5.add(lblCarburant);
       
       JLabel lblPhoto = new JLabel("Photo");
       lblPhoto.setForeground(new Color(230, 230, 250));
       lblPhoto.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
       lblPhoto.setBounds(447, 151, 86, 14);
       panel_5.add(lblPhoto);
       
       
       //selectionner une voiture
       listVoiture.addMouseListener(new MouseAdapter() {
     		@Override
     		public void mouseClicked(MouseEvent arg0) {
     			if(listVoiture.getSelectedRow() != -1 )
     			voiture = ctrlV.getVoitureById((int)listVoiture.getValueAt(listVoiture.getSelectedRow(), 0));
     			
     			matricule.setText(voiture.getMatricul());
     			color.setText(voiture.getColor());
     			kilometrage.setText(Integer.toString(voiture.getKilometrage()));	
     			carburant.setText(voiture.getCarburant());
     			bt_vitess.setText(voiture.getBoiteVitess());
     			prix.setText(Integer.toString(voiture.getPrix()));
     			etat.setText(voiture.getEtat());
     			assurence.setText(voiture.getAssurence());
     			
     			//photo.setIcon(new ImageIcon(voiture.getImage()));
     		}
         });
      
       ///choisir l'image
       JButton btnChoisir = new JButton("");
       btnChoisir.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		JFileChooser photoChose = new JFileChooser();
       		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","gif","png");
       		photoChose.addChoosableFileFilter(filter);
       		int result = photoChose.showSaveDialog(null);
       		if(result == JFileChooser.APPROVE_OPTION){
       			File selectedFile = photoChose.getSelectedFile();
       			photoSelected = selectedFile.getAbsolutePath();
       		}else if(result == JFileChooser.CANCEL_OPTION){
       			JOptionPane.showMessageDialog(null, "vous n'avez pas selectionner une photo");
       		}
       		
       	}
       });
       btnChoisir.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Folder_26px.png"));
       btnChoisir.setBounds(593, 147, 166, 32);
       btnChoisir.setBackground(new Color(0, 102, 204));
       panel_5.add(btnChoisir);
       
       JButton btnAjouter = new JButton("");
       btnAjouter.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		
       		String marque = comboBox.getSelectedItem().toString();
       		String model = comboBox_1.getSelectedItem().toString();
       		String matricul = matricule.getText();
       		String color_ = color.getText();
       		int kilom = Integer.parseInt(kilometrage.getText());
       		String carb = carburant.getText();
       		String btv = bt_vitess.getText();
       		int prix_ =  Integer.parseInt(prix.getText());
       		String etat_ = etat.getText();
       		String assure = assurence.getText();
       		
       		Voiture newVoiture = new Voiture(0, marque, model, matricul,
       				color_, kilom, carb, btv, prix_, photoSelected, 
       				etat_, assure);
       		ctrlV.addVoiture(newVoiture);
       		JOptionPane.showMessageDialog(null, "Ajouter avec succes :)");
       		}
       });
       btnAjouter.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Plus Math_26px.png"));
       btnAjouter.setBounds(250, 314, 89, 32);
       btnAjouter.setBackground(new Color(0, 102, 204));
       panel_5.add(btnAjouter);
       
       JButton btnSupprmer = new JButton("");
       btnSupprmer.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		JOptionPane.showConfirmDialog(null, "vous etes sur ??");
       		ctrlV.deleteVoiture(
       				(int)listVoiture.getValueAt(listVoiture.getSelectedRow(), 0));
       		
       	}
       });
       btnSupprmer.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Delete_26px.png"));
       btnSupprmer.setBounds(344, 312, 89, 34);
       btnSupprmer.setBackground(new Color(0, 102, 204));
       panel_5.add(btnSupprmer);
       
       JButton modifier_btn = new JButton("");
       modifier_btn.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		String marque = comboBox.getSelectedItem().toString();
       		String model = comboBox_1.getSelectedItem().toString();
       		String matricul = matricule.getText();
       		String color_ = color.getText();
       		int kilom = Integer.parseInt(kilometrage.getText());
       		String carb = carburant.getText();
       		String btv = bt_vitess.getText();
       		int prix_ =  Integer.parseInt(prix.getText());
       		String etat_ = etat.getText();
       		String assure = assurence.getText();
       		System.out.println(photoSelected);
       		Voiture newVoiture = new Voiture(0, marque, model, matricul,
       				color_, kilom, carb, btv, prix_, photoSelected, 
       				etat_, assure);
       		ctrlV.updateVoiture(newVoiture, 
       				(int)listVoiture.getValueAt(listVoiture.getSelectedRow(), 0));
       		JOptionPane.showMessageDialog(null, "Modifie avec succes :)");
       		
       	}
       });
       modifier_btn.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Edit_26px.png"));
       modifier_btn.setBackground(new Color(0, 102, 204));
       modifier_btn.setBounds(443, 314, 93, 32);
       panel_5.add(modifier_btn);
       
       btnSearch.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		
       		
       		
       	}
       });
       
       
       /*** LOCATION
        * 
        * 
        * 
        */
		
		JPanel location_p = new JPanel();
		location_p.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("location", 
		new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Key_32px.png"), location_p, null);
		location_p.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(0, 102, 204));
		panel_8.setBounds(0, 0, 981, 497);
		location_p.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(0, 102, 204));
		panel_9.setBounds(12, 385, 957, 100);
		panel_8.add(panel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 933, 87);
		panel_9.add(scrollPane);
		
		JTable jTableLoc = new JTable();
		jTableLoc.setFillsViewportHeight(true);
		jTableLoc.setShowHorizontalLines(true);
		jTableLoc.setShowVerticalLines(false);
		jTableLoc.setGridColor(Color.WHITE);
		jTableLoc.setBackground(new Color(0, 102, 204));
		jTableLoc.setSurrendersFocusOnKeystroke(true);
		jTableLoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableLoc.setColumnSelectionAllowed(true);
		jTableLoc.getTableHeader().setBackground(new Color(0, 102, 204));
		jTableLoc.getTableHeader().setBorder(null);
		jTableLoc.getTableHeader().setForeground(Color.WHITE);
		jTableLoc.setForeground(Color.WHITE);
		//jTable2.setRowHeight(30);



		 DefaultTableModel model_loc = new DefaultTableModel();
		 
		 model_loc.addColumn("Id");
		 model_loc.addColumn("Marque");
		 model_loc.addColumn("Matricule");
		 model_loc.addColumn("Nom");
		 model_loc.addColumn("phone");
		 model_loc.addColumn("Date de debut");
		 model_loc.addColumn("Date de Fin");
		 model_loc.addColumn("Prix");
		
		  
		for(Location l :ctrlLoc.getLocations()){
			// System.out.println(l.getDateDebut()+" set");
			 model_loc.addRow(new Object[]{
					l.getIdLocation(),
					l.getVoitureConserner().getMarque(),
					l.getVoitureConserner().getMatricul(),
					l.getUserConserner().getName(),
					l.getUserConserner().getPhone(),
					l.getDateDebut(),
					l.getDateFin(),
					l.getPrix()
			 });
		 }
		 
		jTableLoc.setModel(model_loc);
		scrollPane.setViewportView(jTableLoc);
        
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(0, 102, 204));
		panel_10.setBounds(12, 12, 957, 361);
		panel_8.add(panel_10);
		
		JLabel label_39 = new JLabel("Marque");
		label_39.setForeground(new Color(25, 25, 112));
		label_39.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_39.setBounds(12, 12, 93, 22);
		panel_10.add(label_39);
		
		JLabel label_40 = new JLabel("");
		label_40.setBounds(117, 12, 209, 16);
		panel_10.add(label_40);
		
		JLabel label_41 = new JLabel("Model");
		label_41.setForeground(new Color(25, 25, 112));
		label_41.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_41.setBounds(12, 42, 55, 16);
		panel_10.add(label_41);
		
		JLabel label_42 = new JLabel("Matricul");
		label_42.setForeground(new Color(25, 25, 112));
		label_42.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_42.setBounds(12, 69, 76, 16);
		panel_10.add(label_42);
		
		JLabel label_44 = new JLabel("kilometrage");
		label_44.setForeground(new Color(25, 25, 112));
		label_44.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_44.setBounds(12, 101, 81, 20);
		panel_10.add(label_44);
		
		JLabel label_45 = new JLabel("Carburant");
		label_45.setForeground(new Color(25, 25, 112));
		label_45.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_45.setBounds(12, 126, 81, 20);
		panel_10.add(label_45);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(new Color(25, 25, 112));
		lblNom.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblNom.setBounds(12, 154, 93, 20);
		panel_10.add(lblNom);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(25, 25, 112));
		lblPhone.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblPhone.setBounds(12, 177, 93, 20);
		panel_10.add(lblPhone);
		
		JLabel label_47 = new JLabel("prix");
		label_47.setForeground(new Color(25, 25, 112));
		label_47.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_47.setBounds(704, 13, 81, 20);
		panel_10.add(label_47);
		
		JLabel lblDateDebut = new JLabel("Date debut");
		lblDateDebut.setForeground(new Color(25, 25, 112));
		lblDateDebut.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblDateDebut.setBounds(704, 40, 81, 20);
		panel_10.add(lblDateDebut);
		
		JLabel lblDateFin = new JLabel("Date fin");
		lblDateFin.setForeground(new Color(25, 25, 112));
		lblDateFin.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblDateFin.setBounds(704, 67, 81, 20);
		panel_10.add(lblDateFin);
		
		JLabel loc_marque = new JLabel("");
		loc_marque.setForeground(new Color(25, 25, 112));
		loc_marque.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_marque.setBounds(117, 16, 81, 20);
		panel_10.add(loc_marque);
		
		JLabel loc_model = new JLabel("");
		loc_model.setForeground(new Color(25, 25, 112));
		loc_model.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_model.setBounds(117, 43, 81, 20);
		panel_10.add(loc_model);
		
		JLabel matricul = new JLabel("");
		matricul.setForeground(new Color(25, 25, 112));
		matricul.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		matricul.setBounds(117, 70, 81, 20);
		panel_10.add(matricul);
		
		JLabel loc_kilom = new JLabel("");
		loc_kilom.setForeground(new Color(25, 25, 112));
		loc_kilom.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_kilom.setBounds(117, 101, 81, 20);
		panel_10.add(loc_kilom);
		
		JLabel loc_carburant = new JLabel("");
		loc_carburant.setForeground(new Color(25, 25, 112));
		loc_carburant.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_carburant.setBounds(117, 126, 81, 20);
		panel_10.add(loc_carburant);
		
		JLabel loc_user = new JLabel("");
		loc_user.setForeground(new Color(25, 25, 112));
		loc_user.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_user.setBounds(117, 154, 81, 20);
		panel_10.add(loc_user);
		
		JLabel loc_u_phone = new JLabel("");
		loc_u_phone.setForeground(new Color(25, 25, 112));
		loc_u_phone.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_u_phone.setBounds(117, 197, 81, 20);
		panel_10.add(loc_u_phone);
		
		JLabel loc_prix = new JLabel("");
		loc_prix.setForeground(new Color(25, 25, 112));
		loc_prix.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_prix.setBounds(797, 16, 81, 20);
		panel_10.add(loc_prix);
		
		JLabel loc_date_debut = new JLabel("");
		loc_date_debut.setForeground(new Color(25, 25, 112));
		loc_date_debut.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_date_debut.setBounds(797, 42, 100, 20);
		panel_10.add(loc_date_debut);
		
		JLabel loc_date_fin = new JLabel("");
		loc_date_fin.setForeground(new Color(25, 25, 112));
		loc_date_fin.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_date_fin.setBounds(797, 72, 100, 20);
		panel_10.add(loc_date_fin);
		
		JTextField searchLoc = new JTextField();
	    searchLoc.setBounds(190, 284, 158, 34);
	    panel_10.add(searchLoc);
	    searchLoc.setColumns(10);
		
		JButton btnChercher = new JButton("");
		btnChercher.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Search_32px.png"));
		btnChercher.setForeground(Color.WHITE);
		btnChercher.setBackground(new Color(0, 102, 204));
		btnChercher.setBounds(376, 284, 98, 32);
		panel_10.add(btnChercher);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205)));
		panel_11.setBackground(new Color(230, 230, 250));
		panel_11.setBounds(344, 12, 319, 205);
		panel_10.add(panel_11);
		
		JLabel loc_image = new JLabel();
		loc_image.setBounds(12, 8, 295, 185);
		panel_11.add(loc_image);
		
		jTableLoc.addMouseListener(new MouseAdapter() {
      		@Override
      		public void mouseClicked(MouseEvent arg0) {
      			
      			if(jTableLoc.getSelectedRow() != -1)
      			loc = ctrlLoc.getLocationById((int)jTableLoc.getValueAt(jTableLoc.getSelectedRow(), 0));
      			
      			loc_marque.setText(loc.getVoitureConserner().getMarque());
      			loc_model.setText(loc.getVoitureConserner().getModel());
      			matricul.setText(loc.getVoitureConserner().getMatricul());
      			loc_kilom.setText(Integer.toString(loc.getVoitureConserner().getKilometrage()));
      			loc_carburant.setText(loc.getVoitureConserner().getCarburant());	
      			loc_user.setText(loc.getUserConserner().getName());
      			loc_u_phone.setText(Integer.toString(loc.getUserConserner().getPhone()));
      			loc_prix.setText(Integer.toString(loc.getPrix()));
      			loc_date_debut.setText(loc.getDateDebut());
      			loc_date_fin.setText(loc.getDateFin());
      			
      			loc_image.setIcon(new ImageIcon(loc.getVoitureConserner().getImage()));
      		}
          });
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(230, 230, 250));
		panel_12.setBounds(159, 8, 1, 1);
		panel_11.add(panel_12);
		
		JButton loc_delete = new JButton("");
		loc_delete.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Delete_26px.png"));
		loc_delete.setBounds(661, 269, 89, 43);
		loc_delete.setBackground(new Color(0, 102, 204));
		panel_10.add(loc_delete);
		
		JButton pdf_btn = new JButton("");
		pdf_btn.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\PDF 2_26px.png"));
		pdf_btn.setForeground(new Color(0, 0, 128));
		pdf_btn.setBackground(new Color(0, 102, 204));
		pdf_btn.setBounds(551, 269, 89, 43);
		panel_10.add(pdf_btn);
		
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(searchLoc.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"le champ de recherch vide :(");
				else{
					if(jTableLoc.getSelectedRow() != -1){
							loc =ctrlLoc.getLocationById((int)jTableLoc.getValueAt(
									jTableLoc.getSelectedRow(), 0));
							for(int i=0;i<model_loc.getRowCount();i++)
								model_loc.removeRow(i);
							
							 model_loc.addRow(new Object[]{
										loc.getIdLocation(),
										loc.getVoitureConserner().getMarque(),
										loc.getVoitureConserner().getMatricul(),
										loc.getUserConserner().getName(),
										loc.getUserConserner().getPhone(),
										loc.getDateDebut(),
										loc.getDateFin(),
										loc.getPrix()
								 });
					
					}
					
					
				}
				
			}
		});
		
		pdf_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jTableLoc.getSelectedRow() != -1){
					loc = ctrlLoc.getLocationById((int)jTableLoc.getValueAt(jTableLoc.getSelectedRow(), 0));
      			
					fact = new Facture(0, loc);
					ctrlFact.addFacture(fact);
					ctrlFact.imprimerFacture(fact);
				}else{
					JOptionPane.showMessageDialog(null, "Selectionner une location");
				}
				
			}
		});
		
		loc_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jTableLoc.getSelectedRow() != -1){
					ctrlLoc.deleteLocation((int)jTableLoc.getValueAt(jTableLoc.getSelectedRow(), 0));
					JOptionPane.showMessageDialog(null, "location suprimer");
				}else{
					JOptionPane.showMessageDialog(null, "Selectionner une location");
				}
			}
		});
		
		/*
		 * Reservation
		 */
		
		JPanel res_p = new JPanel();
		tabbedPane.addTab("Reservation", 
				new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Bill_32px.png"), res_p, null);
		res_p.setBackground(new Color(0, 102, 204));
		res_p.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(10, 11, 946, 168);
		res_p.add(panel);
		panel.setLayout(null);
		
		JButton res_search = new JButton("");
		res_search.setBackground(new Color(0, 102, 204));
		res_search.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Search_32px.png"));
		res_search.setBounds(232, 53, 89, 35);
		panel.add(res_search);
		
		JButton res_delete = new JButton("");
		res_delete.setBackground(new Color(0, 102, 204));
		res_delete.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Delete_26px.png"));
		res_delete.setBounds(337, 53, 89, 33);
		panel.add(res_delete);
		
		JButton valider = new JButton("");
		valider.setBackground(new Color(0, 102, 204));
		valider.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Ok_26px.png"));
		valider.setBounds(445, 53, 89, 35);
		panel.add(valider);
		
		resSearch = new JTextField();
		resSearch.setBounds(89, 53, 125, 33);
		panel.add(resSearch);
		resSearch.setColumns(10);
	
		JButton factBtn = new JButton("");
		factBtn.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Bill_32px.png"));
		factBtn.setBackground(new Color(0, 102, 204));
		factBtn.setBounds(559, 53, 89, 35);
		panel.add(factBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 102, 204));
		panel_3.setBounds(10, 190, 957, 278);
		res_p.add(panel_3);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 933, 267);
		panel_3.add(scrollPane_2);
		
		JTable resTable = new JTable();
		resTable.setFillsViewportHeight(true);
		resTable.setShowHorizontalLines(true);
		resTable.setShowVerticalLines(false);
		resTable.setGridColor(Color.LIGHT_GRAY);
		resTable.setBackground(new Color(0, 102, 204));
		resTable.setSurrendersFocusOnKeystroke(true);
		resTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resTable.setColumnSelectionAllowed(true);
		resTable.getTableHeader().setBackground(new Color(0, 102, 204));
		resTable.getTableHeader().setBorder(null);
		resTable.getTableHeader().setForeground(Color.WHITE);
		resTable.setForeground(Color.WHITE);
		//jTable2.setRowHeight(30);



		 DefaultTableModel model_res = new DefaultTableModel();
		 
		 model_res.addColumn("Id");
		 model_res.addColumn("Marque");
		 model_res.addColumn("Matricule");
		 model_res.addColumn("Prix");
		 model_res.addColumn("Nom");
		 model_res.addColumn("phone");
		 model_res.addColumn("Date de debut");
		 model_res.addColumn("Date de Fin");
	
		for( Reservation res : ctrlRes.getRes()){
			model_res.addRow(new Object[]{
					res.getIdRes(),
					res.getVoiturRes().getMarque(),
					res.getVoiturRes().getMatricul(),
					res.getVoiturRes().getPrix(),
					res.getUser().getName(),
					res.getUser().getPhone(),
					res.getDateDebut(),
					res.getDateFin()		
			 });
		 }

		resTable.setModel(model_res);
		scrollPane_2.setViewportView(resTable);
		
		resTable.addMouseListener(new MouseAdapter() {
      		@Override
      		public void mouseClicked(MouseEvent arg0) {
      			
      			if(resTable.getSelectedRow() != -1)
      			idRowSelected = (int)resTable.getValueAt(resTable.getSelectedRow(), 0);
      		}
          });
		
		res_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(resSearch.getText().isEmpty())
	       			JOptionPane.showMessageDialog(null, "le chemps de recherch vide :(");
	       		else{
	       		   List<Reservation> resResult = new ArrayList<Reservation>();
	       		   resResult = ctrlRes.findRes(resSearch.getText());
		       		if(resResult.isEmpty()){
		       			JOptionPane.showMessageDialog(null, "Rien trouver :(");
		       		}else{
		       		
		       			for(Reservation r: resResult ){
		       				for (int i = 0; i < model_res.getRowCount(); i++) 
			           			model_res.removeRow(i);
		       				
		           			model_res.addRow(new Object[]{
		        					r.getIdRes(),
		        					r.getVoiturRes().getMarque(),
		        					r.getVoiturRes().getMatricul(),
		        					r.getVoiturRes().getPrix(),
		        					r.getUser().getName(),
		        					r.getUser().getPhone(),
		        					r.getDateDebut(),
		        					r.getDateFin()		
		        			 });
		           		}
		       		}
	       		
	       		}
			}
		});
		
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(idRowSelected == 0)
					JOptionPane.showMessageDialog(null, "Selectionner une Reservation");
				else{
					
					res = ctrlRes.getResById(idRowSelected);
					ctrlRes.validerRes(res);
					JOptionPane.showMessageDialog(null, "Reservation valider une location a ete cree");
					
				}
			}
		});
		
		factBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(idRowSelected == 0)
					JOptionPane.showMessageDialog(null, "Selectionner une Reservation");
				else{
					
					
					JOptionPane.showMessageDialog(null, "Reservation valider une location a ete cree");
					
				}
			}
		});
		
		res_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idRowSelected == 0)
					JOptionPane.showMessageDialog(null, "Selectionner une Reservation");
				else{
					ctrlRes.annulerRes(idRowSelected);
					JOptionPane.showMessageDialog(null,"Reservation annuler");
				}
			}
		});
		
		/*
		 *  Partie Facture
		 * 
		 */
		
		JPanel fact_p = new JPanel();
		fact_p.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("facture", 
				new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Bill_32px.png"), fact_p, null);
		fact_p.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(0, 102, 204));
		panel_13.setBounds(12, 57, 957, 358);
		fact_p.add(panel_13);
		panel_13.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 90, 933, 256);
		panel_13.add(scrollPane_1);
		
		
		JTable jTableFact = new JTable();
		jTableFact.setFillsViewportHeight(true);
		jTableFact.setShowHorizontalLines(true);
		jTableFact.setShowVerticalLines(false);
		jTableFact.setGridColor(Color.WHITE);
		jTableFact.setBackground(new Color(0, 102, 204));
		jTableFact.setSurrendersFocusOnKeystroke(true);
		jTableFact.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableFact.setColumnSelectionAllowed(true);
		jTableFact.getTableHeader().setBackground(new Color(0, 102, 204));
		jTableFact.getTableHeader().setBorder(null);
		jTableFact.getTableHeader().setForeground(Color.WHITE);
		jTableFact.setForeground(Color.WHITE);
		//jTable2.setRowHeight(30);



		 DefaultTableModel model_fact = new DefaultTableModel();
		 
		 model_fact.addColumn("Id");
		 model_fact.addColumn("Marque");
		 model_fact.addColumn("Matricule");
		 model_fact.addColumn("Nom");
		 model_fact.addColumn("phone");
		 model_fact.addColumn("Date de debut");
		 model_fact.addColumn("Date de Fin");
		 model_fact.addColumn("Prix");
		
		 for(Facture f : ctrlFact.getFactures()){
				 model_fact.addRow(new Object[]{
						f.getIdFacture(),
						f.getLoc().getVoitureConserner().getMarque(),
						f.getLoc().getVoitureConserner().getMatricul(),
						f.getLoc().getUserConserner().getName(),
						f.getLoc().getUserConserner().getPhone(),
						f.getLoc().getDateDebut(),
						f.getLoc().getDateFin(),
						f.getLoc().getPrix()
				 });
		}
		 
		 
		 jTableFact.setModel(model_fact);
		 scrollPane_1.setViewportView(jTableFact);
		 
		
		JLabel lblListeDesFacture = new JLabel("Liste des facture");
		lblListeDesFacture.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblListeDesFacture.setForeground(new Color(0, 0, 139));
		lblListeDesFacture.setBackground(new Color(230, 230, 250));
		lblListeDesFacture.setBounds(12, 34, 149, 16);
		panel_13.add(lblListeDesFacture);
		
		JButton delete_fact = new JButton("Imprimer une facture");
		delete_fact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jTableFact.getSelectedRow() != -1){
					ctrlFact.deleteFacture((int)jTableFact.getValueAt(jTableFact.getSelectedRow(), 0));
				}else{
					JOptionPane.showMessageDialog(null, "Selectionner une Reservation");
	      		}
			}
		});
		delete_fact.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Delete_26px.png"));
		delete_fact.setForeground(new Color(230, 230, 250));
		delete_fact.setBackground(new Color(0, 102, 204));
		delete_fact.setBounds(179, 27, 86, 29);
		panel_13.add(delete_fact);
		
		
		
		
		JPanel utilisateur_p = new JPanel();
		utilisateur_p.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("Utilisateur", 
		new	ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Circled User Male_32px.png")	, utilisateur_p, null);
		utilisateur_p.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 359, 933, 109);
		utilisateur_p.add(scrollPane_3);
		
		JTable userTable = new JTable();
		userTable.setFillsViewportHeight(true);
		userTable.setShowHorizontalLines(true);
		userTable.setShowVerticalLines(false);
		userTable.setGridColor(Color.WHITE);
		userTable.setBackground(new Color(0, 102, 204));
		userTable.setSurrendersFocusOnKeystroke(true);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userTable.setColumnSelectionAllowed(true);
		userTable.getTableHeader().setBackground(new Color(0, 102, 204));
		userTable.getTableHeader().setBorder(null);
		userTable.getTableHeader().setForeground(Color.WHITE);
		userTable.setForeground(Color.WHITE);
		//jTable2.setRowHeight(30);



		 DefaultTableModel model_user = new DefaultTableModel();
		 
		 model_user.addColumn("Id");
		 model_user.addColumn("Nom");
		 model_user.addColumn("Prenom");
		 model_user.addColumn("Age");
		 model_user.addColumn("Phone");
		 model_user.addColumn("Nni");
		 model_user.addColumn("Permis");
		 model_user.addColumn("isAdmin");
		 model_user.addColumn("Login");
		
		 for(Utilisateur u:ctrlU.getUsers()){
			 model_user.addRow(new Object[]{
						u.getIdUser(),
						u.getName(),
						u.getPrenom(),
						u.getAge(),
						u.getPhone(),
						u.getNni(),
						u.getPermis(),
						u.getIsAdmin(),
						u.getLogin()
				 });
		}
		 
		 
		 userTable.setModel(model_user);
		 scrollPane_3.setViewportView(userTable);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.GRAY);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(230, 230, 250), new Color(230, 230, 250)));
		panel_2.setBackground(new Color(0, 102, 204));
		panel_2.setBounds(10, 11, 933, 337);
		panel_2.setLayout(null);
		utilisateur_p.add(panel_2);
		
		JLabel label = new JLabel("Nom");
		label.setForeground(new Color(230, 230, 250));
		label.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label.setBounds(20, 31, 46, 14);
		panel_2.add(label);
		
		name = new JTextField();
		name.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBackground(new Color(230, 230, 250));
		name.setBounds(90, 28, 166, 20);
		panel_2.add(name);
		
		JLabel label_1 = new JLabel("Prenom");
		label_1.setForeground(new Color(230, 230, 250));
		label_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label_1.setBounds(20, 62, 67, 14);
		panel_2.add(label_1);
		
		prenom = new JTextField();
		prenom.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		prenom.setColumns(10);
		prenom.setBackground(new Color(230, 230, 250));
		prenom.setBounds(90, 59, 166, 20);
		panel_2.add(prenom);
		
		JLabel label_2 = new JLabel("Age");
		label_2.setForeground(new Color(230, 230, 250));
		label_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label_2.setBounds(20, 87, 46, 27);
		panel_2.add(label_2);
		
		age = new JTextField();
		age.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		age.setColumns(10);
		age.setBackground(new Color(230, 230, 250));
		age.setBounds(90, 89, 166, 20);
		panel_2.add(age);
		
		JLabel label_3 = new JLabel("Permis numero");
		label_3.setForeground(new Color(230, 230, 250));
		label_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label_3.setBounds(447, 31, 132, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Telephone");
		label_4.setForeground(new Color(230, 230, 250));
		label_4.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label_4.setBounds(20, 130, 78, 14);
		panel_2.add(label_4);
		
		phone = new JTextField();
		phone.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		phone.setColumns(10);
		phone.setBackground(new Color(230, 230, 250));
		phone.setBounds(90, 127, 166, 20);
		panel_2.add(phone);
		
		JLabel label_5 = new JLabel("NNI");
		label_5.setForeground(new Color(230, 230, 250));
		label_5.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label_5.setBounds(20, 165, 46, 14);
		panel_2.add(label_5);
		
		nni = new JTextField();
		nni.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		nni.setColumns(10);
		nni.setBackground(new Color(230, 230, 250));
		nni.setBounds(90, 162, 166, 20);
		panel_2.add(nni);
		
		permis = new JTextField();
		permis.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		permis.setColumns(10);
		permis.setBackground(new Color(230, 230, 250));
		permis.setBounds(583, 29, 181, 20);
		panel_2.add(permis);
		
		JLabel label_6 = new JLabel("Login");
		label_6.setForeground(new Color(230, 230, 250));
		label_6.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label_6.setBounds(466, 87, 72, 27);
		panel_2.add(label_6);
		
		login = new JTextField();
		login.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		login.setColumns(10);
		login.setBackground(new Color(230, 230, 250));
		login.setBounds(583, 91, 181, 20);
		panel_2.add(login);
		
		JLabel label_7 = new JLabel("Password");
		label_7.setForeground(new Color(230, 230, 250));
		label_7.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label_7.setBounds(466, 117, 86, 14);
		panel_2.add(label_7);
		
		password = new JPasswordField();
		password.setBackground(new Color(230, 230, 250));
		password.setBounds(583, 117, 181, 20);
		panel_2.add(password);
		
		JButton add_user = new JButton("");
		add_user.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Plus Math_26px.png"));
		add_user.setBackground(new Color(0, 102, 204));
		add_user.setBounds(466, 277, 107, 35);
		panel_2.add(add_user);
		
		JButton vider_form = new JButton("");
		vider_form.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Delete_26px.png"));
		vider_form.setBackground(new Color(0, 102, 204));
		vider_form.setBounds(718, 277, 46, 35);
		panel_2.add(vider_form);
		
		JButton modfier = new JButton("");
		modfier.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Edit_26px.png"));
		modfier.setBounds(588, 277, 89, 35);
		modfier.setBackground(new Color(0, 102, 204));
		panel_2.add(modfier);
		
		JButton delete_user = new JButton("");
		delete_user.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Delete_26px.png"));
		delete_user.setBounds(365, 277, 89, 35);
		delete_user.setBackground(new Color(0, 102, 204));
		panel_2.add(delete_user);
		
		JButton search_user_btn = new JButton("");
		search_user_btn.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Search_32px.png"));
		search_user_btn.setBackground(new Color(0, 102, 204));
		search_user_btn.setBounds(266, 277, 89, 35);
		panel_2.add(search_user_btn);
		
		search_user = new JTextField();
		search_user.setBounds(68, 277, 188, 35);
		panel_2.add(search_user);
		search_user.setColumns(10);
		
		JLabel lblIsfidel = new JLabel("IsFidel");
		lblIsfidel.setForeground(new Color(230, 230, 250));
		lblIsfidel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblIsfidel.setBounds(20, 193, 95, 20);
		panel_2.add(lblIsfidel);
		
		isFidel = new JTextField();
		isFidel.setBounds(90, 196, 86, 20);
		panel_2.add(isFidel);
		isFidel.setColumns(10);
		
		JLabel lblIsadmin = new JLabel("IsAdmin");
		lblIsadmin.setForeground(new Color(230, 230, 250));
		lblIsadmin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblIsadmin.setBounds(20, 223, 95, 20);
		panel_2.add(lblIsadmin);
		
		isAdmin = new JTextField();
		isAdmin.setBounds(90, 226, 86, 20);
		panel_2.add(isAdmin);
		isAdmin.setColumns(10);
		
		userTable.addMouseListener(new MouseAdapter() {
      		@Override
      		public void mouseClicked(MouseEvent arg0) {
      			
      			if(userTable.getSelectedRow() != -1){
      			user = ctrlU.getUserById((int)userTable.getValueAt(userTable.getSelectedRow(), 0));
      			
      			name.setText(user.getName());
      			prenom.setText(user.getPrenom());
      			age.setText(Integer.toString(user.getAge()));
      			phone.setText(Integer.toString(user.getPhone()));
      			nni.setText(Integer.toString(user.getNni()));
      			isFidel.setText(Boolean.toString(user.isFidel()));
      			isAdmin.setText(Integer.toString(user.getIsAdmin()));
      			permis.setText(user.getPermis());
      			login.setText(user.getLogin());
      			password.setText(user.getPassword());
      			
      			
      			}
      			
      		}
          });
		delete_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userTable.getSelectedRow() != -1){
	      			 ctrlU.deleteUser((int)userTable.getValueAt(userTable.getSelectedRow(), 0));
	      			 JOptionPane.showMessageDialog(null, "user suprimer");
				}else{
					JOptionPane.showMessageDialog(null, "Selectionner un utilisateur");
				}	
			}
		});
		
		add_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(login.getText().isEmpty() || password.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Remplisez les chemps vide :(");
				else{
					user.setIdUser(0);
					user.setName(name.getText());
					user.setPrenom(prenom.getText());
					user.setPhone(Integer.parseInt(phone.getText()));
					user.setAge(Integer.parseInt(age.getText()));
					user.setNni(Integer.parseInt(nni.getText()));
					user.setPermis(permis.getText());
					user.setLogin(login.getText());
					user.setFidel(Boolean.getBoolean(isFidel.getText()));
					user.setIsAdmin(Integer.parseInt(isAdmin.getText()));
					
					if(ctrlU.addUser(user)){
						JOptionPane.showMessageDialog(null, "Ajouter avec succes ");
					}else{
						JOptionPane.showMessageDialog(null, "User n'est pas ajoutee");
					}
				}
			}
		});
		
		vider_form.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
      			prenom.setText("");
      			age.setText("");
      			phone.setText("");
      			nni.setText("");
      			isFidel.setText("");
      			isAdmin.setText("");
      			permis.setText("");
      			login.setText("");
      			password.setText("");
			}
		});
		
		modfier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(login.getText().isEmpty() || password.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Remplisez les chemps vide :(");
				else{
					user.setIdUser(0);
					user.setName(name.getText());
					user.setPrenom(prenom.getText());
					user.setPhone(Integer.parseInt(phone.getText()));
					user.setAge(Integer.parseInt(age.getText()));
					user.setNni(Integer.parseInt(nni.getText()));
					user.setPermis(permis.getText());
					user.setLogin(login.getText());
					user.setFidel(Boolean.getBoolean(isFidel.getText()));
					user.setIsAdmin(Integer.parseInt(isAdmin.getText()));
					
					if(userTable.getSelectedRow() != -1){
		      			 ctrlU.updateUser(user,(int)userTable.getValueAt(userTable.getSelectedRow(), 0));
		      			 JOptionPane.showMessageDialog(null, "Modifier avec succes ");
					}
				}
			}
		});
		
		search_user_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(search_user.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "chemps de recherche vide");
				else{
					List<Utilisateur> users = new ArrayList<Utilisateur>();
					
					users = ctrlU.findUser(search_user.getText());
					
					if(users.isEmpty())
						JOptionPane.showMessageDialog(null, "Rein trouver :(");
					else{
						
						for(Utilisateur u : users){
							for(int i =0; i<model_user.getRowCount();i++)
								model_user.removeRow(i);
							model_user.addRow(new Object[]{
									u.getIdUser(),
									u.getName(),
									u.getPrenom(),
									u.getAge(),
									u.getPhone(),
									u.getNni(),
									u.getPermis(),
									u.getIsAdmin(),
									u.getLogin()
							 });
						}
					}
					
					
				}
			}
		});
		
		JButton deconnecter = new JButton(user.getName());
		deconnecter.setIcon(new ImageIcon(
				"E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Shutdown_26px.png"));
		deconnecter.setBackground(new Color(0, 102, 204));
		deconnecter.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		deconnecter.setBounds(770, 277, 80, 35);
		
		deconnecter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminGui.this.user = null;
				AdminGui.this.setVisible(false);
				
				new Autentification();
				
			}
		});
		panel_2.add(deconnecter);
		
		JLabel lblLocationVoiture = new JLabel("LOCATION VOITURE");
		lblLocationVoiture.setForeground(Color.WHITE);
		lblLocationVoiture.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblLocationVoiture.setBounds(30, 12, 205, 22);
		contentPane.add(lblLocationVoiture);

		
	}
}
