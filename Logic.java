import java.util.*;

class Logic {
    private final List<Car> cars;
    private final LinkedHashSet<Car> carSet;
    private final LinkedHashSet<Car> sortCarSet = new LinkedHashSet<>();
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    Logic(List<Car> cars, Set<Car> carSet) {
        this.cars = cars;
        this.carSet = (LinkedHashSet<Car>) carSet;
    }

    void start() {
        getCars();
        System.out.println("Введіть число від 1 до 6 \n" +
                "1) Знайти машини, які мають введений діаметр коліс.\n" +
                "2) Знайти машини, які мають введений діаметр коліс та колір кузова.\n" +
                "3) Замінити в усіх машинах, які мають червоний колір кузова, кермо на інше.\n" +
                "4) Збільшити діаметр коліс вдвічі, якщо кермо має кнопочки.\n" +
                "5) Замінити усі машини, які мають колеса діаметром менші за введене значення, на інші машини.\n" +
                "6) Перейти до нової весії програми\n" +
                "7) Завершити виконання програми");
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
                newVersionStart();
                break;
            case 7:

                break;
            default:
                System.out.println("Неправильний ввід спробуйте ще раз\n");
                start();
                break;
        }
    }

    private void newVersionStart() {
        System.out.println("Введіть число від 1 до 5\n" +
                "1) Машинам, які мають вказаний колір кузова та вказаний діаметр колеса, змінити тип шин на вказаний.\n" +
                "2) Видалити машини, діаметр колес яких попадає у вказаний діапазон.\n" +
                "3) Знайти машини, які мають вказаний тип шин та діаметр коліс яких попадає у вказаний діапазон\n" +
                "4) Повернутись до попереднього меню\n" +
                "5) Завершити виконання програми");
        newVersionScan();
    }

    private void newVersionScan() {
        switch (scanner.nextInt()) {
            case 1:
                colorAndDiameterNew();
                newShow(carSet);
                returnBackToMenuNew();
                break;
            case 2:
                System.out.println("Вкажіть діапазон діаметрів коліс \n(менше --> БІЛЬШЕ)\n");
                removeRangeOfDiametersNew();
                newShow(carSet);
                returnBackToMenuNew();
                break;
            case 3:
                checkTypeWheel();
                newShow(sortCarSet);
                returnBackToMenuNew();
                break;
            case 4:
                start();
                break;
            case 5:

                break;
            default:
                System.out.println("Неправильний ввід, спробуйте ще раз\n");
                newVersionStart();
                break;
        }
    }

    private void colorAndDiameterNew() {
        System.out.println("Введіть колір кузова\n(зелений/червоний/жовтий/фіолетовий)\n");
        String color = scanner.next();
        if (color.equals("зелений") || color.equals("червоний") || color.equals("жовтий") || color.equals("фіолетовий")) {
            System.out.println("Введіть діаметр колеса\n");
            int diameter = scanner.nextInt();
            System.out.println("Вкажіть новий тип шити \n(літня/зимова/всесезонна)\n");
            String type = newType();
            for (Car car : cars) {
                if (car.getBodyColor().equals(color)) {
                    if (car.getDiameterWheel() == diameter) {
                        car.setTypeWheel(type);
                    }
                }
            }
        } else {
            System.out.println("Такого кольору немає, бажаєте спробувати ще раз?\n(так/ні)");
            tryAgain(2);//будь-яке число не рівне 1
        }

    }

    private String newType() {
        String type = scanner.next();
        if (type.equals("літня") || type.equals("зимова") || type.equals("всесезонна")) {
            return type;
        } else {
            System.out.println("Спробуйте ще раз");
            return newType();//TODO не факт що робочий рядок :)
        }
    }

    private void checkTypeWheel() {
        System.out.println("Введіть тип шини\n(літня/зимова/всесезонна)\n");
        String type = scanner.next();
        if (type.equals("літня") || type.equals("зимова") || type.equals("всесезонна")) {
            System.out.println("Вкажіть діапазон діаметрів коліс \n(менше --> БІЛЬШЕ)\n");
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();
            if (firstNumber > secondNumber) {
                System.out.println("Ну ок, цей варіант також врахований :)");
                int i = firstNumber;
                firstNumber = secondNumber;
                secondNumber = i;
            }
            for (Car car : carSet) {
                if (car.getTypeWheel().equals(type)) {
                    if (car.getDiameterWheel() >= firstNumber && car.getDiameterWheel() <= secondNumber) {
                        sortCarSet.add(car);
                    }
                }
            }

        } else {
            System.out.println("Такого типу немає, бажаєте спробувати ще раз?\n(так/ні)");
            tryAgain(1);
        }
    }

    private void tryAgain(int variant) {
        switch (scanner.next()) {
            case "так":
                if (variant == 1) {
                    checkTypeWheel();
                } else {
                    colorAndDiameterNew();
                }
                break;
            case "ні":

                break;
            default:
                System.out.println("Неправильний ввід спробуйте ще раз\n");
                tryAgain(variant);
                break;
        }
    }

    private void newShow(Set<Car> carSet) {
        for (Car car : carSet) {
            System.out.println(car.showCar(p -> "Car{" +
                    "brand='" + p.getBrand() + '\'' +
                    ", hasButtons=" + p.getHelmHasButtons() +
                    ", bodyColor='" + p.getBodyColor() + '\'' +
                    ", diameter=" + p.getDiameterWheel() +
                    ", typeWheel=" + p.getTypeWheel() +
                    '}'));
        }
    }

    private void removeRangeOfDiametersNew() {

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        if (firstNumber > secondNumber) {
            System.out.println("Ну ок, цей варіант також врахований :)\n");
            int i = firstNumber;
            firstNumber = secondNumber;
            secondNumber = i;
        }
        removeCars(firstNumber,secondNumber);
    }

    private void removeCars(int firstNumber, int secondNumber) {
        for (Car car : carSet) {
            if (car.getDiameterWheel() >= firstNumber && car.getDiameterWheel() <= secondNumber) {
                carSet.remove(car);
            }
        }
    }

    private void getCars() {
        cars.add(new CarService().bodyColor("зелений").brand("форд").hasButtons(true).diameter(10).type("літня").createCar());
        cars.add(new CarService().bodyColor("червоний").brand("форд").hasButtons(false).type("всесезонна").createCar());
        cars.add(new CarService().bodyColor("фіолетовий").brand("форд").hasButtons(true).type("літня").createCar());
        cars.add(new CarService().bodyColor("зелений").brand("форд").hasButtons(false).type("літня").diameter(11).createCar());
        cars.add(new CarService().bodyColor("зелений").brand("форд").hasButtons(true).type("зимова").createCar());
        cars.add(new CarService().bodyColor("червоний").brand("форд").hasButtons(true).type("зимова").diameter(21).createCar());
        cars.add(new CarService().bodyColor("жовтий").brand("форд").hasButtons(false).type("зимова").diameter(9).createCar());
        cars.add(new CarService().bodyColor("червоний").brand("форд").hasButtons(false).type("літня").diameter(18).createCar());
        cars.add(new CarService().bodyColor("зелений").brand("форд").hasButtons(true).type("всесезонна").diameter(23).createCar());
        cars.add(new CarService().bodyColor("фіолетовий").brand("форд").hasButtons(true).type("всесезонна").diameter(16).createCar());
        carSet.addAll(cars);
    }

    private void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.showCar(p -> "Car{" +
                    "brand='" + p.getBrand() + '\'' +
                    ", hasButtons=" + p.getHelmHasButtons() +
                    ", bodyColor='" + p.getBodyColor() + '\'' +
                    ", diameter=" + p.getDiameterWheel() +
                    ", typeWheel=" + p.getTypeWheel() +
                    '}'));
        }
    }

    private int scanDiameter() {
        System.out.println("Введіть діаметр\n");
        return scanner.nextInt();
    }

    private void returnBackToMenuNew() {
        System.out.println("Повернутись у меню?\n(так/ні)\n");
        switch (scanner.next()) {
            case "так":
                newVersionStart();
                break;
            case "ні":

                break;
            default:
                System.out.println("Неправильний ввід\n");
                returnBackToMenuNew();
        }
    }

    private void returnBackToMenu() {
        System.out.println("Повернутись у меню?\n(так/ні)\n");
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
