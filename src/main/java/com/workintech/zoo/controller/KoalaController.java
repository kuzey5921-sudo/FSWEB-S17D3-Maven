package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    @GetMapping
    public Collection<Koala> getAll() {
        return koalas.values();
    }

    @GetMapping("/{id}")
    public Koala getById(@PathVariable int id) {

        Koala koala = koalas.get(id);

        if (koala == null) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }

        return koala;
    }

    @PostMapping
    public Koala add(@RequestBody Koala koala) {

        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala) {

        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }

        koala.setId(id);
        koalas.put(id, koala);

        return koala;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {

        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }

        koalas.remove(id);
        return "Deleted";
    }
}