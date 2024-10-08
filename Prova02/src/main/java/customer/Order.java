//Mariana Costa da Luz CB3021653
//Ronald Pereira Evangelista CB3020282
package customer;

import java.sql.Date;
import java.time.LocalDate;

public class Order {
	protected int ord_no;
	protected float purch_amt;
	protected Date ord_date;
	protected int customer_id;
	protected int salesman_id;
	
	public Order() {
		
	}
	
	public Order(int ord_no) {
		this.ord_no = ord_no;
	}
	
	public Order(int ord_no, float purch_amt, Date ord_date, int customer_id, int salesman_id) {
		this(purch_amt, ord_date, customer_id, salesman_id);
		this.ord_no = ord_no;
	}
	
	public Order(float purch_amt, Date ord_date, int customer_id, int salesman_id) {
		this.purch_amt = purch_amt;
		this.ord_date = ord_date;
		this.customer_id = customer_id;
		this.salesman_id = salesman_id;
	}

	public int getOrd_no() {
		return ord_no;
	}

	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}

	public float getPurch_amt() {
		return purch_amt;
	}

	public void setPurch_amt(float purch_amt) {
		this.purch_amt = purch_amt;
	}

	public Date getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getSalesman_id() {
		return salesman_id;
	}

	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
}