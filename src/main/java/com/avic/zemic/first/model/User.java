package com.avic.zemic.first.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
    @NotNull(message="姓名不能为空")
    private String name;

    @Max(value = 100, message = "年龄不能大于100岁")
    @Min(value = 18, message = "年龄不能小于18岁")
    private Integer age;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, message = "密码长度不能少于六位")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
