package structures;

import implementations.MyArrayList;

public class MyMinHeap<T extends Comparable<T>> {

    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T value) { //adds an element to the heap and moves it up
        heap.add(value);
        siftUp(heap.size() - 1); //moves the element up if it is smaller than its parent
    }

    public T removeMin() {
        if (heap.size() == 0) {
            throw new RuntimeException("Heap is empty");
        }

        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.add(0, last);
            heap.remove(1);
            siftDown(0);
        }

        return min;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index).compareTo(heap.get(parent)) >= 0) {
                break;
            }

            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.remove(i + 1);

        heap.add(j, temp);
        heap.remove(j + 1);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}