import java.util.Arrays;

public class MyQueue {
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] objects = new Object[DEFAULT_CAPACITY];
    private int size = 0;


    public void add(Object value) {
        if (objects.length == size) {
            int newCapacity = (int) (objects.length * 1.5 + 1);
            objects = Arrays.copyOf(objects, newCapacity);
        }
        objects[size++] = value;

    }

    public Object remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("Not correct index");
        }
        Object o = objects[index];
        System.arraycopy(objects, index + 1, objects, index, size - index - 1);
        return o;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return size > 0 ? objects[0] : null;
    }

    public Object poll() {
        Object o = objects[0];
        System.arraycopy(objects, 1, objects, 0, --size);
        return o;
    }
}

