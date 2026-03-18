public class StackDemo {

    // This class is used to demonstrate the functionality of the IntStack code
    public static void main(String[] args) {
        IntStack stack = new IntStack();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.print("Stack after pushes: ");
        stack.printStack();

        int removed = stack.pop();
        System.out.println("Popped value: " + removed);

        System.out.println("Current top (peek): " + stack.peek());
        System.out.println("Current size: " + stack.size());
        System.out.println("Average of stack elements: " + stack.average());
    }
}