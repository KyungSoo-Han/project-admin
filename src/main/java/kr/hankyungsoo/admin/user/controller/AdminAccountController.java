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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminAccountController {

    private final AdminAccountService adminAccountService;
    private final AdminAccountValidator adminAccountValidator;


    @GetMapping("/sign-up-form")
    public String signUpForm(@ModelAttribute("adminAccount") AdminAccountRequest adminAccount){
        return "/user/sign-up";
    }

    @PostMapping("/sign-up-form")
    public String insertAdminAccount(@ModelAttribute("adminAccount") AdminAccountRequest request, BindingResult bindingResult){
        log.debug("target = {}", bindingResult.getTarget());

        adminAccountValidator.validate(request, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            return "user/sign-up";
        }

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
