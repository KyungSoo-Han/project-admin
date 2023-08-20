package kr.hankyungsoo.admin.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/item")
@Controller
public class ItemController {

    @GetMapping("/form")
    public String form(){
        return "/item/form";
    }

}
