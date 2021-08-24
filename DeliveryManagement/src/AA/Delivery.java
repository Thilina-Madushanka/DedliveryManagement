package AA;

public class Delivery {

	private int id;
	private String date;
	private String name;
	private String address;
	private String TP;
	
	public Delivery(int id, String date, String name, String address, String TP) {
		
		this.id = id;
		this.date = date;
		this.name = name;
		this.address = address;
		this.TP = TP;
	}	

	
	
	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}



	public String getName() {
		return name;
	}

	

	public String getAddress() {
		return address;
	}

	
	public String getTP() {
		return TP;
	}


	
	
	
}