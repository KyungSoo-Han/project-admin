package kr.hankyungsoo.admin.business.domain;

import kr.hankyungsoo.admin.common.domain.AuditingFields;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(callSuper = true)
@Entity
public class Business extends AuditingFields {
    @Id
    @Column(name = "business_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 30)
    private String bizNumber;
    @Column(length = 50)
    private String ownerName;
    @Column(length = 30)
    private String phoneNumber;
    @Column(length = 500)
    private String address;
    @Column(length = 500)
    private String memo;

    private Business(String name, String bizNumber, String ownerName, String phoneNumber, String address, String memo) {
        this.name = name;
        this.bizNumber = bizNumber;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memo = memo;
    }

    public static Business of( String name, String bizNumber, String ownerName, String phoneNumber, String address, String memo){
        return new Business(name,bizNumber,ownerName,phoneNumber,address,memo);
    }

}
