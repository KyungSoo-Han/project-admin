package kr.hankyungsoo.admin.user.domain;

import kr.hankyungsoo.admin.common.domain.AuditingFields;
import kr.hankyungsoo.admin.user.domain.type.RoleType;
import kr.hankyungsoo.admin.user.domain.type.RoleTypesConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(callSuper = true)
@Entity
public class AdminAccount extends AuditingFields {

    @Id
    @Column(length = 50)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Convert(converter = RoleTypesConverter.class)
    @Column(nullable = false)
    private Set<RoleType> roleTypes = new LinkedHashSet<>();

    @Column(length = 100) private String email;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 300)
    private String memo;
    private AdminAccount(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo, String createdBy) {
        this.userId = userId;
        this.password = userPassword;
        this.roleTypes = roleTypes;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
        this.modifiedBy = createdBy;
        this.modifiedAt= LocalDateTime.now();
    }

    public static AdminAccount of(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo) {
        return AdminAccount.of(userId, userPassword, roleTypes, email, nickname, memo, null);
    }

    public static AdminAccount of(String userId, String userPassword, Set<RoleType> roleTypes, String email, String nickname, String memo, String createdBy) {
        return new AdminAccount(userId, userPassword, roleTypes, email, nickname, memo, createdBy);
    }

    public void addRoleType(RoleType roleType) {
        this.getRoleTypes().add(roleType);
    }

    /*public void addRoleTypes(Collection<RoleType> roleTypes) {
        this.getRoleTypes().addAll(roleTypes);
    }*/

    public void removeRoleType(RoleType roleType) {
        this.getRoleTypes().remove(roleType);
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
