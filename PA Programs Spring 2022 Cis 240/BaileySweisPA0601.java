//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA06
//*  
//* This program will Collect input from a user pertaining to Votes on a prop
//* in a town then will compute if the proposition passed then output to a 
//* JOptionPane
//*
//*                         4/3/2022 
//*  
//*                         File Name:  BaileySweisPA0601.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;
import javax.swing.JScrollPane; 
import javax.swing.JTable;
public class BaileySweisPA0601 {
	
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
	
	public static void displayTable(String[][] matrix, String[] headers) {
		JTable table = new JTable(matrix, headers);
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setViewportView(table);
		
		JOptionPane.showMessageDialog(null, scrollPane);
		
	}

	public static void main(String[] args) {
		//Declare final variables
		final int NUM_COLS = 4;
		final int TOWN_NUM = 0;
		final int VOTES_FOR = 1;
		final int VOTES_AGAINST = 2;
		final int TOTAL_VOTES_IT = 3;

		//Declare vars
		int numRows, colValuesfor, colValuesagainst, totalCounterR = 0, totalCounterC = 0, minfor,
				maxfor = 0, minagainst, maxAgainst = 0, townMin = 0, townMax = 0;
		int rowForMin = 0, rowAgainstMin = 0, rowForMax = 0, rowAgainstMax = 0, rowTownMin = 0, rowTownMax = 0;
		double avg = 0.0;
		double ii = 0;
		String finOutput = "";

		// Get number of towns
		numRows = getIntInput(true, 0, false, 0, "How many towns voted", "Error, try again")+1;

		// declare arrays
		String[] headerLables = {"Town Number", "Votes For", "Votes Against", "Total Votes in Town."};
		String [][] strMatrix = new String[numRows+1][NUM_COLS];
		int[][] intMatrix = new int[numRows-1][NUM_COLS];
		int row, col;

		// get votes int matrix
		for (row = 0; row < intMatrix.length; row++) {
			colValuesfor = getIntInput(true, 0, false, 0, String.format
					("In town #%d, How many votes for Prop 114", row+1), "Error, try again");
			colValuesagainst = getIntInput(true, 0, false, 0, String.format
					("In town #%d, How many votes against Prop 114", row+1), "Error, try again");
			intMatrix[row][TOWN_NUM] = (row + 1);
			intMatrix[row][VOTES_FOR] = colValuesfor;
			intMatrix[row][VOTES_AGAINST] = colValuesagainst;

		}
		//Track total votes
		for (row = 0; row < intMatrix.length; row++) {
			for (col=1; col < 3; col++) {
				intMatrix[row][TOTAL_VOTES_IT] = intMatrix[row][col] + intMatrix[row][col-1];
			}
			totalCounterR += intMatrix[row][TOTAL_VOTES_IT];
			col = 0;
		}
		// Build string matrix
		strMatrix[numRows-1][3] = String.format("%d", totalCounterR);
		for (col=1; col < 3; col++) {
			for (row = 0; row < intMatrix.length; row++) {
				totalCounterC += intMatrix[row][col];
			}
			ii = totalCounterC / (numRows-1);
			strMatrix[numRows-1][col] = String.format("%d (avg: %.2f)", totalCounterC, ii);
			totalCounterC = 0;
		}
		for (row = 0; row < intMatrix.length; row++) {
			for (col=0; col < intMatrix[0].length; col++) {
				strMatrix[row][col] = String.format("%d", intMatrix[row][col]);
			}
		}
		strMatrix[numRows-1][0] = "Total Votes";

		displayTable(strMatrix, headerLables);

		// Analyze min max.
		minfor = intMatrix[0][1];
		for(row = 0; row < intMatrix.length; row++) {
			if (intMatrix[row][1] < minfor) {
				minfor = intMatrix[row][1];
				rowForMin = row;
			}
			else if (intMatrix[row][1] > maxfor) {
				maxfor = intMatrix[row][1];
				rowForMax = row;
			}
		}
		finOutput += "The town with the fewest votes for Propostion 114 is Town " + strMatrix[rowForMin][0];
		finOutput += "\nThe town with the highest votes for Propostion 114 is Town " + strMatrix[rowForMax][0];

		minagainst = intMatrix[0][2];
		for(row = 0; row < intMatrix.length; row++) {
			if (intMatrix[row][2] < minagainst) {
				minagainst = intMatrix[row][2];
				rowAgainstMin = row;
			}
			else if (intMatrix[row][2] > maxAgainst) {
				maxAgainst = intMatrix[row][2];
				rowAgainstMax = row;
			}
		}
		finOutput += "\n\nThe town with the fewest votes against Propostion 114 is Town " + strMatrix[rowAgainstMin][0];
		finOutput += "\nThe town with the highest votes against Propostion 114 is Town " + strMatrix[rowAgainstMax][0];

		townMin = intMatrix[0][3];
		for(row = 0; row < intMatrix.length-1; row++) {
			if (intMatrix[row][3] < townMin) {
				townMin = intMatrix[row][3];
				rowTownMin = row;
			}
			else if (intMatrix[row][3] > townMax) {
				townMax = intMatrix[row][3];
				rowTownMax = row;
			}
		}
		finOutput += "\n\nThe town with the fewest number of votes is Town " + strMatrix[rowTownMin][0];
		finOutput += "\nThe town with the highest number of votes is Town " + strMatrix[rowTownMax][0];

		//Output to JOptionPane
		JOptionPane.showMessageDialog(null, finOutput);
	}//End main

}//End BaileySweisPA0601
