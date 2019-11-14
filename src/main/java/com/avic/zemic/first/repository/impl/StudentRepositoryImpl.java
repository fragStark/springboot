package com.avic.zemic.first.repository.impl;

import com.avic.zemic.first.model.Student;
import com.avic.zemic.first.model.StudentRowMapper;
import com.avic.zemic.first.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int saveStudent(Student student) {
        return jdbcTemplate.update("insert into Student(studentId, studentName, studentAge) values(?, ?, ?)",
                student.getStudentId(), student.getStudentName(), student.getStudentAge());
    }

    @Override
    public int updateStudent(Student student) {
        return jdbcTemplate.update("update student set studentName = ?, studentAge = ? where studentId = ?",
                student.getStudentName(), student.getStudentAge(), student.getStudentId());
    }

    @Override
    public int deleteStudent(Long id) {
        return jdbcTemplate.update("delete from student where studentId = ?", id);
    }

    @Override
    public Student findStudentById(Long id) {
        return jdbcTemplate.queryForObject("select * from student where studentId = ?", new BeanPropertyRowMapper<>(Student.class), id);
    }

    @Override
    public List<Student> findStudentAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }


}
