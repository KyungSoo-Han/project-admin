package kr.hankyungsoo.admin.item.dto;

import kr.hankyungsoo.admin.business.domain.Business;
import kr.hankyungsoo.admin.business.dto.BusinessDto;
import kr.hankyungsoo.admin.item.domain.Item;
import kr.hankyungsoo.admin.item.domain.type.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link kr.hankyungsoo.admin.item.domain.Item}
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemDto  {
    private String itemId;
    private String itemName;
    private String unit;
    private ItemType itemType;
    private Long businessId;
    private String memo;

    public static ItemDto of(String itemId,
                             String itemName,
                             String unit,
                             ItemType itemType,
                             Long businessId,
                             String memo) {
        return new ItemDto(itemId, itemName, unit, itemType, businessId, memo);
    }

    public static ItemDto from(Item entity){
        return new ItemDto(
                entity.getItemId(),
                entity.getItemName(),
                entity.getUnit(),
                entity.getItemType(),
                entity.getBusiness().getId(),
                entity.getMemo());
    }

    public Item toEntity(Business business){
        return Item.of(itemId,itemName,unit, itemType, memo, business);
    }

}