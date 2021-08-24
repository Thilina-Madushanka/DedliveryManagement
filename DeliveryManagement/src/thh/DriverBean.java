package thh;

public class DriverBean {
    protected int deliveryid;
    protected String drivername;
    protected String time;
    

    public DriverBean() {}

   

    public DriverBean(int deliveryid, String drivername, String time) {
        super();
        this.deliveryid = deliveryid;
        this.drivername = drivername;
        this.time = time;
        
    }
    public DriverBean(String drivername, String time) {
        super();
        this.drivername =drivername;
        this.time = time;
        
    }



	public int getDeliveryid() {
		return deliveryid;
	}



	public void setDeliveryid(int deliveryid) {
		this.deliveryid = deliveryid;
	}



	public String getDrivername() {
		return drivername;
	}



	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}

    
}