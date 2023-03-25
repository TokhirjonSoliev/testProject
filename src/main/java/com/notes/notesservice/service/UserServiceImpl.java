package com.notes.notesservice.service;

import com.notes.notesservice.dto.UserDto;
import com.notes.notesservice.entity.User;
import com.notes.notesservice.exception.BadCredentialsException;
import com.notes.notesservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException(String.format("Username %s not found", username)));
    }

    public User createUser(UserDto userDto) {
        return userRepository.save(new User(UUID.randomUUID(), userDto.getUsername(), passwordEncoder.encode(userDto.getPassword())));
    }
}
