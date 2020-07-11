package il.ac.hit.costmanager.model;

public class Expense {
	private int id;
	private int userId;
	private double cost;
	private String type;
	private String month;
	private String description;
	
	public Expense() { 
		super();
	}

	

	public Expense(int userId, double total, String type, String month, String description) {
		this.userId = userId;
		this.cost = total;
		this.type = type;
		this.month = month;
		this.description = description;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotal() {
		return cost;
	}

	public void setTotal(double total) {
		this.cost = total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", userId=" + userId + ", total=" + cost + ", type=" + type + ", month=" + month
				+ ", description=" + description + "]";
	}
	
	
	
}
