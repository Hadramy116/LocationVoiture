package com.location.presentation;

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

import javax.swing.border.SoftBevelBorder;
import javax.swing.Icon;

import com.location.data.Facture;
import com.location.data.Location;
import com.location.data.Utilisateur;
import com.location.data.Voiture;
import com.location.lControl.FactureControl;
import com.location.lControl.LocationControl;
import com.location.lControl.UtilisateurControl;
import com.location.lControl.VoitureControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;



public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTextField textField_1;
	private JTextField search_loc;
	private JTextField textField_3;
	
	
	private Utilisateur user = new Utilisateur();
	private Voiture voiture = new Voiture();
	private UtilisateurControl ctrlU = new UtilisateurControl();
	private VoitureControl ctrlV = new VoitureControl();
	private Location loc =new Location();
	private LocationControl ctrlLoc = new LocationControl();
	private Facture facture = new Facture();
	private FactureControl ctrlFact = new FactureControl();
	private Voiture voitureRes = new Voiture();
	
	public ClientGUI(Utilisateur user) {
		
		this.user = user;
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Car_32px.png"));
		setBounds(100, 100, 1024, 607);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setBackground(new Color(0, 102, 204));
		tabbedPane.setBounds(12, 31, 986, 525);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("consultez les voitures",
		new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Car_32px.png")
		, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 204));
		panel_1.setBounds(12, 385, 957, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(12, 12, 933, 87);

       
		
		JTable listVoiture = new JTable();
		listVoiture.setFillsViewportHeight(true);
		listVoiture.setShowHorizontalLines(true);
		listVoiture.setShowVerticalLines(false);
		listVoiture.setGridColor(Color.LIGHT_GRAY);
		listVoiture.setBackground(new Color(230, 230, 250));
		listVoiture.setSurrendersFocusOnKeystroke(true);
		listVoiture.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listVoiture.setColumnSelectionAllowed(true);
		listVoiture.getTableHeader().setBackground(new Color(0, 102, 204));
		listVoiture.getTableHeader().setBorder(null);
		listVoiture.getTableHeader().setForeground(Color.WHITE);
		listVoiture.setForeground(Color.WHITE);
		listVoiture.setBackground(new Color(0, 102, 204));
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
					 v.getEtat(),
					 v.getAssurence()
			 });
		 }
		 
		 listVoiture.setModel(model_voiture);
        jScrollPane1.setViewportView(listVoiture);
        
       panel_1.add(jScrollPane1);
       
       JPanel panel_5 = new JPanel();
       panel_5.setBackground(new Color(0, 102, 204));
       panel_5.setLayout(null);
       panel_5.setBounds(12, 12, 957, 361);
       panel.add(panel_5);
       
       JLabel marque_lb = new JLabel("Marque");
       marque_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       marque_lb.setForeground(Color.WHITE);
       marque_lb.setBounds(12, 12, 93, 22);
       panel_5.add(marque_lb);
       
       JLabel marque_c = new JLabel("");
       marque_c.setBounds(117, 12, 209, 16);
       panel_5.add(marque_c);
       
       JLabel model_lb = new JLabel("Model");
       model_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       model_lb.setForeground(new Color(25, 25, 112));
       marque_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       marque_lb.setForeground(new Color(25, 25, 112));
       model_lb.setBounds(12, 42, 55, 16);
       panel_5.add(model_lb);
       
       JLabel matricule_lb = new JLabel("Matricul");
       matricule_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       matricule_lb.setForeground(new Color(25, 25, 112));
       matricule_lb.setBounds(12, 69, 76, 16);
       panel_5.add(matricule_lb);
       
       JLabel color_lb = new JLabel("Couleur");
       color_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       color_lb.setForeground(new Color(25, 25, 112));
       color_lb.setBounds(12, 98, 81, 20);
       panel_5.add(color_lb);
       
       JLabel kilomet_lb = new JLabel("kilometrage");
       kilomet_lb.setForeground(new Color(25, 25, 112));
       kilomet_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       kilomet_lb.setBounds(12, 130, 81, 20);
       panel_5.add(kilomet_lb);
       
       JLabel carbur_lb = new JLabel("Carburant");
       carbur_lb.setForeground(new Color(25, 25, 112));
       carbur_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       carbur_lb.setBounds(12, 158, 81, 20);
       panel_5.add(carbur_lb);
       
       JLabel bt_vitess_lb = new JLabel("Boite de vitesse");
       bt_vitess_lb.setForeground(new Color(25, 25, 112));
       bt_vitess_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       bt_vitess_lb.setBounds(12, 194, 93, 20);
       panel_5.add(bt_vitess_lb);
       
       JLabel prix_lb = new JLabel("prix");
       prix_lb.setForeground(new Color(25, 25, 112));
       prix_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       prix_lb.setBounds(704, 13, 81, 20);
       panel_5.add(prix_lb);
       
       JLabel etat_lb = new JLabel("Etat");
       etat_lb.setForeground(new Color(25, 25, 112));
       etat_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       etat_lb.setBounds(704, 40, 81, 20);
       panel_5.add(etat_lb);
       
       JLabel assure_lb = new JLabel("assurence");
       assure_lb.setForeground(new Color(25, 25, 112));
       assure_lb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       assure_lb.setBounds(704, 67, 81, 20);
       panel_5.add(assure_lb);
       
       JLabel model_c = new JLabel("");
       model_c.setForeground(new Color(25, 25, 112));
       model_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       model_c.setBounds(117, 43, 178, 20);
       panel_5.add(model_c);
       
       JLabel matricule_c = new JLabel("");
       matricule_c.setForeground(new Color(25, 25, 112));
       matricule_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       matricule_c.setBounds(117, 70, 149, 20);
       panel_5.add(matricule_c);
       
       JLabel color_c = new JLabel("");
       color_c.setForeground(new Color(25, 25, 112));
       color_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       color_c.setBounds(117, 101, 99, 20);
       panel_5.add(color_c);
       
       JLabel kilomet_c = new JLabel("");
       kilomet_c.setForeground(new Color(25, 25, 112));
       kilomet_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       kilomet_c.setBounds(117, 126, 81, 20);
       panel_5.add(kilomet_c);
       
       JLabel carbur_c = new JLabel("");
       carbur_c.setForeground(new Color(25, 25, 112));
       carbur_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       carbur_c.setBounds(117, 154, 81, 20);
       panel_5.add(carbur_c);
       
       JLabel prix_c = new JLabel("");
       prix_c.setForeground(new Color(25, 25, 112));
       prix_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       prix_c.setBounds(797, 16, 81, 20);
       panel_5.add(prix_c);
       
       JLabel etat_c = new JLabel("");
       etat_c.setForeground(new Color(25, 25, 112));
       etat_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       etat_c.setBounds(797, 42, 81, 20);
       panel_5.add(etat_c);
       
       search = new JTextField();
       search.setBounds(212, 282, 158, 34);
       panel_5.add(search);
       search.setColumns(10);
       
       JButton btnNewButton = new JButton("");
       btnNewButton.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Search_32px.png"));
       btnNewButton.setForeground(Color.WHITE);
       btnNewButton.setBackground(new Color(0, 102, 204));
       
       btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) {
       		
       		//JOptionPane.showMessageDialog(null, search.getText());
       		if(search.getText().isEmpty())
       			JOptionPane.showMessageDialog(null, "le chemps de recherch vide :(");
       		else{
       		   List<Voiture> voitures = new ArrayList<Voiture>();
       		   voitures = ctrlV.findVoiture(search.getText().trim());
	       		if(voitures.isEmpty()){
	       			JOptionPane.showMessageDialog(null, "Rien trouver :(");
	       		}else{
	       			for(Voiture v: voitures){
	           			for (int i = 0; i < model_voiture.getRowCount(); i++) {
	    					model_voiture.removeRow(i);
	    				}
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
	       					 v.getEtat(),
	       					 v.getAssurence()
	       			 });
	           		}
	       		}
       		
       		}
       	}
       });
       btnNewButton.setBounds(373, 282, 55, 34);
       panel_5.add(btnNewButton);
       
       JButton btnReserver = new JButton("Reserver");
       btnReserver.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Hand With Pen_32px.png"));
       btnReserver.setForeground(Color.WHITE);
       
       
       btnReserver.setBackground(new Color(0, 102, 204));
       btnReserver.setBounds(433, 282, 140, 34);
       panel_5.add(btnReserver);
       
       JPanel panel_6 = new JPanel();
       panel_6.setBackground(new Color(0, 102, 204));
       panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205)));
       panel_6.setBounds(344, 12, 319, 205);
       panel_5.add(panel_6);
       panel_6.setLayout(null);
       
       JPanel panel_7 = new JPanel();
       panel_7.setBounds(159, 8, 1, 1);
       panel_7.setLayout(null);
       panel_7.setBackground(new Color(230, 230, 250));
       panel_6.add(panel_7);
       
       JLabel label_18 = new JLabel("Marque");
       label_18.setForeground(new Color(25, 25, 112));
       label_18.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_18.setBounds(12, 12, 93, 22);
       panel_7.add(label_18);
       
       JLabel label_19 = new JLabel("");
       label_19.setBounds(117, 12, 209, 16);
       panel_7.add(label_19);
       
       JLabel label_20 = new JLabel("Model");
       label_20.setForeground(new Color(25, 25, 112));
       label_20.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_20.setBounds(12, 42, 55, 16);
       panel_7.add(label_20);
       
       JLabel label_21 = new JLabel("Matricul");
       label_21.setForeground(new Color(25, 25, 112));
       label_21.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_21.setBounds(12, 69, 76, 16);
       panel_7.add(label_21);
       
       JLabel label_22 = new JLabel("Couleur");
       label_22.setForeground(new Color(25, 25, 112));
       label_22.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_22.setBounds(12, 98, 81, 20);
       panel_7.add(label_22);
       
       JLabel label_23 = new JLabel("kilometrage");
       label_23.setForeground(new Color(25, 25, 112));
       label_23.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_23.setBounds(12, 130, 81, 20);
       panel_7.add(label_23);
       
       JLabel label_24 = new JLabel("Carburant");
       label_24.setForeground(new Color(25, 25, 112));
       label_24.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_24.setBounds(12, 158, 81, 20);
       panel_7.add(label_24);
       
       JLabel label_25 = new JLabel("Boite de vitesse");
       label_25.setForeground(new Color(25, 25, 112));
       label_25.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_25.setBounds(12, 194, 93, 20);
       panel_7.add(label_25);
       
       JLabel label_26 = new JLabel("prix");
       label_26.setForeground(new Color(25, 25, 112));
       label_26.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_26.setBounds(704, 13, 81, 20);
       panel_7.add(label_26);
       
       JLabel label_27 = new JLabel("Etat");
       label_27.setForeground(new Color(25, 25, 112));
       label_27.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_27.setBounds(704, 40, 81, 20);
       panel_7.add(label_27);
       
       JLabel label_28 = new JLabel("assurence");
       label_28.setForeground(new Color(25, 25, 112));
       label_28.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_28.setBounds(704, 67, 81, 20);
       panel_7.add(label_28);
       
       JLabel label_29 = new JLabel("");
       label_29.setForeground(new Color(25, 25, 112));
       label_29.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       label_29.setBounds(117, 16, 81, 20);
       panel_7.add(label_29);
       
       JLabel photo = new JLabel(new ImageIcon("C:\\Users\\EL Hadramy Ahmed\\Downloads\\car.png"));
       photo.setBounds(12, 8, 300, 200);
       panel_6.add(photo);
       
       JLabel bt_vitess_c = new JLabel("");
       bt_vitess_c.setForeground(new Color(25, 25, 112));
       bt_vitess_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       bt_vitess_c.setBounds(117, 197, 122, 20);
       panel_5.add(bt_vitess_c);
       
       JLabel assure_c = new JLabel("");
       assure_c.setForeground(new Color(25, 25, 112));
       assure_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
       assure_c.setBounds(797, 70, 81, 20);
       panel_5.add(assure_c);
       
       listVoiture.addMouseListener(new MouseAdapter() {
      		@Override
      		public void mouseClicked(MouseEvent arg0) {
      			voiture = ctrlV.getVoitureById((int)listVoiture.getValueAt(listVoiture.getSelectedRow(), 0));
      			marque_c.setText(voiture.getMarque());
      			model_c.setText(voiture.getModel());
      			matricule_c.setText(voiture.getMatricul());
      			color_c.setText(voiture.getColor());
      			kilomet_c.setText(Integer.toString(voiture.getKilometrage()));	
      			carbur_c.setText(voiture.getCarburant());
      			bt_vitess_c.setText(voiture.getBoiteVitess());
      			prix_c.setText(Integer.toString(voiture.getPrix()));
      			etat_c.setText(voiture.getEtat());
      			assure_c.setText(voiture.getAssurence());
      			
      			photo.setIcon(new ImageIcon(voiture.getImage()));
      		}
          });
       
       btnReserver.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		if(listVoiture.getSelectedRow() != -1){
	          		voiture = ctrlV.getVoitureById((int)listVoiture.getValueAt(listVoiture.getSelectedRow(), 0));
	          		//System.out.println(voiture.getModel());
	          		new ReservationGui(user,voiture);
          		}else{
          			JOptionPane.showMessageDialog(null, "Veuillez selectionner une voiture :(");
          		}
          	}
          });
       /*******************
        * 
        * Location Part
        * 
        * 
        */
    
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("location", 
		new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Key_32px.png"), panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(0, 102, 204));
		panel_8.setBounds(0, 0, 981, 497);
		panel_2.add(panel_8);
		
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
		jTableLoc.setGridColor(Color.LIGHT_GRAY);
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
		
		 for(Location l : ctrlLoc.getLocByUserId(user.getIdUser())){
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
		
		JLabel loc_marque = new JLabel("Marque");
		loc_marque.setForeground(new Color(25, 25, 112));
		loc_marque.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_marque.setBounds(12, 12, 93, 22);
		panel_10.add(loc_marque);
		
		JLabel loc_marque_c = new JLabel("");
		loc_marque_c.setBounds(117, 12, 209, 16);
		panel_10.add(loc_marque_c);
		
		JLabel loc_model = new JLabel("Model");
		loc_model.setForeground(new Color(25, 25, 112));
		loc_model.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_model.setBounds(12, 42, 55, 16);
		panel_10.add(loc_model);
		
		JLabel loc_matricul = new JLabel("Matricul");
		loc_matricul.setForeground(new Color(25, 25, 112));
		loc_matricul.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_matricul.setBounds(12, 69, 76, 16);
		panel_10.add(loc_matricul);
		
		JLabel loc_kilom = new JLabel("kilometrage");
		loc_kilom.setForeground(new Color(25, 25, 112));
		loc_kilom.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_kilom.setBounds(12, 101, 81, 20);
		panel_10.add(loc_kilom);
		
		JLabel loc_carb = new JLabel("Carburant");
		loc_carb.setForeground(new Color(25, 25, 112));
		loc_carb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_carb.setBounds(12, 126, 81, 20);
		panel_10.add(loc_carb);
		
		JLabel loc_nom = new JLabel("Nom");
		loc_nom.setForeground(new Color(25, 25, 112));
		loc_nom.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_nom.setBounds(12, 154, 93, 20);
		panel_10.add(loc_nom);
		
		JLabel loc_prix = new JLabel("prix");
		loc_prix.setForeground(new Color(25, 25, 112));
		loc_prix.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_prix.setBounds(704, 13, 81, 20);
		panel_10.add(loc_prix);
		
		JLabel loc_date_d = new JLabel("Date debut");
		loc_date_d.setForeground(new Color(25, 25, 112));
		loc_date_d.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_date_d.setBounds(704, 40, 81, 20);
		panel_10.add(loc_date_d);
		
		JLabel loc_date_f = new JLabel("Date fin");
		loc_date_f.setForeground(new Color(25, 25, 112));
		loc_date_f.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_date_f.setBounds(704, 67, 81, 20);
		panel_10.add(loc_date_f);
		
		JLabel loc_model_c = new JLabel("");
		loc_model_c.setForeground(new Color(25, 25, 112));
		loc_model_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_model_c.setBounds(117, 43, 81, 20);
		panel_10.add(loc_model_c);
		
		JLabel loc_matricul_c = new JLabel("");
		loc_matricul_c.setForeground(new Color(25, 25, 112));
		loc_matricul_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_matricul_c.setBounds(117, 70, 116, 20);
		panel_10.add(loc_matricul_c);
		
		JLabel loc_kilom_c = new JLabel("");
		loc_kilom_c.setForeground(new Color(25, 25, 112));
		loc_kilom_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_kilom_c.setBounds(117, 101, 81, 20);
		panel_10.add(loc_kilom_c);
		
		JLabel loc_carb_c = new JLabel("");
		loc_carb_c.setForeground(new Color(25, 25, 112));
		loc_carb_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_carb_c.setBounds(117, 126, 81, 20);
		panel_10.add(loc_carb_c);
		
		JLabel loc_nom_c = new JLabel("");
		loc_nom_c.setForeground(new Color(25, 25, 112));
		loc_nom_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_nom_c.setBounds(117, 154, 81, 20);
		panel_10.add(loc_nom_c);
		
		JLabel loc_phone_c = new JLabel("");
		loc_phone_c.setForeground(new Color(25, 25, 112));
		loc_phone_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_phone_c.setBounds(84, 177, 114, 20);
		panel_10.add(loc_phone_c);
		
		JLabel loc_prix_c = new JLabel("");
		loc_prix_c.setForeground(new Color(25, 25, 112));
		loc_prix_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_prix_c.setBounds(797, 16, 81, 20);
		panel_10.add(loc_prix_c);
		
		JLabel loc_date_d_c = new JLabel("");
		loc_date_d_c.setForeground(new Color(25, 25, 112));
		loc_date_d_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_date_d_c.setBounds(797, 42, 81, 20);
		panel_10.add(loc_date_d_c);
		
		search_loc = new JTextField();
		search_loc.setColumns(10);
		search_loc.setBounds(212, 284, 158, 32);
		panel_10.add(search_loc);
		
		JButton btnChercher = new JButton("");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChercher.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Search_32px.png"));
		btnChercher.setForeground(Color.WHITE);
		btnChercher.setBackground(new Color(0, 102, 204));
		btnChercher.setBounds(376, 284, 98, 32);
		panel_10.add(btnChercher);
		
		JButton btnImprimerFacture = new JButton("imprimer facture");
		btnImprimerFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				loc = ctrlLoc.getLocationById((int)jTableLoc.getValueAt(jTableLoc.getSelectedRow(), 0));
				facture = new Facture(0, loc);
				
				if(ctrlFact.getFactureByLocId(loc.getIdLocation()) == null)
						ctrlFact.addFacture(facture);
					
				ctrlFact.imprimerFacture(facture);
			}
		});
		btnImprimerFacture.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Print_32px.png"));
		btnImprimerFacture.setForeground(Color.WHITE);
		btnImprimerFacture.setBackground(new Color(0, 102, 204));
		btnImprimerFacture.setBounds(488, 284, 199, 32);
		panel_10.add(btnImprimerFacture);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 102, 204), new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205)));
		panel_11.setBackground(new Color(0, 102, 204));
		panel_11.setBounds(344, 12, 319, 205);
		panel_10.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(0, 102, 204));
		panel_12.setBounds(159, 8, 1, 1);
		panel_11.add(panel_12);
		
		JLabel label_59 = new JLabel("Marque");
		label_59.setForeground(new Color(25, 25, 112));
		label_59.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_59.setBounds(12, 12, 93, 22);
		panel_12.add(label_59);
		
		JLabel label_60 = new JLabel("");
		label_60.setBounds(117, 12, 209, 16);
		panel_12.add(label_60);
		
		JLabel label_61 = new JLabel("Model");
		label_61.setForeground(new Color(25, 25, 112));
		label_61.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_61.setBounds(12, 42, 55, 16);
		panel_12.add(label_61);
		
		JLabel label_62 = new JLabel("Matricul");
		label_62.setForeground(new Color(25, 25, 112));
		label_62.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_62.setBounds(12, 69, 76, 16);
		panel_12.add(label_62);
		
		JLabel label_63 = new JLabel("Couleur");
		label_63.setForeground(new Color(25, 25, 112));
		label_63.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_63.setBounds(12, 98, 81, 20);
		panel_12.add(label_63);
		
		JLabel label_64 = new JLabel("kilometrage");
		label_64.setForeground(new Color(25, 25, 112));
		label_64.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_64.setBounds(12, 130, 81, 20);
		panel_12.add(label_64);
		
		JLabel label_65 = new JLabel("Carburant");
		label_65.setForeground(new Color(25, 25, 112));
		label_65.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_65.setBounds(12, 158, 81, 20);
		panel_12.add(label_65);
		
		JLabel label_66 = new JLabel("Boite de vitesse");
		label_66.setForeground(new Color(25, 25, 112));
		label_66.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_66.setBounds(12, 194, 93, 20);
		panel_12.add(label_66);
		
		JLabel label_67 = new JLabel("prix");
		label_67.setForeground(new Color(25, 25, 112));
		label_67.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_67.setBounds(704, 13, 81, 20);
		panel_12.add(label_67);
		
		JLabel label_68 = new JLabel("Etat");
		label_68.setForeground(new Color(25, 25, 112));
		label_68.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_68.setBounds(704, 40, 81, 20);
		panel_12.add(label_68);
		
		JLabel label_69 = new JLabel("assurence");
		label_69.setForeground(new Color(25, 25, 112));
		label_69.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		label_69.setBounds(704, 67, 81, 20);
		panel_12.add(label_69);
		
		JLabel loc_photo = new JLabel((Icon) null);
		loc_photo.setBounds(12, 8, 295, 185);
		panel_11.add(loc_photo);
		
		JLabel loc_phone = new JLabel("Phone");
		loc_phone.setForeground(new Color(25, 25, 112));
		loc_phone.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_phone.setBounds(12, 177, 93, 20);
		panel_10.add(loc_phone);
		
		JLabel loc_date_f_c = new JLabel("");
		loc_date_f_c.setForeground(new Color(25, 25, 112));
		loc_date_f_c.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		loc_date_f_c.setBounds(797, 70, 116, 22);
		panel_10.add(loc_date_f_c);
		
		
		jTableLoc.addMouseListener(new MouseAdapter() {
      		@Override
      		public void mouseClicked(MouseEvent arg0) {
      			
      			if(jTableLoc.getSelectedRow() != -1){
      			loc = ctrlLoc.getLocationById((int)jTableLoc.getValueAt(jTableLoc.getSelectedRow(), 0));
      			
      			loc_marque_c.setText(loc.getVoitureConserner().getMarque());
      			loc_model_c.setText(loc.getVoitureConserner().getModel());
      			loc_matricul_c.setText(loc.getVoitureConserner().getMatricul());
      			loc_kilom_c.setText(Integer.toString(loc.getVoitureConserner().getKilometrage()));
      			loc_carb_c.setText(loc.getVoitureConserner().getCarburant());	
      			loc_nom_c.setText(loc.getUserConserner().getName());
      			loc_phone_c.setText(Integer.toString(loc.getUserConserner().getPhone()));
      			loc_prix_c.setText(Integer.toString(loc.getPrix()));
      			loc_date_d_c.setText(loc.getDateDebut());
      			loc_date_f_c.setText(loc.getDateFin());
      			
      			loc_photo.setIcon(new ImageIcon(loc.getVoitureConserner().getImage()));
      	
      			}
      		}
          });
		
		
		/******
		 * Debut facture tabe
		 * 
		 */
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("facture", 
				new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Bill_32px.png"), panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(0, 102, 204));
		panel_13.setBounds(12, 57, 957, 358);
		panel_3.add(panel_13);
		panel_13.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 90, 933, 256);
		panel_13.add(scrollPane_1);
		
		JTable jTableFact = new JTable();
		jTableFact.setFillsViewportHeight(true);
		jTableFact.setShowHorizontalLines(true);
		jTableFact.setShowVerticalLines(false);
		jTableFact.setGridColor(Color.LIGHT_GRAY);
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
			// System.out.println(l.getDateDebut()+" set");
			 if(user.getIdUser() == f.getLoc().getUserConserner().getIdUser()){
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
		 }
		 
		 jTableFact.setModel(model_fact);
		 scrollPane_1.add(jTableFact);
		
		scrollPane_1.setViewportView(jTableFact);
		
		JLabel lblListeDesFacture = new JLabel("Liste des facture");
		lblListeDesFacture.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblListeDesFacture.setForeground(new Color(0, 0, 139));
		lblListeDesFacture.setBackground(new Color(230, 230, 250));
		lblListeDesFacture.setBounds(12, 34, 149, 16);
		panel_13.add(lblListeDesFacture);
		
		/*
		JButton btnImprimerUneFacture = new JButton("Imprimer une facture");
		btnImprimerUneFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//ctrlFact.imprimerFacture(facture);
				//System.out.println(facture.getLoc().getUserConserner().getNni());
			}
			
		});
		btnImprimerUneFacture.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Print_32px.png"));
		btnImprimerUneFacture.setForeground(new Color(230, 230, 250));
		btnImprimerUneFacture.setBackground(new Color(65, 105, 225));
		btnImprimerUneFacture.setBounds(179, 27, 201, 29);
		panel_13.add(btnImprimerUneFacture);*/
        
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 102, 204));
		tabbedPane.addTab("profile", 
		new	ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Circled User Male_32px.png")	, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(0, 102, 204));
		panel_14.setBounds(12, 74, 957, 336);
		panel_4.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Circled User Male_100px.png"));
		lblNewLabel_1.setBounds(55, 30, 112, 185);
		panel_14.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel(user.getName());
		lblUsername.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		lblUsername.setForeground(new Color(0, 0, 128));
		lblUsername.setBounds(262, 42, 84, 16);
		panel_14.add(lblUsername);
		
		JLabel label_43 = new JLabel(user.getPrenom());
		label_43.setForeground(new Color(0, 0, 128));
		label_43.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label_43.setBounds(262, 70, 84, 16);
		panel_14.add(label_43);
		
		JLabel label_46 = new JLabel(user.getLogin());
		label_46.setForeground(new Color(0, 0, 128));
		label_46.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label_46.setBounds(262, 103, 84, 16);
		panel_14.add(label_46);
		
		JLabel label_48 = new JLabel(Integer.toString(user.getAge()));
		label_48.setForeground(new Color(0, 0, 128));
		label_48.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label_48.setBounds(262, 137, 84, 16);
		panel_14.add(label_48);
		
		JLabel label_49 = new JLabel(Integer.toString(user.getPhone()));
		label_49.setForeground(new Color(0, 0, 128));
		label_49.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label_49.setBounds(382, 42, 84, 16);
		panel_14.add(label_49);
		
		JLabel label_81 = new JLabel(Integer.toString(user.getNni()));
		label_81.setForeground(new Color(0, 0, 128));
		label_81.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label_81.setBounds(382, 70, 84, 16);
		panel_14.add(label_81);
		
		JButton btnModifierTonProphile = new JButton("Modifier ton profle");
		btnModifierTonProphile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				new UpdateUserGui(user);
			}
		});
		btnModifierTonProphile.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Edit File_32px.png"));
		btnModifierTonProphile.setForeground(new Color(255, 255, 255));
		btnModifierTonProphile.setBackground(new Color(0, 102, 204));
		btnModifierTonProphile.setBounds(30, 227, 186, 42);
		panel_14.add(btnModifierTonProphile);
		
		JButton deconnecter = new JButton("deconnxion");
		deconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientGUI.this.setVisible(false);
				ClientGUI.this.user = null;
				new Autentification();
			}
		});
		deconnecter.setIcon(new ImageIcon("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Shutdown_26px.png"));
		deconnecter.setForeground(new Color(255, 255, 255));
		deconnecter.setBackground(new Color(0, 102, 204));
		deconnecter.setBounds(232, 227, 186, 42);
		panel_14.add(deconnecter);
		
		
		
		JLabel lblLocationVoiture = new JLabel("LOCATION VOITURE");
		lblLocationVoiture.setForeground(new Color(25, 25, 112));
		lblLocationVoiture.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblLocationVoiture.setBounds(30, 12, 205, 22);
		contentPane.add(lblLocationVoiture);
	}
}
