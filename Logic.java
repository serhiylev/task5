import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private List<Car> cars;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    Logic(List<Car> cars) {
        this.cars = cars;
    }

    void start() {
        add();
        System.out.println("Введіть число від 1 до 6 \n" +
                "1) Знайти машини, які мають введений діаметр коліс.\n" +
                "2) Знайти машини, які мають введений діаметр коліс та колір кузова.\n" +
                "3) Замінити в усіх машинах, які мають червоний колір кузова, кермо на інше.\n" +
                "4) Збільшити діаметр коліс вдвічі, якщо кермо має кнопочки.\n" +
                "5) Замінити усі машини, які мають колеса діаметром менші за введене значення, на інші машини.\n" +
                "6) Завершити виконання програми");
        scan();
    }

    private void scan() {

        switch (scanner.nextInt()) {
            case 1:
                show(searchCarWithWheelDiameter());
                returnBackToMenu();
                break;
            case 2:
                show(searchCarWithWheelDiameterAndBodyColor());
                returnBackToMenu();
                break;
            case 3:
                show(searchCarWithRedBodyColorAndChangeHelm());
                returnBackToMenu();
                break;
            case 4:
                show(changeWheelDiameter());
                returnBackToMenu();
                break;
            case 5:
                //Замінити усі машини, які мають колеса діаметром менші за введене значення, на інші машини(на машини з рандомним діаметром коліс).
                show(changeCars(scanDiameter()));
                returnBackToMenu();
                break;
            case 6:

                break;
            default:
                System.out.println("Неправильний ввід спробуйте ще раз");
                start();
                break;
        }
    }

    private void add() {
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
    }

    private void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    private int scanDiameter() {
        System.out.println("Введіть діаметр\n");
        return scanner.nextInt();
    }

    private void returnBackToMenu() {
        System.out.println("Повернутись у попереднє меню?\n(так/ні)\n");
        switch (scanner.next()) {
            case "так":
                start();
                break;
            case "ні":

                break;
            default:
                System.out.println("Неправильний ввід\n");
                returnBackToMenu();
        }
    }

    private List<Car> changeCars(int diameter) {
        for (Car car : cars) {
            if (car.getDiameterWheel() < diameter) {
                car.changeDiameterWheel(1 + random.nextInt(50));
            }
        }
        return cars;
    }

    private List<Car> searchCarWithWheelDiameter() {
        List<Car> sortCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDiameterWheel() != 0) {
                sortCars.add(car);
            }
        }

        return sortCars;
    }

    private List<Car> searchCarWithWheelDiameterAndBodyColor() {
        for (int i = 0; i < searchCarWithWheelDiameter().size(); i++) {
            if (cars.get(i).getBodyColor() != null) {
                searchCarWithWheelDiameter().remove(i);
            }
        }
        return searchCarWithWheelDiameter();
    }

    private List<Car> searchCarWithRedBodyColorAndChangeHelm() {
        List<Car> sortCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBodyColor().equals("червоний")) {
                car.changeHelm();
            }
        }
        return cars;
    }

    private List<Car> changeWheelDiameter() {
        for (Car car : cars) {
            if (car.getHelmHasButtons()) {
                car.changeDiameterWheel(car.getDiameterWheel() * 2);
            }
        }
        return cars;
    }
}
