package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.adapter.Mappers;
import za.co.protogen.model.Car;
import za.co.protogen.util.Constants;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarsApiController {

    @Autowired
    private Mappers mappers;

    @GetMapping
    public Collection<Car> getCars() {
        return mappers.mapToCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id) {
        return (Car) Constants.cars.get(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        String id = UUID.randomUUID().toString();
        car.setId(id);
        Constants.cars.put(id, car);
        return car;
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable String id, @RequestBody Car car) {
        car.setId(id);
        Constants.cars.put(id, car);
        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) {
        Constants.cars.remove(id);
    }
}
