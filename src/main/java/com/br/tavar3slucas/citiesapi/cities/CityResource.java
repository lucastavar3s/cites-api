package com.br.tavar3slucas.citiesapi.cities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

   private CityRepository repository;

    public CityResource(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> findByAll(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<City> findById(@PathVariable long id) {
        Optional<City> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}