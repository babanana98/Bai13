package entity;

public class ExperienceEmployee extends Employees{
    private int expInYear;
    private String proSkill;

    @Override
    public void showMe() {
        System.out.println(super.toString());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Experience{" + "expInYear=" + expInYear + ", proSkill=" + proSkill + '}';
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
