package com.uabc.edu.appswbd.examen.service;

import com.uabc.edu.appswbd.examen.model.Usuario;
import com.uabc.edu.appswbd.examen.repository.usuarioRepository;
import com.uabc.edu.appswbd.examen.securingweb.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    usuarioRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = userRepo.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("No encontrado"+username));
        return user.map(MyUserDetails::new).get();

    }
}
