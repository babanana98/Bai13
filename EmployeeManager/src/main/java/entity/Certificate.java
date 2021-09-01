package entity;

import java.util.Date;

public class Certificate {
    private int certificatedID;
    private String certificateName;
    private GraduationRank certificateRank;
    private Date certificatedDate;

    public int getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(int certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public GraduationRank getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(GraduationRank certificateRank) {
        this.certificateRank = certificateRank;
    }

    public Date getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(Date certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "Certificate{" + "certificatedID=" + certificatedID + ", certificateName=" + certificateName + ", certificateRank=" + certificateRank + ", certificatedDate=" + certificatedDate + '}';
    }
}
