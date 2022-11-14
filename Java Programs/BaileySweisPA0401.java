//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA0401
//*  
//* This program will Collect input from a user pertaining to registration for
//* a school and then will produce a total tuition fee as well as other fees and
//* classes to a JOptionPane
//*
//*                         3/6/2022 
//*  
//*                         File Name:  BaileySweisPA0401.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;
public class BaileySweisPA0401 {
	
	// Method to calculate Total tuition 
	public static double total_tuit(double gen_fee, double health_fee, double price) {
		return gen_fee + health_fee + price;
	} // End total_tuit 
	
	// Method to calculate Health fee
	public static double health_fee(int credits) {
		final double FEEU9 = 589.32;
		final double FEEO9 = 897.65;
		if (credits < 9) {
			return FEEU9; 
		}
		else {
			return FEEO9;
		}
	} // End health_fee
	
	// Method to calculate General fee
	public static double gen_fee(int credits) {
		final double FEEU9 = 89.34;
		final double FEEO9 = 804.06;
		if (credits < 9) {
			return credits * FEEU9; 
		}
		else {
			return FEEO9;
		}
	} // End gen_fee

	public static void main(String[] args) {
		//Final Variables
		final String ONLINE = "Online";
		final String ON_CAMPUS = "On-Campus";
		final int NUMC1 = 3;
		final int NUMC15 = 4;
		final int NUMC25 = 3;
		final int NUMC3 = 4;
		final int PRICEON1 = 2800;
		final int PRICEON15 = 4000;
		final int PRICEON25 = 3200;
		final int PRICEON3 = 4500;
		final int PRICEOC1 = 3000;
		final int PRICEOC15 = 4100;
		final int PRICEOC25 = 3450;
		final int PRICEOC3 = 4700;
		//Create Variables
		int course;
		String campus, strCourse;
		int whilest = 1;
		int numCred = 0;
		double price = 0;
		boolean check = true;
		double gen_fee;
		double health_fee;
		double tuit;
		String classes = "";
		String finOutput;
		boolean numInput1 = true;
		boolean numInput15 = true;
		boolean numInput25 = true;
		boolean numInput3 = true;
		
		//While loop to ask for inputs
		while (whilest == 1) { // to check when the main loop should be exited
			campus = JOptionPane.showInputDialog(null, "Type: 'Online' for Online Students\n"
					  + "Type: 'On-Campus' for On-Campus Students");
			while(check == true) { //To check when this loop should be exited
				if (campus.equals(ONLINE)) { //If campus equals online
					try { //beginning of try catch block
						strCourse = JOptionPane.showInputDialog(null, "Enter a Course Number (100/150/250/300)" 
						+ "\nEnter (0) to end registration");
						course = Integer.parseInt(strCourse);
						if (course > 0) {
							if ((numInput1 == true) && (course == 100)){
								classes += "100 \n";
								numCred += NUMC1;
								price += PRICEON1;
								numInput1 = false;
							}
							else if ((course == 100) && (numInput1 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else if ((numInput15 == true) && (course == 150)){
								classes += "150 \n";
								numCred += NUMC15;
								price += PRICEON15;
								numInput15 = false;
							}
							else if ((course == 150) && (numInput15 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else if ((numInput25 == true) && (course == 250)){
								classes += "250 \n";
								numCred += NUMC25;
								price += PRICEON25;
								numInput25 = false;
							}
							else if ((course == 250) && (numInput25 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else if ((numInput3 == true) && (course == 300)){
								classes += "300 \n";
								numCred += NUMC3;
								price += PRICEON3;
								numInput3 = false;
							}
							else if ((course == 300) && (numInput3 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid input");
								continue;
							}
						}
						else if (course == 0) { //Outputs code to JOptionPane and exits loops
							gen_fee = gen_fee(numCred);
							health_fee = health_fee(numCred);
							tuit = total_tuit(gen_fee, health_fee, price);
							finOutput = "Type of Student: " + campus + "\n" + "\n";
							finOutput += "Courses Registered: \n" + classes + "\n"; 
							finOutput += "Total Number of Credits: " + numCred + "\n";
							finOutput += String.format("General fee: $%.2f\n", gen_fee);
							finOutput += String.format("Health insurance fee: $%.2f\n", health_fee);
							finOutput += String.format("Course fee: $%.2f\n", price);
							finOutput += String.format("\nTotal tuition fee: $%.2f", tuit);
							JOptionPane.showMessageDialog(null, finOutput);
							whilest = 2;
							check = false;
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Input Try Again");
							check = true;
							campus = ONLINE;
							whilest = 1;
						}
					}
					//Catch block to catch non numerical values and return a JOptionPane
					catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Invalid Input, Try Again");
						continue;
					}
				}
				else if (campus.equals(ON_CAMPUS)) {
					try {
						strCourse = JOptionPane.showInputDialog(null, "Enter a Course Number (100/150/250/300)" 
						+ "\nEnter (0) to end registration");
						course = Integer.parseInt(strCourse);
						if (course > 0) {
							if ((numInput1 == true) && (course == 100)){
								classes += "100 \n";
								numCred += NUMC1;
								price += PRICEOC1;
								numInput1 = false;
							}
							else if ((course == 100) && (numInput1 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else if ((numInput15 == true) && (course == 150)){
								classes += "150 \n";
								numCred += NUMC15;
								price += PRICEOC15;
								numInput15 = false;
							}
							else if ((course == 150) && (numInput15 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else if ((numInput25 == true) && (course == 250)){
								classes += "250 \n";
								numCred += NUMC25;
								price += PRICEOC25;
								numInput25 = false;
							}
							else if ((course == 250) && (numInput25 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else if ((numInput3 == true) && (course == 300)){
								classes += "300 \n";
								numCred += NUMC3;
								price += PRICEOC3;
								numInput3 = false;
							}
							else if ((course == 300) && (numInput3 == false)){
								JOptionPane.showMessageDialog(null, "Already Registered");
								continue;
							}
							else {
								JOptionPane.showMessageDialog(null, "Invalid input");
								continue;
							}
						}
						else if (course == 0) {
							gen_fee = gen_fee(numCred);
							health_fee = health_fee(numCred);
							tuit = total_tuit(gen_fee, health_fee, price);
							finOutput = "Type of Student: " + campus + "\n" + "\n";
							finOutput += "Courses Registered: \n" + classes + "\n"; 
							finOutput += "Total Number of Credits: " + numCred + "\n";
							finOutput += String.format("General fee: $%.2f\n", gen_fee);
							finOutput += String.format("Health insurance fee: $%.2f\n", health_fee);
							finOutput += String.format("Course fee: $%.2f\n", price);
							finOutput += String.format("\nTotal tuition fee: $%.2f", tuit);
							JOptionPane.showMessageDialog(null, finOutput);
							whilest = 2;
							check = false;
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Input Try Again");
							campus = ON_CAMPUS;
							whilest = 1;
						}
					}
				
					catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Invalid Input, Try Again");
						continue;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Input Try Again");
					break;
				}
			}
		}
	} //End Main
} // End BaileySweisPA0401
