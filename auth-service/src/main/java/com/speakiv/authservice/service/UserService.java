package com.speakiv.authservice.service;

import com.speakiv.authservice.model.entity.User;
import com.speakiv.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> appUserOpt = this.userRepository.findByUsernameOrEmail(s,s);
        if(!appUserOpt.isPresent()){
            throw new UsernameNotFoundException("Credentials are wrong");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUserOpt.get().getRoles().stream().forEach((role)->{
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        User appUser = appUserOpt.get();

        return new org.springframework.security.core.userdetails.User(appUser.getId().toString(), passwordEncoder.encode(appUser.getPassword()), authorities);
    }

}
