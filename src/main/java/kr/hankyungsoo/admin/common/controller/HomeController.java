package kr.hankyungsoo.admin.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){

        return "/index";
    }

    @GetMapping("/article")
    public String articleTest(){
        return "management/articles";
    }
}
