import java.util.Scanner;
import java.text.DecimalFormat;

public class MakeChange {

	public static void main(String[] args) {
		// Add a scanner
		Scanner scanner = new Scanner(System.in);

		// Add input from cashier
		System.out.println("What's the cost of items?");
		double costOfItems;
		double AmountTendered;
		costOfItems = scanner.nextDouble();
		System.out.println("Amount Tender");
		AmountTendered = scanner.nextDouble();

		// Add a variable for change
		double change = AmountTendered - costOfItems;

		// sysout message if the customer provided too little money or the exact amount.
		if (AmountTendered < costOfItems) {
			System.out.println("Please give cashier " + "$" + formatCurrency(change * -1));

		} else if (AmountTendered > costOfItems) {
			System.out.println("Your change is " + "$" + formatCurrency(change));
		}

		else {
			System.out.println("You have exact change");
		}
		scanner.close();

		calculateChange(change);
	}

	// use a Method to call. This Method will list results in denominations.

	public static void calculateChange(double change) {
		int twenties = (int) (change / 20);
		change = change % 20;

		int tens = (int) (change / 10);
		change = change % 10;

		int fives = (int) (change / 5);
		change = change % 5;

		int dollars = (int) change;
		double remaining = change - dollars;

		int quarters = (int) (remaining / 0.25);
		remaining = (double) (remaining % 0.25);

		int dimes = (int) (remaining / 0.1);
		remaining = (double) (remaining % 0.1);

		int nickels = (int) (remaining / 0.05);
		remaining = (double) (remaining % 0.05);

		int pennies = (int) Math.round(remaining / 0.01);

		if (twenties > 0) {
			System.out.println(twenties + " twenty-dollar bill(s)");
		}
		if (tens > 0) {
			System.out.println(tens + " ten-dollar bill(s)");
		}
		if (fives > 0) {
			System.out.println(fives + " five-dollar bill(s)");
		}
		if (dollars > 0) {
			System.out.println(dollars + " dollar(s)");
		}
		if (quarters > 0) {
			System.out.println(quarters + " quarter(s)");
		}
		if (dimes > 0) {
			System.out.println(dimes + " dime(s)");
		}
		if (nickels > 0) {
			System.out.println(nickels + " nickel(s)");
		}
		if (pennies > 0) {
			System.out.println(pennies + " penny/pennies");
		}
	}
	public static String formatCurrency(double change) {
		DecimalFormat formatter = new DecimalFormat("0.00");
		return formatter.format(change);
	}

}
