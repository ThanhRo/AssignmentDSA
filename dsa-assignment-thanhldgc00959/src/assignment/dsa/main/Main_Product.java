package assignment.dsa.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
			// DONT USE SPACE WHEN ADDING OBJECT
			JSONParser parser = new JSONParser();

			JSONArray arra = (JSONArray) parser.parse(
					new InputStreamReader(new FileInputStream("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json")));
			List<Tab_Product> listProduct = new ArrayList<Tab_Product>();
			for (Object o : arra) {
				JSONObject jsonObject = (JSONObject) o;
				String product_code = (String) jsonObject.get("pcode");
				String product_name = (String) jsonObject.get("pro_name");
				long product_quantity = (long) jsonObject.get("quantity");
				int quantity = (int) product_quantity;
				long product_sale = (long) jsonObject.get("sale");
				int sale = (int) product_sale;
				double product_price = (double) jsonObject.get("price");
				String product_image_url = (String) jsonObject.get("pro_image_url");
				Tab_Product tp = new Tab_Product(product_code, product_name, quantity, sale, product_price,
						product_image_url);
				listProduct.add(tp);
			}
			System.out.println("Input product code: ");
			String pcode = scan.next();
			System.out.println("Input product name: ");
			String pname = scan.next();
			System.out.println("Input product quantity: ");
			int pquantity = scan.nextInt();
			System.out.println("Input product saled: ");
			int psale = scan.nextInt();
			System.out.println("Input product price: ");
			double pprice = scan.nextDouble();
			System.out.println("Input product image url: ");
			String pimageurl = scan.next();
			Tab_Product tp1 = new Tab_Product(pcode, pname, pquantity, psale, pprice,
					pimageurl);
			listProduct.add(tp1);
			System.out.print("Successfully add");
			menuProduct();

			break;
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

			// JSONParser parser = new JSONParser();
			// try {
			// JSONArray jsonArray = (JSONArray) parser
			// .parse(new
			// FileReader("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json"));
			// List<Tab_Product> products = new LinkedList<>();
			// Iterator iterator = jsonArray.iterator();
			// while (iterator.hasNext()) {
			// Tab_Product tp = new Tab_Product();
			// JSONObject jsonObject = (JSONObject) iterator.next();
			// String product_code = (String) jsonObject.get("pcode");
			// String product_name = (String) jsonObject.get("pro_name");
			// long product_quantity = (long) jsonObject.get("quantity");
			// long product_sale = (long) jsonObject.get("sale");
			// double product_price = (double) jsonObject.get("price");
			// String product_image_url = (String)
			// jsonObject.get("pro_image_url");
			// System.out.println("-------------------------------------");
			// System.out.println("||Product Code:" + product_code +
			// "\n||Product Name:" + product_name
			// + "\n||Product Quantity:" + product_quantity + "\n||Product
			// Sale:" + product_sale
			// + "\n||Product Price:" + product_price + "\n||Product Image URL:"
			// + product_image_url);
			// products.add(tp);
			// }
			// System.out.println("Input product code: ");
			// String pCode = scan.next();
			// System.out.println("Input product name: ");
			// String pName = scan.next();
			// System.out.println("Input product quantity: ");
			// int pQuantity = scan.nextInt();
			// System.out.println("Input product sale: ");
			// int pSale = scan.nextInt();
			// System.out.println("Input product price: ");
			// double pPrice = scan.nextDouble();
			// System.out.println("Input product image url: ");
			// String pImageURL = scan.next();
			// Tab_Product tp1 = new Tab_Product();
			// products.add(tp1);
			// System.out.print("Successfully add");
			// menuProduct();
			// } catch (FileNotFoundException e) {
			// e.printStackTrace();
			// } catch (IOException e) {
			// e.printStackTrace();
			// } catch (ParseException e) {
			// e.printStackTrace();
			// }
			//break;
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
				Tab_Product np = arraylist.get(i);
				System.out.println(np.toString());
			}
			menuProduct();
			break;
		}
		case "5": {
			// Sort By PCode
			SortByPCode sort = new SortByPCode();
			sort.Sort_By_PCode();
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
