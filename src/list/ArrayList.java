package list;

import java.util.Arrays;
import java.util.Collection;

public class ArrayList {

    private Object[] elementData;
    private int size;
    private int modCount;

    public static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    public static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;

    //
    public ArrayList() { this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegal initialCapacity: " + initialCapacity);
        } else if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }
        this.elementData = new Object[initialCapacity];
    }

    public ArrayList(Collection collection){
        this.elementData = collection.toArray();
        if(elementData.length == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

    public boolean add(Object obj) {


        return true;
    }

    public void add(int index, Object obj){

    }

    public int indexOf(Object obj){
        for(int i=0; i<){

        }
        return
    }

}
