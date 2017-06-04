package assignment.module.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import assignment.dsa.model.Tab_Customer;

public class DeleteByCCode_Customer {
	public ArrayList<Tab_Customer> DeleteByCCode(String cCode)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(
				new InputStreamReader(new FileInputStream("C:/Users/WIN/Desktop/dsa2017-data/1e2/customers.json")));
		List<Tab_Customer> listCustomer = new ArrayList<Tab_Customer>();
		for (Object o : a) {
			int i = 0;
			JSONObject jsonObject = (JSONObject) o;
			String custmer_code = (String) jsonObject.get("ccode");
			String customer_name = (String) jsonObject.get("cus_name");
			String customer_phone = (String) jsonObject.get("phone");

			Tab_Customer tc = new Tab_Customer(custmer_code, customer_name, customer_phone);
			listCustomer.add(tc);
			i++;
			if (custmer_code.equals(cCode)) {
				listCustomer.remove(i);
			}
		}
		return (ArrayList<Tab_Customer>) listCustomer;
	}
}
