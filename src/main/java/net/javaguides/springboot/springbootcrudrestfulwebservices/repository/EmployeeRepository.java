package net.javaguides.springboot.springbootcrudrestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springbootcrudrestfulwebservices.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long >{

}
