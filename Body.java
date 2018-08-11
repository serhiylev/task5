public class Body {//кузов
    private String bodyColor;


    public Body() {
    }

    public Body(String bodyColor) {
        this.bodyColor = bodyColor;
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
