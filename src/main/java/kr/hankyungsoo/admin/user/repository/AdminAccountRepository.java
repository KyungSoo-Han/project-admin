package kr.hankyungsoo.admin.user.repository;

import kr.hankyungsoo.admin.user.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount,String> {
}
