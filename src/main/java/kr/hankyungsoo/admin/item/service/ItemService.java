package kr.hankyungsoo.admin.item.service;

import kr.hankyungsoo.admin.business.domain.Business;
import kr.hankyungsoo.admin.business.repository.BusinessRepository;
import kr.hankyungsoo.admin.item.domain.Item;
import kr.hankyungsoo.admin.item.dto.ItemDto;
import kr.hankyungsoo.admin.item.dto.request.ItemRequest;
import kr.hankyungsoo.admin.item.dto.response.ItemResponse;
import kr.hankyungsoo.admin.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final BusinessRepository businessRepository;

    @Transactional
    public void saveItem(ItemDto dto){
        Business business = businessRepository.findById(dto.getBusinessId())
                                                .orElseThrow(EntityNotFoundException::new);

        itemRepository.save(dto.toEntity(business));
    }

    public Page<ItemDto> getItems(Pageable pageable) {

        return itemRepository.findAll(pageable).map(entity->ItemDto.from(entity));
    }
}
