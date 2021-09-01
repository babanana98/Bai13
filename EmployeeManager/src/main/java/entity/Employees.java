package entity;

import java.util.List;

public abstract class Employees {
    public static final int count=0;

    private int id;
    private String fullName;
    private String birthday;
    private String phone;
    private String email;
    private List<Certificate> certificate;

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email + ", certificate=" + certificate + '}';
    }

    public List<Certificate> getCertificate() {
        return certificate;
    }

    public void setCertificate(List<Certificate> certificate) {
        this.certificate = certificate;
    }

    public abstract void showMe();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
