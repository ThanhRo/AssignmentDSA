package assignment.dsa.model;

public class Tab_Order {
	public String pcode;
	public String ccode;
	public long quantity;

	public Tab_Order() {

	}

	public Tab_Order(String pcode, String ccode, long quantity) {
		super();
		this.pcode = pcode;
		this.ccode = ccode;
		this.quantity = quantity;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Tab_Order [pcode=" + pcode + ", ccode=" + ccode + ", quantity=" + quantity + "]";
	}

}
