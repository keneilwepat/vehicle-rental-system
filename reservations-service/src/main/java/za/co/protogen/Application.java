/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen;

import java.time.LocalDate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;

/**
 *
 * @author makox
 */
public class Application {
    
    
   
    public static void main(String[] args) {
        ReservationService reservationService = new ReservationServiceImpl();

        // Add a new reservation
        Reservation newReservation = new Reservation();
        newReservation.setId(3L);
        newReservation.setUserId(3L);
        newReservation.setCarId(3L);
        newReservation.setFromDate(LocalDate.of(2023, 6, 20));
        newReservation.setToDate(LocalDate.of(2023, 6, 25));
        newReservation.setPickUpLocation("San Francisco");
        newReservation.setDropoffLocation("San Diego");
        reservationService.addReservation(newReservation);

        // Get all reservations
        System.out.println("All Reservations:");
        for (Reservation reservation : reservationService.getAllReservations()) {
            System.out.println(reservation);
        }

        // Retrieve a reservation by ID
        Reservation retrievedReservation = reservationService.getReservationById(1L);
        System.out.println("Retrieved Reservation: " + retrievedReservation);

        // Update a reservation
        retrievedReservation.setDropoffLocation("New Location");
        reservationService.updateReservation(retrievedReservation);
        System.out.println("Updated Reservation: " + reservationService.getReservationById(1L));

        // Search reservations
        System.out.println("Search Results:");
        for (Reservation reservation : reservationService.searchReservations("London", "Paris")) {
            System.out.println(reservation);
        }

        // Remove a reservation
        reservationService.removeReservation(2L);
        System.out.println("Remaining Reservations:");
        for (Reservation reservation : reservationService.getAllReservations()) {
            System.out.println(reservation);
        }
    }


    
}
