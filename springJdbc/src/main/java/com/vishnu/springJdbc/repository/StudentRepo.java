package com.vishnu.springJdbc.repository;

import com.vishnu.springJdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public StudentRepo() {
        System.out.println("StudentRepo object created");
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("Jdbc Template inject using setter method");
    }

    public void save(Student s) {
        String query = "insert into student values(?,?,?)";
        jdbcTemplate.update(query, s.getRollno(), s.getName(), s.getMarks());
    }

    public List<Student> findAll() {
        String query = "select * from student";
        List<Student> students = jdbcTemplate.query(query, (rs, rowNum) -> {
            Student student = new Student();
            student.setRollno(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        });
        return students;
    }
}
