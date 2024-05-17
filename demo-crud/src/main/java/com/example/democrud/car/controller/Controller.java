package com.example.democrud.car.controller;

import com.example.democrud.car.Car;
import com.example.democrud.car.dao.Dao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class Controller {

    Dao dao;
    public Controller(Dao dao) {
        this.dao = dao;
    }

    @PostMapping("/save")
    public Car save(@RequestBody Car car){
        return dao.save(car);
    }
    @GetMapping("/all")
    public List<Car> findAll(){
        return dao.findAll();
    }
    @GetMapping("/by-id")
    public Car findById(@RequestParam UUID id){

        if(!dao.existsById(id)){
            return new Car();
        }
        return dao.findById(id).get();
    }

    @PutMapping("/type/by-id")
    public Car update(@RequestParam UUID id, @RequestParam Car.Type type){

        if(dao.existsById(id)){
            Car car = dao.findById(id).get();
            car.setType(type);
            return car;
        }
        return new Car();
    }

    @DeleteMapping("/by-id")
    public ResponseEntity<Optional<Car>> delete(@RequestParam UUID id){
        Optional<Car> temp = dao.findById(id);
        if(!dao.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        dao.deleteById(id);
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        dao.deleteAll();
    }

}
