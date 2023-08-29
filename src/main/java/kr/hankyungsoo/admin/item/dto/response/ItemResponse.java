package kr.hankyungsoo.admin.item.dto.response;

import kr.hankyungsoo.admin.item.domain.type.ItemType;
import kr.hankyungsoo.admin.item.dto.ItemDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ItemResponse {

    private String itemId;
    private String itemName;
    private String unit;
    private ItemType itemType;
    private Long businessId;
    private String memo;

    public static ItemResponse from(ItemDto dto) {
        return new ItemResponse(
                dto.getItemId(),
                dto.getItemName(),
                dto.getUnit(),
                dto.getItemType(),
                dto.getBusinessId(),
                dto.getMemo());
    }
}
