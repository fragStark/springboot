package com.avic.zemic.first.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setStudentId(resultSet.getLong("studentId"));
        student.setStudentName(resultSet.getString("studentName"));
        student.setStudentAge(resultSet.getInt("studentAge"));
        return student;
    }
}
