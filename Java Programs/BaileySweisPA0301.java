//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA0301
//*  
//* This program will Collect unit price and total units from user and produce
//* a price with a specific discount rate depending on the amount of unit sales  
//*
//*                         2/20/2022 
//*  
//*                         File Name:  BaileySweisPA0301.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;
public class BaileySweisPA0301 {

	public static void main(String[] args) {
		// create final variables
		double dr1 = 0.0;
		double dr2 = 10.0;
		double dr3 = 15.0;
		double dr4 = 20.0; 
		String unitPrice;
		String unitSold;
		double unitPrices;
		double unitSales;
		double finPrice = 0;
		double priceSales;
		String finOutput;
		double discount = 0;
		
		// collect info from user using JOptionPane
		unitPrice = JOptionPane.showInputDialog(null,"What is the unit price of the product sold?");
		unitSold = JOptionPane.showInputDialog(null,"Total numbers of units sold?");
		
		// Parse strings to doubles
		unitPrices = Double.parseDouble(unitPrice);
		unitSales = Double.parseDouble(unitSold);
		
		// Calculate unit price and unit sales
		priceSales = unitPrices * unitSales;
		
		// If statement to calculate discount rate or reject input
		if ((unitSales >= 0) && (unitPrices >= 0)) {
			if(unitSales < 100.0) {
				finPrice = priceSales;
				discount = dr1;
			}
			else if ((unitSales >= 100.0) && (unitSales <= 250.0)){
				finPrice = priceSales * (dr2 / 100.0);
				finPrice = priceSales - finPrice;
				discount = dr2;
			}
			else if ((unitSales >= 251.0) && (unitSales <= 500.0)) {
				finPrice = priceSales * (dr3 / 100.0);
				finPrice = priceSales - finPrice;
				discount = dr3;
			}
			else if (unitSales > 500.0) {
				finPrice = priceSales * (dr4 / 100.0);
				finPrice = priceSales - finPrice;
				discount = dr4;
			}	
		}
		else {
			JOptionPane.showMessageDialog(null, "Not a valid input");
			System.exit(0);
		}
		
		// format string to 2 decimal places
		finOutput = String.format("Unit Price: $%2.2f", unitPrices);
		finOutput = finOutput + String.format("\nTotal Number of Units: %2.0f", unitSales);
		finOutput = finOutput + String.format("\nTotal Price before Discount: $%2.2f", priceSales);
		finOutput = finOutput + String.format("\nDiscount Applied: %2.0f", discount);
		finOutput = finOutput + "%";
		finOutput = finOutput + String.format("\nTotal price after discount: $%2.2f", finPrice);
		
		// print output to JOptionPane
		JOptionPane.showMessageDialog(null, finOutput);

	} // End main

} // End BaileySweis PA0301
