package com.springboot.spring_data.Entity.ApiRespone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//Class Declaration
//<T> Generic type
public class ApiResponse<T> {
    private String message;
    private Integer status;
    private T employee;
}
