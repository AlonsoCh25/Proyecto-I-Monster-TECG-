import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


public class App extends Application implements EventHandler<javafx.event.ActionEvent> {
    private Initial_cards InitCards;
    private DoubleLinkedList History;
    private DoubleCircularList Mass;
    private Stack Deck;
    private FlowPane containermanocartas;
    private String type;
    private Server server;
    private Client client;
    private String name;
    private String Inmessage;
    private boolean active;
    private float life;
    private float mana;
    private int port;
    private float f_mana;
    private float f_life;
    private ProgressBar BarVida;
    private ProgressBar BarMana;
    private HBox containerVida;
    private HBox containerMana;
    private boolean isMyTurn;

    public App(String type, int port, String name) throws Exception {
        this.containerVida = new HBox();
        this.containerMana = new HBox();
        this.type = type;
        this.name = name;
        this.mana = 1000;
        this.f_mana = mana/1000;
        this.life = 1000;
        this.f_life = life/1000;
        this.port = port;
        this.BarMana = new ProgressBar(f_mana);
        this.BarVida = new ProgressBar(f_life);
        if(type == "client"){
            this.isMyTurn = true;
            this.client = new Client("127.0.0.1", this.port);
            Thread t_client = new Thread(client);
            t_client.start();
            this.port = client.getPort();
            this.active = true;
        }
        if(type == "server"){
            this.isMyTurn = false;
            this.server = new Server();
            Thread t_server = new Thread(server);
            t_server.start();
            this.port = server.getPort();
            this.active = true;
        }
        this.InitCards = new Initial_cards();
        this.InitCards.crete_All_cards();
        this.InitCards.create_Mass();
        this.InitCards.create_Deck();
        this.Deck = InitCards.getDeck();
        this.Mass = InitCards.getMass();
        this.containermanocartas = new FlowPane();
    }
    @Override
    public void start(Stage primaryStage) {
        Label L_User = new Label("Name: " + this.name);
        L_User.setFont(new Font(25));
        L_User.setTextFill(Color.web("#FFFFFF"));
        Label L_Port = new Label("Port: " + Integer.toString(this.port));
        L_Port.setFont(new Font(25));
        L_Port.setTextFill(Color.web("#FFFFFF"));

        this.BarVida.setMinWidth(500);
        Label labelvida = new Label("Life");
        labelvida.setFont(new Font(40));
        labelvida.setTextFill(Color.web("#008000"));
        containerVida.setMargin(L_User, new Insets(5,10,0,0));
        containerVida.setMargin(L_Port, new Insets(5,100,0,0));
        HBox.setMargin(labelvida,new Insets(0,5,0,0));
        HBox.setMargin(BarVida,new Insets(20,0,0,0));

        containerVida.getChildren().addAll(L_User, L_Port, labelvida,this.BarVida);
        containerVida.setPrefWidth(200);
        containerVida.setAlignment(Pos.TOP_LEFT);

        this.BarMana.setMinWidth(500);
        Label labelmana = new Label("Mana");
        labelmana.setFont(new Font(50));
        labelmana.setTextFill(Color.web("#DAA520"));
        HBox.setMargin(labelmana,new Insets(0,70,0,0));
        HBox.setMargin(BarMana,new Insets(0,100,0,0));
        containerMana.getChildren().addAll(labelmana,BarMana);
        containerMana.setPrefWidth(200);
        containerMana.setAlignment(Pos.CENTER);


        VBox containerdeck = new VBox();
        Image deck = new Image(getClass().getResourceAsStream("/images/background_2.jpg"));

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
        btndeck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isMyTurn()){
                    if(Mass.size()< 10){
                        Object card = Deck.pop();
                        Mass.insertEnd(card);
                        if(card.getClass() == Spell.class){
                            Image carta1 = new Image(((Spell) card).getRute()+".jpg");
                            ImageView View1 = new ImageView(carta1);
                            containermanocartas.getChildren().add(View1);
                        }
                        if(card.getClass() == Henchmen.class){
                            Image carta1 = new Image(((Henchmen) card).getRute()+".jpg");
                            ImageView View1 = new ImageView(carta1);
                            containermanocartas.getChildren().add(View1);
                        }
                        if(card.getClass() == Secret.class){
                            Image carta1 = new Image(((Secret) card).getRute()+".jpg");
                            ImageView View1 = new ImageView(carta1);
                            containermanocartas.getChildren().add(View1);
                        }
                    }
                }
            }
        });
        update_cards();
        Thread t = new Thread(this::receive_message);
        t.start();

        containermanocartas.setOrientation(Orientation.HORIZONTAL);
        containermanocartas.setAlignment(Pos.CENTER);
        containermanocartas.setHgap(20);
        containermanocartas.setVgap(20);

        BackgroundImage myBI= new BackgroundImage(new Image("/images/background_3.jpg",1200,900,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        containermanocartas.setBackground(new Background(myBI));

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
        btncarta.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                int card_selected = Integer.parseInt(textCarta.getText());
                textCarta.clear();
                Object card = Mass.Data_find(card_selected);
                if(isEnough(card)){
                    if(isMyTurn()){
                        setMyTurn(false);
                        Mass.delete(card);
                        update_cards();
                        try {
                            sendMessage(card);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
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


        BackgroundImage FondoCentro= new BackgroundImage(new Image("/images/background_1.jpg",1800,1000,false,true),
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
    //Acciones del que envia los mensajes
    public void Action_send(String action){
        switch (action){
            case "-10%":
                break;
            case "-10m":
                break;
            case "-30%":
                break;
            case "d_card":
                break;
            case "+lastM":
                //No Afecta al contrincante
                break;
            case "E_250":
                //No Afecta al contrincante
                break;
            case "doubleM":
                //No Afecta al contrincante
                break;
            case "big_damage":
                break;
            case "c_mass":
                break;
            case "n_damage":
                //No Afecta al contrincante
                break;
            case "r_damage":
                //No Afecta al contrincante
                break;
            case "v_+50%":
                //No Afecta al contrincante
                break;
            case "p_4cards":
                //No Afecta al contrincante
                break;
            case "r_card":
                break;
            case "s_card":
                break;
            case "shield":
                //No Afecta al contrincante
                break;
            case "freeze_x1":
                break;
            case "-damage":
                //No Afecta al contrincante
                break;
            case "freeze_x2":
                break;
            case "n_shield":
                break;
            case "v_+25%":
                //No Afecta al contrincante
                break;
            case "+100m":
                //No Afecta al contrincante
                break;
            case "p_3cards":
                //No Afecta al contrincante
                break;

            }
    }
    public void Action_received(String action, int attack){
        if(action.equals("null")){
            if(attack > 0){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        setDamage(attack);
                    }
                });
            }
        }else{
            switch (action){
                case "-10%":
                    break;
                case "-10m":
                    break;
                case "-30%":
                    break;
                case "d_card":
                    break;
                case "+lastM":
                    //No Afecta al contrincante
                    break;
                case "E_250":
                    //No Afecta al contrincante
                    break;
                case "doubleM":
                    //No Afecta al contrincante
                    break;
                case "big_damage":
                    break;
                case "c_mass":
                    break;
                case "n_damage":
                    //No Afecta al contrincante
                    break;
                case "r_damage":
                    //No Afecta al contrincante
                    break;
                case "v_+50%":
                    //No Afecta al contrincante
                    break;
                case "p_4cards":
                    //No Afecta al contrincante
                    break;
                case "r_card":
                    break;
                case "s_card":
                    break;
                case "shield":
                    //No Afecta al contrincante
                    break;
                case "freeze_x1":
                    break;
                case "-damage":
                    //No Afecta al contrincante
                    break;
                case "freeze_x2":
                    break;
                case "n_shield":
                    break;
                case "v_+25%":
                    //No Afecta al contrincante
                    break;
                case "+100m":
                    //No Afecta al contrincante
                    break;
                case "p_3cards":
                    //No Afecta al contrincante
                    break;
            }
        }
    }
    @Override
    public void handle(ActionEvent event) { }
    public boolean isActive(){return this.active;}
    public boolean isEnough(Object data){
        if(data.getClass() == Spell.class){
            if(((Spell) data).getMana() <= this.mana){
                return true;
            }else{
                return false;
            }
        }
        if(data.getClass() == Henchmen.class){
            if(((Henchmen) data).getMana() <= this.mana){
                return true;
            }else{
                return false;
            }
        }
        if(data.getClass() == Secret.class){
            if(((Secret) data).getMana() <= this.mana){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }
    public void sendMessage(Object data) throws JsonProcessingException {
        Json json = new Json();
        Message message;
            if(type == "client"){
                if(data.getClass() == Secret.class){
                    message = new Message("Secret", ((Secret) data).getAction(), ((Secret) data).getMana(), 0);
                    client.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Secret) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Henchmen.class){
                    message = new Message("Henchmen", "null", ((Henchmen) data).getMana(), ((Henchmen) data).getAttack());
                    client.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Henchmen) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Spell.class){
                    message = new Message("Spell", ((Spell) data).getAction(), ((Spell) data).getMana(),0);
                    client.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Spell) data).getMana());
                    setMyTurn(false);
                }

            }
            if(type == "server"){
                if(data.getClass() == Secret.class){
                    message = new Message("Secret", ((Secret) data).getAction(), ((Secret) data).getMana(), 0);
                    server.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Secret) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Henchmen.class){
                    message = new Message("Henchmen", null, ((Henchmen) data).getMana(), ((Henchmen) data).getAttack());
                    server.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Henchmen) data).getMana());
                    setMyTurn(false);
                }
                if(data.getClass() == Spell.class){
                    message = new Message("Spell", ((Spell) data).getAction(), ((Spell) data).getMana(),0);
                    server.SendMessage(json.toJson(message));
                    Action_send(message.getAction());
                    setMana(((Spell) data).getMana());
                    setMyTurn(false);
                }
        }
    }
    public void update_cards(){
        containermanocartas.getChildren().clear();
        for(int i = 1; this.Mass.size()>=i; i++){
            Object data = this.Mass.Data_find(i);
            if(data.getClass() == Spell.class){
                Image carta1 = new Image(((Spell) data).getRute()+".jpg");
                ImageView View1 = new ImageView(carta1);
                containermanocartas.getChildren().add(View1);
            }
            if(data.getClass() == Henchmen.class){
                Image carta1 = new Image(((Henchmen) data).getRute()+".jpg");
                ImageView View1 = new ImageView(carta1);
                containermanocartas.getChildren().add(View1);
            }
            if(data.getClass() == Secret.class){
                Image carta1 = new Image(((Secret) data).getRute()+".jpg");
                ImageView View1 = new ImageView(carta1);
                containermanocartas.getChildren().add(View1);
            }
        }
    }
    public void setMana(int mana){
        this.mana -= mana;
        this.f_mana = this.mana/1000;
        this.containerMana.getChildren().remove(BarMana);
        this.BarMana = new ProgressBar(f_mana);
        this.BarMana.setMinWidth(500);
        this.containerMana.getChildren().add(BarMana);
        containerMana.setPrefWidth(200);
        containerMana.setAlignment(Pos.CENTER);
    }
    public void setDamage(int damage){
        if((this.life-(damage))<=1000){
            System.out.println("IF " + this.type);
            this.life -= damage;
            this.f_life = this.life/1000;
            this.containerVida.getChildren().remove(BarVida);
            this.BarVida = new ProgressBar(f_life);
            this.BarVida.setMinWidth(500);
            this.containerVida.getChildren().add(BarVida);
            containerVida.setPrefWidth(200);
            containerVida.setAlignment(Pos.TOP_LEFT);
        }else{
            System.out.println("Else");
            this.life = 1000;
            this.f_life = this.life/1000;
            this.containerVida.getChildren().remove(BarVida);
            this.BarVida = new ProgressBar(f_life);
            this.BarVida.setMinWidth(500);
            this.containerVida.getChildren().add(BarVida);
            containerVida.setPrefWidth(200);
            containerVida.setAlignment(Pos.TOP_LEFT);
        }


    }
    public void receive_message(){
        while (isActive()){
            Json json = new Json();
            if(type.equals("client")) {
                if (this.client.getInMessage() != null) {
                    this.Inmessage = this.client.getInMessage();
                    this.client.setInMessage(null);
                }
            }
            if(type.equals("server")){
                if(this.server.getInMessage() != null) {
                    this.Inmessage = this.server.getInMessage();
                    this.server.setInMessage(null);
                }
            }
            if(Inmessage!=null){
                System.out.println(Inmessage);
                try{
                    JsonNode node = json.parsing(Inmessage);
                    Message message = new Message(node.get("type").textValue(),node.get("action").asText(), node.get("mana").asInt(), node.get("attack").asInt());
                    Action_received(message.getAction(), message.getAttack());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                this.Inmessage = null;
                setMyTurn(true);
            }
        }
    }
    public boolean isMyTurn() {
        return isMyTurn;
    }
    public void setMyTurn(boolean myTurn) {
        this.isMyTurn = myTurn;
    }
}
