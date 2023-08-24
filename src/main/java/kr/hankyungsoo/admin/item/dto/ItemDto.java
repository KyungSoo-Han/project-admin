package kr.hankyungsoo.admin.item.dto;

import kr.hankyungsoo.admin.business.dto.BusinessDto;
import kr.hankyungsoo.admin.item.domain.Item;
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
    private BusinessDto businessDto;
    private String memo;

    public static ItemDto of(String itemId,
                             String itemName,
                             String unit,
                             BusinessDto businessDto,
                             String memo) {
        return new ItemDto(itemId, itemName, unit, businessDto, memo);
    }

    public static ItemDto from(Item entity){
        return new ItemDto(
                entity.getItemId(),
                entity.getItemName(),
                entity.getUnit(),
                BusinessDto.from(entity.getBusiness()),
                entity.getMemo());
    }

    public Item toEntity(){
        return Item.of(itemId,itemName,unit,memo, businessDto.toEntity());
    }

}