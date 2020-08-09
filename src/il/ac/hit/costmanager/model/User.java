package il.ac.hit.costmanager.model;
/**
 * 
 *  @author Alexey Belogurov & Jacob Graham
 * 
 * This class represents user. 
 * */
public class User {
	/**
	 *@param id users id
	 *@param userName users name
	 *@param password users password*/
	private int id;
	private String userName;
	private String password;
	
    public User(){super();}
	
    public User(String userName, String password) {
    	setUserName(userName);
    	setPassword(password);
    }
    
    public User(User u) {
    	setUserName(u.userName);
    	setPassword(u.password);
    	setId(u.id);
 
    }
    /**
	 *getters and setters for params.
	 */

	public	void setId(int id) {
    	this.id=id;
    }
	
		public	void setUserName(String name) {
		this.userName=name;
	}

	public	void setPassword(String password) {
		this.password=password;
	}

	public int getId() {
		return this.id;
	}

	public	String getUserName() {
		return this.userName;
	}

	public	 String getPassword() {
		return this.password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
