import java.util.Objects;

public class Wheel {//колесо
    private int diameter = 0;
    private String  type;

    Wheel() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return diameter == wheel.diameter;
    }

    @Override
    public int hashCode() {

        return Objects.hash(diameter);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
