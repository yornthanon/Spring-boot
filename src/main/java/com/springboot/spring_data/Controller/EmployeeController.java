package com.springboot.spring_data.Controller;

import com.springboot.spring_data.Entity.ApiRespone.ApiResponse;
import com.springboot.spring_data.Entity.EmployeeEntity;
//import com.springboot.spring_data.Sevice.EmployeeService;
import com.springboot.spring_data.Sevice.Implement.EmployeeImplement;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    //Constructor Injection
   private final EmployeeImplement employeeImplement;

    public EmployeeController(EmployeeImplement employeeImplement) {
        this.employeeImplement = employeeImplement;
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse<EmployeeEntity>> PostData(
            @RequestBody
            EmployeeEntity employee) {
        return employeeImplement.createEmpl(employee);
    }
    @GetMapping("getall")

    public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAllData(){
        return employeeImplement.getAllEmpl();

    }
}
