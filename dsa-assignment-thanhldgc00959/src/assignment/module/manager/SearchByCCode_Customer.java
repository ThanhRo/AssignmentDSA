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
import assignment.dsa.model.Tab_Product;

public class SearchByCCode_Customer {

	public List<Tab_Customer> SearchByCCode(String cCode,List<Tab_Customer> in)
			throws FileNotFoundException, IOException, ParseException {
		List<Tab_Customer> resultlist = new ArrayList<Tab_Customer>();
		for (Tab_Customer o : in) {
			if (o.ccode.equals(cCode)) {
				resultlist.add(o);
			}
		}
		return resultlist;
	}

}
