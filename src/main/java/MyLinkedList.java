import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class MyLinkedList {

    private int size = 0;
    private Node first;
    private Node last;

    public void add(Object value) {
        Node node = new Node();
        node.item = value;

        if (size == 0) {
            first = node;
            last = node;
        }
        else {
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    public Object remove(int index) {
        Node nodeToRemove = getNode(index);
        Node prevNode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return nodeToRemove.item;
    }

    public void clear() {
       Node node = first;

        for (int i = 0; i < size - 1; i++) {
            node = node.next;
            Node prevNode = node.prev;
            prevNode.next = null;
            prevNode.item = null;
            prevNode.prev = null;
        }
        node.next = null;
        node.item = null;
        node.prev = null;
       first = null;
       last = null;
       size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return getNode(index).item;
    }

    private Node getNode(int index) {
        if(index < 0 || index > size - 1) {
            throw new RuntimeException("Not correct index");
        }

        if( index == 0 ) {
            return first;
        }
        Node node = first;
        for(int i = 1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + MyLinkedList.Node.getItem() +
                '}';
    }
    private static class Node {
        static Object item;
        Node next;
        Node prev;

        public static Object getItem() {
            return item;
        }
    }
}
