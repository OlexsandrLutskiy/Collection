public class MyHashMap {
    private int size = 0;
    private Node first;


    public void put(Object key, Object value) {
        if (size == 0) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            first = newNode;
            size++;
            return;
        }
        Node node = null;
        while (node == null || node.next != null) {
            node = node == null ? first : node.next;

            if (node != null && node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        node.next = newNode;
        size++;
    }

    public Object remove(Object key) {
        if (size == 0) {
            return null;
        }
        if (first.key.equals(key)) {
            Node next = first.next;
            Object value = first.value;
            first.next = null;
            first.key = null;
            first.value = null;
            first = next;
            return value;
        }
        Node node = first;

        while (node != null) {
            Node next = node.next;
            if (next != null && next.key.equals(key)) {
                node.next = next.next;
                Object value = next.value;
                next.key = null;
                next.value = null;
                next.next = null;
                size--;
                return value;
            }
            node = node.next;
        }
        return null;
    }

    public void clear() {
        Node node = first;
        while (node != null) {
            Node nextNode = node.next;
            node.value = null;
            node.key = null;
            node.next = null;
            node = nextNode;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        Node node = first;

        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private static class Node {
        Object value;
        Object key;
        Node next;
    }
}

