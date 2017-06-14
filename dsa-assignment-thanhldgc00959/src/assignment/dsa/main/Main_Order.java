package assignment.dsa.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apps.saleman.services.Res;
import assignment.dsa.model.Tab_Order;
import assignment.dsa.model.Tab_Product;
import assignment.module.manager.SortByPCode;
import assignment.module.manager.SortByPCodeAndCCode_Order;

public class Main_Order {
	static List<Tab_Order> orders = new LinkedList<>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		menuOrder();
	}

	private static void menuOrder() throws FileNotFoundException, IOException, ParseException {

		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("SMS Order");
		System.out.println("1.Display Order");
		System.out.println("2.Sort By PCode and CCode");
		System.out.println("3.Back To  Main Menu");
		System.out.println("Chose from 1 to 3 :");
		String choice = scan.next();
		System.out.println("--------------------------");

		switch (choice) {
		case "1": {

			JSONParser parser = new JSONParser();
			try {
				if (orders.isEmpty()) {
					JSONArray jsonArray = (JSONArray) parser
							.parse(new FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/orders.json"));
					Iterator iterator = jsonArray.iterator();
					while (iterator.hasNext()) {
						Tab_Order to = new Tab_Order();
						JSONObject jsonObject = (JSONObject) iterator.next();
						String product_code = (String) jsonObject.get("pcode");
						String customer_code = (String) jsonObject.get("ccode");
						long quantity = (long) jsonObject.get("quantity");
						to.ccode = customer_code;
						to.pcode = product_code;
						to.quantity = quantity;
						System.out.println(to.toString());
						orders.add(to);
					}
				} else {
					for (Tab_Order order : orders) {
						System.out.println(order.toString());
					}
				}
				menuOrder();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		}
		case "2": {
			SortByPCodeAndCCode_Order sbpco = new SortByPCodeAndCCode_Order();
			sbpco.dataFile = Res.getDesktopFile("dsa2017-data/1e2/orders.json");
			sbpco.inputData(orders);
			sbpco.displayDataWithTotal();
			sbpco.sortBy_pcode_and_ccode();
			Main_Order mo = new Main_Order();
			mo.main(null);
			break;
		}

		case "3": {
			Main m = new Main();
			m.main(null);
			break;
		}
		}
	}
}
