package ARRAY;

import java.util.Random;

public class Array {
    public static float[] m_data;
    public static int m_size;
    public static int m_capacity;
    public static void array() {
        init(5);

        System.out.println("Initial array:");
        Print();

        insert(2, 20);
        System.out.println("After insert at index 2:");
        Print();

        set(1, 15);
        System.out.println("After setting value at index 1:");
        Print();

        remove(3);
        System.out.println("After removing element at index 3:");
        Print();

        System.out.println("Element at index 2: " + at(2));

        System.out.println("Index of value 20: " + find(20));

        System.out.println("Max value: " + max());
        System.out.println("Min value: " + min());

        System.out.println("Size of array: " + size());

        System.out.println("Iterating over array using custom iterator:");
        ArrayIterator iterator = new ArrayIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

//*****************************************************************************

    public static void init(int size) {
        m_data = new float[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            m_data[i] = random.nextFloat() * 10;
        }
        m_size = size;
        m_capacity = size;
    }

//*****************************************************************************

    public static void insert(int index, float value) {
        validateIndex(index, true);
        if (m_size == m_capacity) {
            float[] newdata = new float[m_capacity + 1];
            for (int i = 0; i < m_size; i++) {
                if (i < index)
                    newdata[i] = m_data[i];
                else
                    newdata[i + 1] = m_data[i];
            }
            newdata[index] = value;
            m_data = newdata;
            m_capacity++;
        }
        m_size++;
    }

//*****************************************************************************

    public static void remove(int index) {
        validateIndex(index, false);
        for (int i = index; i < m_size - 1; i++) {
            m_data[i] = m_data[i + 1];
        }
        m_size--;
        m_data[m_size] = 0;
    }

//*****************************************************************************

    public static float set(int index, float value) {
        validateIndex(index, false);
        float oldValue = m_data[index];
        m_data[index] = value;
        return oldValue;
    }

//*****************************************************************************

    public static float at(int index) {
        validateIndex(index, false);
        return m_data[index];
    }

//*****************************************************************************

    public static long find(float value) {
        for (int i = 0; i < m_size; i++) {
            if (m_data[i] == value) {
                return i;
            }
        }
        return -1;
    }

//*****************************************************************************

    public static float max() {
        if (m_size == 0) {
            throw new IllegalArgumentException("ARRAY.Array is empty");
        }
        float max = m_data[0];
        for (int i = 1; i < m_size; i++) {
            if (m_data[i] > max) {
                max = m_data[i];
            }
        }
        return max;
    }

//*****************************************************************************

    public static float min() {
        if (m_size == 0) {
            throw new IllegalArgumentException("ARRAY.Array is empty");
        }
        float min = m_data[0];
        for (int i = 1; i < m_size; i++) {
            if (m_data[i] < min) {
                min = m_data[i];
            }
        }
        return min;
    }

//*****************************************************************************

    public static int size() {
        return m_size;
    }

//*****************************************************************************

    private static void validateIndex(int index, boolean insertCall) {
        if ((insertCall && index > m_size) || index >= m_size) {
            throw new IllegalArgumentException("Invalid Index");
        }
    }

//*****************************************************************************

    public static void Print(){
        System.out.print("[");
        for(int i = 0 ; i < m_size ; i++){
            System.out.print(m_data[i]);
            if(i < m_size - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

//*****************************************************************************

}
