import java.util.Objects;

class Car implements Comparable<Car> {
    private String brand;//марка
    private Helm helm = new Helm();
    private Body body = new Body();
    private Wheel wheel = new Wheel();

    public Car(String brand, boolean hasButtons, String bodyColor, int diameter, String type) {
        this.brand = brand;
        wheel.setType(type);
        helm.setHasButtons(hasButtons);
        body.setBodyColor(bodyColor);
        wheel.setDiameter(diameter); ;
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

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", hasButtons=" + helm.getHasButtons() +
                ", bodyColor='" + body.getBodyColor() + '\'' +
                ", diameter=" + wheel.getDiameter() +
                ", typeWheel=" + wheel.getType() +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.getDiameterWheel() - o.getDiameterWheel();
    }
}
