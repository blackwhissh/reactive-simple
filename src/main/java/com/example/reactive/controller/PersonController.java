package com.example.reactive.controller;

import com.example.reactive.entity.Person;
import com.example.reactive.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Flux<Person> getAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Person> findById(@PathVariable(name = "id") Integer id){
        return personRepository.findById(id);
    }
    @PostMapping
    public Mono<Person> save(@RequestBody Person person){
        return personRepository.save(person);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable(name = "id") Integer id){
        return personRepository.deleteById(id);
    }
}
