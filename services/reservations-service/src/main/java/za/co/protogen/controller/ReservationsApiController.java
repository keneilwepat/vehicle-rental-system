package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.adapter.Mappers;
import za.co.protogen.model.Reservation;
import za.co.protogen.model.Car;
import za.co.protogen.model.User;
import za.co.protogen.util.Constants;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationsApiController {

    @Autowired
    private Mappers mappers;

    @Autowired
    private RestTemplate restTemplate;

    private final String CARS_SERVICE_URL = "http://localhost:9102/cars/";
    private final String USERS_SERVICE_URL = "http://localhost:9101/users/";

    @GetMapping
    public Collection<Reservation> getReservations() {
        return mappers.mapToReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable String id) {
        return (Reservation) Constants.reservations.get(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        // Verify carId
        Car car = restTemplate.getForObject(CARS_SERVICE_URL + reservation.getCarId(), Car.class);
        if (car == null) {
            throw new RuntimeException("Invalid carId: " + reservation.getCarId());
        }

        // Verify userId
        User user = restTemplate.getForObject(USERS_SERVICE_URL + reservation.getUserId(), User.class);
        if (user == null) {
            throw new RuntimeException("Invalid userId: " + reservation.getUserId());
        }

        String id = UUID.randomUUID().toString();
        reservation.setId(id);
        Constants.reservations.put(id, reservation);
        return reservation;
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable String id, @RequestBody Reservation reservation) {
        // Verify carId
        Car car = restTemplate.getForObject(CARS_SERVICE_URL + reservation.getCarId(), Car.class);
        if (car == null) {
            throw new RuntimeException("Invalid carId: " + reservation.getCarId());
        }

        // Verify userId
        User user = restTemplate.getForObject(USERS_SERVICE_URL + reservation.getUserId(), User.class);
        if (user == null) {
            throw new RuntimeException("Invalid userId: " + reservation.getUserId());
        }

        reservation.setId(id);
        Constants.reservations.put(id, reservation);
        return reservation;
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable String id) {
        Constants.reservations.remove(id);
    }
}
