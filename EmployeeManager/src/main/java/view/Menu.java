package view;

import entity.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu implements MenuHandler{
    @Override
    public OptionMainMenu showMainMenu() {
        System.out.println(this.getMenu());
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        while(!input.matches("[1-4]")){
            System.out.println("Invalid input!!!");
            input=scan.nextLine();
        }
        switch(input){
            case "1": return OptionMainMenu.ADD_NEW;
            case "2": return OptionMainMenu.UPDATE;
            case "3": return OptionMainMenu.SEARCH;
            case "4": return OptionMainMenu.EXIT;
            default: return OptionMainMenu.EXIT;
        }
    }

    @Override
    public Employees showAddNewView() {
        System.out.println(this.getCreatedItem());
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        while(!input.matches("[1-3]")){
            System.out.println("Invalid input!!!");
            input=scan.nextLine();
        }
        switch(input){
            case "1": return this.scanNewExperienceEmployee(scan);
            case "2": return this.scanNewFresherEmployee(scan);
            case "3": return this.scanNewInternEmployee(scan);
            default: return null;
        }
    }

    @Override
    public int showFindByIdView() {
        System.out.println("Enter Employee ID: ");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        while(!input.matches("[0-9]{1,}")){
            System.out.println("Invalid input");
            input=scan.nextLine();
        }
        return Integer.parseInt(input);
    }

    @Override
    public boolean showOptionMessage(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OptionUpdateMenu showUpdateView() {
        System.out.println("------ Excecute update ------");
        System.out.println("1. Update");
        System.out.println("2. Delete");

        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        while(!input.matches("[1-2]")){
            System.out.println("Invalid input!!!");
            input=scan.nextLine();
        }

        switch(input){
            case "1": return OptionUpdateMenu.UPDATE;
            case "2": return OptionUpdateMenu.DELETE;
            default: return OptionUpdateMenu.UPDATE;
        }
    }

    @Override
    public Employees showUpdateEmployeeView(Employees e) {
        Scanner scan=new Scanner(System.in);
        Employees employees=null;
        if(e instanceof ExperienceEmployee){
            employees= this.scanUpdateExperienceEmployee((ExperienceEmployee)e, scan);
        }
        if(e instanceof FresherEmployee){
            employees= this.scanUpdateFresherEmployee((FresherEmployee)e, scan);
        }
        if(e instanceof InternEmployee){
            employees= this.scanUpdateInternEmployee((InternEmployee)e, scan);
        }
        if(this.scanSaveOption(scan)){
            return employees;
        }
        return null;
    }

    @Override
    public void showMessage(String msg) {
        System.out.println("----> Notify: "+msg);
    }

    @Override
    public OptionSearchMenu showSearchView() {
        System.out.println(this.getOptionSearchMenu());
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        while(!input.matches("[123]")){
            System.out.println("Invalid input");
            input=scan.nextLine();
        }
        switch(input){
            case "1": return OptionSearchMenu.FIND_ALL_EXPERIENCE;
            case "2": return OptionSearchMenu.FIND_ALL_FRESHER;
            case "3": return OptionSearchMenu.FIND_ALL_INTERN;
            default: return OptionSearchMenu.FIND_ALL_EXPERIENCE;
        }
    }

    @Override
    public void showListInternView(List<InternEmployee> list) {
        if(list.isEmpty() || list==null){
            System.out.println("There is no Intern");
        }else{
            System.out.println("------ Intern list -------");
            list.forEach((t)->t.showMe());
        }
    }

    @Override
    public void showListExperienceView(List<ExperienceEmployee> list) {
        if(list.isEmpty() || list==null){
            System.out.println("There is no Experience");
        }else{
            System.out.println("------ Experience list -------");
            list.forEach((t)->t.showMe());
        }
    }

    @Override
    public void showListFresherView(List<FresherEmployee> list) {
        if(list.isEmpty() || list==null){
            System.out.println("There is no Fresher");
        }else{
            System.out.println("------ Fresher list -------");
            list.forEach((t)->t.showMe());
        }
    }

    private String getMenu(){
        StringBuilder str=new StringBuilder("--------------- Menu ---------------");
        str.append("\n1. Add New Employee");
        str.append("\n2. Update");
        str.append("\n3. Search");
        str.append("\n4. Exit");
        str.append("\nEnter your option: ");
        return str.toString();
    }

    private String getCreatedItem(){
        StringBuilder str=new StringBuilder("--------------- Create New ---------------");
        str.append("\n1. Experience ");
        str.append("\n2. Fresher ");
        str.append("\n3. Intern ");
        str.append("\nEnter your option: ");
        return str.toString();
    }

    private String getOptionSearchMenu(){
        StringBuilder str=new StringBuilder("--------------- Srearch for ---------------");
        str.append("\n1. Experience list");
        str.append("\n2. Fresher list");
        str.append("\n3. Intern list");
        str.append("\nEnter your option: ");
        return str.toString();
    }

    private String scanName(Scanner scan){
        String name=scan.nextLine();
        if(!name.isEmpty()){
            while (!name.matches("[a-zA-Z ]{1,50}")){
                System.out.println("Invalid Name");
                name=scan.nextLine();
            }
            return name;
        }

        return null;
    }

    private String scanBirthday(Scanner scan){
        String dob=scan.nextLine();
        if(!dob.isEmpty()){
            while (!dob.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                System.out.println("Invalid Birthday");
                dob=scan.nextLine();
            }
            return dob;
        }

        return null;
    }

    private String scanPhone(Scanner scan){
        String phone=scan.nextLine();
        if(!phone.isEmpty()){
            while (!phone.matches("[0-9]{10}")){
                System.out.println("Invalid Phone (10 digits)");
                phone=scan.nextLine();
            }
            return phone;
        }

        return null;
    }

    private String scanEmail(Scanner scan){
        String email=scan.nextLine();
        if(!email.isEmpty()){
            while (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
                System.out.println("Invalid Email");
                email=scan.nextLine();
            }

            return email;
        }

        return null;
    }

    private List<Certificate> scanCertificate(Scanner scan){
        return null;
    }

    private String scanNumber(Scanner scan){
        String expInYear=scan.nextLine();
        if(!expInYear.isEmpty()){
            while (!expInYear.matches("[0-9]{1,}")){
                System.out.println("Invalid ExpInYear");
                expInYear=scan.nextLine();
            }

            return expInYear;
        }

        return null;
    }

    private String scanText(Scanner scan){
        String proSkill=scan.nextLine();
        if(!proSkill.isEmpty()){
            return proSkill;
        }

        return null;
    }

    private String scanGraduationDate(Scanner scan){
        String graduationDate=scan.nextLine();
        if(!graduationDate.isEmpty()){
            while (!graduationDate.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                System.out.println("Invalid GraduationDate");
                graduationDate=scan.nextLine();
            }
            return graduationDate;
        }

        return null;
    }

    private GraduationRank scanGraduationRank(Scanner scan){
        System.out.println("1. EXCELLENT");
        System.out.println("2. GOOD");
        System.out.println("3. AVERAGE");
        String graduationRank=scan.nextLine();
        if(!graduationRank.isEmpty()){
            while (!graduationRank.matches("[123]")){
                System.out.println("Invalid GraduationRank");
                graduationRank=scan.nextLine();
            }
            switch(graduationRank){
                case "1": return GraduationRank.EXCELLENT;
                case "2": return GraduationRank.GOOD;
                case "3": return GraduationRank.AVERAGE;
            }
        }

        return null;
    }

    private boolean scanSaveOption(Scanner scan){
        System.out.println("Do you want to save?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        String op=scan.nextLine();
        while(!op.matches("[12]")){
            System.out.println("Invalid input");
            op=scan.nextLine();
        }

        switch(op){
            case "1": return true;
            case "2": return false;
            default: return false;
        }
    }

    private ExperienceEmployee scanNewExperienceEmployee(Scanner scan){
        ExperienceEmployee experience=new ExperienceEmployee();
        System.out.println("Name: ");
        experience.setFullName(scanName(scan));
        System.out.println("Birthday: ");
        experience.setBirthday(scanBirthday(scan));
        System.out.println("Phone: ");
        experience.setPhone(scanPhone(scan));
        System.out.println("Email: ");
        experience.setEmail(scanEmail(scan));
        System.out.println("Certificate: ");
        experience.setCertificate(scanCertificate(scan));
        System.out.println("ExpInYear: ");
        Optional.ofNullable(scanNumber(scan)).ifPresent((t)->experience.setExpInYear(Integer.parseInt(t)));
        System.out.println("ProSkill: ");
        experience.setProSkill(scanText(scan));

        if(scanSaveOption(scan)){
            return experience;
        }
        return null;
    }

    private FresherEmployee scanNewFresherEmployee(Scanner scan){
        FresherEmployee fresher=new FresherEmployee();
        System.out.println("Name: ");
        fresher.setFullName(scanName(scan));
        System.out.println("Birthday: ");
        fresher.setBirthday(scanBirthday(scan));
        System.out.println("Phone: ");
        fresher.setPhone(scanPhone(scan));
        System.out.println("Email: ");
        fresher.setEmail(scanEmail(scan));
        System.out.println("Certificate: ");
        fresher.setCertificate(scanCertificate(scan));
        System.out.println("GraduationDate: ");
        fresher.setGraduationDate(scanGraduationDate(scan));
        System.out.println("GraduationRank: ");
        fresher.setGraduationRank(scanGraduationRank(scan));
        System.out.println("Education: ");
        fresher.setEducation(scanText(scan));

        if(scanSaveOption(scan)){
            return fresher;
        }
        return null;
    }

    private InternEmployee scanNewInternEmployee(Scanner scan){
        InternEmployee intern=new InternEmployee();;
        System.out.println("Name: ");
        intern.setFullName(scanName(scan));
        System.out.println("Birthday: ");
        intern.setBirthday(scanBirthday(scan));
        System.out.println("Phone: ");
        intern.setPhone(scanPhone(scan));
        System.out.println("Email: ");
        intern.setEmail(scanEmail(scan));
        System.out.println("Certificate: ");
        intern.setCertificate(scanCertificate(scan));
        System.out.println("Majors: ");
        intern.setMajors(scanText(scan));
        System.out.println("Semester: ");
        intern.setSemester(scanText(scan));
        System.out.println("UniversityName: ");
        intern.setUniversityName(scanText(scan));

        if(scanSaveOption(scan)){
            return intern;
        }
        return null;
    }

    private ExperienceEmployee scanUpdateExperienceEmployee(ExperienceEmployee e,Scanner scan){
        System.out.println("Name: "+e.getFullName());
        Optional.ofNullable(this.scanName(scan))
                .ifPresent((t)->e.setFullName(t));

        System.out.println("Birthday: "+e.getBirthday());
        Optional.ofNullable(this.scanBirthday(scan))
                .ifPresent((t)->e.setBirthday(t));

        System.out.println("Phone: "+e.getPhone());
        Optional.ofNullable(this.scanPhone(scan))
                .ifPresent((t)->e.setPhone(t));

        System.out.println("Email"+e.getEmail());
        Optional.ofNullable(this.scanEmail(scan))
                .ifPresent((t)->e.setEmail(t));

        System.out.println("Experience In Year: "+e.getExpInYear());
        Optional.ofNullable(this.scanNumber(scan))
                .ifPresent((t)->e.setExpInYear(Integer.parseInt(t)));

        System.out.println("Professional Skill: "+e.getProSkill());
        Optional.ofNullable(this.scanText(scan))
                .ifPresent((t)->e.setProSkill(t));

        return e;
    }

    private FresherEmployee scanUpdateFresherEmployee(FresherEmployee e,Scanner scan){
        System.out.println("Name: "+e.getFullName());
        Optional.ofNullable(this.scanName(scan))
                .ifPresent((t)->e.setFullName(t));

        System.out.println("Birthday: "+e.getBirthday());
        Optional.ofNullable(this.scanBirthday(scan))
                .ifPresent((t)->e.setBirthday(t));

        System.out.println("Phone: "+e.getPhone());
        Optional.ofNullable(this.scanPhone(scan))
                .ifPresent((t)->e.setPhone(t));

        System.out.println("Email"+e.getEmail());
        Optional.ofNullable(this.scanEmail(scan))
                .ifPresent((t)->e.setEmail(t));

        System.out.println("Graduation Date: "+e.getGraduationDate());
        Optional.ofNullable(this.scanGraduationDate(scan))
                .ifPresent((t)->e.setGraduationDate(t));

        System.out.println("Graduation Rank: "+e.getGraduationRank());
        Optional.ofNullable(this.scanGraduationRank(scan))
                .ifPresent((t)->e.setGraduationRank(t));

        System.out.println("Education: "+e.getEducation());
        Optional.ofNullable(this.scanText(scan))
                .ifPresent((t)->e.setEducation(t));

        return e;
    }

    private InternEmployee scanUpdateInternEmployee(InternEmployee e,Scanner scan){
        System.out.println("Name: "+e.getFullName());
        Optional.ofNullable(this.scanName(scan))
                .ifPresent((t)->e.setFullName(t));

        System.out.println("Birthday: "+e.getBirthday());
        Optional.ofNullable(this.scanBirthday(scan))
                .ifPresent((t)->e.setBirthday(t));

        System.out.println("Phone: "+e.getPhone());
        Optional.ofNullable(this.scanPhone(scan))
                .ifPresent((t)->e.setPhone(t));

        System.out.println("Email"+e.getEmail());
        Optional.ofNullable(this.scanEmail(scan))
                .ifPresent((t)->e.setEmail(t));

        System.out.println("Majors: "+e.getMajors());
        Optional.ofNullable(this.scanText(scan))
                .ifPresent((t)->e.setMajors(t));

        System.out.println("Semester: "+e.getSemester());
        Optional.ofNullable(this.scanText(scan))
                .ifPresent((t)->e.setSemester(t));

        System.out.println("UniversityName"+e.getUniversityName());
        Optional.ofNullable(this.scanText(scan))
                .ifPresent((t)->e.setUniversityName(t));

        return e;
    }
}
