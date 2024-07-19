package za.co.protogen.model;

public class Reservation {
    private String id;
    private String userId;
    private String carId;
    private String date;

    // No-argument constructor
    public Reservation() {}

    // Parameterized constructor
    public Reservation(String id, String userId, String carId, String date) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.date = date;
    }
    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
