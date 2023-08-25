package kr.hankyungsoo.admin.item.dto.request;

import kr.hankyungsoo.admin.business.dto.BusinessDto;
import kr.hankyungsoo.admin.item.domain.Item;
import kr.hankyungsoo.admin.item.domain.type.ItemType;
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
    private ItemType itemType;
    private Long businessId;
    private String memo;

    public static ItemRequest of(String itemId,
                                 String itemName,
                                 String unit,
                                 ItemType itemType,
                                 Long businessId,
                                 String memo) {
        return new ItemRequest(itemId, itemName, unit, itemType, businessId, memo);
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
        return ItemDto.of(itemId,itemName,unit, itemType, businessId, memo);
    }

}