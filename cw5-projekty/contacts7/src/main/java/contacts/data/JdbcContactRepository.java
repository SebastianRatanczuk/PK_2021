package contacts.data;

import contacts.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class JdbcContactRepository implements ContactRepository {

    @Autowired
    private JdbcOperations jdbc;

    @Override
    public List<Contact> findContacts(long max, int count) {
        return jdbc.query("SELECT id, first_name, last_name, email, phone" +
                        " FROM Contact" +
                        " WHERE id > ?" +
                        " ORDER by id asc limit 20",
                new ContactRowMapper(), max);
    }

    @Override
    public void insert(Contact contact) {
        jdbc.update("INSERT INTO Contact "
                        + "(first_name, last_name, email, phone)"
                        + " VALUES (?, ?, ?, ?)",
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getPhone());
    }

    @Override
    public Contact findOne(long id) {
        return jdbc.queryForObject(
                "SELECT id, first_name, last_name, email, phone" +
                        " FROM Contact" +
                        " WHERE id = ?",
                new ContactRowMapper(), id);
    }

    @Override
    public void delete(long id) {
        jdbc.update("DELETE FROM Contact" +
                " WHERE id = ?", id);
    }

    @Override
    public void update(Contact contact) {
        jdbc.update("UPDATE Contact "
                        + "SET first_name=?, last_name=?, email=?, phone=? "
                        + "WHERE id = ?",
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getId());
    }

    private static class ContactRowMapper implements RowMapper<Contact> {
        @Override
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Contact(rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("phone"));
        }
    }
}
