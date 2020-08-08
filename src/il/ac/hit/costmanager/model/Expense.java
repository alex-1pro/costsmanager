package il.ac.hit.costmanager.model;
/**
 * @authors Alexey Belogurov & Jacob Graham
 * 
 * This class represents expense. 
 * */
public class Expense {
	/**
	 *@param id expense id
	 *@param userId expense userId
	 *@param cost expense cost
	 *@param type expense type
	 *@param month expense month
	 *@param description expense description
	 */
	
	private int id;
	private int userId;
	private double cost;
	private String type;
	private String month;
	private String description;
	/**
	 * empty constructor needs for hibernat*/
	public Expense() { 
		super();
	}

	/**
	 * constructor whith params
	 *@param id expense id
	 *@param userId expense userId
	 *@param cost expense cost
	 *@param type expense type
	 *@param month expense month
	 *@param description expense description 
	 **/

	public Expense(int userId, double total, String type, String month, String description) {
		setId(userId);
		setCost(total);
		setType(type);
		setMonth(month);
		setDescription(description);
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

	public double getCost() {
		return cost;
	}

	public void setCost(double total) {
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
