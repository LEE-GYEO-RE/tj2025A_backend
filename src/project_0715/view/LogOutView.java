package project_0715.view;

public class LogOutView {

    private LogOutView(){}
    private static final LogOutView logoutView = new LogOutView();
    public static LogOutView getInstance(){
        return logoutView;
    }
}