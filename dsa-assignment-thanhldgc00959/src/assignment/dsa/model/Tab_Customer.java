package assignment.dsa.model;

public class Tab_Customer {
	public String ccode;
	public String cus_name;
	public String phone;

	public Tab_Customer() {

	}

	public Tab_Customer(String ccode, String cus_name, String phone) {
		super();
		this.ccode = ccode;
		this.cus_name = cus_name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Tab_Customer [ccode=" + ccode + ", cus_name=" + cus_name + ", phone=" + phone + "]";
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
