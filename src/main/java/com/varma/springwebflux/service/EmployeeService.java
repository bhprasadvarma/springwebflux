package com.varma.springwebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varma.springwebflux.entity.Employee;
import com.varma.springwebflux.repo.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	//All Employees
	public Flux<Employee> getAllEmployees(){
		return this.employeeRepository.findAll();
	} 	
	
	//Specific Employee
	public Mono<Employee> getEmployeeById(int employeeId){
		return this.employeeRepository.findById(employeeId);
	}
	
	//Create Employee
	public Mono<Employee> createEmployee(final Employee employee){
		return this.employeeRepository.save(employee.setAsNew(true));
	}
	
	//Update Employee
	@Transactional
     public Mono<Employee> updateEmployee(final int employeeId,final Employee employee){
        return this.employeeRepository.findById(employeeId)
                    .flatMap(p -> {
                        p.setName(employee.getName());
                        p.setDesignation(employee.getDesignation());
                        return this.employeeRepository.save(p.setAsNew(false));
                    }).switchIfEmpty(this.employeeRepository.save(employee.setAsNew(true)));
						
	}
	
	//Delete Employee
	public Mono<Void> deleteEmployee(final int employeeId){
		return this.employeeRepository.deleteById(employeeId);
	}
	
}
