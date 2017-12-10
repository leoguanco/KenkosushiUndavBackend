package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Role;
import com.kenkosushi.Undav.domain.model.User;
import com.kenkosushi.Undav.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Collections.emptyList;

@Service("userService")
public class UserService implements UserDetailsService{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User findById(Long id){
        return userRepository.findOne(id);
    }

    public Collection<User> findAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        List<GrantedAuthority> authorities =  buildAuthorities(user.getRole());

        if(user == null){
            throw new UsernameNotFoundException(s);
        }

        return buildUser(user, authorities);
    }

    private org.springframework.security.core.userdetails.User buildUser(User user, List<GrantedAuthority> authorities){
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getActive(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<Role> roles){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for(Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new ArrayList<GrantedAuthority>(authorities);
    }
}
