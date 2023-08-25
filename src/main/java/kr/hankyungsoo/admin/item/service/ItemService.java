package kr.hankyungsoo.admin.item.service;

import kr.hankyungsoo.admin.business.domain.Business;
import kr.hankyungsoo.admin.business.repository.BusinessRepository;
import kr.hankyungsoo.admin.item.dto.ItemDto;
import kr.hankyungsoo.admin.item.dto.request.ItemRequest;
import kr.hankyungsoo.admin.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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

}
