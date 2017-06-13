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

	public ArrayList<Tab_Product> DeleteByPCode(String pCode, List<Tab_Product> in)
			throws FileNotFoundException, IOException, ParseException {

		for (Tab_Product o : in) {
			if (o.pcode.equals(pCode)) {
				in.remove(o);
			}
		}
		return (ArrayList<Tab_Product>) in;

	}

	public ArrayList<Tab_Product> DeleteAfterByPCode(String pCode, List<Tab_Product> in)
			throws FileNotFoundException, IOException, ParseException {

		for (Tab_Product o : in) {
			if (o.pcode.equals(pCode)) {
				if (in.iterator().hasNext()) {
					in.iterator().next();
					in.remove(o);
				}
			}
		}
		return (ArrayList<Tab_Product>) in;

	}
}
