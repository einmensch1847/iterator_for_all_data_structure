package ARRAY;

import java.util.NoSuchElementException;

public class ArrayIterator {
    private int currentIndex = 0;

    public boolean hasNext() {
        return currentIndex < Array.m_size;
    }

    public float next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the array");
        }
        return Array.m_data[currentIndex++];
    }
}