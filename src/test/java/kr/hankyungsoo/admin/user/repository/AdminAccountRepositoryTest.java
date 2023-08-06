package kr.hankyungsoo.admin.user.repository;

import kr.hankyungsoo.admin.user.domain.AdminAccount;
import kr.hankyungsoo.admin.user.domain.type.RoleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

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
        //Given
        long preCount = adminAccountRepository.count();

        AdminAccount adminAccount = AdminAccount.builder()
                .userId("test")
                .roleType(RoleType.ROLE_ADMIN)
                .nickName("hanks")
                .password("1234")
                .introduce("hello, i'm admin")
                .createdBy("other-admin")
                .build();

        //When
        adminAccountRepository.save(adminAccount);

        //Then
        assertThat(adminAccountRepository.count()).isEqualTo(preCount+1);

    }

    @Test
    public void givenAdminAccountNewRole_whenUpdating_thenIsOK() throws Exception {
        //Given
        AdminAccount adminAccount = AdminAccount.builder()
                .userId("test")
                .roleType(RoleType.ROLE_ADMIN)
                .nickName("hanks")
                .password("1234")
                .introduce("hello, i'm admin")
                .createdBy("other-admin")
                .build();

        adminAccountRepository.save(adminAccount);

        //When
        AdminAccount updatingAdminAccount = adminAccountRepository.getReferenceById("test");
        updatingAdminAccount.updateRole(RoleType.ROLE_USER);

        //Then
        System.out.println("adminAccount = " + adminAccount);
        System.out.println("updatingAdminAccount = " + updatingAdminAccount);
        assertThat(adminAccount).isEqualTo(updatingAdminAccount);
        assertThat(updatingAdminAccount.getRoleType()).isEqualTo(RoleType.ROLE_USER);



    }


}