package com.avic.zemic.first.repository;

import com.avic.zemic.first.model.Student;

import java.util.List;

public interface StudentRepository {
    int saveStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Long id);
    Student findStudentById(Long id);
    List<Student> findStudentAll();
}
