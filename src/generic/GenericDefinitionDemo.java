package generic;

/**
 * 查看class文件：
 * 1. vim GenericDefinitionDemo.class :%!xxd
 * 2. javap -verbose GenericDefinitionDemo.class
 * @param <T>
 */
public class GenericDefinitionDemo<T> {

    //
    static <String, T, Alibaba> String get(String string, Alibaba cat){
        return string;
    }

    public static void main(String[] args){
        String first = "2q3";
        Long second = 111L;

        String s = get(first, second);
    }

}

class Alibaba{}
