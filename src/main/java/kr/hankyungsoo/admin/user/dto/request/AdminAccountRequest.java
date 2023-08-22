package kr.hankyungsoo.admin.user.dto.request;

import kr.hankyungsoo.admin.user.domain.type.RoleType;
import kr.hankyungsoo.admin.user.dto.AdminAccountDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminAccountRequest {

     private String userId;
     private String userPassword;
     private Set<RoleType> roleTypes;
     private String email;
     private String nickname;
     private String memo;
     private LocalDateTime createdAt;
     private String createdBy;
     private LocalDateTime modifiedAt;
     private String modifiedBy;

    public static AdminAccountRequest of(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo) {
        return AdminAccountRequest.of(userId, userPassword, roleTypes, email, nickname, memo, null, null, null, null);
    }

    public static AdminAccountRequest of(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new AdminAccountRequest(userId, userPassword, roleTypes, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public AdminAccountDto toDto() {
        return AdminAccountDto.of(
                userId,
                userPassword,
                roleTypes,
                email,
                nickname,
                memo,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

}
