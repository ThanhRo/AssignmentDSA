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

	public ArrayList<Tab_Product> SearchByPCode(String pCode, List<Tab_Product> in)
			throws FileNotFoundException, IOException, ParseException {
		List<Tab_Product> resultlist = new ArrayList<Tab_Product>();
		for (Tab_Product o : in) {
			if (o.pcode.equals(pCode)) {
				resultlist.add(o);
			}
		}
		return (ArrayList<Tab_Product>) resultlist;
	}
}
