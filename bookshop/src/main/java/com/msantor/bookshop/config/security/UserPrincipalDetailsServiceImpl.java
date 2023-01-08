package com.msantor.bookshop.config.security;


import com.msantor.bookshop.dao.ClientRepository;
import com.msantor.bookshop.model.ClientEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsServiceImpl implements UserDetailsService {

    private ClientRepository clientRepository;

    public UserPrincipalDetailsServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        ClientEntity user = clientRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new MyUserPrincipal(user);
    }


}