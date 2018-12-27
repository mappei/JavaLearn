package list;

import java.io.Serializable;
import java.util.*;

public class ArrayList extends AbstractList implements List, Cloneable, RandomAccess, Serializable {

    private Object[] elementData;
    //数组中元素的个数
    private int size;
    private int modCount;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;

    //
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegal initialCapacity: " + initialCapacity);
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
        this.elementData = new Object[initialCapacity];
    }

    public ArrayList(Collection collection) {
        this.elementData = collection.toArray();
        if (elementData.length == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    //元素个数
    public int size() {
        return size;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    //返回之前的元素
    public Object set(int index, Object obj) {
        rangeCheck(index);
        Object old = elementData[index];
        elementData[index] = obj;
        return old;
    }

    //Add   添加完元素之后，size+1
    public boolean add(Object obj) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = obj;
        return true;
    }

    public void add(int index, Object obj) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = obj;
        size++;
    }

    public boolean addAll(int index, Collection collection) {
        rangeCheckForAdd(index);
        int increse = collection.size();
        ensureCapacityInternal(size + increse);
        //移动原数组index之后的元素
        if (size - index > 0)//!!!!!!!!!!!!!!!!!
            System.arraycopy(elementData, index, elementData, index + increse, size - index);
        //向列表中添加新的Collection
        System.arraycopy(collection.toArray(), 0, elementData, index, increse);
        //修改size长度!!!!!!!!!!!!!!!!!!!!!!
        size += increse;
        return true;
    }

    public boolean addAll(Collection collection) {
        int increse = collection.size();
        ensureCapacityInternal(increse + size);
        System.arraycopy(collection.toArray(), 0, elementData, size, increse);
        size += increse;
        return true;
    }
//--------------------------------------
    public boolean removeAll(Collection collection) {
        Object[] array = collection.toArray();
        int count = 0;
        if (array.length > 0) {
            for (int i = 0; i < size; i++) {
                if (collection.contains(elementData[i])) {
                    if (size - i - 1 > 0) {
                        elementData[i] = null;
                        count++;
                        modCount++;
                        System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                        return true;
                    }
                }
            }
            size -= count;
        }
        return false;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        if (newCapacity > MAX_ARRAY_SIZE)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalArgumentException();
        }
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    public Object remove(int index) {
        rangeCheck(index);
        //!!!!!!!!!!!!!!!!!!
        modCount++;
        Object moveElemetn = elementData[index];
        int move = size - index - 1;
        //避免删除最后一个，move == 0
        if (move > 0)
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size - 1] = null;
        size--;
        return moveElemetn;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
    }

    //只删除第一次出现的对象
    public boolean remove(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
        } else {
            for (int i = size; i >= 0; i--)
                if (obj.equals(elementData[i])) {
                    fastRemove(i);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int move = size - index - 1;
        if (move > 0)
            System.arraycopy(elementData, index + 1, elementData, index, move);
        elementData[--size] = null;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (obj.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (obj.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

}
