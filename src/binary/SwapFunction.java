package binary;

/**
 * 异或运算：
 * 使用异或运算可以解决数字之间的交换，比较？，插入？ 提高性能
 */
public class SwapFunction {

    public static void main(String[] args) {
        swap(12,32);
    }

    private static void swap(int a, int b){
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);
    }
}
