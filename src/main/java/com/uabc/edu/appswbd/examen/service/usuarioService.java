package com.uabc.edu.appswbd.examen.service;


import com.uabc.edu.appswbd.examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.examen.model.Productos;
import com.uabc.edu.appswbd.examen.model.Usuario;
import com.uabc.edu.appswbd.examen.repository.usuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {


    @Autowired
    usuarioCrudRepository repository;

    public List<Usuario> getUsuarios()
    {
        List<Usuario> result = (List<Usuario>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Usuario>();
        }
    }

    public Usuario getUsuarioById(Long id) throws RecordNotFoundException
    {
        Optional<Usuario> product = repository.findById(id);

        if(product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }



    public Usuario createOrUpdateUsuario(Usuario entity)
    {
        if(entity.getId()  == null)
        {
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            Optional<Usuario> product = repository.findById(entity.getId());

            if(product.isPresent())
            {
                Usuario newEntity = product.get();
                newEntity.setUserName(entity.getUserName());
                newEntity.setPassword(entity.getPassword());


                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteArticulo(Long id) throws RecordNotFoundException
    {
        Optional<Usuario> product = repository.findById(id);

        if(product.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }




}
