package contacts.services;

import contacts.dao.model.Contact;
import contacts.dao.repository.ContactsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ContactServiceImpl implements ContactsService {

    @Autowired
    private ContactsRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findContacts(20, 0);
    }
}
