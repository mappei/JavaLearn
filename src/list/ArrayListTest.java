package list;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        /*ArrayList list = new ArrayList();
        //ArrayList list = new ArrayList();
        list.add("hbjnkml,;n");
        list.remove(-32);*/

        //remove
       /* ArrayList list = new ArrayList();
        list.add(12);
        list.add(1111);
        list.add(343);
        list.add(24324);
        list.add(343);
        //Object afdsa = list.set(2, "afdsa");
        ArrayList remove = new ArrayList();
        remove.add(343);
        list.removeAll(remove);

        java.util.ArrayList listUtil = new java.util.ArrayList();
        listUtil.add(12);
        listUtil.add(2343);
        listUtil.add(343);
        listUtil.add(222);
        Object asaf = listUtil.set(2, "asaf");

        //System.out.println(afdsa.toString());
        System.out.println(list.toString());
        System.out.println(list.size());*/

        //ArrayList 和 linkedList 做插入删除的速度比较
        //1. Add(E e): 两者用时几乎一样，甚至ArrayList要快于LinkedList,
        // 因为增加数组只在最后插入数据长度+1，没有任何元素位移；链表操作需要修改指针的只想需要花费时间
        //2. Add(int index, E e): 链表的插入操作要快于数组的操作
        //因为当列表中数据很多的情况下，从中间插入数据，链表只需要修改引用的只想，而数组后面的元素都要发生位置移动从而时间慢
        /*LinkedList<Integer> link = new LinkedList<>();
        for (int i = 1; i < 10000000; i++) {
            link.add(i);
        }
        long linkBefore = System.currentTimeMillis();
        for (int i = 1; i < 1000; i++) {
            link.add(5002,1);
        }
        long linkAfter = System.currentTimeMillis();
        System.out.println("link:" + (linkAfter - linkBefore));


        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i < 10000000; i++) {
            array.add(i);
        }
        long arrayBefore = System.currentTimeMillis();
        for (int i = 1; i < 1000; i++) {
            array.add(5002,1);
        }
        long arrayAfter = System.currentTimeMillis();
        System.out.println("array:" + (arrayAfter - arrayBefore));*/

        //验证 ArrayList 中hugeCapacity(int minCapacity) 合适参数小于0
        //System.out.println(biggerThanMax(Integer.MAX_VALUE));


        //比较 for循环 与 System.arrayCopy 的效率
        /*ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            list.add(123);
        }
        long arrBefore = System.currentTimeMillis();
        move(list);
        long arrAfter = System.currentTimeMillis();
        System.out.println("for : " + (arrAfter - arrBefore));

        long copyBefore = System.currentTimeMillis();
        System.arraycopy(list, 0, list, 1, list.size());
        long copyAfter = System.currentTimeMillis();
        System.out.println("arrayCopy: " + (copyAfter - copyBefore));*/




    }

    /**
     * 验证对整数类型的最大值做加法，返回值为负数
     *
     * @param max Integer.MAX_VALUE
     * @return
     */
    public static int biggerThanMax(int max) {
        return max + 10;
    }

    public static void move(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            newList.add(i, list.get(i));
        }
    }

}
