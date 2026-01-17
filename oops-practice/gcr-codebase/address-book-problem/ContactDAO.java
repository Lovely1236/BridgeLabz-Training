package gcr_codebase.address_book_problem;
import java.util.ArrayList;
public class ContactDAO {
	 private ArrayList<ContactModel> contacts = new ArrayList<>();

	    public void save(ContactModel c) {
	        contacts.add(c);
	    }
}
