public class MyLinkedList<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public void add(E value) {
        Node<E> node = new Node();
        node.item = value;

        if (size == 0) {
            first = node;
            last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    public E remove(int index) {
        Node<E> nodeToRemove = getNode(index);

        if (index == 0) {
            Node<E> nextNode = nodeToRemove.next;
            nextNode.prev = null;
        }
        if (index == size - 1) {
            Node<E> prevNode = nodeToRemove.prev;
            prevNode.next = null;
        } else {
            Node<E> prevNode = nodeToRemove.prev;
            Node<E> nextNode = nodeToRemove.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return nodeToRemove.item;
    }

    public void clear() {
        Node<E> node = first;

        for (int i = 0; i < size - 1; i++) {
            node = node.next;
            Node<E> prevNode = node.prev;
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

    public E get(int index) {
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("Not correct index");
        }

        if (index == 0) {
            return first;
        }
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

    }
}
