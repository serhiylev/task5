import java.util.Objects;

class Helm {//кермо
    private boolean hasButtons;

    Helm() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helm helm = (Helm) o;
        return hasButtons == helm.hasButtons;
    }

    @Override
    public int hashCode() {

        return Objects.hash(hasButtons);
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
