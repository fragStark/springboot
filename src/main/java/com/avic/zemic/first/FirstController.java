package com.avic.zemic.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message","大家好，This is the first Thymeleaf！！");
        map.addAttribute("interface", "ThymeLeaf!!!!");
        map.addAttribute("flag", "yes");
        return "index";
    }
}
