package me.jerry.example.webflux.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // @RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
    @PostMapping(value = {"/create", "/"})
//    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
//    public void create(@RequestBody Employee e) {
//        employeeService.create(e).subscribe();
//    }
    public Mono<Employee> create(@RequestBody Employee e) {
        return employeeService.save(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Long id) {
        Mono<Employee> e = employeeService.findById(id);
        HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(e, status);
    }

    @GetMapping(value = "/name/{name}")
    @ResponseBody
    public Flux<Employee> findByName(@PathVariable("name") String name) {
        return employeeService.findByName(name);
    }

    // @RequestMapping(method = RequestMethod.GET) // , produces = MediaType.TEXT_EVENT_STREAM_VALUE
    @GetMapping
    @ResponseBody
    public Flux<Employee> findAll() {
        Flux<Employee> emps = employeeService.findAll();
        return emps;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> update(@RequestBody Employee e) {
        return employeeService.save(e);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        employeeService.delete(id).subscribe();
    }

}
