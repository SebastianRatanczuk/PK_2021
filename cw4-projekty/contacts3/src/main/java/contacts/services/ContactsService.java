package contacts.services;

import contacts.dao.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactsService {

    List<Contact> getAllContacts();
}
