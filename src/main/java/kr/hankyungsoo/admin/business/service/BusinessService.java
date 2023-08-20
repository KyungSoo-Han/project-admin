package kr.hankyungsoo.admin.business.service;

import kr.hankyungsoo.admin.business.dto.BusinessDto;
import kr.hankyungsoo.admin.business.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BusinessService {
    private final BusinessRepository businessRepository;

    public void save(BusinessDto dto){
        businessRepository.save(dto.toEntity());
    }
}
