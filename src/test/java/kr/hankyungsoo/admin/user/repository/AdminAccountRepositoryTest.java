package kr.hankyungsoo.admin.user.repository;

import kr.hankyungsoo.admin.user.domain.AdminAccount;
import kr.hankyungsoo.admin.user.domain.type.RoleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("관리자 계정 Repository")
@DataJpaTest
class AdminAccountRepositoryTest {

    private final AdminAccountRepository adminAccountRepository ;

    public AdminAccountRepositoryTest(@Autowired AdminAccountRepository adminAccountRepository) {
        this.adminAccountRepository = adminAccountRepository;
    }

    @Test
    public void 관리자계정_조회() throws Exception {
        //Given


        //When
        List<AdminAccount> adminAccounts = adminAccountRepository.findAll();

        //Then
        assertThat(adminAccounts)
                .isNotNull()
                .hasSize(0);
    }

    @Test
    public void givenAdminAccount_whenInserting_thenIsOK() throws Exception {
        // Given
        long previousCount = adminAccountRepository.count();
        AdminAccount adminAccount = AdminAccount.of("test", "pw", Set.of(RoleType.DEVELOPER), null, null, null);

        // When
        adminAccountRepository.save(adminAccount);

        // Then
        assertThat(adminAccountRepository.count()).isEqualTo(previousCount + 1);

    }

    @Test
    public void givenAdminAccountNewRole_whenUpdating_thenIsOK() throws Exception {
        // Given
        AdminAccount adminAccount = adminAccountRepository.getReferenceById("uno");
        adminAccount.addRoleType(RoleType.DEVELOPER);
        //adminAccount.addRoleType(List.of(RoleType.USER, RoleType.USER));
        adminAccount.removeRoleType(RoleType.ADMIN);

        // When
        AdminAccount updatedAccount = adminAccountRepository.saveAndFlush(adminAccount);

        // Then
        assertThat(updatedAccount)
                .hasFieldOrPropertyWithValue("userId", "uno")
                .hasFieldOrPropertyWithValue("roleTypes", Set.of(RoleType.DEVELOPER, RoleType.USER));


    }


}