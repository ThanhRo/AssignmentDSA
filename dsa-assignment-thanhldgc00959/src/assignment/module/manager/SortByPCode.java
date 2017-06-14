package assignment.module.manager;

import java.io.File;
import java.util.Collections;
import java.util.List;

import apps.saleman.services.Json;
import apps.saleman.services.SwingUtils;
import assignment.dsa.model.Tab_Product;

public class SortByPCode {

	public File dataFile;
	private List<Tab_Product> items;

	// Order list:
	// 3.1. Input data
	public void inputData(List<Tab_Product> items) {
		try {
			if (items == null)
				items = Json.readList(dataFile, Tab_Product.class);
			else
				this.items = items;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3.2. Display data with total value
	public void displayDataWithTotal() {
		for (Tab_Product ik : items)
			System.out.println(ik.toString());
	}

	// public void displayFigure(String t) {
	// SwingUtils.showData(t, items);
	// }

	// 3.3. Sort by pcode
	public void sortBy_pcode_and_proname() {
		Collections.sort(items, (x, y) -> pcode_then_code(x, y));
		this.displayDataWithTotal();
	}

	private int pcode_then_code(Tab_Product x, Tab_Product y) {
		int d = x.pcode.compareTo(y.pcode);
		if (d != 0)
			return d;

		return x.pcode.compareTo(y.pro_name);

	}
}