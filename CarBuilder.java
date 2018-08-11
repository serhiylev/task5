public class CarBuilder {
    private String brand;
    private boolean hasButtons;
    private String bodyColor;
    private int diameter;

    public CarBuilder Brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder HasButtons(boolean hasButtons) {
        this.hasButtons = hasButtons;
        return this;
    }

    public CarBuilder BodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
        return this;
    }

    public CarBuilder Diameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public Car createCar() {
        return new Car(brand, hasButtons, bodyColor, diameter);
    }
}