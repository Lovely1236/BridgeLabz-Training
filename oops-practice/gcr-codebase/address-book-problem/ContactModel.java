package gcr_codebase.address_book_problem;

public class ContactModel {
	// This Layer is also called as MODEL / POJO LAYER 
	// This class holds only data (no logic)
	    private String name;
	    private String phone;
	    private String email;
	    private String city;
	    private String state;

	    public ContactModel(String name, String phone, String email,
	                   String city, String state) {
	        this.name = name;
	        this.phone = phone;
	        this.email = email;
	        this.city = city;
	        this.state = state;
	    }

	    // Getters and Setters
	    public String getName() { return name; }
	    public String getPhone() { return phone; }
	    public String getEmail() { return email; }
	    public String getCity() { return city; }
	    public String getState() { return state; }

	    public void setPhone(String phone) { this.phone = phone; }
	    public void setCity(String city) { this.city = city; }
	    public void setState(String state) { this.state = state; }
     
}

