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
	public List<Tab_Customer> DeleteByCCode(String cCode,List<Tab_Customer> in)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		for (Tab_Customer o : in) {
			if (o.ccode.equals(cCode)) {
				in.remove(o);
			}
		}
		return in;
	}
}
