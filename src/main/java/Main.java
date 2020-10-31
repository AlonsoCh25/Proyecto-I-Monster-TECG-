import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args){
        //Inicia el servidor
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
        while (isActive){
            //El cliente envia un mensaje
            Client.SendMessage("HOLA SERVIDOR");
            //El servidor envia un mensaje
            Server.SendMessage("hola cliente");
            isActive = false;
        }
        //Se cierran los servicios
        Client.setClientActive(false);
        Server.setServerActive(false);
    }
}
