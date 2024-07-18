/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.core;

import java.util.List;
import za.co.protogen.domain.Reservation;

/**
 *
 * @author makox
 */
public interface ReservationService {
    
   
    void addReservation(Reservation reservation);
    void removeReservation(Long id);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
    void updateReservation(Reservation reservation);
    List<Reservation> searchReservations(String pickUpLocation, String dropoffLocation);


    
}
