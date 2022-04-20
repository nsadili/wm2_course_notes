package az.edu.az.wm2.mongo_db_demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
    private Integer id;
    private String shortName;
    private String fullName;

    public Course() {
    }

    public Course(Integer id, String shortName, String fullName) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
