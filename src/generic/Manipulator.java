package generic;

/**类型擦除： 泛型参数会擦除到他的第一边界
 * eg:
 * eg1:ArrayList<Integer>/ ArrayList<String> 参数类型为T, 在JVM看来都是Object类型
 * eg2:<T extends Cat> ArrayList<Garfield>/ ArrayList<Cat> 参数类型为Cat, 所以JVM视为Cat类型
 *
 * 因为存在类型擦除，所以在返回泛型对象时，对象能够调用的方法取决于第一边界类型(如eg1中Object,eg2中Cat)
 */
public class Manipulator<T extends HasF> {

    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    /**
     * 泛型类中定义泛型的类型为<T extends HasF>
     * 因此根据泛型擦除取第一边界类型为 HasF, obj = HasF
     */
    public void manipulate() {
        obj.f();
    }
}

class Manipulator1<T> {
    private T obj;

    public Manipulator1(T x) {
        obj = x;
    }

    /**
     * 此方法中的obj无法调用到HasF中的方法，
     * 根据泛型擦除，此时的obj = Object
     */
    /*public void manipulate() {
        obj.f();
    }*/
}

class HasF {

    public void f() {
        System.out.println("HasF.f()");
    }
}