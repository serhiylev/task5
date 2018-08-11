import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Logic logic = new Logic(cars);
        logic.start();
    }
}
