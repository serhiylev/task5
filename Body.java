import java.util.Objects;

public class Body {//кузов
    private String bodyColor;

    Body() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(bodyColor, body.bodyColor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bodyColor);
    }

    @Override
    public String toString() {
        return "bodyColor= " + bodyColor ;
    }


    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }
}
