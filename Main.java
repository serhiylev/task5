import java.util.ArrayList;
import java.util.List;


public class Main {
    private static List<Car> cars = new ArrayList<>();
    public static void main(String[] args) {
        Logic logic = new Logic();
        cars.add(new CarBuilder().bodyColor("зелений").brand("форд").hasButtons(true).diameter(10).createCar());
        cars.add(new CarBuilder().bodyColor("червоний").brand("форд").hasButtons(false).createCar());
        cars.add(new CarBuilder().bodyColor("фіалетовий").brand("форд").hasButtons(true).createCar());
        cars.add(new CarBuilder().bodyColor("зелений").brand("форд").hasButtons(false).diameter(11).createCar());
        cars.add(new CarBuilder().bodyColor("зелений").brand("форд").hasButtons(true).createCar());
        cars.add(new CarBuilder().bodyColor("червоний").brand("форд").hasButtons(true).diameter(21).createCar());
        cars.add(new CarBuilder().bodyColor("жовтий").brand("форд").hasButtons(false).diameter(9).createCar());
        cars.add(new CarBuilder().bodyColor("червоний").brand("форд").hasButtons(false).diameter(18).createCar());
        cars.add(new CarBuilder().bodyColor("зелений").brand("форд").hasButtons(true).diameter(23).createCar());
        cars.add(new CarBuilder().bodyColor("фіолетовий").brand("форд").hasButtons(true).diameter(16).createCar());

        logic.start(cars);


    }
}
