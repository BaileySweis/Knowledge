//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA0302
//*  
//* This program will collect input pertaining to hour and minutes in mountain
//* time and converts it into the time zone specified from user input
//* formatted as "The current time in (TimeZone) is (calculated time and minutes)
//* (Today, Tomorrow, or Yesterday)" on a JOptionPane
//*
//*                         2/20/2022 
//*  
//*                         File Name:  BaileySweisPA0302.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;
public class BaileySweisPA0302 {

	public static void main(String[] args) {
		// Create vars
		String cHour;
		String minute;
		String tZone;
		int cHours;
		int minutes;
		int finOutput = 0;
		String todayTY = null;
		
		// collect input 
		cHour = JOptionPane.showInputDialog(null, "Enter the current hour in the mountain time zone (24-hour format:" );
		minute = JOptionPane.showInputDialog(null, "Enter the minutes:" );
		tZone = JOptionPane.showInputDialog(null, "Enter the destination state for time conversion (2 capital letters):" );
		
		//Parse to int
		cHours = Integer.parseInt(cHour);
		minutes = Integer.parseInt(minute);
		
		//Make sure input is below maximum
		if (cHours > 24) {
			JOptionPane.showMessageDialog(null, "Invalid Input, Exiting System");
			System.exit(0);
		}
		if (minutes > 60) {
			JOptionPane.showMessageDialog(null, "Invalid Input, Exiting System");
			System.exit(0);
		}
		
		//create case 
		switch (tZone){
		case "HI" :
			if (cHours == 1) {
				finOutput = 21 ;
				todayTY = "Yesterday";
			}
			else if (cHours == 2) {
				finOutput = 22 ;
				todayTY = ("Yesterday");
			}
			else if (cHours == 3) {
				finOutput = 23 ;
				todayTY = "Yesterday";
			}
			else if (cHours == 4) {
				finOutput = 24 ;
				todayTY = "Today";
			}
			else {
				finOutput = cHours - 4;
				todayTY = "Today";
			}
			break;
				
		case "AK" :
			if (cHours == 1) {
				finOutput = 23;
				todayTY = "Yesterday";
			}
			else if (cHours == 2) {
				finOutput = 24 ;
				todayTY = ("Today");
			}
			else {
				finOutput = cHours - 2;
				todayTY = "Today";
			}
			break;
			
		case "CA" :
			
		case "ID" :
		
		case "NV" :
			
		case "OR" :
			
		case "WA" :
			if (cHours == 1) {
				finOutput = 24;
				todayTY = "Today";
			}
			else {
				finOutput = cHours - 1;
				todayTY = "Today";
			}
			break;
			
		case "AZ" :
		
		case "CO" :
			
		case "MT" :
			
		case "NM" :
			
		case "UT" :
		
		case "WY" :
			finOutput = cHours;
			todayTY = "Today";
			break;
			
		case "AL" :
			
		case "AR" :
			
		case "IA" :
			
		case "IL" :
			
		case "IN" :
			
		case "KS" :
			
		case "KY" :
			
		case "LA" :
			
		case "MI" :
			
		case "MN" :
			
		case "MO" :
			
		case "MS" :
			
		case "ND" :
			
		case "NE" :
			
		case "OK" :
			
		case "SD" :
			
		case "TN" :
			
		case "TX" :
			
		case "WI" :
			if (cHours == 24) {
				finOutput = 1;
				todayTY = "Tomorrow";
			}
			else if (cHours == 23) {
				finOutput = 24;
				todayTY = "Tomorrow";
			}
			else {
				finOutput = cHours + 1;
				todayTY = "Today";
			}
			break;
			
		case "CT" :
			
		case "DE" :
			
		case "FL" :
			
		case "GA" :
			
		case "MA" :
			
		case "MD" :
			
		case "ME" :
			
		case "NC" :
			
		case "NH" :
			
		case "NJ" :
			
		case "NY" :
			
		case "OH" :
			
		case "PA" :
			
		case "RI" :
			
		case "SC" :
			
		case "VA" :
			
		case "VT" :
			
		case "WV" :
			if (cHours == 24) {
				finOutput = 2;
				todayTY = "Tomorrow";
			}
			else if (cHours == 23) {
				finOutput = 1;
				todayTY = "Tomorrow";
			}
			else if (cHours == 22) {
				finOutput = 24 ;
				todayTY = "Tomorrow";
			}
			else {
				finOutput = cHours + 2;
				todayTY = "Today";
			}
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Invalid Input, Exiting System");
			System.exit(0);
			
		}
		
		// Format minutes under 10 to have a zero in front 
		if (minutes < 10) {
			minute = "0" + minute;
		}
		
		// Output to JOptionPane
		JOptionPane.showMessageDialog(null,
		"The current time in " + tZone + " is "
		+ finOutput + ":" + minute + " " + todayTY);
	} // End main

} // End BaileySweis PA0302
