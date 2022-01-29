public class Main {
    public static void main(String[] args) {

        MyStack<String> myStack = new MyStack<>();

        myStack.push("first");
        myStack.push("second");
        myStack.push("third");
        myStack.push("forth");


        myStack.all();
        System.out.println(myStack.size());

        myStack.delete(0);
        myStack.all();
        System.out.println(myStack.size());
    }
}
