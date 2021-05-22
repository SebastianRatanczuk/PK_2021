package contacts.data;

import contacts.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> findContacts(long max, int count);

    Contact findOne(long id);

    void insert(Contact contact);

    void update(Contact contact);

    void delete(long id);

}