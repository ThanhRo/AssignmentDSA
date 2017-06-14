package assignment.dsa.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apps.saleman.services.Res;
import assignment.dsa.model.Tab_Product;
import assignment.module.manager.DeleteByPCode;
import assignment.module.manager.SearchByPCode;
import assignment.module.manager.SortByPCode;

public class Main_Product {
	static List<Tab_Product> products = new LinkedList<>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		menuProduct();
	}

	@SuppressWarnings("unchecked")
	public static void menuProduct() throws FileNotFoundException, IOException, ParseException {

		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("SMS Product");
		System.out.println("1.Display Product");
		System.out.println("2.Add New Product");
		System.out.println("3.Search By PCode");
		System.out.println("4.Delete By PCode");
		System.out.println("5.Sort By PCode");
		System.out.println("6.Delete after by xPcode");
		System.out.println("7.Back To Main Menu");
		System.out.println("Chose from 1 to 7 :");
		System.out.println("--------------------------");

		String choice = scan.next();
		switch (choice) {
		case "1": {
			// Display Product
			JSONParser parser = new JSONParser();
			try {
				if (products.isEmpty()) {
					JSONArray jsonArray = (JSONArray) parser
							.parse(new FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json"));
					Iterator iterator = jsonArray.iterator();
					while (iterator.hasNext()) {
						Tab_Product tp = new Tab_Product();
						JSONObject jsonObject = (JSONObject) iterator.next();
						String product_code = (String) jsonObject.get("pcode");
						String product_name = (String) jsonObject.get("pro_name");
						long product_quantity = (long) jsonObject.get("quantity");
						long product_sale = (long) jsonObject.get("sale");
						double product_price = (double) jsonObject.get("price");
						String product_image_url = (String) jsonObject.get("pro_image_url");
						tp.pcode = product_code;
						tp.pro_name = product_name;
						tp.quantity = product_quantity;
						tp.sale = product_sale;
						tp.price = product_price;
						tp.pro_image_url = product_image_url;
						System.out.println(tp.toString());
						products.add(tp);
					}
				} else {
					for (Tab_Product product : products) {
						System.out.println(product.toString());
					}
				}
				menuProduct();
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
			// Add New Product

			try {
				System.out.println("Input product code: ");
				String pCode = scan.next();
				System.out.println("Input product name: ");
				String pName = scan.next();
				System.out.println("Input product quantity: ");
				long pQuantity = scan.nextLong();
				System.out.println("Input product sale: ");
				long pSale = scan.nextLong();
				System.out.println("Input product price: ");
				double pPrice = scan.nextDouble();
				System.out.println("Input product image url: ");
				String pImageURL = scan.next();
				Tab_Product tp1 = new Tab_Product(pCode, pName, pQuantity, pSale, pPrice, pImageURL);
				products.add(tp1);
				System.out.print("Successfully add");
				menuProduct();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		}
		case "3": {
			// Search By PCode
			System.out.println("-------------------------------------");
			System.out.println("-------------Search Product----------");
			System.out.println("Input Product Code : ");
			String pCode = scan.next();
			SearchByPCode searchPCode = new SearchByPCode();
			ArrayList<Tab_Product> arrayList = searchPCode.SearchByPCode(pCode, products);
			for (Tab_Product tp : arrayList) {
				System.out.println(tp.toString());
			}
			menuProduct();
			break;
		}
		case "4": {
			// Delete By Pcode
			System.out.println("-------------------------------------");
			System.out.println("-------------Delete Product----------");
			System.out.println("Input Product Code : ");
			String pCode = scan.next();
			DeleteByPCode deletePCode = new DeleteByPCode();
			deletePCode.DeleteByPCode(pCode, products);
			for (Tab_Product tp : products) {
				System.out.println(tp.toString());
			}
			menuProduct();
			break;
		}
		case "5": {
			// Sort By PCode
			SortByPCode sbpco = new SortByPCode();
			sbpco.dataFile = Res.getDesktopFile("dsa2017-data/1e2/products.json");
			sbpco.inputData(products);
//			sbpco.displayDataWithTotal();
			sbpco.sortBy_pcode_and_proname();
			menuProduct();
			break;
		}
		case "6": {
			System.out.println("-------------------------------------");
			System.out.println("-------------Delete Product----------");
			System.out.println("Input Product Code : ");
			String pCode = scan.next();
			DeleteByPCode deletePCode = new DeleteByPCode();
			deletePCode.DeleteAfterByPCode(pCode, products);
			for (Tab_Product tp : products) {
				System.out.println(tp.toString());
			}
			menuProduct();
			break;
		}
		case "7": {
			Main m = new Main();
			m.main(null);
			break;
		}
		}
	}
}
