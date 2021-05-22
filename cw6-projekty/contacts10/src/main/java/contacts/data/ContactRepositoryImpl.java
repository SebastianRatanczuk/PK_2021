package contacts.data;

import contacts.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ContactRepositoryImpl {
    @PersistenceContext
    private EntityManager em;

    public List<Contact> findContacts(long max, int count) {
        return (List<Contact>) em.createQuery("select c from Contact c where c.id > :id ORDER by c.id asc").setParameter("id", max).getResultList();
    }
}