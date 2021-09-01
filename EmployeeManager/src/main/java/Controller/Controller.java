package Controller;

import DAO.DAOHandler;
import entity.Employees;
import view.MenuHandler;
import view.OptionMainMenu;
import view.OptionSearchMenu;
import view.OptionUpdateMenu;

public class Controller implements ControlHandler{
    private MenuHandler menu;
    private DAO.DAOHandler dao;

    public Controller(MenuHandler menu, DAOHandler dao) {
        this.menu = menu;
        this.dao = dao;
    }

    @Override
    public void startApplication() {
        boolean flag=true;
        while(flag){
            OptionMainMenu op=menu.showMainMenu();
            if(op.equals(OptionMainMenu.ADD_NEW)){
                this.addNew();
            }
            if(op.equals(OptionMainMenu.UPDATE)){
                this.update();
            }
            if(op.equals(OptionMainMenu.SEARCH)){
                this.search();
            }
            if(op.equals(OptionMainMenu.EXIT)){
                flag=false;
            }
        }
    }

    private void addNew(){
        Employees e=menu.showAddNewView();
        if(e!=null){
            dao.insert(e);
        }
    }

    private void update(){
        Employees e=dao.findById(menu.showFindByIdView());
        if(e!=null){
            OptionUpdateMenu op=menu.showUpdateView();
            if(op.equals(OptionUpdateMenu.UPDATE)){
                Employees e2=menu.showUpdateEmployeeView(e);
                if(e2!=null){
                    dao.update(e);
                    menu.showMessage("Update successfully!");
                }
            }
            if(op.equals(OptionUpdateMenu.DELETE)){
                dao.delete(e.getId());
                menu.showMessage("Delete successfully!");
            }
        }else{
            menu.showMessage("Employee not found");
        }
    }

    private void search(){
        OptionSearchMenu op=menu.showSearchView();
        if(op.equals(OptionSearchMenu.FIND_ALL_INTERN)){
            menu.showListInternView(dao.findAllIntern());
        }
        if(op.equals(OptionSearchMenu.FIND_ALL_EXPERIENCE)){
            menu.showListExperienceView(dao.findAllExperience());
        }
        if(op.equals(OptionSearchMenu.FIND_ALL_FRESHER)){
            menu.showListFresherView(dao.findAllFresher());
        }
    }
}
