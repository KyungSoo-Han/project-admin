package kr.hankyungsoo.admin.item.controller;

import kr.hankyungsoo.admin.item.dto.request.ItemRequest;
import kr.hankyungsoo.admin.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/item")
@Controller
public class ItemController {

    private final ItemService itemService;
    private final ItemValidator itemValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(itemValidator);
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("item", new ItemRequest());
        return "/item/form";
    }

    /**
     *
     * @param item
     * @param bindingResult
     * @return
     * TODO: Business Id 연결 작업 필요
     */
    @PostMapping("/form")
    public String insertItem(@Validated @ModelAttribute("item") ItemRequest item, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "item/form";
        }
        item.setBusinessId(1L);

        itemService.saveItem(item.toDto());
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model){
        return "item/list";
    }

}
