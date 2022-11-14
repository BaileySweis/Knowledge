//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA08
//*  
//* This program will Track stocks for a user that are import from a file
//* then will be able to track stocks and statistics and output stocks to a txt file
//* 
//* 
//*
//*                         5/1/2022 
//*  
//*                         File Name:  BaileySweisPA0801.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.util.Scanner;
//Create class
class Stock{
	private String name, symbol;
	private double lastPrice, yearLow, yearHigh;
	private static int numStocks = 0;
	
	// Constructor when add stock is chosen.
	public Stock(String name, String symbol, double lastPrice, double yearLow, double yearHigh) {
		this.name = name;
		this.symbol = symbol;
		this.lastPrice = lastPrice;
		this.yearLow = yearLow;
		this.yearHigh = yearHigh;
		numStocks++;
	}
	public String getName() {
		return name;
	}
	public String getSymbol() {
		return symbol;
	}
	public Double getyearLow() {
		return yearLow;
	}
	public Double getyearHigh() {
		return yearHigh;
	}
	public Double getLastPrice() {
		return lastPrice;
	}
	public static int getNumStocks() {
		return numStocks;
	}
	public void setlastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}
	
} // End Stock

public class BaileySweisPA0801 {
	public static double getDoubleInput(boolean lowerLimitFlag, double lowerLimit,
			boolean upperLimitFlag, double upperLimit, String prompt, String errorMsg) {
		String prompter;
		double num = 0.0, fin = 0.0;
		boolean check = true;
		while (check == true) {
			try {
				prompter = JOptionPane.showInputDialog(null,prompt);
				num = Double.parseDouble(prompter);
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
	public static int isStockInList(Stock[] stockArray, String stockSymbol) {
		//Check if the stock is in our database when checking stats
		int out = -1;
		for (int index = 0; index < Stock.getNumStocks(); index++) {
			if (stockSymbol.equals(stockArray[index].getSymbol())) {
				out = index;
				break;
			}
			else {
				
			}
		}
		return out;
	}

	public static void main(String[] args) {
		//Create array and hard code 4 stocks
		Stock[] stockArray = new Stock[10];
		//Create Jfilechooser to allow for input from user)
		JFileChooser fileChooser = new JFileChooser();
		//Create variables
		String name = "", symb = "";
		double weekLow = 0, weekHigh = 0, lastPrice = 0;
		int programChoice;
		int index = 4, stockin = 0;
		boolean check = true, check2 = true;
		File inFile = null;
		Scanner input = null;
		while (check2 == true) {
			//Intro to stock tracker and ask to import data
			JOptionPane.showMessageDialog(null, "Please select a input file with initial stock data"
					, "Welcome to the stock tracker", JOptionPane.INFORMATION_MESSAGE);
			//Import file with jFileChooser
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				inFile = fileChooser.getSelectedFile();
				check2 = false;
			}
			else {
				continue;
			}
		}
		//Input stock data to array
		try {
			input = new Scanner(inFile);
		}
		catch(FileNotFoundException ex) {
			System.out.print("file does not exist");
			System.exit(0);
		}
		input.useDelimiter(",");
		for(int ll = 0; input.hasNext() == true; ll++) {
			name = input.next();
			name = name.trim();
			symb = input.next();
			symb = symb.trim();
			String lastPriceStr = input.next();
			lastPriceStr = lastPriceStr.trim();
			lastPrice = Double.parseDouble(lastPriceStr);
			String weekLowStr = input.next();
			weekLowStr = weekLowStr.trim();
			weekLow = Double.parseDouble(weekLowStr);
			String weekHighStr = input.next();
			weekHighStr = weekHighStr.trim();
			weekHigh = Double.parseDouble(weekHighStr);
			stockArray[ll] = new Stock(name, symb, lastPrice, weekLow, weekHigh);
		}
		// loop to ask question until user is ready to quit
		while(check == true) {
			programChoice = getIntInput(true, 0, true, 4, "0 – Add a stock to your database\n"
					+ "1 – Get statistics on a specific stock\n"
					+ "2 – Export Stock data to file stockdata.txt\n" 
					+ "3 - Delete a Stock\n" 
					+ "4 - Exit program" , "Error, choose again");
			// If statement that is chosen if user enters zero
			if (programChoice == 0) {
				if(index < 10) {
					name = JOptionPane.showInputDialog(null, "Please enter the stock name");
					symb = JOptionPane.showInputDialog(null, "Please enter the stock symbol");
					symb = symb.toUpperCase();
					weekLow = getDoubleInput(true, 0, false, 0, "Please enter the 52 week low for " + name
							, "error enter a positive number");
					weekHigh = getDoubleInput(true, 0, false, 0, "Please enter the 52 week high for " + name
							, "error enter a positive number");
					lastPrice = getDoubleInput(true, 0, false, 0, "Please enter the last price for " + name
							, "error enter a positive number");
					stockArray[index] = new Stock(name, symb, lastPrice, weekLow, weekHigh);
					index++;
					continue;
				}
				else {
					JOptionPane.showMessageDialog(null, "Can not add another stock - Your database is full");
					continue;
				}
			}
			// If statement that is chosen if user enters one
			else if (programChoice == 1) {
				symb = JOptionPane.showInputDialog(null, "Please enter the stock Symbol you are interested in.");
				symb = symb.toUpperCase();
				stockin = isStockInList(stockArray, symb);
				if (stockin != -1) {
					
				}
				else {
					JOptionPane.showMessageDialog(null, "I am sorry but that symbol is one we are not currently tracking");
					continue;
				}
				lastPrice = getDoubleInput(true, 0, false, 0, "Please enter the most recent price for " + symb,
						"Error, Try again.");
				// IF statements for different scenarios.
				if (lastPrice > stockArray[stockin].getyearHigh()) {
					JOptionPane.showMessageDialog(null, String.format("The current price of %s (%s) stock is $%.2f\n" 
							+ "That represents a change of $%.2f from their most recent recorded price of $%.2f\n" 
							+ "The current price is $%.2f higher than the stock's 52 week high of $%.2f"
							,stockArray[stockin].getName(), stockArray[stockin].getSymbol()
							, lastPrice, lastPrice - stockArray[stockin].getLastPrice()
							, stockArray[stockin].getLastPrice(), lastPrice - stockArray[stockin].getyearHigh()
							, stockArray[stockin].getyearHigh()));
				}
				else if (lastPrice < stockArray[stockin].getyearLow()) {
					JOptionPane.showMessageDialog(null, String.format("The current price of %s (%s) stock is $%.2f\n" 
							+ "That represents a change of $%.2f from their most recent recorded price of $%.2f\n" 
							+ "The current price is $%.2f below than the stock's 52 week low of $%.2f"
							,stockArray[stockin].getName(), stockArray[stockin].getSymbol()
							, lastPrice, lastPrice - stockArray[stockin].getLastPrice()
							, stockArray[stockin].getLastPrice(), stockArray[stockin].getyearLow() - lastPrice 
							, stockArray[stockin].getyearLow()));
				}
				else {
					JOptionPane.showMessageDialog(null, String.format("The current price of %s (%s) stock is $%.2f\n" 
							+ "That represents a change of $%.2f from their most recent recorded price of $%.2f\n" 
							+ "The current price is $%.2f above 52 week low of $%.2f and $%.2f below it's 52 week high of $%.2f"
							,stockArray[stockin].getName(), stockArray[stockin].getSymbol()
							, lastPrice, lastPrice - stockArray[stockin].getLastPrice()
							, stockArray[stockin].getLastPrice(), lastPrice - stockArray[stockin].getyearLow()
							, stockArray[stockin].getyearLow(), stockArray[stockin].getyearHigh() - lastPrice
							, stockArray[stockin].getyearHigh()));
				}
				stockArray[stockin].setlastPrice(lastPrice);
			}
			else if (programChoice == 2){
				// If statement that is chosen if user enters Two
				File file = new File("stockdata.txt");
			    if (file.exists() == true) {
			      int result = JOptionPane.showConfirmDialog(null, "File already exist, OverWrite?");
			      if (result == JOptionPane.YES_OPTION) {
			    	  
			      }
			      else {
			    	  continue;
			      }
			    }
			    PrintWriter output = null; 
			    try {
			    	output = new PrintWriter(file);
			    } catch (FileNotFoundException ex) {
			    	System.out.println("Error:  File not found exception");
			    }
			    for (int s = 0; s < Stock.getNumStocks(); s++) {
			    	output.print(stockArray[s].getName() + ", ");
			    	output.print(stockArray[s].getSymbol() + ", ");
			    	output.print(stockArray[s].getLastPrice() + ", ");
			    	output.print(stockArray[s].getyearLow() + ", ");
			    	output.println(stockArray[s].getyearHigh() + ", ");
			    }
			    output.close();
			    JOptionPane.showMessageDialog(null, "Stock Data was succesfully exported to stockdata.txt");
			}
			else if (programChoice == 3) {
				//If user would like to delete a stock
				String delChoice = JOptionPane.showInputDialog(null, "Please enter the symbol of the stock to be deleted");
				delChoice = delChoice.toUpperCase();
				int r = isStockInList(stockArray, delChoice);
				if (r != -1) {
					JOptionPane.showMessageDialog(null, "FixME");
				}
				else {
					JOptionPane.showMessageDialog(null, "Stock does not exist");
					continue;
				}
			}
			else {
				System.exit(0);
			}
		}
	} // End main

} // End BaileySweisPA0801
