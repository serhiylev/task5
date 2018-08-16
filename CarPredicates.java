import java.util.function.Predicate;

class CarPredicates {
    public static Predicate<Car> carWithWheelDiameter() {
        return car -> car.getDiameterWheel() != 0;
    }

    public static Predicate<Car> carWithBodyColor() {
        return car -> car.getBodyColor() == null;
    }

    public static Predicate<Car> carWithRedBodyColor() {
        return car -> car.getBodyColor().equals("червоний");
    }

    public static Predicate<Car> hasButtons() {
        return Car::getHelmHasButtons;
    }

    public static Predicate<Car> carWithDiameterSmallerThan(int diameter) {
        return car -> car.getDiameterWheel() < diameter;
    }

    public static Predicate<Car> removeCars(int firstNumber, int secondNumber) {
        return car -> car.getDiameterWheel() >= firstNumber && car.getDiameterWheel() <= secondNumber;
    }

}
