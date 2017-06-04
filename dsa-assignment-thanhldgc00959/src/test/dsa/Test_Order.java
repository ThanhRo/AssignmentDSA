package test.dsa;

import apps.saleman.services.Res;
import assignment.module.manager.SortByPCodeAndCCode_Order;

public class Test_Order {
	public static void main(String[] args){
		SortByPCodeAndCCode_Order sbpco = new SortByPCodeAndCCode_Order();
		sbpco.dataFile = Res.getDesktopFile("dsa2017-data/1e2/orders.json");
		sbpco.inputData();
		sbpco.displayDataWithTotal();
		sbpco.sortBy_pcode_and_ccode();
	}
}
