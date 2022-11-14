//*************************************************************************** 
//*  
//* CIS 240                  Spring 2022                  Bailey Sweis 
//*  
//*                         Program Assignment PA07
//*  
//* This program will Track stocks for a user and the user can also input new
//* stocks and statistics and ref those stocks in the future.
//* 
//* 
//*
//*                         4/16/2022 
//*  
//*                         File Name:  BaileySweisPA0701.java 
//*  
//***************************************************************************
import javax.swing.JOptionPane;

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
	public int getNumStocks() {
		return numStocks;
	}
	public void setlastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}
	
} // End Stock

public class BaileySweisPA0701 {
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
		for (int index = 0; index < stockArray.length; index++) {
			if (stockArray[index] == null) {
				break;
			}
			else if (stockSymbol.equals(stockArray[index].getSymbol())) {
				out = index;
				break;
			}
			else {
				continue;
			}
		}
		return out;
	}

	public static void main(String[] args) {
		//Create array and hard code 4 stocks
		Stock[] stockArray = new Stock[10];
		stockArray[0] = new Stock("Amazon", "AMZN", 3054.00, 1889.15, 3552.25);
		stockArray[1] = new Stock("Lululemon", "LULU", 311.16, 177.77, 399.90);
		stockArray[2] = new Stock("Telsa", "TSLA", 635.62, 89.28, 900.40);
		stockArray[3] = new Stock("Disney", "DIS", 185.54, 92.56, 203.02);
		//Create variables
		String name, symb;
		double weekLow, weekHigh, lastPrice;
		int programChoice;
		int index = 4, stockin = 0;
		boolean check = true;
		// loop to ask question until user is ready to quit 
		while(check == true) {
			programChoice = getIntInput(true, 0, true, 2, "0 – Add a stock to your database\n"
					+ "1 – Get statistics on a specific stock \n"
					+ "2 – Exit the program ", "Error, choose again");
			// If statement that is chosen if user enters zero
			if (programChoice == 0) {
				if(index < 10) {
					name = JOptionPane.showInputDialog(null, "Please enter the stock name");
					symb = JOptionPane.showInputDialog(null, "Please enter the stock symbol");
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
				
			}
			else {
				// If statement that is chosen if user enters Two
				System.exit(0);
			}
		}
	} // End main

} // End BaileySweisPA0701
