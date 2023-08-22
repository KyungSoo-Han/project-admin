package kr.hankyungsoo.admin.user.controller;

import kr.hankyungsoo.admin.common.domain.constant.FormStatus;
import kr.hankyungsoo.admin.user.domain.type.RoleType;
import kr.hankyungsoo.admin.user.dto.AdminAccountDto;
import kr.hankyungsoo.admin.user.dto.request.AdminAccountRequest;
import kr.hankyungsoo.admin.user.service.AdminAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminAccountController {

    private final AdminAccountService adminAccountService;

    @GetMapping("/sign-up-form")
    public String signUpForm(ModelMap map){
        map.addAttribute("formStatus", FormStatus.CREATE);
        return "/user/sign-up";
    }

    @PostMapping("/sign-up-form")
    public String insertAdminAccount(AdminAccountRequest request){
        request.setRoleTypes(Collections.singleton(RoleType.ADMIN));
        request.setCreatedBy(request.getEmail());
        request.setModifiedBy(request.getEmail());
        request.setCreatedAt(LocalDateTime.now());
        request.setModifiedAt(LocalDateTime.now());

        log.debug("request = {}",request.toString());
        adminAccountService.saveUser(request.toDto());

        return "redirect:/";
    }
}
