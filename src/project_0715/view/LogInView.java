package project_0715.view;

public class LogInView { // class start

    private LogInView(){}
    private static final LogInView loginView = new LogInView();
    public static LogInView getInstance(){
        return loginView;
    }
} // class end