package kr.hankyungsoo.admin.item.service;

import kr.hankyungsoo.admin.item.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;
import static org.mockito.BDDMockito.willDoNothing;

@DisplayName("비즈니스 로직 - 품목")
@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @InjectMocks private ItemService sut;
    @Mock private ItemRepository itemRepository;

    @Test
    void deleteItem() {
        String itemId = "001";
        Long businessId = 1L;

        willDoNothing().given(itemRepository).deleteItem(businessId,itemId);

        sut.deleteItem(businessId,itemId);

        then(itemRepository).should().deleteItem(businessId,itemId);
    }
}