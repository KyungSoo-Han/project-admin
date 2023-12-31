package kr.hankyungsoo.admin.item.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hankyungsoo.admin.common.service.PaginationService;
import kr.hankyungsoo.admin.item.dto.request.ItemRequest;
import kr.hankyungsoo.admin.item.dto.response.ItemResponse;
import kr.hankyungsoo.admin.item.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/item")
@Controller
public class ItemController {

    private final ItemService itemService;
    private final PaginationService paginationService;

    private final ItemValidator itemValidator;

  /*
    //itemRequest에 대한 유효성 검사를 하지만 데이터 조회시에도 같은 객체를 사용하기 때문에 문제가 발생
    //데이터 조회시에는 유효성 검사가 필요없음
    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(itemValidator);
    }
    */


    @GetMapping("/list")
    public String list(@PageableDefault(size = 10, sort = "itemId", direction = Sort.Direction.DESC) Pageable pageable,
                       ModelMap map) throws JsonProcessingException {
        Page<ItemResponse> items = itemService.getItems(pageable).map(dto -> ItemResponse.from(dto));
        List<Integer> barNumbers = paginationService.getPaginationBarNumbers(pageable.getPageNumber(), items.getTotalPages());

        map.addAttribute("items",items );
        map.addAttribute("paginationBarNumbers", barNumbers);
        log.debug("map={}",map);

        return "item/list";
    }

    @GetMapping("/form")
    public String form(Model model, HttpSession httpsession ){
        model.addAttribute("item", new ItemRequest());
        log.debug("httpsession = {}", httpsession);
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
    public String saveItem(@Validated @ModelAttribute("item") ItemRequest item, BindingResult bindingResult){

        itemValidator.validate(item, bindingResult);

        if(bindingResult.hasErrors()){
            return "item/form";
        }
        item.setBusinessId(1L);
        log.debug("item = {}", item);
        if(StringUtils.hasText(item.getItemId())){
            itemService.updateItem(item.getItemId(), item.toDto());
            log.debug("UPDATE item.getItemId() = {}", item.getItemId());
        }
        else{
            itemService.saveItem(item.toDto());
            log.debug("INSERT item.getItemId() = {}", item.getItemId());
        }

        return "redirect:/item/list";
    }

    @GetMapping("/{businessId}/{itemId}")
    public String formForUpdate(@PathVariable Long businessId, @PathVariable String itemId , Model model){
        ItemResponse itemResponse = itemService.getItem(businessId, itemId);
        model.addAttribute("item", itemResponse);
        //log.debug("httpsession = {}", httpsession);
        return "/item/form";
    }
    @PostMapping("/{itemId}/form")
    public String updateItem(@Validated @PathVariable String itemId, @ModelAttribute("item") ItemRequest item,
                             BindingResult bindingResult){

        itemValidator.validate(item,bindingResult);

        if(bindingResult.hasErrors()){
            return "item/form";
        }

        itemService.updateItem(itemId, item.toDto());

        return "redirect:/item/list";
    }

    @PostMapping("/{businessId}/{itemId}/delete")
    public String deleteItem(@PathVariable Long businessId, @PathVariable String itemId){
        itemService.deleteItem(businessId, itemId );
        return "redirect:/item/list";
    }
}
