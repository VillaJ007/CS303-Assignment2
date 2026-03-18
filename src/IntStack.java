import java.util.ArrayList;
import java.util.EmptyStackException;

// This class utilizes the ArrayList data structure to manipulate a stack of integers

public class IntStack {
    private ArrayList<Integer> list;

    public IntStack() {
        list = new ArrayList<>();
    }

    // PRE: value is any integer
    // POST: value is added to the top of the stack
    public void push(int value) {
        list.add(value);
    }

    // PRE: stack should not be empty
    // PSOT: removes and returns the top element fo the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    // PRE: stack should not be empty
    // POST: return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    // PRE: stack should not be empty
    // POST: return the avg of all elements in the stack
    public double average() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int sum = 0;
        for (int value : list) {
            sum += value;
        }
        return (double) sum / list.size();
    }

    public void printStack() {
        System.out.println(list);
    }
}
