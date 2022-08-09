package com.example.item.service;

import com.example.item.domain.JwtRequest;
import com.example.item.domain.JwtResponse;
import com.example.item.domain.User;
import com.example.item.repository.UserRepository;
import com.example.item.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    private Set getAuthorities(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(userLogin);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(), user.getPassword(), getAuthorities(user));
        } else {
            throw new UsernameNotFoundException("UserLogin is not valid");
        }
    }

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userLogin = jwtRequest.getUserLogin();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userLogin, userPassword);
        final UserDetails userDetails = loadUserByUsername(userLogin);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        return new JwtResponse(newGeneratedToken);
    }

    private void authenticate(String userLogin, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin, userPassword));
        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials from user");
        }
    }

}
