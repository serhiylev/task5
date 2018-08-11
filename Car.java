class Car {
    private String brand;//марка
    private Helm helm = new Helm();
    private Body body = new Body();
    private Wheel wheel = new Wheel();

    public Car(String brand, boolean hasButtons, String bodyColor, int diameter) {
        this.brand = brand;
        helm.setHasButtons(hasButtons);
        body.setBodyColor(bodyColor);
        wheel.setDiameter(diameter); ;
    }


    void changeDiameterWheel(int diameter) {
        wheel.changeDiameter(diameter);
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
                '}';
    }
}
