package com.avic.zemic.first;

import com.avic.zemic.first.mapper.StudentMapper;
import com.avic.zemic.first.model.Student;
import com.avic.zemic.first.page.Page;
import com.avic.zemic.first.page.StudentParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    public void testStudent() {
        // 增加
//        studentMapper.insertStudent(new Student(1266L, "刘欢畅", 20));
        // 修改
//        studentMapper.updateStudent(new Student(1260L, "陈", 23));
        // 删除
        studentMapper.deleteStudent(1260L);
//         查询Object
//        Student studentOne = studentMapper.getStudentById(1267L);
//        System.out.println(studentOne);
        // 查询List
        List<Student> list = studentMapper.getStudentAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testGetStudentAll() {
        List<Student> list = studentMapper.getStudentAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testGetStudentById() {
        Student student = studentMapper.getStudentById(1267L);
        System.out.println(student);
    }

    @Test
    public void testInsertStudent() {
        studentMapper.insertStudent(new Student(1266L, "刘欢畅", 20));
        List<Student> list = studentMapper.getStudentAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testUpdateStudent() {
        studentMapper.updateStudent(new Student(1260L, "陈", 23));
        List<Student> list = studentMapper.getStudentAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testDeleteStudent() {
        studentMapper.deleteStudent(1260L);
    }

    @Test
    public void testGetPageList() {
        StudentParam studentParam = new StudentParam(null, null);
        List<Student> students = studentMapper.getPageList(studentParam);
        Integer studentCount = studentMapper.getStudentCount();
        Page page = new Page(1,studentCount/studentParam.getPageSize() + 1, studentCount, students);
        System.out.println(page);
    }
}
