package assignment.dsa.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import assignment.dsa.model.Tab_Customer;
import assignment.dsa.model.Tab_Product;
import assignment.module.manager.SearchByCCode_Customer;
import assignment.module.manager.SearchByPCode;

public class Main_Customer {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		menuCustomer();
	}

	private static void menuCustomer() throws FileNotFoundException, IOException, ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("SMS Customer");
		System.out.println("1.Display Customer");
		System.out.println("2.Add New Customer");
		System.out.println("3.Search By CCoder");
		System.out.println("4.Delete By CCode");
		System.out.println("5.Back To Main Menu");
		System.out.println("Chose from 1 to 5 :");
		System.out.println("--------------------------");

		String choice = scan.next();
		switch (choice) {
		case "1": {
			// Display Customer
			JSONParser parser = new JSONParser();
			try {
				JSONArray jsonArray = (JSONArray) parser
						.parse(new FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/customers.json"));
				List<Tab_Customer> customers = new LinkedList<>();
				Iterator iterator = jsonArray.iterator();
				while (iterator.hasNext()) {
					Tab_Customer tc = new Tab_Customer();
					JSONObject jsonObject = (JSONObject) iterator.next();
					String customer_code = (String) jsonObject.get("ccode");
					String customer_name = (String) jsonObject.get("cus_name");
					String customer_phone = (String) jsonObject.get("phone");
					System.out.println("-------------------------------------");
					System.out.println("||Customer Code:" + customer_code + "\n||Customer Name:" + customer_name
							+ "\n||Customer Quantity:" + customer_phone);
					customers.add(tc);
				}
				menuCustomer();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		case "2": {
			// Add New Customer
		}
		case "3": {
			// Search by CCode
			System.out.println("-------------------------------------");
			System.out.println("-------------Search Customer----------");
			System.out.println("Input Customer Code : ");
			String cCode = scan.next();
			SearchByCCode_Customer searchCCode = new SearchByCCode_Customer();
			ArrayList<Tab_Customer> arrayList = searchCCode.SearchByCCode(cCode);
			for (int i = 0; i < arrayList.size(); i++) {
				Tab_Customer tc = arrayList.get(i);
				System.out.println(tc.toString());
			}
			menuCustomer();
			break;
		}
		case "4": {
			// Delete by CCode
		}
		case "5": {
			Main m = new Main();
			m.main(null);
			break;
		}
		}
	}
}