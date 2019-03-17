package generic;

/**
 * 查看class文件：
 * 1. vim GenericDefinitionDemo.class :%!xxd
 * 2. javap -verbose GenericDefinitionDemo.class
 * @param <T>
 */
public class GenericDefinitionDemo<T> {

    /**
     * 此方法为泛型方法
     * <String, T, Alibaba> 尖括号中的String, 并不代表java.lang.String,仅仅是一个代号
     * 此时的泛型<T>与类名后中定义的<T>是两个代指，互不影响
     */
    static <String, T, Alibaba> String get(String string, Alibaba cat){
        return string;
    }

    public static void main(String[] args){
        String first = "2q3";
        Long second = 111L;

        String s = get(first, second);
    }
}
