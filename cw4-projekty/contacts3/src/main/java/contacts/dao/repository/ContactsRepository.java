package contacts.dao.repository;

import java.util.List;

import contacts.dao.model.Contact;

public interface ContactsRepository {

	public List<Contact> findContacts(long max, int count);

}
