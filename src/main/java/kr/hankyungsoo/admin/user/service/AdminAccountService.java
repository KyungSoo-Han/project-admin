package kr.hankyungsoo.admin.user.service;

import kr.hankyungsoo.admin.user.domain.AdminAccount;
import kr.hankyungsoo.admin.user.domain.type.RoleType;
import kr.hankyungsoo.admin.user.dto.AdminAccountDto;
import kr.hankyungsoo.admin.user.dto.UserAccountDto;
import kr.hankyungsoo.admin.user.repository.AdminAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class AdminAccountService {

    private final AdminAccountRepository adminAccountRepository;

    @Transactional(readOnly = true)
    public Optional<AdminAccountDto> searchUser(String username) {
        return adminAccountRepository.findById(username)
                .map(AdminAccountDto::from);
    }

    public AdminAccountDto saveUser(AdminAccountDto dto) {
        return AdminAccountDto.from(
                adminAccountRepository.save(AdminAccount.of(dto.userId(), dto.userPassword(), dto.roleTypes(), dto.email(),
                            dto.nickname(), dto.memo(), dto.createdBy()))
        );
    }
    public void deleteUser(String username) {
        adminAccountRepository.deleteById(username);
    }

}
