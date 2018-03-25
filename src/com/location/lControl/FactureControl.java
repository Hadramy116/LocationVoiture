package com.location.lControl;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.location.data.ConnexionDB;
import com.location.data.Facture;
import com.location.data.Location;

public class FactureControl implements IFacture {

	Connection dbCon = ConnexionDB.getDbConnexion();
	private Facture facture ;
	private PreparedStatement ps;
	private List<Facture> factures = new ArrayList<Facture>();
	private Location loc = new Location();
	private LocationControl locCtrl = new LocationControl();
	
	@Override
	public void addFacture(Facture f) {
		
		String sql = "INSERT INTO `facture`(`clientName`, "
				+ "`phone`, `marqueVoiture`, `matricul`, `asserance`,"
				+ " `prixLocation`, `dateDebut`, `dateFin`, `idLoc`)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			ps =  dbCon.prepareStatement(sql);
			ps.setString(1, f.getLoc().getUserConserner().getName());
			ps.setInt(2, f.getLoc().getUserConserner().getPhone());
			ps.setString(3, f.getLoc().getVoitureConserner().getMarque());
			ps.setString(4, f.getLoc().getVoitureConserner().getMatricul());
			ps.setString(5, f.getLoc().getVoitureConserner().getAssurence());
			ps.setInt(6, f.getLoc().getPrix());
			ps.setString(7,f.getLoc().getDateDebut());
			ps.setString(8, f.getLoc().getDateFin());
			ps.setInt(9, f.getLoc().getIdLocation());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteFacture(int id) {
		
		String sql = "DELETE FROM `locationvoiture`.`facture`"
				+ " WHERE `facture`.`idFacture` = ?";
		
		try {
			ps = dbCon.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Facture> getFactures() {
		String sql = "SELECT * FROM `facture`";
		
		try {
			ps = dbCon.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();
			while(rs.next()){
				loc = locCtrl.getLocationById(rs.getInt(10));
				facture = new Facture(rs.getInt(1), loc);
				factures.add(facture);
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return factures;
		
	}

	@Override
	public void imprimerFacture(Facture f) {
		Document document = new Document();
	    try
	    {
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Facture.pdf"));
	        document.open();
	        
	        
	        document.add(new Paragraph("Location Voiture facture"));
	        
	        Image img = Image.getInstance("E:\\1ID COURS\\S3\\Java Courses\\Atelier\\LocationVoiture\\src\\files\\Car_32px.png");
	        document.add(img);
	 
	        PdfPTable table = new PdfPTable(7); // 6 columns.
	        table.setWidthPercentage(100); //Width 100%
	        table.setSpacingBefore(10f); //Space before table
	        table.setSpacingAfter(10f); //Space after table
	 
	        
	 
	        PdfPCell cell;
	        cell = new PdfPCell(new Phrase("Nom"));
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase("Phone"));
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase("Marque voiture"));
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase("Matrcule voiture"));
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase("Prix Location"));
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase("Date de debut"));
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase("Date de fin"));
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        
	        ///Remplire les collonnes
	        
	        cell = new PdfPCell(new Phrase(f.getLoc().getUserConserner().getName()));
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase(f.getLoc().getUserConserner().getPhone()+""));
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase(f.getLoc().getVoitureConserner().getMarque()));
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	
	        cell = new PdfPCell(new Phrase(f.getLoc().getVoitureConserner().getMatricul()));
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase(f.getLoc().getVoitureConserner().getPrix()+""));
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	  
	        cell = new PdfPCell(new Phrase(f.getLoc().getDateDebut()));
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	        
	       
	        cell = new PdfPCell(new Phrase(f.getLoc().getDateFin()));
	        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell.setBorderColor(BaseColor.BLACK);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(cell);
	 
	        document.add(table);
	 
	        document.close();
	        writer.close();
	        
	        Desktop.getDesktop().open(new File("Facture.pdf"));
	    } catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public Facture getFactById(int id) {
		String sql = "SELECT * FROM `facture` WHERE idFacture = ?";
		
		try {
			ps = dbCon.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()){
				loc = locCtrl.getLocationById(rs.getInt(10));
				facture = new Facture(rs.getInt(1), loc);
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return facture;
	}

	@Override
	public Facture getFactureByLocId(int id) {
		String sql = "SELECT * FROM `facture` WHERE idLoc = ?";
		
		try {
			ps = dbCon.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()){
				loc = locCtrl.getLocationById(rs.getInt(10));
				facture = new Facture(rs.getInt(1), loc);
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return facture;
	}

}
