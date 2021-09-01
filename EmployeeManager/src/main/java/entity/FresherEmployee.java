package entity;

public class FresherEmployee extends Employees{
    private String graduationDate;
    private GraduationRank graduationRank;
    private String education;

    @Override
    public void showMe() {
        System.out.println(super.toString());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fresher{" + "graduationDate=" + graduationDate + ", graduationRank=" + graduationRank + ", education=" + education + '}';
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
