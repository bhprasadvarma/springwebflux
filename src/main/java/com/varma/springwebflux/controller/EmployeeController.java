/**
 * 
 */
package com.varma.springwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varma.springwebflux.entity.Employee;
import com.varma.springwebflux.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author user
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/employees") /*localhost:8899/employees*/
	public Flux<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping("/employees/{employeeId}") /*localhost:8899/employees/1*/
	public Mono<ResponseEntity<Employee>> getEmployee(@PathVariable Integer employeeId){
		return employeeService.getEmployeeById(employeeId)
				.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}	
	
	@RequestMapping(method=RequestMethod.POST, value="/employees") /*localhost:8899/employees*/
    public Mono<Employee> createEmployee(@RequestBody Mono<Employee> employeeMono){
        return employeeMono.flatMap(this.employeeService::createEmployee);
    }
	
    @RequestMapping(method=RequestMethod.PUT, value="/employees/{employeeId}") /*localhost:8899/employees/2*/
    public Mono<Employee> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee){
        return this.employeeService.updateEmployee(employeeId, employee);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/employees/{employeeId}") /*localhost:8899/employees/3*/
    public Mono<Void> deleteEmployee(@PathVariable int employeeId){
    	System.out.println(">>>>>>>>>>>Delete Employee:::"+employeeId+">>>>>>>>>>>>>>>>>");
        return this.employeeService.deleteEmployee(employeeId);
    }	
}
