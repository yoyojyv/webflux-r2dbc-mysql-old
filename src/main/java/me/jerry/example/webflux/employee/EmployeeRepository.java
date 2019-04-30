package me.jerry.example.webflux.employee;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

    // @Query("SELECT * FROM employee WHERE name = $1")
    @Query("SELECT * FROM employee WHERE name = ?")
    Flux<Employee> findByName(String name);

}
