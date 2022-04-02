package com.devsuperior.bds01.dto;

import java.io.Serializable;

import com.devsuperior.bds01.entities.Department;

public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private String name;
    private Long id;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }
    
    public DepartmentDTO(Department entity){
        this.name = entity.getName();
        this.id = entity.getId();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
