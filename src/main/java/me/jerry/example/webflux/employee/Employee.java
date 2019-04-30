package me.jerry.example.webflux.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private Long id;

    private String name;

    private Long salary;

}
