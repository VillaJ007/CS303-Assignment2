import java.util.NoSuchElementException;

// This class supports the use of a basic singly linked list using head tail and size

public class SingleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Private static inner Node class
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // PRE: item can be any value even null
    // POST: item is addded to the front of the list and size is increased by 1
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // PRE: item can be any value
    // POST: item is added to the end of the list and size increased by 1
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // PRE: list should not be empty
    // POST: removes and returns the first element and descreases size by 1, if list becomes empty set head/tail null
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty .");
        }
        T removedData = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }
        return removedData;
    }

    // PRE: list should not be empty
    // POST: remove and return the last element and descrease size and update the tail
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            T removedData = head.data;
            head = tail = null;
            size = 0;
            return removedData;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T removedData = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return removedData;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // PRE: index can be any int
    // POST: item is inserted at the given index
    public void insert(int index, T item) {
        if (index <= 0) { // insert at front for indexes 0 or less
            addFirst(item);
            return;
        }
        if (index >= size) { // insert at the end for indexes greater than size of list
            addLast(item);
            return;
        }
        Node<T> newNode = new Node<>(item);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // PRE: index should be between size of list -1 and 0
    // Post: if index is valid remove the element and decrease size, return false otherwise
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (index == 0) {
            removeFirst();
            return true;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        if (current.next == tail) {
            tail = current;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    // PRE: item can be any value
    // POST: returns index once item is found, return size if not found
    public int find(T item) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((item == null && current.data == null) ||
                (item != null && item.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return size;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}
