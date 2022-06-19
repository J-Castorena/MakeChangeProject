package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		MakeChange makeChange = new MakeChange();
		Scanner userInput = new Scanner(System.in);
		makeChange.bootCashRegister(userInput);

	}

	public void bootCashRegister(Scanner userInput) {
		boolean keepRunning = true;
		do {
			double price = askPriceOfItem(userInput);
			double amount = askAmountTendered(userInput);
			double change = changeDue(price, amount);
			System.out.println(change);
			System.out.println(price + " " + amount);
			if (price > amount) {
				System.out.println("Amount tendered is too low please retrieve correct amount. ");
			} else if (price == amount) {
				System.out.println("Exact amount no change due. ");
			} else {
					System.out.println("Your change is: " + change);
			}

		} while (keepRunning);

	}

	public double askPriceOfItem(Scanner userInput) {
		System.out.println("Please enter the price of the item: ");
		double priceOfItem = userInput.nextDouble();
		return priceOfItem;
	}

	public double askAmountTendered(Scanner userInput) {
		System.out.println("How much money was tendered? ");
		double amountTendered = userInput.nextDouble();
		return amountTendered;
	}
	
	public double changeDue(double price, double amount) {
		double change = amount - price;
		return change;
		
	}

}
