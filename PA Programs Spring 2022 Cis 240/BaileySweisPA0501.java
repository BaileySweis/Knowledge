//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA0501
//*  
//* This program will Collect int input from a user based on parameters set.
//* it will also catch all bad data and loop back to the original prompt.
//* 
//*
//*                         3/27/2022 
//*  
//*                         File Name:  BaileySweisPA0501.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;
public class BaileySweisPA0501 {
	
	public static int getIntInput(boolean lowerLimitFlag, int lowerLimit,
		boolean upperLimitFlag, int upperLimit, String prompt, String errorMsg) {
		//Create variables
		String prompter;
		int num = 0, fin = 0;
		boolean check = true;
		//While loop for data validation
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
			//ccatch to catch all none numbers
			catch (NumberFormatException ex){
				JOptionPane.showMessageDialog(null, errorMsg);
				continue;
			}
		}
		return fin;
	}

	public static void main(String[] args) {
		int num;
		num = getIntInput(true, 1, true, 10, "Enter a number between 1 and 10", "Please try again");
		JOptionPane.showMessageDialog(null, num);
		System.exit(0);

	}// end main

}//End BaileySweisPA0501
