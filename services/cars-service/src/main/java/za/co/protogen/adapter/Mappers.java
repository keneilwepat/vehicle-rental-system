package za.co.protogen.adapter;

import org.springframework.stereotype.Component;
import za.co.protogen.persistence.Car;
import za.co.protogen.util.Constants;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mappers {

    public Car mapToCar(Long id, String model, String manufacturer) {
        Car car = new Car();
        car.setId(id);
        car.setModel(model);
        car.setManufacturer(manufacturer);
        return car;
    }

    public List<Car> mapToCars() {
        List<Car> cars = new ArrayList<>();
        for (Object value : Constants.cars.values()) {
            cars.add((Car) value);
        }
        return cars;
    }
}
