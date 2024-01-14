package com.eldar.business.jiraextractor.api.services.impl;

import com.eldar.business.jiraextractor.api.exceptions.customs.NotFoundException;
import com.eldar.business.jiraextractor.domain.repositories.AppUserRepository;
import com.eldar.business.jiraextractor.utils.constants.UserConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author claudio.vilas
 * date 01/2024
 * description
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> {
                    log.error("ERROR:".concat(UserConst.U_USERNAME_NOT_FOUND));
                    return new NotFoundException(UserConst.U_USERNAME_NOT_FOUND);
                });
    }
}
