package generic;

import java.util.List;
import list.ArrayList;

/**
 * 区分List, List<Object>, List<?>
 *     a1:可以被一下三种类型引用赋值，并且可以添加任何类型的数据，和其他List操作
 *     a2:只接受a1引用赋值，接受添加任何类型数据，和其他List操作
 *     a3:由于执行具体类型，只接受a1引用赋值，添加指定类型元素，和其他List操作
 *     a4:未制定具体类型，因此可以接受任何类型的引用赋值，但是不接受添加add元素，因为元素类型未知，但支持List其他remove,clear等操作
 */
public class ListNoGeneric {

    public static void main(String[] args) {

        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(12));
        a1.add(new String("qqq"));

        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(22));
        a2.add(new String("sfdf"));

        //设置参数固定类型为Integer
        List<Integer> a3 = a1;
        a3.add(new Integer(33));
        //a3.add(new Object());
        //a3.add(new String("1243"));
        a3.remove(0);
        a3.clear();

        /**
         * 通配符集合
         * 1. 可以接受任何类型的集合赋值
         * 2. 不能添加任何元素
         * 3. 可以remove 和 clear 操作
         */
        List<?> a4 = a1;
        a1.remove(0);
        a4.clear();
        //a4.add(new Object());
    }
}
