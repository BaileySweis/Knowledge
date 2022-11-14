//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA0201
//*  
//* This project will take four parameters using JPane pertaining to  
//* the total manufacturing and unit cost of Bluetooth speakers
//* and output those totals onto another JPane.
//*
//*                         2/6/2022 
//*  
//*                         File Name:  BaileySweisPA0201.java 
//*  
//*************************************************************************** 
import javax.swing.JOptionPane;
public class BaileySweisPA0201 {

	public static void main(String[] args) {
		
		// Define Variables 
		final double DIRECT_LABOR_COST = 25.00;
		String DirectMatCosts;
		String NumOfEmployees; 
		String ManufaOverheadCosts;
		String NumOfUnitsManufa;
		double InputDirectMatCosts;
		double InputNumOfEmployees;
		double InputManufaOverheadCosts;
		double InputNumOfUnitsManufa;
		double TotalManufaCosts;
		double UnitCosts;
		String FinalMessage;
		
		// Create JPanes asking for input
		DirectMatCosts = JOptionPane.showInputDialog(null,
		"Direct Materials costs: ");
		NumOfEmployees = JOptionPane.showInputDialog(null,
		"Total Number of Employees: ");
		ManufaOverheadCosts = JOptionPane.showInputDialog(null,
		"Manufacturing Overhead Costs: ");
		NumOfUnitsManufa = JOptionPane.showInputDialog(null,
		"Number of Units Manufactured: ");
		
		// Convert strings to int
		InputDirectMatCosts = Integer.parseInt(DirectMatCosts);
		InputNumOfEmployees = Integer.parseInt(NumOfEmployees);
		InputManufaOverheadCosts = Integer.parseInt(ManufaOverheadCosts);
		InputNumOfUnitsManufa = Integer.parseInt(NumOfUnitsManufa);
		
		// Calculations for total manufacturing costs
		TotalManufaCosts = (InputDirectMatCosts + (DIRECT_LABOR_COST 
		* InputNumOfEmployees) + InputManufaOverheadCosts);
		
		// Calculations for  Unit costs
		UnitCosts = (TotalManufaCosts / InputNumOfUnitsManufa);
		
		// Format final message
		FinalMessage = String.format("Total Manufacturing Costs        :$%2.2f" 
		+ "\nNumber of units manufactured :%2.0f\n" 
		+ "Cost per unit                             :$%2.2f"
		, TotalManufaCosts, InputNumOfUnitsManufa, UnitCosts);
		
		// JPane to output Data
		JOptionPane.showMessageDialog(null, FinalMessage, "Output"
		, JOptionPane.INFORMATION_MESSAGE);
		
	} // End Main 

} // End BaileySweisPA0201
