package com.uabc.edu.appswbd.examen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.uabc.edu.appswbd.examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.examen.model.EmployeeEntity;
import com.uabc.edu.appswbd.examen.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public List<EmployeeEntity> getAllEmployees()
	{
		List<EmployeeEntity> result = (List<EmployeeEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}
	
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException
	{
		Optional<EmployeeEntity> employee = repository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<EmployeeEntity> employee = repository.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				EmployeeEntity newEntity = employee.get();
				newEntity.setTipo(entity.getTipo());
				newEntity.setRaza(entity.getRaza());
				newEntity.setColor(entity.getColor());
				newEntity.setPelaje(entity.getPelaje());
				newEntity.setFecha_nacimiento(entity.getFecha_nacimiento());
				newEntity.setVacunas(entity.getVacunas());
				//int temp = parseInt(entity.getEstado());
				//if (temp == 0){
				//	newEntity.setEstado("Adoptado");
				//}else{
				if(entity.getAdoptivo() == "") {
					newEntity.setEstado("0");
				}else {
					newEntity.setEstado("Adoptado");
				}
				//}


				newEntity.setAdoptivo(entity.getAdoptivo());


				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteEmployeeById(Long id) throws RecordNotFoundException 
	{
		Optional<EmployeeEntity> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	} 
}