package list;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListCompareTest {

    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<>();
        LinkedList<Integer> link2 = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            link.add(i);
            array.add(i);
        }
        for (int i = 0; i < 2000; i++) {
            link2.add(i);
        }
        /*getCompare(link, "link");
        getCompare(array, "array");*/
        /*addCompare(link, "link");
        addCompare(array, "array");*/
        //removeEvensVar1(link);
        //removeEvensVar2(link);
        //removeEvensVar3(link);
        //removeEvensVar3(array);
        /*ListIterator<Integer> arrayIterator = array.listIterator();
        arrayIterator.next();
        arrayIterator.remove();

        System.out.println(arrayIterator.next());*/

        /*testRandomAccess(link);
        testRandomAccess(array);*/
        LinkedList<Integer> a = new LinkedList<>();
        a.add(123);
        a.add(234);
        a.add(345);
        /*LinkedList<Integer> b = new LinkedList<>();
        b.add(3646);
        b.add(4656);
        b.add(3425);
        test01(a, b);*/
        //a.removeFirst();
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map.put(1,"234"));
        System.out.println(map.put(1,"45345"));
        Set s = new HashSet();
        a.add(null);
        Set s1 = new TreeSet();
        s1.add(null);
        System.out.println(s.toString()+s1.toString());
    }

    public static void testRandomAccess(List<Integer> list) {
        /*long before = System.currentTimeMillis();
        for (int i=0, n=list.size(); i < n; i++)
            list.get(i);
        long after = System.currentTimeMillis();
        System.out.println("for:"+(after - before));*/

        long itbefore = System.currentTimeMillis();
        for (Iterator i = list.iterator(); i.hasNext(); )
            i.next();
        long itafter = System.currentTimeMillis();
        System.out.println("it:" + (itafter - itbefore));
    }

    /**
     * 对于数组和链表get()效率问题：
     * 1. 使用普通for()方法的效率：数组 > 链表
     * 2. 使用增强for()：数组 = 链表
     * 2. 使用增强for 循环的与普通for循环高效：增强for > 普通for
     * 增强for 的高效得益于List 实现Iterable接口，迭代器有效的从一项到下一项的推进
     *
     * @param list
     * @param type
     */
    public static void getCompare(List<Integer> list, String type) {
        long arrayBefore = System.currentTimeMillis();
        int total = 0;
        //使用增强for实验get()方法效率时，两者几乎相同
        /*for (Integer arr : list) {
            total += arr;
        }*/
        //使用普通for可以明显比较出两者的差距
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        long arrayAfter = System.currentTimeMillis();
        System.out.println("使用增强for比较" + type + "执行时间：" + (arrayAfter - arrayBefore));
    }

    /**
     * LinkedList 与 ArrayList 的add() 方法的效率：
     * 1. 当数据只在末尾端频繁插入或删除，linkedList = ArrayList
     * 2. 当数据在非末端（如中间，或前端，离末尾远的位置）频繁插入或删除，LinkedList >> ArrayList
     *
     * @param list
     * @param type
     */
    public static void addCompare(List<Integer> list, String type) {
        long arrayBefore = System.currentTimeMillis();
        //在List最前端插入，两者会有很明显的差距
        for (int i = 0; i < 10000; i++) {
            list.add(0, 12);
        }
        //在List末尾频繁的操作，两者几乎相等
        /*for (int i = 0; i < 10000; i++) {
            list.add(13);
        }*/
        long arrayAfter = System.currentTimeMillis();
        System.out.println("使用增强for比较" + type + "执行时间：" + (arrayAfter - arrayBefore));
    }

    /**
     * 删除列表中偶数值：
     * 当列表中使用删除操作时，需要使用linkedList增加效率
     * v1.0 使用while,通过get()获取元素值，但是get()方法对于linkedList并不高效
     * （同时我们在v1.0中对比了for 与 while 的运行效率，while 的效率要大于 for）
     * v2.0 为了避免在LinkedList中使用get()方法，我们引入增强for，但是引发异常ConcurrentModificationException
     * v3.0 通过使用迭代器的删除操作，避免以上出现的异常或者性能问题
     * （同时在Collection中提供了类似的方法使用，参数传入过滤条件）
     *
     * @param list
     */
    public static void removeEvensVar1(List<Integer> list) {
        /*long before = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                list.remove(i);
        }
        long after = System.currentTimeMillis();
        System.out.println("for:" + (after - before));*/

        long whilebefore = System.currentTimeMillis();
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 0)
                list.remove(i);
            else
                i++;
        }
        long whileafter = System.currentTimeMillis();
        System.out.println("while:" + (whileafter - whilebefore));
    }

    /**
     * 通过使用增强for 删除偶数值，但是会抛出异常ConcurrentModificationException
     * 因为LinkedList中 私有的内部类ListItr 实现了ListIterator,迭代器会自动将下一个元素进行推进即next()，
     * 但是当 当前元素被删除后modCount++，
     * 因此迭代器再寻找下一个元素的时候会进行验证，checkForComodification()
     *
     * @param list
     */
    public static void removeEvensVar2(List<Integer> list) {
        for (Integer a : list) {
            if (a % 2 == 0)
                list.remove(a);
        }
    }

    /**
     * 使用迭代器避免了上面测问题，同时
     * 在 Collection.java --> removeIf(Predicate<? super E> filter)
     * 就是使用迭代器的方式完成删除操作，迭代器查找下一个元素，迭代器的remove() 方法
     * <p>
     * 再此要说明，因为ArrayList有对removeIf进行重写，
     * 当两种List调用这个方法时，ArrayList 的效率远高于 LinkedList
     *
     * @param list
     */
    public static void removeEvensVar3(List<Integer> list) {
        ListIterator<Integer> listIterator = list.listIterator();
        long before = System.currentTimeMillis();
        //list.removeIf(integer -> integer % 2 == 0);
        while (listIterator.hasNext()) {
            if (listIterator.next() % 2 == 0)
                listIterator.remove();
        }
        long after = System.currentTimeMillis();
        System.out.println("迭代器：" + (after - before));
    }


    public static void test01(List<Integer> a, List<Integer> b) {
        //交替合并将b合并到a中
        ListIterator<Integer> aIt = a.listIterator();
        Iterator<Integer> bIt = b.iterator();
        while (bIt.hasNext()) {
            if (aIt.hasNext()) {
                aIt.next();
                aIt.add(bIt.next());
            }
        }
        System.out.println(a);

        //在b中每隔一个位置删除一个元素
        Iterator<Integer> bItRemove = b.iterator();//重新获取迭代器
        while (bItRemove.hasNext()) {
            bItRemove.next();
            if (bItRemove.hasNext()) {
                bItRemove.next();
                bItRemove.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);

        ListIterator<Integer> aItIndex = a.listIterator(a.size());
        while (aItIndex.hasNext()) {
            System.out.println(aItIndex.nextIndex() + " , " + aItIndex.next());
        }
        System.out.println(aItIndex.nextIndex());
    }

}
