import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    void start(List<Car> cars) {
        System.out.println("Введіть число від 1 до 6 \n" +
                "1) Знайти машини, які мають введений діаметр коліс.\n" +
                "2) Знайти машини, які мають введений діаметр коліс та колір кузова.\n" +
                "3) Замінити в усіх машинах, які мають червоний колір кузова, кермо на інше.\n" +
                "4) Збільшити діаметр коліс вдвічі, якщо кермо має кнопочки.\n" +
                "5) Замінити усі машини, які мають колеса діаметром менші за введене значення, на інші машини.\n" +
                "6) Завершити виконання програми");
        scan(cars);
    }

    private void scan(List<Car> cars) {

        switch (scanner.nextInt()) {
            case 1:
                show(searchCarWithWheelDiameter(cars));
                returnBackToMenu(cars);
                break;
            case 2:
                show(searchCarWithWheelDiameterAndBodyColor(cars));
                returnBackToMenu(cars);
                break;
            case 3:
                show(searchCarWithRedBodyColorAndChangeHelm(cars));
                returnBackToMenu(cars);
                break;
            case 4:
                show(changeWheelDiameter(cars));
                returnBackToMenu(cars);
                break;
            case 5:
                //Замінити усі машини, які мають колеса діаметром менші за введене значення, на інші машини(на машини з рандомним діаметром коліс).
                show(changeCars(scanDiameter(),cars));
                returnBackToMenu(cars);
                break;
            case 6:

                break;
            default:
                System.out.println("Неправильний ввід спробуйте ще раз");
                start(cars);
                break;
        }
    }

    private int scanDiameter() {
        System.out.println("Введіть діаметр\n");
        return scanner.nextInt();
    }

    private List<Car> changeCars(int diameter,List<Car> cars) {
        for (Car car : cars) {
            if (car.getDiameterWheel() < diameter) {
                car.changeDiameterWheel(1 + random.nextInt(50));
            }
        }
        return cars;
    }

    private void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    private void returnBackToMenu(List<Car> cars) {
        System.out.println("Повернутись у попереднє меню?\n(так/ні)\n");
        switch (scanner.next()) {
            case "так":
                start(cars);
                break;
            case "ні":

                break;
            default:
                System.out.println("Неправильний ввід\n");
                returnBackToMenu(cars);
        }
    }

    private List<Car> searchCarWithWheelDiameter(List<Car> cars) {
        List<Car> sortCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDiameterWheel() != 0) {
                sortCars.add(car);
            }
        }

        return sortCars;
    }

    private List<Car> searchCarWithWheelDiameterAndBodyColor(List<Car> cars) {
        for (int i = 0; i < searchCarWithWheelDiameter(cars).size(); i++) {
            if (cars.get(i).getBodyColor() != null) {
                searchCarWithWheelDiameter(cars).remove(i);
            }
        }
        return searchCarWithWheelDiameter(cars);
    }

    private List<Car> searchCarWithRedBodyColorAndChangeHelm(List<Car> cars) {
        List<Car> sortCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBodyColor().equals("червоний")) {
                car.changeHelm();
            }
        }
        return cars;
    }

    private List<Car> changeWheelDiameter(List<Car> cars) {
        for (Car car : cars) {
            if (car.getHelmHasButtons()) {
                car.changeDiameterWheel(car.getDiameterWheel() * 2);
            }
        }
        return cars;
    }

}
