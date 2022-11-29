import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    //this is the main class and the portal to the game
    @Override
    public void start(Stage primaryStage) {
        ChoosePlayMode.playMode(primaryStage);

    }
}
