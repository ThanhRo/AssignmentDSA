package test.dsa;

import apps.saleman.services.Res;
import assignment.module.manager.SortByPCode;
import assignment.module.manager.SortByPCodeAndCCode_Order;

public class Test_Product {
	public static void main(String[] args){
		SortByPCode sbpco = new SortByPCode();
		sbpco.dataFile = Res.getDesktopFile("dsa2017-data/1e2/products.json");
		sbpco.inputData(null);
		sbpco.displayDataWithTotal();
		sbpco.sortBy_pcode_and_proname();
	}
}
