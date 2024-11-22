package VECTORS;

import java.util.*;

public class Vectors {
    public static int[] data ;
    public static int size ;
    public static final int INITIAL_CAPACITY = 10;
    public static void vectors(){
        data = new int[INITIAL_CAPACITY];
        size = 0;
        Add(10);
        Add(20);
        Add(30);
        Add(40);
        Print();
        Randomize_Elements();
        Print();
        System.out.println("element at index 1 : "+Get(1));
        System.out.println("element at index 2 : "+Get(2));
        Remove(3);
        Print();
        System.out.println(Size());

        System.out.println("Iterating using Custom Iterator:");
        VectorIterator iterator = new VectorIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

//*****************************************************************************

    public static void Add(int value){
        ensureCapacity();
        data[size++] = value;
    }

//*****************************************************************************

    public static void Randomize_Elements(){
        Random random = new Random();
        for(int i = 0 ; i < size ; i++){
            data[i] = random.nextInt(100);
        }
    }

//*****************************************************************************

    public static void Remove(int index){
        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for(int i = index ; i < size - 1 ; i++ ){
            data[i] = data[i+1];
        }
        size-- ;
    }

//*****************************************************************************

    public static int Get(int index){
        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

//*****************************************************************************

    public static void ensureCapacity(){
        if(size == data.length){
            int[] newData = new int[data.length * 2];
            for(int i = 0 ; i < data.length ; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
    }

//*****************************************************************************

    public static int Size(){
        return size;
    }

//*****************************************************************************

    public static void Print(){
        System.out.print("[");
        for(int i = 0 ; i < size ; i++){
            System.out.print(data[i]);
            if(i < size - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

//*****************************************************************************

}
