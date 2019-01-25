package binary;

public class PowFunction {

    public static void main(String[] args){
        System.out.println(isPow(2));
    }

    private static void pow(int num, int deep) {
        int count = 0;
        while (num > 1) {
            int a = num % deep;
            if (a != 0) {
                System.out.println("不是" + deep + "幂函数");
                return;
            }
            num = num / deep;
            count++;
        }
        System.out.println("yes, " + deep + "的" + count + "次幂");
    }

    /**
     * 使用位运算符转换为方便计算机理解的二进制语言
     * 通过规律我们可以发现：
     * 2^2   = 0100 / 2^3   = 1000 / 2^4   = 10000
     * 2^2-1 = 0011 / 2^3-1 = 0111 / 2^4-1 = 01111
     * 两者取并集为0
     * @param num
     * @return
     */
    public static boolean isPow(int num) {
        return (num & (num - 1)) == 0;
    }
}
