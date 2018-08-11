public class Helm {//кермо
    private boolean hasButtons;

    Helm() {
    }

    public void change() {
        hasButtons = !hasButtons;
    }

    public boolean getHasButtons() {
        return hasButtons;
    }

    public void setHasButtons(boolean hasButtons) {
        this.hasButtons = hasButtons;
    }
}
