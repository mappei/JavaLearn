# Generic 泛型
>引入泛型增强类的灵活性，可以有效避免类转换异常的风险，泛型也是语法糖的一种
>语法糖：是一种对语言功能没有影响，增加程序可读性，减少代码出错，方便使用

```java
public class Stove {
    public static Object heat(Object food) {
        System.out.println(food + "is done.");
        return food;
    }
    public static void main(String[] args){
      Meat meat = new Meat();
      //可能会引起ClassCaseException
      meat = (Meat)Stove.heat(meat);
      Soup soup = new Soup();
      soup = (Soup) Stove.heat(soup);
    }
}
```
### 语法
泛型可以定义在类、接口、方法中，编译器可以通过识别尖括号和尖括号的中字母识别泛型。
约定俗成的符号包括：
- E (Element) 代表集合元素
- T (Type)  代表类的类型，某个类
- K,V (Kay,Value) 代表键值对元素

通过`GenericDefinitionDemo.java`中我们可以总结以下几点：
1. 尖括号中的每个元素都代指一种未知类型
2. 尖括号的位置必须在**方法返回值之前**或**类名之后**，并且类名后定义的泛型与方法中定义的泛型互不影响，可以完全不同。
    eg:
    ```java
    public class Generic<T>{
       public <A> String createMethod(){
            return "do something";
       }
    }
    ```
3. 泛型在定义处只具备执行第一边界类型，可以参考`Manipulator.java`中提到的，
由于存在类型擦除所以在`<T>`中第一边界为Object所以在`class Manipulator1`的方法中无法调用`HasF`中的方法，只能调用Object类型的方法；
但是在`<T extends HasF>`中第一边界为`HasF` 所以在`class Manipulator`中有权限调用到`f()`方法。
4. 对于编译后的字节码指令，并不存在一些方法签名，充分说明泛型只是一种编写代码是的**语法检查**。在使用泛型时，会根据第一边界执行强类型转换，即类型擦除。

### 泛型好处
- 类型安全：不必担心类转换异常
- 提升可读性：可以从代码中直接看到泛型集合、泛型方法所处理的对象类型
- 代码重用：合并了同类型的处理代码，提高代码重用

以上，我们可以使用泛型重构开篇代码：
```java
public class Stove {
    public static <T> T heat(T food) {
        System.out.println(food + "is done.");
        return food;
    }
    public static void main(String[] args){
      Meat meat = new Meat();
      meat = Stove.heat(meat);
      
      Soup soup = new Soup();
      soup = Stove.heat(soup);
    }
}
```
### Tips
- 查看class文件：
    1. ```vim GenericDefinitionDemo.class :%!xxd```
    2. ```javap -verbose GenericDefinitionDemo.class```
- 泛型与集合的联合使用参照`ListNoGeneric.java`，注意区分List, List\<Object>, List<Integer>, List<?>，大致可以总结一下几点：
    1. List\</Object>：接受List 的引用赋值，但是不接受其他类型
    2. List\<?>：叫做通配符集合，接受任何类型的引用赋值、remove、clear，不接受添加任何元素，因为不知道元素的具体类型。
    **其用法主要是做为参数接受外部参数或返回一个不知道元素类型的集合**
    3. 不支持List\<Object> 与 List<Integer> 之间相互赋值
    4. 引入<? extends T>, <? super T> 的概念，具体集合中介绍
