package kr.hankyungsoo.admin.user.domain;

import kr.hankyungsoo.admin.common.domain.AuditingFields;
import kr.hankyungsoo.admin.user.domain.type.RoleType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class AdminAccount extends AuditingFields {

    @Id
    @Column(length = 50)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private RoleType roleType;

    @Column(length = 50, nullable = false)
    private String nickName;

    @Column(length = 300)
    private String introduce;

    @Builder
    public AdminAccount(String userId, String password, RoleType roleType, String nickName, String introduce,
                        String createdBy) {
        this.userId = userId;
        this.password = password;
        this.roleType = roleType;
        this.nickName = nickName;
        this.introduce = introduce;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();

    }

    public void updateRole(RoleType roleType) throws Exception {
        if(this.roleType == roleType)
            throw new Exception("이미 설정된 Role타입입니다.");
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminAccount that)) return false;
        return userId != null && userId.equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
