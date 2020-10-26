public class Main {
    public static void main(String[] args) {
        DoubleLinkedList N = new DoubleLinkedList();
        N.deleteFirst();
        N.deleteEnd();
        System.out.println("SIZE "+ N.size());
        N.displayList();
    }
}
