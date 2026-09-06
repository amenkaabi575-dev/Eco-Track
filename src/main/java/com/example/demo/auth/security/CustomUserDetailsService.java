package com.example.demo.auth.security;


import com.example.demo.user.UserRepository;
import com.example.demo.user.enitity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsernameWithOrganization(username)
                .orElseThrow(()-> new UsernameNotFoundException("User cannot be found with username " + username));
        return new CustomUserDetails(user);
    }
}
