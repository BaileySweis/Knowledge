//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA0502
//*  
//* This program will Collect input from a user pertaining to a ride service
//* it will then ask a series of questions and compute the total 
//* to a JOptionPane
//*
//*                         3/27/2022 
//*  
//*                         File Name:  BaileySweisPA0502.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;

public class BaileySweisPA0502 {
	//Collect int input and validate it
	public static int getIntInput(boolean lowerLimitFlag, int lowerLimit,
			boolean upperLimitFlag, int upperLimit, String prompt, String errorMsg) {
		String prompter;
		int num = 0, fin = 0;
		boolean check = true;
		while (check == true) {
			try {
				prompter = JOptionPane.showInputDialog(null,prompt);
				num = Integer.parseInt(prompter);
				if (lowerLimitFlag == true) {
					if (num < lowerLimit) {
						JOptionPane.showMessageDialog(null, errorMsg);
						continue;
					}
					else {
						fin = num;
						check = false;
					}
				}
				if (upperLimitFlag == true) {
					if (num > upperLimit) {
						JOptionPane.showMessageDialog(null, errorMsg);
						check = true;
					}
					else {
						fin = num;
						check = false;
					}
				}
			}
			catch (NumberFormatException ex){
				JOptionPane.showMessageDialog(null, errorMsg);
				continue;
			}
		}
		return fin;
	}
	//Calc Travel charges for multiple passengers
	public static double calculateTravelCharges(int route_num, int num_of_passengers) {
		final double route1Dp = 60.00;
		final double route1Mp = 26.50;
		final double route2Dp = 53.12;
		final double route2Mp = 24.20;
		final double route3Dp = 63.78;
		final double route3Mp = 28.78;

		double num;

		if ((route_num == 1) && (num_of_passengers == 2)){
			num = route1Dp;
		}
		else if ((route_num == 1) && (num_of_passengers > 2)) {
			num = num_of_passengers * route1Mp;
		}
		else if ((route_num == 2) && (num_of_passengers == 2)) {
			num = route2Dp;
		}
		else if ((route_num == 2) && (num_of_passengers > 2)) {
			num = num_of_passengers * route2Mp;
		}
		else if ((route_num == 3) && (num_of_passengers == 2)) {
			num = route3Dp;
		}
		else{
			num = num_of_passengers * route3Mp;
		}
		return num;


	}
	// Calc travel for only one passenger
	public static double calculateTravelCharges(int route_num) {
		final double route1Sp = 35.00;
		final double route2Sp = 32.89;
		final double route3Sp = 38.00;

		double num;

		if (route_num == 1) {
			num = route1Sp;
		}
		else if (route_num == 2) {
			num = route2Sp;
		}
		else {
			num = route3Sp;
		}
		return num;
	}
	// Calculates membership discounts
	public static double calculateMembershipDiscount(double travelCharges, double discountRate) {
		final double MdSp = 0.05;
		final double MdDp = 0.062;
		final double MdMp = 0.08;

		double num;

		if ((travelCharges == 35.00) || (travelCharges == 32.89) || (travelCharges == 38.00)){
			num = travelCharges * MdSp;
		}
		else if ((travelCharges == 60.00) || (travelCharges == 53.12) || (travelCharges == 63.78)){
			num = travelCharges * MdDp;
		}
		else {
			num = travelCharges * MdMp;
		}
		return num;

	}
	// Calculate coupon discount
	public static double calculateCouponDiscount(double travelCharges, int numPassengers) {
		final int COUPON_DISCOUNT = 5;

		double num;

		num = COUPON_DISCOUNT;
		return num;
	}
	// calculates first time user discount
	public static double calculateFirstTimeUserDiscount(double travelCharges, double discountRate) {
		final double FTDS = 0.10;
		final double FTDD = 0.07;
		final double FTDM = 0.04;

		double num;

		if ((travelCharges == 35.00) || (travelCharges == 32.89) || (travelCharges == 38.00)){
			num = travelCharges * FTDS;
		}
		else if ((travelCharges == 60.00) || (travelCharges == 53.12) || (travelCharges == 63.78)){
			num = travelCharges * FTDD;
		}
		else {
			num = travelCharges * FTDM;
		}
		return num;

	}
	public static double calculateSalesTax(double travelCharges, double taxRate) {
		final double SALES_TAX = 0.075;

		double num;

		num = SALES_TAX * travelCharges;
		return num;
	}

