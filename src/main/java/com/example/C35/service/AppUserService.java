package com.example.C35.service;


import com.example.C35.dto.AppUserDTO;
import com.example.C35.entity.AppRole;
import com.example.C35.entity.AppUser;
import com.example.C35.repository.IAppRoleRepository;
import com.example.C35.repository.IAppUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private IAppRoleRepository appRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    public AppUser create(AppUserDTO appUserDTO){
        ObjectMapper mapper = new ObjectMapper();
        AppUser appUser = mapper.convertValue(appUserDTO,AppUser.class);
        String password = bCryptPasswordEncoder.encode(appUserDTO.getPassword());
        Set<Long> idRoles = appUserDTO.getIdRoles();
        Set<AppRole> appRoles = new HashSet<>();
        for (Long idRole : idRoles) {
            AppRole appRole = appRoleRepository.getById(idRole);
            appRoles.add(appRole);
        }
        appUser.setPassword(password);
        appUser.setRoles(appRoles);
        return appUserRepository.save(appUser);
    }
}
