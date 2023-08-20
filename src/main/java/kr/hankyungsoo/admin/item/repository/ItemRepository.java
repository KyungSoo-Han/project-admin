package kr.hankyungsoo.admin.item.repository;

import kr.hankyungsoo.admin.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
