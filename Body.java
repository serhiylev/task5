public class Body {//кузов
    private String bodyColor;


    Body() {
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
