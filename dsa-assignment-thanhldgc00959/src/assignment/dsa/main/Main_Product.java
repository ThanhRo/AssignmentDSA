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
		System.out.println("6.Back To Main Menu");
		System.out.println("Chose from 1 to 6 :");
		System.out.println("--------------------------");

		String choice = scan.next();
		switch (choice) {
		case "1": {
			// Display Product
			JSONParser parser = new JSONParser();
			try {
				JSONArray jsonArray = (JSONArray) parser
						.parse(new FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json"));
				List<Tab_Product> products = new LinkedList<>();
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
					System.out.println("-------------------------------------");
					System.out.println("||Product Code:" + product_code + "\n||Product Name:" + product_name
							+ "\n||Product Quantity:" + product_quantity + "\n||Product Sale:" + product_sale
							+ "\n||Product Price:" + product_price + "\n||Product Image URL:" + product_image_url);
					products.add(tp);
				}
				menuProduct();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			/*
			 * try { Object obj = parser.parse(new
			 * FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json")
			 * ); JSONObject jsonObject = (JSONObject) obj;
			 * 
			 * String product_code = (String) jsonObject.get("pcode"); String
			 * product_name = (String) jsonObject.get("pro_name"); int
			 * product_quantity = (int) jsonObject.get("quantity"); int
			 * product_sale = (int) jsonObject.get("sale"); double product_price
			 * = (double) jsonObject.get("price"); String product_image_url =
			 * (String) jsonObject.get("pro_image_url");
			 * System.out.println("-------------------------------------");
			 * System.out.println("Product Code: " + product_code + "Product
			 * Name" + product_name + "Product Quantity" + product_quantity +
			 * "Product Sale" + product_sale + "Product Price" + product_price +
			 * "Product Image URL" + product_image_url);
			 * 
			 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch
			 * (IOException e) { e.printStackTrace(); } catch (ParseException e)
			 * { e.printStackTrace(); }
			 */

			break;
		}
		case "2": {
			// Add New Product

			// JSONParser parser = new JSONParser();
			//
			// JSONArray arra = (JSONArray) parser.parse(
			// new InputStreamReader(new
			// FileInputStream("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json")));
			// List<Tab_Product> listProduct = new ArrayList<Tab_Product>();
			// for (Object o : arra) {
			// JSONObject person = (JSONObject) o;
			// String procode = (String) person.get("pcode");
			// String pro_name = (String) person.get("pro_name");
			// long quantity = (long) person.get("quantity");
			// int quant = (int) quantity;
			// long sale = (long) person.get("sale");
			// int sal = (int) sale;
			// double price = (double) person.get("price");
			// String product_image_url = (String) person.get("pro_image_url");
			// Tab_Product pd = new Tab_Product(procode, pro_name, quant, sal,
			// price, product_image_url);
			// listProduct.add(pd);
			// }
			// System.out.println("Input product code: ");
			// String pcode = scan.next();
			// System.out.println("Input product name: ");
			// String pname = scan.next();
			// System.out.println("Input product quantity: ");
			// int pquan = scan.nextInt();
			// System.out.println("Input product saled: ");
			// int psale = scan.nextInt();
			// System.out.println("Input product price: ");
			// double pprice = scan.nextDouble();
			// System.out.println("Input product Image URL: ");
			// String pimageurl = scan.next();
			// Tab_Product pd2 = new Tab_Product(pcode, pname, pquan, psale,
			// pprice, pimageurl);
			// listProduct.add(pd2);
			// System.out.print("Successfully add");
			// menuProduct();
			// break;

			/////////////////////////////////////////////////////////////////////////
			/*
			 * JSONParser parser = new JSONParser();
			 * 
			 * JSONArray arra = (JSONArray) parser.parse( new
			 * InputStreamReader(new FileInputStream(
			 * "C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json")));
			 * List<Tab_Product> listProduct = new ArrayList<Tab_Product>(); for
			 * (Object o : arra) { JSONObject jsonObject = (JSONObject) o;
			 * String product_code = (String) jsonObject.get("pcode"); String
			 * product_name = (String) jsonObject.get("pro_name"); long
			 * product_quantity = (long) jsonObject.get("quantity"); int
			 * quantity = (int) product_quantity; long product_sale = (long)
			 * jsonObject.get("sale"); int sale = (int) product_sale; double
			 * product_price = (double) jsonObject.get("price"); String
			 * product_image_url = (String) jsonObject.get("pro_image_url");
			 * Tab_Product tp = new Tab_Product(product_code, product_name,
			 * quantity, sale, product_price, product_image_url);
			 * listProduct.add(tp); } System.out.println("Input product code: "
			 * ); String pcode = scan.next(); System.out.println(
			 * "Input product name: "); String pname = scan.next();
			 * System.out.println("Input product quantity: "); int pquantity =
			 * scan.nextInt(); System.out.println("Input product saled: "); int
			 * psale = scan.nextInt(); System.out.println(
			 * "Input product price: "); double pprice = scan.nextDouble();
			 * System.out.println("Input product image url: "); String pimageurl
			 * = scan.next(); Tab_Product tp1 = new Tab_Product(pcode, pname,
			 * pquantity, psale, pprice, pimageurl); listProduct.add(tp1);
			 * System.out.println("Successfully add"); menuProduct();
			 * 
			 * break;
			 */
			///////////////////////////////////////////////////////////////////////////////////
			/*
			 * JSONParser parser = new JSONParser(); try {
			 * 
			 * JSONArray jsonArray = (JSONArray) parser .parse(new
			 * FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json")
			 * ); List<Tab_Product> listProduct = new ArrayList<Tab_Product>();
			 * Iterator iterator = jsonArray.iterator(); while
			 * (iterator.hasNext()) { Tab_Product tp = new Tab_Product();
			 * JSONObject jsonObject = (JSONObject) iterator.next();
			 * jsonObject.put("pcode", tp.getPcode());
			 * jsonObject.put("pro_name", tp.getPro_name());
			 * jsonObject.put("quantity", tp.getQuantity());
			 * jsonObject.put("sale", tp.getSale()); jsonObject.put("price",
			 * tp.getPrice()); jsonObject.put("pro_image_url",
			 * tp.getPro_image_url()); listProduct.add(tp); }
			 * 
			 * System.out.println("Input product code: "); String pCode =
			 * scan.next(); System.out.println("Input product name: "); String
			 * pName = scan.next(); System.out.println(
			 * "Input product quantity: "); int pQuantity = scan.nextInt();
			 * System.out.println("Input product sale: "); int pSale =
			 * scan.nextInt(); System.out.println("Input product price: ");
			 * double pPrice = scan.nextDouble(); System.out.println(
			 * "Input product image url: "); String pImageURL = scan.next();
			 * Tab_Product tp1 = new Tab_Product(pCode, pName, pQuantity, pSale,
			 * pPrice, pImageURL); listProduct.add(tp1); System.out.print(
			 * "Successfully add"); menuProduct(); } catch (Exception e) {
			 * e.printStackTrace(); }
			 */

			JSONParser parser = new JSONParser();// DONT USE SPACE WHEN ADDING
			try {
				JSONArray jsonArray = (JSONArray) parser
						.parse(new FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json"));
				List<Tab_Product> products = new LinkedList<>();
				Iterator iterator = jsonArray.iterator();
				while (iterator.hasNext()) {

					JSONObject jsonObject = (JSONObject) iterator.next();
					String product_code = (String) jsonObject.get("pcode");
					String product_name = (String) jsonObject.get("pro_name");
					long product_quantity = (long) jsonObject.get("quantity");
					long product_sale = (long) jsonObject.get("sale");
					double product_price = (double) jsonObject.get("price");
					String product_image_url = (String) jsonObject.get("pro_image_url");
					Tab_Product tp = new Tab_Product(product_code, product_name, product_quantity, product_sale,
							product_price, product_image_url);
					products.add(tp);
				}
				System.out.println("Input product code: ");
				String pCode = scan.next();
				System.out.println("Input product name: ");
				String pName = scan.next();
				System.out.println("Input product quantity: ");
				int pQuantity = scan.nextInt();
				System.out.println("Input product sale: ");
				int pSale = scan.nextInt();
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
			ArrayList<Tab_Product> arrayList = searchPCode.SearchByPCode(pCode);
			for (int i = 0; i < arrayList.size(); i++) {
				Tab_Product tp = arrayList.get(i);
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
			ArrayList<Tab_Product> arraylist = deletePCode.DeleteByPCode(pCode);
			for (int i = 0; i < arraylist.size(); i++) {
				Tab_Product tp = arraylist.get(i);
				System.out.println(tp.toString());
			}
			menuProduct();
			break;
		}
		case "5": {
			// Sort By PCode
			SortByPCode sbpco = new SortByPCode();
			sbpco.dataFile = Res.getDesktopFile("dsa2017-data/1e2/products.json");
			sbpco.inputData();
			sbpco.displayDataWithTotal();
			sbpco.sortBy_pcode_and_proname();
			menuProduct();
			break;
		}
		case "6": {
			Main m = new Main();
			m.main(null);
			break;
		}
		}
	}
}
