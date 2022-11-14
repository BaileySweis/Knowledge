//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA01
//*  
//* This project will display personal information on a 
//*	default, warning, question, and plain pane. This project
//* will also spell out my last name (Sweis) in block letters. 
//*  
//*                         1/30/2022 
//*  
//*                         File Name:  BaileySweisPA01.java 
//*  
//*************************************************************************** 
import javax.swing.JOptionPane;

public class BaileySweisPA01 {

	public static void main(String[] args) {
		
		 // Create default message displaying predefined data
		JOptionPane.showMessageDialog(null, 
			"My Name is Bailey Sweis \n" 
			+ "My Phone Number is 310-444-2302 \n" 
			+ "If I add those digits together they add up to: " 
			+ (3+1+0+4+4+4+2+3+0+2));
		
		// Create Warning message displaying predefined data
		JOptionPane.showMessageDialog(null, 
				"My Name is Bailey Sweis \n" 
				+ "My Phone Number is 310-444-2302 \n" 
				+ "If I add those digits together they add up to: " 
				+ (3+1+0+4+4+4+2+3+0+2), 
				"Warning Message", JOptionPane.WARNING_MESSAGE);
		
		// Create Question message displaying predefined data
		JOptionPane.showMessageDialog(null, 
				"My Name is Bailey Sweis \n" 
				+ "My Phone Number is 310-444-2302 \n" 
				+ "If I add those digits together they add up to: " 
				+ (3+1+0+4+4+4+2+3+0+2), 
				"Question Message", JOptionPane.QUESTION_MESSAGE);
		
		 // Create plain Message displaying predefined data
		JOptionPane.showMessageDialog(null, 
				"My Name is Bailey Sweis \n" 
				+ "My Phone Number is 310-444-2302 \n" 
				+ "If I add those digits together they add up to: " 
				+ (3+1+0+4+4+4+2+3+0+2), 
				"Plain Message", JOptionPane.PLAIN_MESSAGE);
		
		// Create Name with block letters 
		System.out.print("     SSSSS     "
				+ "WW               WW              WW"
				+"     EEEEEEEE     IIIIIIII        SSSSS\n"
				+ "    SS         WW              WWWW             WW"
				+"     EE              II          SS\n"
				+ "      SS        WW            WW   WW          WW"
				+"      EE              II             SS\n"
				+ "        SS        WW          WW     WW        WW"
				+"      EEEEEEEE        II               SS\n"
				+ "          SS        WW       WW       WW      WW"
				+"       EEEEEEEE        II              SS\n"
				+ "         SS          WW    WW           WW   WW"
				+"        EE              II             SS\n"
				+ "        SS             WW  WW             WW WW"
				+"        EE              II           SS\n"
				+ "   SSSSS                WWWW               WWWW"
				+"        EEEEEEEE     IIIIIIII    SSSSS");
		
	} // End Main Method 

} // End BaileySweisPA01
