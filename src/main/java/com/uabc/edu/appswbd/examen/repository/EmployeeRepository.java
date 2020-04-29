package com.uabc.edu.appswbd.examen.repository;

import com.uabc.edu.appswbd.examen.model.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository 
			extends CrudRepository<EmployeeEntity, Long> {

}
