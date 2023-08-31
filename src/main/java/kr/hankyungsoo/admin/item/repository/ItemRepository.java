package kr.hankyungsoo.admin.item.repository;

import kr.hankyungsoo.admin.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, String> {
    @Modifying
    @Query("delete from Item i where i.business.id = :businessId and i.itemId = :itemId ")
    void deleteItem(String itemId, Long businessId);
}
