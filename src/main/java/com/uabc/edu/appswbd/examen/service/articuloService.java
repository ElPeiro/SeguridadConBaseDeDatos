package com.uabc.edu.appswbd.examen.service;


import com.uabc.edu.appswbd.examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.examen.model.AnimalesEntity;
import com.uabc.edu.appswbd.examen.model.Productos;
import com.uabc.edu.appswbd.examen.repository.AnimalesRepository;
import com.uabc.edu.appswbd.examen.repository.articuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class articuloService {

    @Autowired
    articuloRepository repository;

    public List<Productos> getArticulos()
    {
        List<Productos> result = (List<Productos>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Productos>();
        }
    }

    public Productos getProductoById(Long id) throws RecordNotFoundException
    {
        Optional<Productos> product = repository.findById(id);

        if(product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Productos createOrUpdateProducto(Productos entity)
    {
        if(entity.getId()  == null)
        {
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            Optional<Productos> product = repository.findById(entity.getId());

            if(product.isPresent())
            {
                Productos newEntity = product.get();
                newEntity.setNombre(entity.getNombre());
                newEntity.setCodigo(entity.getCodigo());
                newEntity.setPrecio(entity.getPrecio());

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
        Optional<Productos> product = repository.findById(id);

        if(product.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }


}
