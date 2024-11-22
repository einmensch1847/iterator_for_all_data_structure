package VECTORS;

import java.util.NoSuchElementException;

public class VectorIterator {
    private int currentIndex = 0;

    public boolean hasNext() {
        return currentIndex < Vectors.size;
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the vector");
        }
        return Vectors.data[currentIndex++];
    }
}