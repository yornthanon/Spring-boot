package com.springboot.spring_data.Sevice.Implement;

import com.springboot.spring_data.Entity.ApiRespone.ApiResponse;
import com.springboot.spring_data.Entity.EmployeeEntity;
import com.springboot.spring_data.Repository.EmployeeRepository;
import com.springboot.spring_data.Sevice.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeImplement  implements EmployeeService {
    // constructor Injection
    private final EmployeeRepository repository;
    public EmployeeImplement(EmployeeRepository repository){
        this.repository=repository;
    }

    @Override
    public ResponseEntity<ApiResponse<EmployeeEntity>> createEmpl(EmployeeEntity employee) {
        // 1.check name is not Empty
        if (employee.getName()==null || employee.getName().trim().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ApiResponse<>(
                            "Name Cannot is Empty",
                            HttpStatus.BAD_REQUEST.value(),
                            null
                    )
            );
        }
        //2.check email is not Empty
        if (employee.getEmail()==null || employee.getEmail().trim().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ApiResponse<>(
                            "Email is not Empty ",
                            HttpStatus.BAD_REQUEST.value(),
                            null
                    )
            );
        }
        //3.check Email format Manually
        String emailFormat = "A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        if (!employee.getEmail().matches(emailFormat)){
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(
                            "Email must be valid format" ,
                            HttpStatus.BAD_REQUEST.value(),
                            null
                    )
            );

        }
        // 4.check email is Dubplicate
        boolean existSEmail = repository.existsAllByEmail(employee.getEmail());
        if (existSEmail) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ApiResponse<>(
                            "Email's Already Exists",
                            HttpStatus.CONFLICT.value(),
                            null

                    )

            );

        }
        EmployeeEntity saveEmp = repository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(
                        "Employee's Create Successfully ",
                        HttpStatus.CREATED.value(),
                        saveEmp
                )
        );




    }
}
