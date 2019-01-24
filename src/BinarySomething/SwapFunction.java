package BinarySomething;

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
