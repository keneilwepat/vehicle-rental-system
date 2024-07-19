package za.co.protogen.adapter;

import org.springframework.stereotype.Component;
import za.co.protogen.model.Reservation;
import za.co.protogen.util.Constants;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mappers {

    public Reservation mapToReservation(String id, String userId, String carId, String date) {
        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setUserId(userId);
        reservation.setCarId(carId);
        reservation.setDate(date);
        return reservation;
    }

    public List<Reservation> mapToReservations() {
        List<Reservation> reservations = new ArrayList<>();
        for (Object value : Constants.reservations.values()) {
            reservations.add((Reservation) value);
        }
        return reservations;
    }
}
