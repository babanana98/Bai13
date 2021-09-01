package entity;

public class InternEmployee extends Employees{
    private String majors;
    private String semester;
    private String universityName;

    @Override
    public void showMe() {
        System.out.println(super.toString());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Intern{" + "majors=" + majors + ", semester=" + semester + ", universityName=" + universityName + '}';
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
