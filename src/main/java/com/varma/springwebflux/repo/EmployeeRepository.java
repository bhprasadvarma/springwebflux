/**
 * 
 */
package com.varma.springwebflux.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.varma.springwebflux.entity.Employee;

/**
 * @author user
 *
 */
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {

}
