package 队列;

import 数组.Array;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;
    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
    }
    public ArrayQueue() {
        array = new Array<E>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + array +
                '}';
    }
}

