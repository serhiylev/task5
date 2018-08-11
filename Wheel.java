public class Wheel {//колесо
    private int diameter = 0;

    public Wheel() {
    }

    public Wheel(int diameter) {

        this.diameter = diameter;
    }


    void changeDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "diameter= " + diameter;
    }





    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
