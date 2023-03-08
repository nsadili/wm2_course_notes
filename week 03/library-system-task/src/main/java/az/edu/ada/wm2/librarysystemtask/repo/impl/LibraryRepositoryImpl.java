package az.edu.ada.wm2.librarysystemtask.repo.impl;

import az.edu.ada.wm2.librarysystemtask.model.Library;
import az.edu.ada.wm2.librarysystemtask.repo.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    private static final Logger logger = LoggerFactory.getLogger(LibraryRepositoryImpl.class);

    private DataSource ds;

    public LibraryRepositoryImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Iterable<Library> list() {
        List<Library> librarys = new ArrayList<>();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, title, description,yearr,author FROM library;");) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                librarys.add(new Library(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return librarys;
    }

    @Override
    public Optional<Library> findById(Integer id) {
        Optional<Library> result = Optional.empty();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "SELECT id, title, description,yearr,author FROM library WHERE id=?;");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = Optional.of(new Library(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Library save(Library library) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "INSERT INTO library(title, description, yearr,author) VALUES(?,?,?,?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, library.getTitle());
            ps.setString(2, library.getDescription());
            ps.setString(3, library.getYearr());
            ps.setString(4, library.getAuthor());

            int rows = ps.executeUpdate();

            if (rows == 0)
                throw new SQLException("No rows affected!");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next())
                    library.setId(rs.getInt(1));
                else
                    throw new SQLException("No id returned as a result of insert");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return library;
    }

    @Override
    public void update(Library library) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "UPDATE library SET title = ?, description = ? ,yearr = ?, author = ? WHERE id = ?");) {
            ps.setString(1, library.getTitle());
            ps.setString(2, library.getDescription());
            ps.setInt(3, library.getId());
            ps.setString(4, library.getYearr());
            ps.setString(5, library.getAuthor());

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
                             "DELETE FROM library WHERE id=?;");) {
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}