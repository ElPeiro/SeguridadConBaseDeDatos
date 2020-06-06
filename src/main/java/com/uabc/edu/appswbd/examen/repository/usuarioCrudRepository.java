package com.uabc.edu.appswbd.examen.repository;


import com.uabc.edu.appswbd.examen.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioCrudRepository extends CrudRepository<Usuario,Long> {

}
