package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos = new HashMap<>();

    @PostMapping
    public Kangaroo saveKangaroo(@RequestBody Kangaroo kangaroo) {
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @GetMapping
    public Collection<Kangaroo> findAllKangaroos() {
        return kangaroos.values();
    }

    @GetMapping("/{id}")
    public Kangaroo findKangarooById(@PathVariable int id) {
        return kangaroos.get(id);
    }

    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable int id, @RequestBody Kangaroo kangaroo) {
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public void deleteKangaroo(@PathVariable int id) {
        kangaroos.remove(id);
    }
}