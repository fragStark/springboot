package com.avic.zemic.first;

import com.avic.zemic.first.model.Student;
import com.avic.zemic.first.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testInsertStudent() {
        Student student = new Student(1267L, "杨雅文", 25);
        studentRepository.saveStudent(student);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student(101L, "杨嘉杰", 24);
        studentRepository.updateStudent(student);
    }

    @Test
    public void testDeleteStudent() {
        studentRepository.deleteStudent(101L);
    }

    @Test
    public void testFindStudentById() {
        Student student = studentRepository.findStudentById(1268L);
        System.out.println(student);
    }

    @Test
    public void testFindStudentAll() {
        List<Student> students =  studentRepository.findStudentAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
