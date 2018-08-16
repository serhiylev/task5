import java.util.Objects;
import java.util.function.Function;

class Car implements Comparable<Car> {
    private final String brand;//марка
    private final Helm helm = new Helm();
    private final Body body = new Body();
    private final Wheel wheel = new Wheel();

    public String getBrand() {
        return brand;
    }

    Car(String brand, boolean hasButtons, String bodyColor, int diameter, String type) {
        this.brand = brand;
        wheel.setType(type);
        helm.setHasButtons(hasButtons);
        body.setBodyColor(bodyColor);
        wheel.setDiameter(diameter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) &&
                Objects.equals(helm, car.helm) &&
                Objects.equals(body, car.body) &&
                Objects.equals(wheel, car.wheel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, helm, body, wheel);
    }

    void changeDiameterWheel(int diameter) {
        wheel.changeDiameter(diameter);
    }

    String  getTypeWheel() { return wheel.getType();}

    void setTypeWheel(String type) {
        wheel.setType(type);
    }

    void changeHelm() {
        helm.change();
    }

    public boolean getHelmHasButtons() {
        return helm.getHasButtons();
    }

    public String getBodyColor() {
        return body.getBodyColor();
    }

    public int getDiameterWheel() {
        return wheel.getDiameter();
    }

    String showCar(Function<Car, String> function) {
        return function.apply(this);
    }

    @Override
    public int compareTo(Car o) {
        return this.getDiameterWheel() - o.getDiameterWheel();
    }
}
