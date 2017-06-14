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

	public List<Tab_Product> DeleteByPCode(String pCode, List<Tab_Product> in)
			throws FileNotFoundException, IOException, ParseException {

		for (Tab_Product o : in) {
			if (o.pcode.equals(pCode)) {
				in.remove(o);
			}
		}
		return in;

	}

	public List<Tab_Product> DeleteAfterByPCode(String pCode, List<Tab_Product> in)
			throws FileNotFoundException, IOException, ParseException {

		for (int i = 0; i < in.size(); i++) {
			if (in.get(i).pcode.equals(pCode) && in.size() > i+1) {
				in.remove(in.get(i+1));
			}
		}
		return in;
	}
}
