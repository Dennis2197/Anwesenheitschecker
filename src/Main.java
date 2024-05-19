import controller.MainController;
import view.MainView;
import view.ResultWindow;

public class Main {
    public static void main(String[] args) {
        new MainController( new MainView(1000, 750), new ResultWindow());
    }
}
