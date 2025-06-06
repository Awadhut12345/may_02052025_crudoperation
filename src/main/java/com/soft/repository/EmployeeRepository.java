package com.soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soft.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query
	public List<Employee> findAllByOrderBySalaryDesc();
	
	@Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE 'r%'")
    List<Employee> findEmployeeStartingWithR();
	
	
}
