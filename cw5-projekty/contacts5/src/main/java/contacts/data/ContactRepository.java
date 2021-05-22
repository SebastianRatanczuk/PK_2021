package contacts.data;

import contacts.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> findContacts(long max, int count);

    void insert(Contact contact);
}