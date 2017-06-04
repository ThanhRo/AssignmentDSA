package assignment.module.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import assignment.dsa.model.Tab_Product;

public class SearchByPCode {

	public ArrayList<Tab_Product> SearchByPCode(String pCode) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new InputStreamReader(new FileInputStream("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json")));
		List<Tab_Product> resultlist = new ArrayList<Tab_Product>();
		for (Object o : a){
			JSONObject jsonObject = (JSONObject) o;
			String product_code = (String) jsonObject.get("pcode");
			String product_name = (String) jsonObject.get("pro_name");
			long product_quantity = (long) jsonObject.get("quantity");
		    int quantity = (int) product_quantity;
			long product_sale = (long) jsonObject.get("sale");
			int sale = (int) product_sale;
			double product_price = (double) jsonObject.get("price");
			String product_image_url = (String) jsonObject.get("pro_image_url");
			Tab_Product tp = new Tab_Product(product_code,product_name,quantity,sale,product_price,product_image_url); 
			List<Tab_Product> listProduct = new ArrayList<Tab_Product>();
			listProduct.add(tp);
			if (product_code.equals(pCode)){
    			resultlist.add(tp);    			
    		}
		}
		return (ArrayList<Tab_Product>) resultlist;
	}

	/*public ArrayList<Tab_Product> SearchByPCode(String pCode) {
		JSONParser parser = new JSONParser();
		List<Tab_Product> p = new ArrayList<>();
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
						+ "\n||Product Quantity:" + product_quantity + "\n||Product	Sale:" + product_sale
						+ "\n||Product Price:" + product_price + "\n||Product Image	URL:" + product_image_url);

				products.add(tp);
				if (product_code.equals(pCode)) {
					p.add(tp);
				}

				return (ArrayList<Tab_Product>) p;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}*/
}
