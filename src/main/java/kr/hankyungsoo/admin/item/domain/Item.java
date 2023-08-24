package kr.hankyungsoo.admin.item.domain;

import kr.hankyungsoo.admin.business.domain.Business;
import kr.hankyungsoo.admin.common.domain.AuditingFields;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Entity
public class Item  extends AuditingFields {

    @Id
    @Column(length = 50, nullable = false)
    private String itemId;
    @Column(length = 100, nullable = false)
    private String itemName;
    @Column(length = 10)
    private String unit;
    @Column(length = 500)
    private String memo;
    @JoinColumn(name = "business_id")
    @ManyToOne(fetch = LAZY)
    private Business business;

    private Item(String itemId, String itemName, String unit, String memo, Business business) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unit = unit;
        this.memo = memo;
        this.business = business;
    }
    public static Item of(String itemId, String itemName, String unit, String memo, Business business) {
        return new Item(itemId,itemName,unit,memo,business);
    }

}
