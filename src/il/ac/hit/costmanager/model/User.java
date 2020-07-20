package il.ac.hit.costmanager.model;

public class User {
	private int id;
	private String userName;
	private String password;
	
    public User(){super();}//not sure if need super()
    
	/*
	 * public User(int id,String userName,String password) { this.id=id;
	 * this.userName=userName; this.password=password;
	 * 
	 * }
	 */
	
    public User(String userName, String password) {
    	this.userName=userName;
    	this.password=password;
    	
    }
    
    public User(User u) {
    	this.id=u.id;
    	this.password=u.password;
    	this.userName=u.userName;
    }
    
    	

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
