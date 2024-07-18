/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.co.protogen.domain.Reservation;

/**
 *
 * @author makox
 */
public class Constant {
    
   
    public static List<Reservation> reservations = new ArrayList<>();
    static {
        // Add mock data
        Reservation reservation1 = new Reservation();
        reservation1.setId(1L);
        reservation1.setUserId(1L);
        reservation1.setCarId(1L);
        reservation1.setFromDate(LocalDate.of(2023, 6, 10));
        reservation1.setToDate(LocalDate.of(2023, 6, 15));
        reservation1.setPickUpLocation("New York");
        reservation1.setDropoffLocation("Los Angeles");
        reservations.add(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setId(2L);
        reservation2.setUserId(2L);
        reservation2.setCarId(2L);
        reservation2.setFromDate(LocalDate.of(2023, 6, 12));
        reservation2.setToDate(LocalDate.of(2023, 6, 18));
        reservation2.setPickUpLocation("London");
        reservation2.setDropoffLocation("Paris");
        reservations.add(reservation2);

        // Add more reservations as needed
    }


    
}
