package com.satish.location.controller;

import com.satish.location.entities.Location;
import com.satish.location.payload.Packet;
import com.satish.location.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationRESTController {

    @Autowired
    LocationRepository repository;

    //http://localhost:8080/locationweb/location
    @PostMapping
    public ResponseEntity<?> addLocation(@RequestBody Location location) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new Packet<>(true, "Location added", repository.save(location)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Packet<>(false, "error : " + e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<?> updateLocation(@RequestBody Location location) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Packet<>(true, "Location added", repository.save(location)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Packet<>(false, "error : " + e.getMessage()));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMapping(@PathVariable("id") int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Packet<>(true, "Location removed"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Packet<>(false, "error : " + e.getMessage()));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLocation(@PathVariable("id") int id) {
        try{
            return ResponseEntity.ok(new Packet<>(true,"Location found",
                    repository.findById(id).get()));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Packet<>(false,"error : "+e.getMessage()));
        }

    }

    @GetMapping
    public ResponseEntity<?> getAllLocation() {
        System.out.println("get All location");
            return ResponseEntity.ok(new Packet<>(true,"All Location",
                    repository.findAll()));
    }

}
