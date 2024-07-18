/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core.impl;

import java.util.ArrayList;
import java.util.List;
import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

/**
 *
 * @author makox
 */
public class CarServiceImpl implements CarService{
    
    
 
    @Override
    public void addCar(Car car) {
        Constant.cars.add(car);
    }

    @Override
    public void removeCar(Car car) {
        Constant.cars.remove(car);
    }

    @Override
    public Car getCarById(String vin) {
        for (Car car : Constant.cars) {
            if (car.getVin().equals(vin)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(Constant.cars);
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        List<Car> result = new ArrayList<>();
        for (Car car : Constant.cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public List<Car> getCarsByYear(int year) {
        List<Car> result = new ArrayList<>();
        for (Car car : Constant.cars) {
            if (car.getYear() == year) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> result = new ArrayList<>();
        for (Car car : Constant.cars) {
            if (car.getColor().equalsIgnoreCase(color)) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public void updateCar(Car car) {
        Car existingCar = getCarById(car.getVin());
        if (existingCar != null) {
            existingCar.setMake(car.getMake());
            existingCar.setModel(car.getModel());
            existingCar.setYear(car.getYear());
            existingCar.setColor(car.getColor());
            existingCar.setEngine(car.getEngine());
            existingCar.setTransmission(car.getTransmission());
            existingCar.setFuelType(car.getFuelType());
            existingCar.setMileage(car.getMileage());
            existingCar.setPrice(car.getPrice());
            existingCar.setOwnerId(car.getOwnerId());
            existingCar.setFeatures(car.getFeatures());
        }
    }

    @Override
    public double calculateAverageMileage() {
        if (Constant.cars.isEmpty()) {
            return 0.0;
        }
        int totalMileage = 0;
        for (Car car : Constant.cars) {
            totalMileage += car.getMileage();
        }
        return (double) totalMileage / Constant.cars.size();
    }

    @Override
    public Car findCheapestCar() {
        if (Constant.cars.isEmpty()) {
            return null;
        }
        Car cheapestCar = Constant.cars.get(0);
        for (Car car : Constant.cars) {
            if (car.getPrice() < cheapestCar.getPrice()) {
                cheapestCar = car;
            }
        }
        return cheapestCar;
    }

    @Override
    public Car findMostExpensiveCar() {
        if (Constant.cars.isEmpty()) {
            return null;
        }
        Car mostExpensiveCar = Constant.cars.get(0);
        for (Car car : Constant.cars) {
            if (car.getPrice() > mostExpensiveCar.getPrice()) {
                mostExpensiveCar = car;
            }
        }
        return mostExpensiveCar;
    }

    @Override
    public Car findNewestCar() {
        if (Constant.cars.isEmpty()) {
            return null;
        }
        Car newestCar = Constant.cars.get(0);
        for (Car car : Constant.cars) {
            if (car.getYear() > newestCar.getYear()) {
                newestCar = car;
            }
        }
        return newestCar;
    }

    @Override
    public Car findOldestCar() {
        if (Constant.cars.isEmpty()) {
            return null;
        }
        Car oldestCar = Constant.cars.get(0);
        for (Car car : Constant.cars) {
            if (car.getYear() < oldestCar.getYear()) {
                oldestCar = car;
            }
        }
        return oldestCar;
    }

    @Override
    public List<Car> searchCars(String criteria) {
        List<Car> result = new ArrayList<>();
        String lowerCaseCriteria = criteria.toLowerCase();
        for (Car car : Constant.cars) {
            if (car.getMake().toLowerCase().contains(lowerCaseCriteria) ||
                car.getModel().toLowerCase().contains(lowerCaseCriteria) ||
                String.valueOf(car.getYear()).contains(lowerCaseCriteria) ||
                car.getColor().toLowerCase().contains(lowerCaseCriteria) ||
                car.getEngine().toLowerCase().contains(lowerCaseCriteria) ||
                car.getTransmission().toLowerCase().contains(lowerCaseCriteria) ||
                car.getFuelType().toLowerCase().contains(lowerCaseCriteria) ||
                String.valueOf(car.getMileage()).contains(lowerCaseCriteria) ||
                car.getVin().toLowerCase().contains(lowerCaseCriteria) ||
                String.valueOf(car.getPrice()).contains(lowerCaseCriteria) ||
                String.valueOf(car.getOwnerId()).contains(lowerCaseCriteria) ||
                car.getFeatures().stream().anyMatch(feature -> feature.toLowerCase().contains(lowerCaseCriteria))) {
                result.add(car);
            }
        }
        return result;
    }


    
}
