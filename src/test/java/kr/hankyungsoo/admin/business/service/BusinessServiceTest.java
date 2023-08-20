package kr.hankyungsoo.admin.business.service;

import kr.hankyungsoo.admin.business.domain.Business;
import kr.hankyungsoo.admin.business.dto.BusinessDto;
import kr.hankyungsoo.admin.business.repository.BusinessRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 사업")
@ExtendWith(MockitoExtension.class)
class BusinessServiceTest {

    @InjectMocks private BusinessService sut;
    @Mock private BusinessRepository businessRepository;

    @Test
    public void givenBusinessInfo_whenSavingBusiness_thenSaveBusiness() throws Exception {
        //Given

        BusinessDto dto = new BusinessDto("오떡케",
                "100-22-33422",
                "한경수2",
                "011-2213-3422",
                "서울시 광진구 자양동",
                "테스트");

        given(businessRepository.save(dto.toEntity())).willReturn(createBusiness());

        //When
        sut.save(dto);

        //Then
        then(businessRepository).should().save(any(Business.class));


    }
    private Business createBusiness() {
        Business business = Business.of(
                "오떡케",
                "100-22-33422",
                "한경수2",
                "011-2213-3422",
                "서울시 광진구 자양동",
                "테스트"
        );
        ReflectionTestUtils.setField(business, "id", 2L);

        return business;

    }

}