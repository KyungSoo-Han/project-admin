package kr.hankyungsoo.admin.business.repository;

import kr.hankyungsoo.admin.business.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business,Long> {
}
