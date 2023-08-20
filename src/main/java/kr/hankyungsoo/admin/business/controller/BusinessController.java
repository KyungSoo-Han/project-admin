package kr.hankyungsoo.admin.business.controller;

import kr.hankyungsoo.admin.business.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/business")
@Controller
public class BusinessController {
    private final BusinessService businessService;


}
