package kr.hankyungsoo.admin.item.controller;

import kr.hankyungsoo.admin.item.dto.request.ItemRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/item")
@Controller
public class ItemController {

    @GetMapping("/form")
    public String form(@ModelAttribute ItemRequest item){
        return "/item/form";
    }

    @PostMapping("/form")
    public String insertItem(@ModelAttribute ItemRequest item, BindingResult bindingResult){

        return "redirect:/";
    }
}
