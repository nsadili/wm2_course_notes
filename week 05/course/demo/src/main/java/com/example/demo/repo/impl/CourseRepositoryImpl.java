package com.example.demo.repo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
import com.example.demo.repo.CourseRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private static final Logger logger = LoggerFactory.getLogger(CourseRepositoryImpl.class);

    private DataSource ds;

    public CourseRepositoryImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Iterable<Course> list() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, course_name, department_name, credits FROM course;");) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courses;
    }

    @Override
    public Optional<Course> findById(Integer id) {
        Optional<Course> result = Optional.empty();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "SELECT id, course_name, department_name, credit FROM course WHERE id=?;");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = Optional.of(new Course(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Course save(Course course) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "INSERT INTO course(course_name, department_name, credits) VALUES(?,?,?)",
                             Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDepartmentName());
            ps.setInt(3, course.getCredits());

            int rows = ps.executeUpdate();

            if (rows == 0)
                throw new SQLException("No rows affected!");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next())
                    course.setId(rs.getInt(1));
                else
                    throw new SQLException("No id returned as a result of insert");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return course;
    }

    @Override
    public void update(Course course) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(
                             "UPDATE course SET course_name = ?, department_name = ?, credits = ? WHERE id = ?");) {
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDepartmentName());
            ps.setInt(3, course.getCredits());
            ps.setInt(4, course.getId());

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
                             "DELETE FROM course WHERE id=?;");) {
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