	public static void main(String[] args) {
		int routeToTravel, passengers, member, fTUser, coupon;
		double CalcTC, CalcMember, CalcFTU, CalcCoupon, beforeST, salesTx, afterST;
		String finOutput = "";

		routeToTravel = getIntInput(true, 1, true, 3,
				"Which route would you like to travel (1-3)?", "Invalid Number");
		passengers = getIntInput(true, 1, false, 4,
				"How many passengers?", "Invalid Number");
		member = getIntInput(true, 0, true, 1,
				"Are you a member (0=no, 1=yes)?", "Please choose 0 or 1");
		fTUser = getIntInput(true, 0, true, 1,
				"Are you a first-time user (0=no, 1=yes)?", "Please choose 0 or 1");
		coupon = getIntInput(true, 0, true, 1,
				"Do you have a coupon (0=no, 1=yes)?", "Please choose 0 or 1");

		// use calcravelcharges and add specified string to finOutput
		if ((routeToTravel == 1) && (passengers == 1)){
			CalcTC = calculateTravelCharges(routeToTravel);
			finOutput = String.format("Travel charges for single passenger on Route 1: $%.2f\n", 
					CalcTC);
		}
		else {
			CalcTC = calculateTravelCharges(routeToTravel, passengers);
			finOutput = String.format("Travel charges for %d passengers on Route %d: $%.2f\n",
					passengers, routeToTravel, CalcTC);
		}
		if (member == 1) {
			CalcMember = calculateMembershipDiscount(CalcTC, 0);
			finOutput += String.format("Membership discount(5.00%%): $%.2f\n", 
					CalcMember);
		}
		else {
			CalcMember = 0;
		}
		if (passengers == 1) {
			if (fTUser == 1) {
				CalcFTU = calculateFirstTimeUserDiscount(CalcTC, 0);
				finOutput += String.format("First-Time user discount (10.00%%): $%.2f\n", 
						CalcFTU);
			}
			else {
				CalcFTU = 0;
			}

		}
		else if (passengers == 2) {
			if (fTUser == 1) {
				CalcFTU = calculateFirstTimeUserDiscount(CalcTC, 0);
				finOutput += String.format("First-Time user discount (7.00%%): $%.2f\n", 
						CalcFTU);
			}
			else {
				CalcFTU = 0;
			}
		}
		else {
			if (fTUser == 1) {
				CalcFTU = calculateFirstTimeUserDiscount(CalcTC, 0);
				finOutput += String.format("First-Time user discount (4.00%%): $%.2f\n", 
						CalcFTU);
			}
			else {
				CalcFTU = 0;
			}
		}
		if (fTUser == 1) {
			CalcCoupon = calculateCouponDiscount(CalcTC, 1);
			finOutput += "Coupon discount ($5.00): $5.00\n";
		}
		else {
			CalcCoupon = 0;
		}
		//Finalized output and then outputs finOutput to JOptionPane
		beforeST = CalcTC - CalcMember - CalcFTU - CalcCoupon;
		finOutput += String.format("Charges after applying applicable discounts: $%.2f\n", beforeST);
		salesTx = calculateSalesTax(CalcTC, 0);
		finOutput += String.format("Sales tax applied (7.50%%): $%.2f\n", salesTx);
		afterST = beforeST + salesTx;
		finOutput += String.format("Final Charge: $%.2f", afterST);
		JOptionPane.showMessageDialog(null, finOutput, "Thank you for using Rapid Ride!",
				JOptionPane.INFORMATION_MESSAGE);
	}//end main
} // end BaileySweisPA0502
