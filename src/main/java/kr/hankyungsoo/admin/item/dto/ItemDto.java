package kr.hankyungsoo.admin.item.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link kr.hankyungsoo.admin.item.domain.Item}
 */
@Data
public class ItemDto  {
    String itemId;
    String itemName;
    String unit;
    LocalDateTime expDate;
    String memo;
}