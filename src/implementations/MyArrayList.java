package implementations;

import interfaces.MyList;

public class MyArrayList<T> implements MyList<T> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    private void resize() { //increases the array size by 2 times
        Object[] newArr = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
    }

    @Override
    public void add(T element) { //adds an element to the end of the list
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    @Override
    public void add(int index, T element) { //inserts an element at the specified index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == elements.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (T) elements[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T removed = (T) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}