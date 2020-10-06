package com.hw.homeworks.hw4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int index = 0;

    public ArrayIterator(T[] array){
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return array[index++];
    }

    public static void main(String[] args) {
        Integer[] array1 = {7, 3, 6, 12};
        ArrayIterator<Integer> arrIt1 = new ArrayIterator<>(array1);

        System.out.println(arrIt1.next());
    }
}
