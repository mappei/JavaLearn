package list;

import java.util.Arrays;

/**
 * 单链表
 */
public class SimpleLinkedList {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Node next;
        Object item;

        Node(Object item, Node next) {
            this.next = next;
            this.item = item;
        }
    }

    public void add(Object obj) {
        Node l = last;
        Node newNode = new Node(obj, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * 改变相邻结点位置
     *
     * @param index 首结点下标
     */
    public void chengeItemPosition(int index) {
        Node nodePrev = getNode(index);
        Node nodeNext = getNode(index + 1);
        if (nodeNext == null || nodePrev == null)
            return;
        if (size == 2){
            first = nodeNext;
            first.next = nodePrev;
            nodePrev.next = null;
        } else if (index == 0) {
            first.next = getNode(index + 2);
            nodeNext.next = first;
            first = nodeNext;
        } else if (index == size - 2) {
            Node prev = getNode(index - 1);
            prev.next = nodeNext;
            nodeNext.next = nodePrev;
            nodePrev.next = last;
        } else {
            nodePrev.next = getNode(index + 2);
            nodeNext.next = nodePrev;
            Node prev = getNode(index - 1);
            prev.next = nodeNext;
        }
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node f = this.first;
        if (f == null)
            return null;
        for (int i = 0; i < index; i++) {
            f = f.next;
        }
        return f;
    }

    private void checkIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {
        Object[] obj = new Object[size];
        Node f = first;
        for (int i = 0; i < size; i++) {
            if (f == null){
                break;
            }
            obj[i] = f.item;
            f = f.next;
        }
        return Arrays.toString(obj);
    }
}
