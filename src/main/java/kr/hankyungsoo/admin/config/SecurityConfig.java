package kr.hankyungsoo.admin.config;

import kr.hankyungsoo.admin.user.domain.type.RoleType;
import kr.hankyungsoo.admin.user.dto.UserAccountDto;
import kr.hankyungsoo.admin.user.dto.security.AdminPrincipal;
import kr.hankyungsoo.admin.user.repository.AdminAccountRepository;
import kr.hankyungsoo.admin.user.service.AdminAccountService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] rolesAboveManager = {RoleType.MANAGER.name(), RoleType.DEVELOPER.name(), RoleType.ADMIN.name()};

        return http
                 .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .antMatchers("/admin/**").permitAll()
                        .anyRequest().authenticated())

                //.formLogin(withDefaults())
                .formLogin()
                    .loginPage("/admin/loginForm")
                    .usernameParameter("userId")
                    .passwordParameter("password")
                    .failureUrl("/admin/sign-up-form")
                    .loginProcessingUrl("/admin/login")
                    .and()
                .logout(logout -> logout.logoutSuccessUrl("/"))
                //.oauth2Login(withDefaults())
                .build();
    }
 /*   @Bean
    public UserDetailsService userDetailsService(AdminAccountService adminAccountService){
        return username -> adminAccountService
                .searchUser(username)
                .map(AdminPrincipal::from)
                .orElseThrow(()->new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: "+ username));

    }*/
}
