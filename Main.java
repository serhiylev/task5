import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Set<Car> carSet = new LinkedHashSet<>();
        Logic logic = new Logic(cars,carSet);
        logic.getCars();
        logic.start();
    }
}
