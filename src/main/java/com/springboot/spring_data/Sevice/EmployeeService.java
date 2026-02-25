package com.springboot.spring_data.Sevice;

import com.springboot.spring_data.Entity.ApiRespone.ApiResponse;
import com.springboot.spring_data.Entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    ResponseEntity<ApiResponse<EmployeeEntity>> createEmpl(EmployeeEntity employee);
    ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAllEmpl();


}
