package kr.hankyungsoo.admin.user.service;

import kr.hankyungsoo.admin.user.domain.AdminAccount;
import kr.hankyungsoo.admin.user.domain.type.RoleType;
import kr.hankyungsoo.admin.user.dto.AdminAccountDto;
import kr.hankyungsoo.admin.user.dto.UserAccountDto;
import kr.hankyungsoo.admin.user.dto.security.AdminPrincipal;
import kr.hankyungsoo.admin.user.repository.AdminAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class AdminAccountService implements UserDetailsService {

    private final AdminAccountRepository adminAccountRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional(readOnly = true)
    public Optional<AdminAccountDto> searchUser(String username) {
        return adminAccountRepository.findById(username)
                .map(AdminAccountDto::from);
    }

    public AdminAccountDto saveUser(AdminAccountDto dto) {
        return AdminAccountDto.from(
                adminAccountRepository.save(AdminAccount.of(dto.userId(), passwordEncoder.encode(dto.userPassword()), dto.roleTypes(), dto.email(),
                            dto.nickname(), dto.memo(), dto.createdBy()))
        );
    }
    public void deleteUser(String username) {
        adminAccountRepository.deleteById(username);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.debug("userId ={}", userId);
        AdminAccount adminAccount = adminAccountRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId + "가 없습니다."));
        return AdminPrincipal.from(AdminAccountDto.from(adminAccount));
    }
}
