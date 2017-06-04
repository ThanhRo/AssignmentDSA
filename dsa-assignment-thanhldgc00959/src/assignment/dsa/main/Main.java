package assignment.dsa.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		menu();
	}

	public static void menu() throws FileNotFoundException, IOException, ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("SMS App");
		System.out.println("1.Product");
		System.out.println("2.Customer");
		System.out.println("3.Order");
		System.out.println("4.Exit");
		System.out.println("Chose from 1 to 4 :");
		System.out.println("--------------------------");
		String choice = scan.next();

		switch (choice) {
		case "1": {
			Main_Product mp = new Main_Product();
			mp.main(null);
		}
		case "2": {
			Main_Customer mc = new Main_Customer();
			mc.main(null);
		}
		case "3": {
			Main_Order mo = new Main_Order();
			mo.main(null);
		}

		case "4": {
			System.exit(0);
			break;
		}
		}
	}
}
