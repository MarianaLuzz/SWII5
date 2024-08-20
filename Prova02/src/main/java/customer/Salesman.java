//Mariana Costa da Luz
package customer;

public class Salesman {
	protected int salesman_id;
	protected String name;
	protected String city;
	protected float commission;
	
	public Salesman() {
		
	}
	
	public Salesman(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	
	public Salesman(int salesman_id, String name, String city, float commission) {
		this(name, city, commission);
		this.salesman_id = salesman_id;
	}
	
	public Salesman(String name, String city, float commission) {
		this.name = name;
		this.city = city;
		this.commission = commission;
	}
	
	public int getId() {
		return salesman_id;
	}
	
	public void setId(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public float getCommission() {
		return commission;
	}
	
	public void setCommission(float commission) {
		this.commission = commission;
	}	
}