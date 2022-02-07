package com.br.tavar3slucas.citiesapi.staties;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staties")
public class StateResource {

    private final StateRepository repository;

    public StateResource(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<State> staties(Pageable page){
        return repository.findAll(page);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity findById(@PathVariable Long id){
//        Optional<State> optional = repository.findById(id);
//
//        if (optional.isPresent()) {
//            return ResponseEntity.ok().body(optional.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }

    @GetMapping("/{id}")
   public ResponseEntity findById (@PathVariable long id) {
        Optional<State> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else  return ResponseEntity.notFound().build();

    }
}
