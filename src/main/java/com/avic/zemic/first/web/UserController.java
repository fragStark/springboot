package com.avic.zemic.first.web;

import com.avic.zemic.first.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public User getUser() {
        User user = new User();
        user.setName("苏驰");
        user.setAge(50);
        user.setPassword("123456");
        return user;
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
