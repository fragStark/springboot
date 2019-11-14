package com.avic.zemic.first.page;

public class StudentParam extends PageParam {
    private String studentName;
    private Integer studentAge;

    @Override
    public String toString() {
        return "StudentParam{" +
                "studentName='" + studentName + '\'' +
                ", studentAge='" + studentAge + '\'' +
                '}';
    }

    public StudentParam() {
    }

    public StudentParam(String studentName, Integer studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
}
