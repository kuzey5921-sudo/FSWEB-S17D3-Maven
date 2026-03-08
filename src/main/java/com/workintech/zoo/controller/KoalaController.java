package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas = new HashMap<>();

    @PostMapping
    public Koala saveKoala(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @GetMapping
    public Collection<Koala> findAllKoalas() {
        return koalas.values();
    }

    @GetMapping("/{id}")
    public Koala findKoalaById(@PathVariable int id) {
        return koalas.get(id);
    }

    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable int id, @RequestBody Koala koala) {
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public void deleteKoala(@PathVariable int id) {
        koalas.remove(id);
    }
}