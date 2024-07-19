// Car.java
package za.co.protogen.model;

public class Car {
    private String id;
    private String model;
    private String manufacturer;

    // No-argument constructor
    public Car() {}

    // Parameterized constructor
    public Car(String id, String model, String manufacturer) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
    }
    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
