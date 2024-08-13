package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.adapter.Mappers;
import za.co.protogen.persistence.Car;
import za.co.protogen.util.Constants;

import java.util.Collection;
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
    public Car getCarById(@PathVariable Long id) {
        return (Car) Constants.cars.get(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        Long id = Long.valueOf(UUID.randomUUID().toString());
        car.setId(id);
        Constants.cars.put(String.valueOf(id), car);
        return car;
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        Constants.cars.put(String.valueOf(id), car);
        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        Constants.cars.remove(id);
    }
}
