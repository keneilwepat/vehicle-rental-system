/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core.impl;

import java.util.ArrayList;
import java.util.List;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

/**
 *
 * @author makox
 */
public class ReservationServiceImpl implements ReservationService{
    
   

    @Override
    public void addReservation(Reservation reservation) {
        Constant.reservations.add(reservation);
    }

    @Override
    public void removeReservation(Long id) {
        Reservation reservation = getReservationById(id);
        if (reservation != null) {
            Constant.reservations.remove(reservation);
        }
    }

    @Override
    public Reservation getReservationById(Long id) {
        for (Reservation reservation : Constant.reservations) {
            if (reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(Constant.reservations);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        Reservation existingReservation = getReservationById(reservation.getId());
        if (existingReservation != null) {
            Constant.reservations.remove(existingReservation);
            Constant.reservations.add(reservation);
        }
    }

    @Override
    public List<Reservation> searchReservations(String pickUpLocation, String dropoffLocation) {
        List<Reservation> results = new ArrayList<>();
        for (Reservation reservation : Constant.reservations) {
            if (reservation.getPickUpLocation().equalsIgnoreCase(pickUpLocation) &&
                reservation.getDropoffLocation().equalsIgnoreCase(dropoffLocation)) {
                results.add(reservation);
            }
        }
        return results;
    }


    
}
