package gcr_codebase.address_book_problem;

import java.util.Collections;
import java.util.Comparator;
public class AddressBookService {
	 private ContactDAO repo = new ContactDAO();

	    // UC1: Add Contact
	    public void addContact(ContactModel c) {
	        repo.save(c);
	    }
}
