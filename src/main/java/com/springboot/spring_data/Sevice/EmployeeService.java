package com.springboot.spring_data.Sevice;

import com.springboot.spring_data.Entity.ApiRespone.ApiResponse;
import com.springboot.spring_data.Entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    ResponseEntity<ApiResponse<EmployeeEntity>> createEmpl(EmployeeEntity employee);


}
