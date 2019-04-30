package me.jerry.example.webflux.employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<Employee> save(Employee e);

    Mono<Employee> findById(Long id);

    Flux<Employee> findByName(String name);

    Flux<Employee> findAll();

    Mono<Void> delete(Long id);

}
