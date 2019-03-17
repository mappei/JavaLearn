# The use of bit operators 位运算符的用法
> 我们编写的代码都会编译为计算机能够理解的字节码指令，此篇介绍两个通过使用位运算符提高程序执行效率
### 交换两个数字的位置
核心代码，用过使用异或运算符，不再借助第三变量完成位置交换。
参`SwapFunction.java`
```java
private static void swap(int a, int b){
    a ^= b;
    b ^= a;
    a ^= b;
    System.out.println(a);
    System.out.println(b);
}
```
### 判断一个数是否为幂函数值
幂函数：能够被2整除，底数为2，指数为任意自然数。  
由此可以通过二进制数找到规律：幂函数值与幂函数值-1 互补，因此通过求两个数的&运算，结果为0即为幂函数值。
参`PowFunction.java`
```java
public static boolean isPow(int num) {
    return (num & (num - 1)) == 0;
}
```

以上方法都是通过**规律**，使用位运算符简化代码  
Q:一长串字符串中找相同字母出现次数
   
   Keep continue
