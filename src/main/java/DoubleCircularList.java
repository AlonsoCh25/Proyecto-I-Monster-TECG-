public class DoubleCircularList {
    private Node head;
    private Node last;
    private int size;
    public DoubleCircularList() {
        this.head = null;
        this.last = null;
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
        if(isEmpty()){
            this.head = newNode;
            newNode.setNext(this.head);
            newNode.setPrevious(last);
            this.last = newNode;
            this.size++;
        }else{
            this.last.setNext(newNode);
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            newNode.setPrevious(this.last);
            this.head = newNode;
            this.size++;
        }
    }
    public void insertEnd(Object data) {
        Node newNode = new Node(data);
        this.head.setPrevious(newNode);
        newNode.setPrevious(this.last);
        this.last.setNext(newNode);
        newNode.setNext(this.head);
        this.last = newNode;
    }
    public void deleteFirst(){
        if(isEmpty() == false) {
            if (this.head == this.last) {
                this.head = null;
                this.last = null;
                this.size = 0;
            } else {
                Node temp = this.head;
                this.head = temp.getNext();
                this.head.setPrevious(temp.getPrevious());
                this.last.setNext(this.head);
                this.size--;
            }
        }
    }
    public void deleteEnd(){
        if(isEmpty() == false){
            if(this.head == this.last){
                this.head = null;
                this.last = null;
                this.size = 0;
            }else{
                Node temp = this.last;
                this.last = temp.getPrevious();
                this.head.setPrevious(temp.getPrevious());
                this.last.setNext(this.head);
                this.size--;
            }
        }
    }
    public void displayList() {
        Node current = this.head;
        if(size() > 1){
            for (int i = 1; i <= size(); i += 1) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }else{
            if(size() == 1){
                System.out.println(current.getData());
            }else{
                System.out.println("Empty");
            }
        }

    }
    public Node find(Object searchValue) {
        Node current = this.head;
        for (int i = 1; i <= size(); i += 1) {
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
        for (int i = 1; i <= size(); i += 1) {
            if (current.getData().equals(searchValue)) {
                if (current == this.head) {
                    if(this.head.getNext() == this.head){
                        this.head = null;
                        this.last = null;
                        this.size = 0;
                    }else{
                        Node temp = this.head;
                        this.head = temp.getNext();
                        this.head.setPrevious(temp.getPrevious());
                        this.last.setNext(this.head);
                        this.size--;
                    }
                } else {
                    if(current.getNext() == this.head){
                        Node temp = this.last;
                        this.last = temp.getPrevious();
                        this.head.setPrevious(temp.getPrevious());
                        this.last.setNext(this.head);
                        this.size--;
                    }else{
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                        this.size--;
                    }
                }
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

}