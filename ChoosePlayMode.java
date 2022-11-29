import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoosePlayMode {
    //this class allows the player if he wants to play alone or with the computer
    public static void playMode(Stage primaryStage){
        GridPane gridPane=new GridPane();
        VBox computer=new VBox();
        VBox multi=new VBox();
        computer.setAlignment(Pos.CENTER);
        multi.setAlignment(Pos.CENTER);
        Label computerPlay=new Label("Play with computer");
        Label multiplayer=new Label("Play with another person");
        computer.getChildren().add(computerPlay);
        multi.getChildren().add(multiplayer);
        gridPane.getChildren().addAll(computer,multi);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        GridPane.setConstraints(computer,0,0);
        GridPane.setConstraints(multi,1,0);
        Scene scene=new Scene(gridPane,700,700);
        scene.getStylesheets().add("style.css");
        multi.getStyleClass().add("container");
        computer.getStyleClass().add("container");
        primaryStage.setScene(scene);
        primaryStage.show();
        multi.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                DashBord.dashbord(primaryStage);
            }
        });
        computer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                DashBord.dashbord(primaryStage);
            }
        });
    }
}
