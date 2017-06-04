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
				JSONArray jsonArray = (JSONArray) parser
						.parse(new FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/orders.json"));
				List<Tab_Order> orders = new LinkedList<>();
				Iterator iterator = jsonArray.iterator();
				while (iterator.hasNext()) {
					Tab_Order to = new Tab_Order();
					JSONObject jsonObject = (JSONObject) iterator.next();
					String product_code = (String) jsonObject.get("pcode");
					String customer_code = (String) jsonObject.get("ccode");
					long quantity = (long) jsonObject.get("quantity");
					System.out.println("-------------------------------------");
					System.out.println("||Product Code:" + product_code + "\n||Customer Code:" + customer_code
							+ "\n||Product Quantity:" + quantity);
					orders.add(to);
				}
				menuOrder();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		case "2": {
			SortByPCodeAndCCode_Order sbpco = new SortByPCodeAndCCode_Order();
			sbpco.dataFile = Res.getDesktopFile("dsa2017-data/1e2/orders.json");
			sbpco.inputData();
			sbpco.displayDataWithTotal();
			sbpco.sortBy_pcode_and_ccode();
		}

		case "3": {
			Main m = new Main();
			m.main(null);
			break;
		}
		}
	}
}
