package com.uabc.edu.appswbd.examen.repository;

import com.uabc.edu.appswbd.examen.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUserName(String username);
}
