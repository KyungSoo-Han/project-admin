package kr.hankyungsoo.admin.business.dto;

import kr.hankyungsoo.admin.business.domain.Business;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * DTO for {@link kr.hankyungsoo.admin.business.domain.Business}
 */
@AllArgsConstructor
@Getter
@ToString
public class BusinessDto {

    private String name;
    private String bizNumber;
    private String ownerName;
    private String phoneNumber;
    private String address;
    private String memo;


    public static BusinessDto of(String name, String bizNumber, String ownerName, String phoneNumber, String address, String memo) {
        return new BusinessDto(name, bizNumber, ownerName, phoneNumber, address, memo);
    }

    public static BusinessDto from(Business business){
        return new BusinessDto(business.getName(),
                business.getBizNumber(),
                business.getOwnerName(),
                business.getPhoneNumber(),
                business.getAddress(),
                business.getMemo());
    }

    public Business toEntity(){
        return Business.of(name,bizNumber,ownerName,phoneNumber,address,memo);
    }
}