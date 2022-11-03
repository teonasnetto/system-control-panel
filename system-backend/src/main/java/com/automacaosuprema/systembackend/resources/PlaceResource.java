package com.automacaosuprema.systembackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automacaosuprema.systembackend.entities.Place;
import com.automacaosuprema.systembackend.repositories.PlaceRepositorie;

@RestController
@RequestMapping(value = "/places")
public class PlaceResource {

    @Autowired
    private PlaceRepositorie placeRepositorie;

    @GetMapping
    public ResponseEntity<List<Place>> findAll() {
        List<Place> list = (List<Place>) placeRepositorie.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Place> findById(@PathVariable Long id) {
        Place obj = placeRepositorie.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Place> insert(@RequestBody Place obj) {
        obj = placeRepositorie.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Place> update(@PathVariable Long id, @RequestBody Place obj) {
        Place newPlace = placeRepositorie.findById(id).map(record -> {
            record.setPlaceName(obj.getPlaceName());
            return placeRepositorie.save(record);
        }).orElse(null);
        return ResponseEntity.ok().body(newPlace);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        placeRepositorie.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
