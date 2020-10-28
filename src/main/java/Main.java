import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        DoubleCircularList b = new DoubleCircularList();
        b.insertFirst(1);
        b.insertFirst(2);
        b.insertFirst(3);
        Node node = new Node(8);

        Json a = new Json();

        String json = a.toJson(node);
        System.out.println(json);
        System.out.println(a.parse(json, Node.class));
    }
}
