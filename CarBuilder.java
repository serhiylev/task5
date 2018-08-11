public class CarBuilder {
    private String brand;
    private boolean hasButtons;
    private String bodyColor;
    private int diameter;

    public CarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder hasButtons(boolean hasButtons) {
        this.hasButtons = hasButtons;
        return this;
    }

    public CarBuilder bodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
        return this;
    }

    public CarBuilder diameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public Car createCar() {
        return new Car(brand, hasButtons, bodyColor, diameter);
    }
}