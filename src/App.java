import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        HBox containerVida = new HBox();
        ProgressBar BarVida = new ProgressBar(1);
        BarVida.setMinWidth(500);
        /*UIManager.put(BarVida,Color.GREEN);*/
        Label labelvida = new Label("Vida");
        labelvida.setFont(new Font(50));
        labelvida.setTextFill(Color.web("#008000"));
        HBox.setMargin(labelvida,new Insets(0,100,0,0));
        HBox.setMargin(BarVida,new Insets(0,100,0,0));
        containerVida.getChildren().addAll(labelvida,BarVida);
        containerVida.setPrefWidth(200);
        containerVida.setAlignment(Pos.CENTER);
        /*containerVida.setBackground(new Background(new BackgroundFill(Color.web("#000000"),CornerRadii.EMPTY, Insets.EMPTY)));*/


        HBox containerMana = new HBox();
        ProgressBar BarMana = new ProgressBar(0.150);
        BarMana.setMinWidth(500);
        /*UIManager.put(BarVida,Color.GREEN);*/
        Label labelmana = new Label("Mana");
        labelmana.setFont(new Font(50));
        labelmana.setTextFill(Color.web("#DAA520"));
        HBox.setMargin(labelmana,new Insets(0,70,0,0));
        HBox.setMargin(BarMana,new Insets(0,100,0,0));
        containerMana.getChildren().addAll(labelmana,BarMana);
        containerMana.setPrefWidth(200);
        containerMana.setAlignment(Pos.CENTER);
        /*containerMana.setBackground(new Background(new BackgroundFill(Color.web("#000000"),CornerRadii.EMPTY,Insets.EMPTY)));*/


        VBox containerdeck = new VBox();
        Image deck = new Image(getClass().getResourceAsStream("/images/Fondo2.jpg"));

        ImageView Viewdeck = new ImageView(deck);
        Viewdeck.setFitHeight(400);
        Viewdeck.setFitWidth(200);

        Button btndeck = new Button("Obtener Carta");
        btndeck.setFont(new Font(15));
        btndeck.setPrefHeight(35);
        btndeck.setPrefWidth(130);

        VBox.setMargin(Viewdeck, new Insets(100,0,0,0));
        VBox.setMargin(btndeck, new Insets(50,0,0,0));

        containerdeck.getChildren().addAll(Viewdeck,btndeck);
        containerdeck.setPrefWidth(300);
        containerdeck.setAlignment(Pos.CENTER);
        /*containerdeck.setBackground(new Background(new BackgroundFill(Color.web("#000000"),CornerRadii.EMPTY,Insets.EMPTY)));*/


        FlowPane containermanocartas = new FlowPane();

        Image carta1 = new Image(getClass().getResourceAsStream("/images/1.jpg"));
        Image carta2 = new Image(getClass().getResourceAsStream("/images/2.jpg"));
        Image carta3 = new Image(getClass().getResourceAsStream("/images/3.jpg"));
        Image carta4 = new Image(getClass().getResourceAsStream("/imagenes/4.jpg"));
        Image carta5 = new Image(getClass().getResourceAsStream("/imagenes/5.jpg"));
        Image carta6 = new Image(getClass().getResourceAsStream("/imagenes/6.jpg"));
        Image carta7 = new Image(getClass().getResourceAsStream("/imagenes/7.jpg"));
        Image carta8 = new Image(getClass().getResourceAsStream("/imagenes/8.jpg"));
        Image carta9 = new Image(getClass().getResourceAsStream("/imagenes/9.jpg"));
        Image carta10 = new Image(getClass().getResourceAsStream("/imagenes/10.jpg"));

        ImageView View1 = new ImageView(carta1);
        ImageView View2 = new ImageView(carta2);
        ImageView View3 = new ImageView(carta3);
        ImageView View4 = new ImageView(carta4);
        ImageView View5 = new ImageView(carta5);
        ImageView View6 = new ImageView(carta6);
        ImageView View7 = new ImageView(carta7);
        ImageView View8 = new ImageView(carta8);
        ImageView View9 = new ImageView(carta9);
        ImageView View10 = new ImageView(carta10);

        containermanocartas.setOrientation(Orientation.HORIZONTAL);
        containermanocartas.setAlignment(Pos.CENTER);
        containermanocartas.setHgap(20);
        containermanocartas.setVgap(20);
        /*containermanocartas.setBackground(new Background(new BackgroundFill(Color.web("#DAA520"),CornerRadii.EMPTY,Insets.EMPTY)));*/


        BackgroundImage myBI= new BackgroundImage(new Image("/images/Fondo3.jpg",1200,900,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        containermanocartas.setBackground(new Background(myBI));
        containermanocartas.getChildren().addAll(View1,View2,View3,View4,View5,View6,View7,View8,View9,View10);

        VBox containerextra = new VBox();
        containerextra.setPrefWidth(300);
        containerextra.setAlignment(Pos.CENTER);
        /*containerextra.setBackground(new Background(new BackgroundFill(Color.web("#000000"),CornerRadii.EMPTY,Insets.EMPTY)));*/
        Label labelcartas = new Label("Elige la carta");
        labelcartas.setFont(new Font(30));
        labelcartas.setTextFill(Color.web("#F8F8FF"));

        TextField textCarta = new TextField();
        textCarta.setFont(new Font(15));
        textCarta.setMaxWidth(200);
        System.out.println(textCarta);

        Button btncarta = new Button("Lanzar");
        btncarta.setFont(new Font(15));
        btncarta.setPrefHeight(35);
        btncarta.setPrefWidth(130);

        VBox.setMargin(labelcartas,new Insets(50,0,0,0));
        VBox.setMargin(textCarta, new Insets(50,0,0,0));
        VBox.setMargin(btncarta, new Insets(50,0,0,0));

        containerextra.getChildren().addAll(labelcartas,textCarta,btncarta);

        BorderPane root = new BorderPane();

        root.setTop(containerVida);
        root.setBottom(containerMana);
        root.setRight(containerdeck);
        root.setCenter(containermanocartas);
        root.setLeft(containerextra);


        BackgroundImage FondoCentro= new BackgroundImage(new Image("/images/Fondo1.jpg",1800,1000,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        root.setBackground(new Background(FondoCentro));


        primaryStage.setTitle("Monsters");
        Scene scene = new Scene(root,1800,1000);
        primaryStage.setScene(scene);
        primaryStage.show();





    }


    public static void main(String[] args) {
        launch(args);
    }
}
