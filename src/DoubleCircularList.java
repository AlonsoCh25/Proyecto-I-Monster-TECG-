public class DoubleCircularList {
    private Node head;
    private int size;
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null;
    }
    public int size() {
        return this.size;
    }
    public void insertFirst(Object data) {
        Node newNode = new Node(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }
    public void insertEnd(Object data) {
        Node newNode = new Node(data);
        Node temp = this.head;
        boolean A = true;
        while(A){
            if (temp.getNext() == null){
                temp.setNext(newNode);
                newNode.setNext(null);
                this.size ++;
                A = false;
            }
            else{
                temp = temp.getNext();
            }

        }
    }
    public Node deleteFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.getNext();
            this.size--;
            return temp;
        } else {
            return null;
        }
    }
    public Node deleteEnd() {
        boolean A = true;
        Node temp = this.head;
        Node previous = this.head;
        while(A){
            if (temp.getNext() == null){
                previous.setNext(null);
                this.size--;
                A = false;
            }
            if (temp.getNext() != null){
                if(temp == previous){
                    temp = temp.getNext();
                }
                else{
                    previous = temp;
                    temp = temp.getNext();
                }
            }
        }

        return null;
    }
    public void displayList() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    public Node find(Object searchValue) {
        Node current = this.head;
        while (current != null) {
            if (current.getData().equals(searchValue)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }
    public Node delete(Object searchValue) {
        Node current = this.head;
        Node previous = this.head;
        while (current != null) {
            if (current.getData().equals(searchValue)) {
                if (current == this.head) {
                    this.head = this.head.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return current;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return null;
    }

}
