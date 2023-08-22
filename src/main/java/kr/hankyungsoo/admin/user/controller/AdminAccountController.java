package kr.hankyungsoo.admin.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminAccountController {

    @GetMapping("/sign-up-form")
    public String signUp(){
        return "/user/sign-up";
    }
}
