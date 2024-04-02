package Model;

public class Child extends Person {
    private boolean isStudy;

    public Child(int age, boolean isStudy) {
        super(age);
        this.isStudy = isStudy;
    }

    public boolean getIsStudy() {
        return isStudy;
    }

    public void setStudy(boolean isStudy) {
        this.isStudy = isStudy;
    }

    @Override
    public String toString() {
        return "Age: " + this.getAge() + " - " + isStudy;
    }

}
