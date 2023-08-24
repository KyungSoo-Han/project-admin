package kr.hankyungsoo.admin.item.dto.request;

import kr.hankyungsoo.admin.business.dto.BusinessDto;
import kr.hankyungsoo.admin.item.domain.Item;
import kr.hankyungsoo.admin.item.dto.ItemDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link Item}
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ItemRequest {
    private String itemId;
    private String itemName;
    private String unit;
    private BusinessDto businessDto;
    private String memo;

    public static ItemRequest of(String itemId,
                                 String itemName,
                                 String unit,
                                 BusinessDto businessDto,
                                 String memo) {
        return new ItemRequest(itemId, itemName, unit, businessDto, memo);
    }
/*
    public static ItemRequest from(Item entity){
        return new ItemRequest(
                entity.getItemId(),
                entity.getItemName(),
                entity.getUnit(),
                entity.getExpDate(),
                BusinessDto.from(entity.getBusiness()),
                entity.getMemo());
    }*/

    public ItemDto toDto(){
        return ItemDto.of(itemId,itemName,unit,businessDto,memo);
    }

}