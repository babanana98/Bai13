package view;

import entity.Employees;
import entity.ExperienceEmployee;
import entity.FresherEmployee;
import entity.InternEmployee;

import java.util.List;

public interface MenuHandler {
    public OptionMainMenu showMainMenu();
    public Employees showAddNewView();
    public int showFindByIdView();
    public boolean showOptionMessage(String title);
    public OptionUpdateMenu showUpdateView();
    public Employees showUpdateEmployeeView(Employees e);
    public void showMessage(String msg);
    public OptionSearchMenu showSearchView();
    public void showListInternView(List<InternEmployee> list);
    public void showListExperienceView(List<ExperienceEmployee> list);
    public void showListFresherView(List<FresherEmployee> list);
}
