package com.uabc.edu.appswbd.examen.repository;

import com.uabc.edu.appswbd.examen.model.AnimalesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository 
			extends CrudRepository<AnimalesEntity, Long> {

}
