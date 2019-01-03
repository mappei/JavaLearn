package list;

import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Exercise {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(4);
        l.add(6);
        l.add(5443);
        l.add(345);
        l.add(6535);
        l.add(543);
        l.add(23);
        l.add(9);
        l.add(99);
        List<Integer> p = new ArrayList<>();
        p.add(3);
        p.add(4);
        p.add(7);
        p.add(2);
        p.add(6);
        p.add(9);

        long before = System.currentTimeMillis();
        printLots(l, p);
        long after = System.currentTimeMillis();
        System.out.println("result time: " + (after - before));

        /********************************************************/
        //2. 通过之调整链（而不是数据）来交换两个相邻的元素，使用
        //     a. 单链表
        //     b. 双向链表
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add(456);
        simpleLinkedList.add(890);
        simpleLinkedList.add(2144);
        simpleLinkedList.add(111);
        simpleLinkedList.add(123);
        simpleLinkedList.add(234);
        System.out.println(simpleLinkedList.toString());
        simpleLinkedList.chengeItemPosition(4);
        System.out.println(simpleLinkedList.toString());

    }

    /**
     * 1. 给定一个表L 和 另一个表 P，他们包含以升序排序的整数。操作printLots(L, P) 将打印L 中那些由P所制定的位置上的元素
     * 例如：P = 1,3,4,6, 那么L 中位置于1，3，4，6的元素被打印出来， 写出过程printLots().
     * 只可使用public型 Collections API 容器操作，求运行时间
     */
    public static void printLots(List<Integer> l, List<Integer> p) {
        Iterator<Integer> pIt = p.iterator();
        List<Integer> result = new ArrayList<>();
        while (pIt.hasNext()) {
            Integer integer = l.get(pIt.next() - 1);
            result.add(integer);
        }
        System.out.println(result);
    }

    /**
     *
     * @param l 双向链表
     * @param index 相邻元素的第一个元素的下标
     */
    public static void chengePosition(List<Integer> l, int index){


    }


}
