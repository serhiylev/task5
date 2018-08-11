import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    void start() {
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
                shov(searchCarWithWheelDiameter());
                returnBackToMenu();
                break;
            case 2:
                shov(searchCarWithWheelDiameterAndBodyColor());
                returnBackToMenu();
                break;
            case 3:
                shov(searchCarWithRedBodyColorAndChangeHelm());
                returnBackToMenu();
                break;
            case 4:
                shov(changeWheelDiameter());
                returnBackToMenu();
                break;
            case 5:
                //Замінити усі машини, які мають колеса діаметром менші за введене значення, на інші машини(на машини з рандомним діаметром коліс).
                shov(changeCars(scanDiameter()));
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

    private int scanDiameter() {
        System.out.println("Введіть діаметр\n");
        return scanner.nextInt();
    }

    private List<Car> changeCars(int diameter) {
        for (Car car : Main.cars) {
            if (car.getDiameterWheel() < diameter) {
                car.changeDiameterWheel(1 + random.nextInt(50));
            }
        }
        return Main.cars;
    }

    private void shov(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
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

    private List<Car> searchCarWithWheelDiameter() {
        List<Car> sortCars = new ArrayList<>();
        for (int i = 0; i < Main.cars.size(); i++) {
            if (Main.cars.get(i).getDiameterWheel() != 0) {
                sortCars.add(Main.cars.get(i));
            }
        }

        return sortCars;
    }

    private List<Car> searchCarWithWheelDiameterAndBodyColor() {
        for (int i = 0; i < searchCarWithWheelDiameter().size(); i++) {
            if (Main.cars.get(i).getBodyColor() != null) {
                searchCarWithWheelDiameter().remove(i);
            }
        }
        return searchCarWithWheelDiameter();
    }

    private List<Car> searchCarWithRedBodyColorAndChangeHelm() {
        List<Car> sortCars = new ArrayList<>();
        for (int i = 0; i < Main.cars.size(); i++) {
            if (Main.cars.get(i).getBodyColor() == "червоний") {
                Main.cars.get(i).changeHelm();
            }
        }
        return Main.cars;
    }

    private List<Car> changeWheelDiameter() {
        for (int i = 0; i < Main.cars.size(); i++) {
            if (Main.cars.get(i).getHelmHasButtons()) {
                Main.cars.get(i).changeDiameterWheel(Main.cars.get(i).getDiameterWheel() * 2);
            }
        }
        return Main.cars;
    }

}
