package kr.hankyungsoo.admin.user.controller;


import kr.hankyungsoo.admin.user.dto.AdminAccountDto;
import kr.hankyungsoo.admin.user.dto.request.AdminAccountRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminAccountValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AdminAccountRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminAccountRequest adminAccountRequest = (AdminAccountRequest) target;

        if(!StringUtils.hasText(adminAccountRequest.getUserId())){
            errors.rejectValue("userId","required",null,null);
        }
        if(!StringUtils.hasText(adminAccountRequest.getEmail())){
            errors.rejectValue("email","required",null,null);
        }
        if(!StringUtils.hasText(adminAccountRequest.getNickname())){
            errors.rejectValue("nickname","required",null,null);
        }
        if(!StringUtils.hasText(adminAccountRequest.getUserPassword())){
            errors.rejectValue("userPassword","required",null,null);
        }
        if(!StringUtils.hasText(adminAccountRequest.getUserPassword2())){
            errors.rejectValue("userPassword2","required",null,null);
        }


        if(!adminAccountRequest.getUserPassword().equals(adminAccountRequest.getUserPassword2())){
            errors.rejectValue("userPassword","this-not-equal",new Object[]{"비밀번호"},"비밀번호가 맞지 않습니다.");
        }
    }
}
