import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOver extends Application implements EventHandler<ActionEvent>{
    private String result;
    private String color;
    private String name;
    public static void main(String[] args) {
        launch(args);
    }
    public GameOver(String result, String name){
        this.name = name;
        this.result = result;
    }
    @Override
    public void start(Stage primaryStage) {
        if(result.equals("WINNER")){
            this.color = "#72DE60";
        }else{
            this.color = "#FF2626";
        }
        VBox container = new VBox();

        Label labelTitle = new Label("Game Over");
        labelTitle.setFont(new Font(40));
        labelTitle.setTextFill(Color.web("#F8F8FF"));

        VBox containerconection = new VBox();

        Label labelName = new Label(result + " " + name);
        labelName.setFont(new Font(30));
        labelName.setTextFill(Color.web(color));

        Button btnContinue = new Button("Continue");
        btnContinue.setFont(new Font(20));
        btnContinue.setPrefWidth(370);
        btnContinue.setPrefHeight(44);
        btnContinue.setMaxWidth(400);
        btnContinue.setCursor(Cursor.HAND);
        btnContinue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Login login = new Login();
                    login.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        containerconection.getChildren().addAll(labelName,btnContinue);
        containerconection.setAlignment(Pos.TOP_CENTER);

        VBox.setMargin(labelName, new Insets(10, 0, 0, 0));

        container.getChildren().addAll(labelTitle, containerconection);
        container.setPrefWidth(300);
        container.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(containerconection, new Insets(0, 30, 0, 30));



        HBox root = new HBox();
        root.getChildren().addAll(container);
        HBox.setHgrow(container, Priority.ALWAYS);

        BackgroundImage FondoHBox= new BackgroundImage(new Image("/images/background_2.jpg",850,500,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        root.setBackground(new Background(FondoHBox));

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Monsters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
    }
}