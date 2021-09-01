import Controller.ControlHandler;
import Controller.Controller;
import DAO.EmployeeDAO;
import view.Menu;

public class Application {
    public static void main(String arg[]){
        ControlHandler controler=new Controller(new Menu(), new EmployeeDAO());
        controler.startApplication();
    }
}
