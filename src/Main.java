public class Main {
    public static void main(String[] args) {

//        MyStack<String> myStack = new MyStack<>();
//
//        myStack.push("first");
//        myStack.push("second");
//        myStack.push("third");
//        myStack.push("forth");
//        myStack.push("fifth");
//
//
//        myStack.all();
//        System.out.println(myStack.size());
//
//        myStack.delete(0);
//        myStack.all();
//        System.out.println(myStack.size());
//
//        System.out.println(myStack.find(myStack, "second"));



        DoubleNodeQueue<String> doubleNodeQueue = new DoubleNodeQueue<>();

        doubleNodeQueue.addFirst("the first one");
        doubleNodeQueue.addLast("the last one");
        doubleNodeQueue.addFirst("the previous one");
        doubleNodeQueue.addFirst("the ancient one");
        doubleNodeQueue.addLast("the end");
        doubleNodeQueue.addFirst("ancestor");
        doubleNodeQueue.all();
        System.out.println();
        doubleNodeQueue.removeFirst();
        doubleNodeQueue.all();
        System.out.println();
        doubleNodeQueue.removeLast();
        doubleNodeQueue.all();
        System.out.println(doubleNodeQueue.size());
        System.out.println();
        doubleNodeQueue.delete(3);
        doubleNodeQueue.all();
        System.out.println();
        doubleNodeQueue.insertBefore(doubleNodeQueue, "insert_before", 0);
        doubleNodeQueue.all();
        System.out.println();
        doubleNodeQueue.insertAfter(doubleNodeQueue, "insert_after", 3);
        doubleNodeQueue.all();
        System.out.println();
    }
}
