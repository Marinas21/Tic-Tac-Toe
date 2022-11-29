import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DashBord {


    public static void dashbord(Stage primaryStage){

        MultiPlayer multiPlayer=new MultiPlayer();
        GridPane gridPane=new GridPane();
        int row=0;
        int column=0;
        final int[] index = {1};
        for(int i=1;i<10;i++){
            HBox hBox=new HBox();
            hBox.getStyleClass().add("game-container");
            int id=i;
            GridPane.setConstraints(hBox,column,row);
            column++;
            if(column==3){
                column=0;
                row++;
            }
            hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(id);
                    String amswer=multiPlayer.play(index[0],id);
                    if (amswer.equals("tie")){
                        Label label;
                        if(index[0]==1){
                            label= new Label("X");
                        }
                        else{
                            label = new Label("0");
                        }
                        hBox.getChildren().add(label);
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("tie");
                        alert.show();
                    }
                    else if(amswer.contains("won")){
                        Label label;
                        if(index[0]==1){
                            label= new Label("X");
                        }
                        else{
                            label = new Label("0");
                        }
                        hBox.getChildren().add(label);
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText(amswer);
                        alert.show();

                    }else if(amswer.equals("is taken")){
                        Alert alert=new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("try again");
                        alert.show();
                    }
                    else {
                        Label label = new Label(amswer);
                        hBox.getChildren().add(label);
                        if(index[0] ==1){
                            index[0]++;
                        }
                        else{
                            index[0]--;
                        }
                    }
                }
            });
            gridPane.getChildren().add(hBox);
        }

        Button button=new Button("Go back");
        gridPane.getChildren().add(button);
        GridPane.setConstraints(button,0,4);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChoosePlayMode.playMode(primaryStage);
            }
        });
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        gridPane.setAlignment(Pos.CENTER);
        Scene scene=new Scene(gridPane,1000,1000);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
