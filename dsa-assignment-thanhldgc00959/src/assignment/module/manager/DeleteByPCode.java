package assignment.module.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import assignment.dsa.model.Tab_Product;

public class DeleteByPCode {

	public ArrayList<Tab_Product> DeleteByPCode(String pCode)
			throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(
				new InputStreamReader(new FileInputStream("C:/Users/WIN/Desktop/dsa2017-data/1e2/products.json")));
		List<Tab_Product> listProduct = new ArrayList<Tab_Product>();
		for (Object o : a) {
			int i = 0;
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
			i++;
			if (product_code.equals(pCode)) {
				listProduct.remove(i);
			}
		}
		return (ArrayList<Tab_Product>) listProduct;

	}
}
