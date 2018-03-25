package com.location.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import net.sourceforge.jdatepicker.util.JDatePickerUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import com.location.data.Location;
import com.location.data.Reservation;
import com.location.data.Utilisateur;
import com.location.data.Voiture;
import com.location.lControl.LocationControl;
import com.location.lControl.ResControl;


public class ReservationGui extends JFrame {

	private JPanel contentPane;
	private Utilisateur user = new Utilisateur();
	private Voiture voiture = new Voiture();
	
	public ReservationGui(Utilisateur user, Voiture voiture) {
		this.user =  user;
		this.voiture = voiture;
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Car_32px.png"));
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(10, 71, 575, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		UtilDateModel dModel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(dModel);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBackground(new Color(112, 128, 144));
		datePicker.setBounds(157, 68, 172, 26);
		 
		panel.add(datePicker);
		
		
		
		JLabel lblDateFin = new JLabel("Date debut");
		lblDateFin.setForeground(new Color(230, 230, 250));
		lblDateFin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblDateFin.setBounds(30, 65, 84, 36);
		panel.add(lblDateFin);
		
		UtilDateModel dModel2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(dModel2);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBackground(new Color(119, 136, 153));
		datePicker2.setBounds(157, 116, 172, 26);
		
		panel.add(datePicker2);
		
		JLabel label = new JLabel("Date fin");
		label.setForeground(new Color(230, 230, 250));
		label.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		label.setBounds(30, 106, 84, 36);
		panel.add(label);
		
		JLabel lblBonjour = new JLabel("Bonjour");
		lblBonjour.setForeground(new Color(230, 230, 250));
		lblBonjour.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblBonjour.setBounds(30, 0, 84, 25);
		panel.add(lblBonjour);
		
		JLabel lblVoiture = new JLabel("Voiture");
		lblVoiture.setForeground(new Color(230, 230, 250));
		lblVoiture.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblVoiture.setBounds(30, 29, 84, 36);
		panel.add(lblVoiture);
		
		JLabel lblUser = new JLabel(user.getName());
		lblUser.setForeground(new Color(230, 230, 250));
		lblUser.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblUser.setBounds(152, 3, 84, 22);
		panel.add(lblUser);
		
		JLabel lblDonnee = new JLabel(voiture.getModel()+" : "+voiture.getMatricul());
		lblDonnee.setForeground(new Color(230, 230, 250));
		lblDonnee.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblDonnee.setBounds(152, 35, 200, 22);
		panel.add(lblDonnee);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(new Color(0, 0, 205));
		btnValider.setBackground(new Color(230, 230, 250));
		btnValider.setBounds(157, 164, 172, 23);
		panel.add(btnValider);
		
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Date dateD = (Date) datePicker.getModel().getValue();
				Date dateF = (Date) datePicker2.getModel().getValue();
				
				if(dateD == null || dateF == null){
					JOptionPane.showMessageDialog(null, "Date no valide :(");
				}else if(dateF.before(dateD)){
					JOptionPane.showMessageDialog(null, "Date no valide :(");
				}else if(dateD.equals(dateF)){
					JOptionPane.showMessageDialog(null, "Date no valide :(");
				}else{
					
					LocationControl ctrlLoc = new LocationControl();
					//Location loc = new Location();
					
					List<Location> locs = ctrlLoc.getLocationByVoitureId(voiture.getIdVoiture());
					
					if(locs.isEmpty()){
						
						Reservation res = new Reservation(0, user, voiture,
								dateD, dateF);
						ResControl ctrlRes = new ResControl();
						ctrlRes.addRes(res);
						JOptionPane.showMessageDialog(null, "Reserver avec succes");
						ReservationGui.this.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Cette voiture \nN'est pas disponible Pour le moment ?");
						ReservationGui.this.setVisible(false);
					}
				}
					
				}
				
				
		});
		
	}
}

