package com.devsuperior.bds01.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Page<EmployeeDTO> findAll(Pageable pageable){
        Page<Employee> list=  repository.findAll(pageable);
        return list.map(EmployeeDTO::new);
    }

    public EmployeeDTO insert(EmployeeDTO dto) {
        
        Employee entity = new Employee();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment(departmentRepository.getOne(dto.getDepartmentId()));
        
        return new EmployeeDTO(repository.save(entity));
    }

}
