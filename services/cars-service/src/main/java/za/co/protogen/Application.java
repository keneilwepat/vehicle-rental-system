/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen;

import java.util.ArrayList;
import java.util.List;
import za.co.protogen.core.CarService;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;

/**
 *
 * @author makox
 */
public class Application {
       
   
    public static void main(String[] args) {
        
        
        CarService carService = new CarServiceImpl();

        // Create and add cars
        Car car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Corolla");
        car1.setYear(2021);
        car1.setColor("White");
        car1.setEngine("1.8L");
        car1.setTransmission("Automatic");
        car1.setFuelType("Gasoline");
        car1.setMileage(10000);
        car1.setVin("ABC123");
        car1.setPrice(25000);
        car1.setOwnerId(123);
        car1.setFeatures(new ArrayList<>());
        carService.addCar(car1);

        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear(2020);
        car2.setColor("Red");
        car2.setEngine("1.5L");
        car2.setTransmission("CVT");
        car2.setFuelType("Gasoline");
        car2.setMileage(15000);
        car2.setVin("XYZ789");
        car2.setPrice(22000);
        car2.setOwnerId(456);
        car2.setFeatures(new ArrayList<>());
        carService.addCar(car2);

        // Retrieve and print all cars
        List<Car> allCars = carService.getAllCars();
        System.out.println("All Cars:");
        for (Car car : allCars) {
            System.out.println(car);
        }

        // Get a car by ID
        Car retrievedCar = carService.getCarById("ABC123");
        System.out.println("Retrieved Car: " + retrievedCar);

        // Update a car
        car1.setColor("Black");
        carService.updateCar(car1);
        System.out.println("Updated Car: " + carService.getCarById("ABC123"));

        // Calculate average mileage
        double averageMileage = carService.calculateAverageMileage();
        System.out.println("Average Mileage: " + averageMileage);

        // Find the cheapest car
        Car cheapestCar = carService.findCheapestCar();
        System.out.println("Cheapest Car: " + cheapestCar);

        // Find the most expensive car
        Car mostExpensiveCar = carService.findMostExpensiveCar();
        System.out.println("Most Expensive Car: " + mostExpensiveCar);

        // Find the newest car
        Car newestCar = carService.findNewestCar();
        System.out.println("Newest Car: " + newestCar);

        // Find the oldest car
        Car oldestCar = carService.findOldestCar();
        System.out.println("Oldest Car: " + oldestCar);

        // Search cars by criteria
        List<Car> searchResults = carService.searchCars("Toyota");
        System.out.println("Search Results:");
        for (Car car : searchResults) {
            System.out.println(car);
        }

        // Remove a car
        carService.removeCar(car1);
        System.out.println("Car removed. Remaining cars:");
        for (Car car : carService.getAllCars()) {
            System.out.println(car);
        }
    }


    
}
