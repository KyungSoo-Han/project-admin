package kr.hankyungsoo.admin.item.service;

import kr.hankyungsoo.admin.item.dto.ItemDto;
import kr.hankyungsoo.admin.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(ItemDto dto){

    }

}
