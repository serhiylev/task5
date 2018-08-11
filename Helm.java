public class Helm {//кермо
    private boolean hasButtons;

    public Helm() {
    }

    Helm(boolean hasButtons) {
        this.hasButtons = hasButtons;
    }

    @Override
    public String toString() {
        return "hasButtons= " + hasButtons;
    }

    public void change() {
        if (hasButtons) {
            hasButtons = false;
        } else {
            hasButtons = true;
        }

    }

    public boolean getHasButtons() {
        return hasButtons;
    }

    public void setHasButtons(boolean hasButtons) {
        this.hasButtons = hasButtons;
    }
}
