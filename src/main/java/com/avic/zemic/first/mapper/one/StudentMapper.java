package com.avic.zemic.first.mapper.one;

import com.avic.zemic.first.model.Student;
import com.avic.zemic.first.page.StudentParam;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentAll();
    Student getStudentById(Long id);
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);

    List<Student> getPageList(StudentParam studentParam);
    int getStudentCount();
}
