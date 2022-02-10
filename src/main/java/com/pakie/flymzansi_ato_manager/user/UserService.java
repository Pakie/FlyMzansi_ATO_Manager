package com.pakie.flymzansi_ato_manager.user;

import com.pakie.flymzansi_ato_manager.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto) throws EmailExistsException;

}
