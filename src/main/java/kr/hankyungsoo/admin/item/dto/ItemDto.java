package kr.hankyungsoo.admin.item.dto;

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
    private BusinessDto businessDto;
    private String memo;

    public static ItemDto of(String itemId,
                             String itemName,
                             String unit,
                             ItemType itemType,
                             BusinessDto businessDto,
                             String memo) {
        return new ItemDto(itemId, itemName, unit, itemType, businessDto, memo);
    }

    public static ItemDto from(Item entity){
        return new ItemDto(
                entity.getItemId(),
                entity.getItemName(),
                entity.getUnit(),
                entity.getItemType(),
                BusinessDto.from(entity.getBusiness()),
                entity.getMemo());
    }

    public Item toEntity(){
        return Item.of(itemId,itemName,unit, itemType, memo, businessDto.toEntity());
    }

}