package kr.hankyungsoo.admin.item.repository;

import kr.hankyungsoo.admin.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, String> {
    @Modifying
    @Query("delete from Item i where i.business.id = :businessId and i.itemId = :itemId ")
    void deleteItem(@Param("businessId") Long businessId, @Param("itemId")String itemId );

    @Query("select MAX(CAST(i.itemId AS int)) + 1 from Item i where i.business.id = :businessId")
    int nextItemId(@Param("businessId") Long businessId);
}
