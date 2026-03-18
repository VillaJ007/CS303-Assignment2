// This class demonstrates the functionality of the SingleLinkedList code

public class LinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        System.out.println("List empty? " + list.isEmpty());

        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        list.addLast("D");

        System.out.print("After addFirst/addLast: ");
        list.printList();

        System.out.println("First item: " + list.getFirst());
        System.out.println("Last item: " + list.getLast());

        list.insert(2, "X");
        System.out.print("After insert at index 2: ");
        list.printList();

        System.out.println("Index of X: " + list.find("X"));
        System.out.println("Index of Z (not found): " + list.find("Z"));

        System.out.println("Removed first: " + list.removeFirst());
        System.out.print("After removeFirst: ");
        list.printList();

        System.out.println("Removed last: " + list.removeLast());
        System.out.print("After removeLast: ");
        list.printList();

        System.out.println("Remove index 1 successful? " + list.remove(1));
        System.out.print("After remove index 1: ");
        list.printList();

        System.out.println("Current size: " + list.size());
    }
}