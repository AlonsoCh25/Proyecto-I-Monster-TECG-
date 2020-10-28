public class Main {
    public static void main(String[] args) throws Exception {
        int size = 9;
        Stack s = new Stack(size);
        for(int i = 1; i<size; i+=1){
            s.push(i);
        }
        for(int i = 1; i<size; i+=1){
            System.out.println(s.pop());
        }
    }
}
