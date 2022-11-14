//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA0202
//*  
//* This project will take Five parameters using the console pertaining
//* to Manufacturing and unit costs as well as including a percent raise
//* for direct labor costs and will then output totals to console
//*  
//*                         2/6/2022 
//*  
//*                         File Name:  BaileySweisPA0202.java 
//*  
//*************************************************************************** 
import java.util.Scanner;
public class BaileySweisPA0202 {

	public static void main(String[] args) {
		
		// Create variables 
		final double DIRECT_LABOR_COST = 25.00;
		final double UNIT_COSTS = 22.39;
		double DirectMatCosts;
		int NumOfEmployees; 
		double ManufaOverheadCosts;
		int NumOfUnitsManufa;
		double CostPerEmployee;
		double PercentRaise;
		double PercentRaise2;
		double TotalManufaCosts;
		
		// create scanner
		Scanner scanner = new Scanner(System.in);
		
		// Ask for Direct Materials costs and receive input
		System.out.println("Please Enter Direct Materials Costs: ");
		DirectMatCosts = scanner.nextDouble();
		
		// Ask for Number of employees and receive input
		System.out.println("Please Enter Number of Employees: ");
		NumOfEmployees = scanner.nextInt();
		
		// Ask for Manufacturing Overhead Costs and receive input
		System.out.println("Please Enter Manufacturing Overhead Costs: ");
		ManufaOverheadCosts = scanner.nextDouble();
		
		// Ask for Number of Units Manufactured and receive input
		System.out.println("Please Enter Units Manufactured: ");
		NumOfUnitsManufa = scanner.nextInt();
		
		// Ask for the percent raise and receive input
		System.out.println("Please Enter Percent Raise Being Considered: ");
		PercentRaise = scanner.nextDouble();
		
		// Make PercentRaise a percentage
		PercentRaise2 = PercentRaise / 100;
		
		// Calculations
		CostPerEmployee = (DIRECT_LABOR_COST 
		+ (PercentRaise2 * DIRECT_LABOR_COST));
		TotalManufaCosts = (DirectMatCosts + (CostPerEmployee 
		* NumOfEmployees) + ManufaOverheadCosts);
		
		// print output
		System.out.printf("Increased direct labor cost per employee :$%2.2f \n"
		,CostPerEmployee);
		System.out.printf("Total manufacturing Cost                 :$%2.2f \n"
		,TotalManufaCosts);
		System.out.print("Number of Units Manufactured             :" 
		+ NumOfUnitsManufa + "\n");
		System.out.printf("Cost per Unit                            :$%2.2f \n"
		, UNIT_COSTS);
		
		// Close Scanner
		scanner.close();
		
	} // End main

} // End BaileySweisPA0202
