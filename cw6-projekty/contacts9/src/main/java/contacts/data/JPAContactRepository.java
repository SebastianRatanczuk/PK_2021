package contacts.data;

import contacts.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class JPAContactRepository implements ContactRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Contact> findContacts(long max, int count) {
        return (List<Contact>) em.createQuery("select c from Contact c where c.id > :i ORDER by c.id asc").setParameter("i", max).getResultList();
    }

    @Override
    public Contact findOne(long id) {
        return em.find(Contact.class, id);
    }

    @Override
    public void insert(Contact contact) {
        em.persist(contact);
    }

    @Override
    public void update(Contact contact) {
        em.merge(contact);
    }

    @Override
    public void delete(long id) {
        em.remove(findOne(id));
    }
}
