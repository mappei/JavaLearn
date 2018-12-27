package list;


import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args){
        /*ArrayList list = new ArrayList();
        //ArrayList list = new ArrayList();
        list.add("hbjnkml,;n");
        list.remove(-32);*/

        //remove
        ArrayList list = new ArrayList();
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
        System.out.println(list.size());
    }

}
