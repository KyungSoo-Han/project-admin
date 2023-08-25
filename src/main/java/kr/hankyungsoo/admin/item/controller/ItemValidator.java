package kr.hankyungsoo.admin.item.controller;


import kr.hankyungsoo.admin.item.dto.request.ItemRequest;
import kr.hankyungsoo.admin.user.dto.request.AdminAccountRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ItemRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ItemRequest itemRequest = (ItemRequest) target;

        if(!StringUtils.hasText(itemRequest.getItemId())){
            errors.rejectValue("itemId","required",null,null);
        }
        if(!StringUtils.hasText(itemRequest.getItemName())){
            errors.rejectValue("itemName","required",null,null);
        }
        if(!StringUtils.hasText(itemRequest.getUnit())){
            errors.rejectValue("unit","required",null,null);
        }
        if(!StringUtils.hasText(itemRequest.getItemType().name())){
            errors.rejectValue("userPassword","required",null,null);
        }
        if(!StringUtils.hasText(itemRequest.getMemo())){
            errors.rejectValue("memo","required",null,null);
        }

    }
}
