import implementations.MyArrayList;
import implementations.MyLinkedList;
import structures.MyStack;
import structures.MyQueue;
import structures.MyMinHeap;

public class Main {
    public static void main(String[] args) {

        // 🔹 ArrayList
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("ArrayList:");
        System.out.println(list.get(1)); // 20
        list.remove(1);
        System.out.println(list.get(1)); // 30
        System.out.println("Size: " + list.size());


        // 🔹 LinkedList
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println("\nLinkedList:");
        System.out.println(list2.get(1)); // 2
        list2.remove(1);
        System.out.println(list2.get(1)); // 3


        // 🔹 Stack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nStack:");
        System.out.println(stack.peek()); // 30
        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20


        // 🔹 Queue
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("\nQueue:");
        System.out.println(queue.peek());    // 1
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2


        // 🔹 MinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);

        System.out.println("\nMinHeap:");
        System.out.println(heap.removeMin()); // 1
        System.out.println(heap.removeMin()); // 2
        System.out.println(heap.removeMin()); // 5
    }
}