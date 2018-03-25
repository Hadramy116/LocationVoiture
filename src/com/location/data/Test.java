package com.location.data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.location.lControl.LocationControl;
import com.location.lControl.ResControl;
import com.location.lControl.UtilisateurControl;
import com.location.lControl.VoitureControl;


public class Test {

	public static void main(String[] args){
		
		UtilisateurControl ctrlU = new UtilisateurControl();
	
		
		Utilisateur user = new Utilisateur(0, "sidi", "Ahmed", 22, "w232", false, 22222
						, 0, "sidi", "123", 12323);
		
		user = ctrlU.autenficateUser("uu", "admin");
		
		
		
		
		// 2006-05-01
		long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
				Calendar calendar1 = new GregorianCalendar();
				calendar1.set(Calendar.YEAR, 2016);
				calendar1.set(Calendar.MONTH, 1);
				calendar1.set(Calendar.DAY_OF_MONTH, 1);
				Date date1 = calendar1.getTime();
				//  2006-08-15
				Calendar calendar2 = new GregorianCalendar();
				calendar2.set(Calendar.YEAR, 2016);
				calendar2.set(Calendar.MONTH, 4);
				calendar2.set(Calendar.DAY_OF_MONTH, 15);
				Date date2 = calendar2.getTime();
				// Différence
				long diff = Math.abs(date2.getTime() - date1.getTime());
				long numberOfDay = (long)diff/CONST_DURATION_OF_DAY;
				System.err.println("Le nombre de jour est : " + numberOfDay);
		
		
	}
	

}
