package com.avic.zemic.first.web;

import com.avic.zemic.first.model.User;
import io.swagger.annotations.Api;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Api(value = "消息", protocols = "http")
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public User getUser() {
        User user = new User();
        user.setName("苏驰");
        user.setAge(50);
        user.setPassword("123456");
        return user;
    }

    @PutMapping("/setUserName/{name}")
    public void setUserName(String name) {
        User user = new User();
        user.setName(name);
    }

    @PostMapping("/setUser")
    public void setUser(@Valid User user) {
        String name = user.getName();
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user: " + user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }
}
