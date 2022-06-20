package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		MakeChange makeChange = new MakeChange();
		Scanner userInput = new Scanner(System.in);
		makeChange.bootCashRegister(userInput);

	}

	public void bootCashRegister(Scanner userInput) {
		int penny = 0;
		int nickle = 0;
		int dime = 0;
		int quarter = 0;
		int dollar = 0;
		int fiveDollar = 0;
		int tenDollar = 0;
		int twentyDollar = 0;
		boolean keepRunning = true;

		do {
			int price = convertDoubleToInt(askPriceOfItem(userInput));
			int amount = convertDoubleToInt(askAmountTendered(userInput));
			int change = changeDue(price, amount);
			int originalChange = change;
//			System.out.println(change);
//			System.out.println(price + " " + amount);
			if (price > amount) {
				System.out.println("Amount tendered is too low please retrieve correct amount. ");
			} else if (price == amount) {
				System.out.println("Exact amount no change due. ");
			} else {
				while (change != 0) {
					if (change >= 2000) {
						twentyDollar++;
						change = change - 2000;
					} else if (change >= 1000) {
						tenDollar++;
						change = change - 1000;
					} else if (change >= 500) {
						fiveDollar++;
						change = change - 500;
					} else if (change >= 100) {
						dollar++;
						change = change - 100;
					} else if (change >= 25) {
						quarter++;
						change = change - 25;
					} else if (change >= 10) {
						dime++;
						change = change - 10;
					} else if (change >= 5) {
						nickle++;
						change = change - 5;
					} else if (change >= 1) {
						penny++;
						change = change - 1;
					}
				}
				returnChange(originalChange, penny, nickle, dime, quarter, dollar, fiveDollar, tenDollar, twentyDollar);
			}
			System.out.println("Do you want to make another transaction? Y/N ");
			String choice = userInput.next();

			if (choice.equals("Y") || choice.equals("y")) {
				penny = 0;
				nickle = 0;
				dime = 0;
				quarter = 0;
				dollar = 0;
				fiveDollar = 0;
				tenDollar = 0;
				twentyDollar = 0;
			} else if (choice.equals("N") || choice.equals("n")) {
				System.out.println("Goodbye.");
				keepRunning = false;
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

	public int changeDue(int price, int amount) {
		int change = amount - price;
		return change;

	}

	public int convertDoubleToInt(double money) {
		int dollarAmount = (int) money;
		double diff = (money - dollarAmount);
		int amountToReturn = ((int) ((diff * 100) + 0.5)) + dollarAmount * 100;
		return amountToReturn;
	}

	public void returnChange(int originalChange, int penny, int nickle, int dime, int quarter, int dollar,
			int fiveDollar, int tenDollar, int twentyDollar) {
		System.out.println("Result: ");
		while (originalChange > 0) {
			if (twentyDollar >= 1) {
				System.out.println(twentyDollar + " twenty dollar bill ");
				originalChange = originalChange - (2000 * twentyDollar);
				twentyDollar = 0;
			} else if (tenDollar >= 1) {
				System.out.println(tenDollar + " ten dollar bill ");
				originalChange = originalChange - (1000 * tenDollar);
				tenDollar = 0;
			} else if (fiveDollar >= 1) {
				System.out.println(fiveDollar + " five dollar bill ");
				originalChange = originalChange - (500 * fiveDollar);
				fiveDollar = 0;
			} else if (dollar >= 1) {
				System.out.println(dollar + " dollar bill ");
				originalChange = originalChange - (100 * dollar);
				dollar = 0;
			} else if (quarter >= 1) {
				System.out.println(quarter + " quarter(s) ");
				originalChange = originalChange - (25 * quarter);
				quarter = 0;
			} else if (dime >= 1) {
				System.out.println(dime + " dime(s) ");
				originalChange = originalChange - (10 * dime);
				dime = 0;
			} else if (nickle >= 1) {
				System.out.println(nickle + " nickle(s) ");
				originalChange = originalChange - (5 * nickle);
				nickle = 0;
			} else if (penny >= 1) {
				System.out.println(penny + " penny/(ies) ");
				originalChange = originalChange - (penny);
				penny = 0;
			}
		}
	}

}
