import java.util.Arrays;

public class MyArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    public Object[] getObjects() {
        return objects;
    }

    public void add(Object value) {
        if(objects.length == size) {
            int newCapacity = (int) (objects.length * 1.5 + 1);
            objects = Arrays.copyOf(objects, newCapacity);
        }
        objects[size++] = value;
    }

    public Object remove(int index) {
        if(index < 0 || index > size - 1) {
            throw new RuntimeException("Not correct index");
        }
        Object o = objects[index];
        System.arraycopy(objects, index + 1, objects, index, size - index - 1);
        objects[size - 1] = null;
        size--;
        return o;
    }

    public void clear() {
        for(int i = 0; i < size; i++) {
            objects[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

   public Object get(int index) {
       return objects[index];
   }
 }
