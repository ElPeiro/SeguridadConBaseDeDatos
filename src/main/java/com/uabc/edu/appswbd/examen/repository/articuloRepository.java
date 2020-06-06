package com.uabc.edu.appswbd.examen.repository;


import com.uabc.edu.appswbd.examen.model.AnimalesEntity;
import com.uabc.edu.appswbd.examen.model.Productos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface articuloRepository extends CrudRepository<Productos, Long> {


}
