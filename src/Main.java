import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        //Inicia el servidor
        Json json = new Json();
        Server Server = new Server();
        Thread server = new Thread(Server);
        server.start();
        //Inicia el cliente
        Client Client = new Client("127.0.0.1", Server.getPort());
        Thread client = new Thread(Client);
        client.start();
        boolean isActive = false;
        while (isActive == false){
            if (Server.getServer() != null){
                if(Server.getClient() != null){
                    isActive = true;
                }
            }
        }
        Message message = new Message("Prueba", "No haga nada");
        String mesa = json.toJson(message);
        JsonNode ne = json.parsing(mesa);
        System.out.println(ne.get("type"));
        while (isActive){
            //El cliente envia un mensaje
            Client.SendMessage("HOLA SERVIDOR " + mesa);
            //El servidor envia un mensaje
            Server.SendMessage("hola cliente " + mesa);
            isActive = false;
        }
        //Se cierran los servicios
        Client.setClientActive(false);
        Server.setServerActive(false);
    }
}
