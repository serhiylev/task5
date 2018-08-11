import java.util.ArrayList;
import java.util.List;


public class Main {
    public static List<Car> cars = new ArrayList();
    public static void main(String[] args) {
        Logic logic = new Logic();
        Car car;
        cars.add(car = new CarBuilder().BodyColor("зелений").Brand("форд").HasButtons(true).Diameter(10).createCar());
        cars.add(car = new CarBuilder().BodyColor("червоний").Brand("форд").HasButtons(false).createCar());
        cars.add(car = new CarBuilder().BodyColor("фіалетовий").Brand("форд").HasButtons(true).createCar());
        cars.add(car = new CarBuilder().BodyColor("зелений").Brand("форд").HasButtons(false).Diameter(11).createCar());
        cars.add(car = new CarBuilder().BodyColor("зелений").Brand("форд").HasButtons(true).createCar());
        cars.add(car = new CarBuilder().BodyColor("червоний").Brand("форд").HasButtons(true).Diameter(21).createCar());
        cars.add(car = new CarBuilder().BodyColor("жовтий").Brand("форд").HasButtons(false).Diameter(9).createCar());
        cars.add(car = new CarBuilder().BodyColor("червоний").Brand("форд").HasButtons(false).Diameter(18).createCar());
        cars.add(car = new CarBuilder().BodyColor("зелений").Brand("форд").HasButtons(true).Diameter(23).createCar());
        cars.add(car = new CarBuilder().BodyColor("фіолетовий").Brand("форд").HasButtons(true).Diameter(16).createCar());

        logic.start();


    }
}
