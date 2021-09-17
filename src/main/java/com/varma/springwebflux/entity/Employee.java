/**
 * 
 */
package com.varma.springwebflux.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author user
 *
 */
@Table
public class Employee implements Persistable<Integer>{

	@Id
	private Integer id;
	private String name;
	private String designation;
		
    /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

	@JsonIgnore
	@Transient
	private boolean newEmployee;

	
	@Override
    @JsonIgnore
    @Transient
    public boolean isNew() {
		System.out.println("isNew >>> newEmployee :::"+this.newEmployee);
		if(this.newEmployee) {
			return this.newEmployee || id == getId();
		}else {
			return this.newEmployee || id == null;
		}
    }
	
	@JsonIgnore
    @Transient
    public Employee setAsNew(boolean isNewEmployee){
        this.newEmployee = isNewEmployee;
        System.out.println("setAsNew >>> newEmployee :::"+this.newEmployee);
        return this;
    }	
}
