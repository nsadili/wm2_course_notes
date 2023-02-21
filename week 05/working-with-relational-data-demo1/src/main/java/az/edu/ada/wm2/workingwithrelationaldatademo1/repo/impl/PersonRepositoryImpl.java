package az.edu.ada.wm2.workingwithrelationaldatademo1.repo.impl;

import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;
import az.edu.ada.wm2.workingwithrelationaldatademo1.repo.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private static final Logger logger = LoggerFactory.getLogger(PersonRepositoryImpl.class);

    private DataSource ds;

    public PersonRepositoryImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Iterable<Person> list() {
        List<Person> persons = new ArrayList<>();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, first_name, last_name FROM person;");) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                persons.add(new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return persons;
    }

    @Override
    public Optional<Person> findById(Integer id) {
        Optional<Person> result = Optional.empty();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "SELECT id, first_name, last_name FROM person WHERE id=?;");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = Optional.of(new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Person save(Person person) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "INSERT INTO person(first_name, last_name) VALUES(?,?)",
                             Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());

            int rows = ps.executeUpdate();

            if (rows == 0)
                throw new SQLException("No rows affected!");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next())
                    person.setId(rs.getInt(1));
                else
                    throw new SQLException("No id returned as a result of insert");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    @Override
    public void update(Person person) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "UPDATE person SET first_name = ?, last_name = ? WHERE id = ?");) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getId());

            int rows = ps.executeUpdate();

            if (rows == 0)
                throw new SQLException("No rows affected!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "DELETE FROM person WHERE id=?;");) {
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
