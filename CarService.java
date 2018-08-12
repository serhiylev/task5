public class CarService {
    private String brand;
    private boolean hasButtons;
    private String bodyColor;
    private int diameter;
    private String type;


    public CarService brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarService hasButtons(boolean hasButtons) {
        this.hasButtons = hasButtons;
        return this;
    }

    public CarService bodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
        return this;
    }

    public CarService diameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public CarService type(String type) {
        this.type = type;
        return this;
    }

    public Car createCar() {
        return new Car(brand, hasButtons, bodyColor, diameter,type);
    }
}