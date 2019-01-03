package list;

import java.util.Arrays;
import java.util.ListIterator;

/**
 * 双链表
 */
public class LinkedList {

    public Node first;
    public Node last;
    private int size;
    private int modCount;

    private static class Node {
        public Node prev;
        public Node next;
        public Object data;

        public Node(Node prev, Object data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedList() {
        first = last = null;
        size = 0;
    }

    public LinkedList(LinkedList list) {
        addAll(size, list);
    }

    public void addAll(int index, LinkedList list) {
        checkIndexGT(index);
        if (list.size == 0) {
            return;
        }

        if (index == size) {
            final Node prev = last;
            Node newNode = new Node(list.getNode(list.size - 1), list.get(list.size - 1), null);
            last = newNode;
            if (prev == null) {
                first = list.getNode(0);
                first.prev = null;
            } else {
                prev.next = list.getNode(0);
            }
        } else {
            Node current = getNode(index);
            Node prev = current.prev;
            if (prev == null) {
                this.first = list.first;
                list.getNode(list.size - 1).next = current;
                current.prev = list.getNode(list.size - 1);
            } else {
                Node last = list.getNode(list.size - 1);
                Node first = list.getNode(0);
                first.prev = prev;
                last.next = current;
                prev.next = first;
                current.prev = last;
            }
        }

        list.first = null;
        list.last = null;
        size += list.size;
        modCount++;
    }

    public void add(Object obj) {
        addLast(obj);
    }

    public void add(int index, Object obj) {
        checkIndexGT(index);
        if (index == size) {
            add(obj);
        } else {
            addBefore(obj, getNode(index));
        }
    }

    public void remove(int index) {
        checkIndexGE(index);
        Node removeNode = getNode(index);
        Node prev = removeNode.prev;
        Node next = removeNode.next;
        if (prev == null)
            first = next;
        else if (next == null)
            last = prev;
        else {
            prev.next = next;
            next.prev = prev;
        }
        //释放被删除的结点，同时将被删除结点的连接释放
        //help GC
        removeNode.data = null;
        removeNode.prev = null;
        removeNode.next = null;
        size--;
        modCount++;
        modCount++;
    }

    private void addBefore(Object obj, Node current) {
        Node prev = current.prev;
        Node newNode = new Node(prev, obj, current);
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        current.prev = newNode;
        size++;
        modCount++;

    }

    private void addLast(Object obj) {
        Node l = last;
        Node newNode = new Node(l, obj, null);
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        last = newNode;
        size++;
        modCount++;
    }

    public void chengeItemPosition(int index) {
        Node nodePrev = getNode(index);
        if (size == 2) {
            first = last;
            first.next = last.prev;
            first.prev = null;
            last = nodePrev;
            last.next = null;
            last.prev = first;
        } else if (index == 0) {
            Node node = getNode(1);
            first.next = getNode(2);
            first.prev = node;
            node.next = first;
            node.prev = null;
            first = node;
        } else if (index == size - 2) {
        } else {
        }
    }

    private void checkIndexGT(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    public Integer size() {
        return size;
    }

    public Object get(int index) {
        checkIndexGE(index);
        return getNode(index).data;
    }

    public Object set(int index, Object obj) {
        checkIndexGE(index);
        Node old = getNode(index);
        Object oldItem = old.data;
        old.data = obj;
        return oldItem;
    }

    private void checkIndexGE(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    public void removeFirst() {
        Node f = first.next;
        first.data = null;
        first.next = null;
        first = f;
        if (f == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        modCount++;
    }

    Node getNode(int index) {
        checkIndexGT(index);
        if (index < size >> 1) {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = get(i);
        }
        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        /*LinkedList list = new LinkedList();
        list.add(13);
        list.add(131);
        list.add(1311);
        list.add(0, 2222);
        System.out.println(list.toString());
        System.out.println("size : " + (list.size()));
        list.remove(3);
        list.add(333);
        System.out.println(list.toString());
        System.out.println("size : " + (list.size()));*/


        /*LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        LinkedList list2 = new LinkedList();
        list2.add(222);
        list1.addAll(3, list2);
        System.out.println("size : " + (list1.size()));
        System.out.println(list1.toString());*/

        /*java.util.LinkedList list1 = new java.util.LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);*/
        /*java.util.LinkedList list2 = new java.util.LinkedList();
        list2.add(222);
        list1.addAll(1, list2);
        System.out.println(list1);*/
        /*ListIterator listIterator = list1.listIterator();
        listIterator.remove();*/

        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        System.out.println(list1.toString());
        list1.chengeItemPosition(0);
        System.out.println(list1.toString());

    }

}
