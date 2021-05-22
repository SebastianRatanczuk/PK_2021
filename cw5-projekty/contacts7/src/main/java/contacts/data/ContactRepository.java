package contacts.data;

import contacts.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> findContacts(long max, int count);

    void insert(Contact contact);

    Contact findOne(long id);

    void delete(long id);

    void update(Contact contact);
}