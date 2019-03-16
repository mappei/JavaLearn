package generic;

import java.util.ArrayList;
import java.util.List;

public class AnimalCatGarfield<T> {

    public static void main(String[] args) {
        List<Animal> animal = new ArrayList<>();
        List<Cat> cat = new ArrayList<>();
        List<Garfield> garfield = new ArrayList<>();

        //List<?>  通配符集合, List<> 钻石
        //<? extends T>
        //赋值
        //List<? extends Cat> extendsCatFromAnimal = animal;
        List<? extends Cat> extendsCatFromCat = cat;
        List<? extends Cat> extendsCatFromGarfield = garfield;

        //<? super T>
        List<? super Cat> superCatFromAnimal = animal;
        List<? super Cat> superCatFromCat = cat;
        //List<? super Cat> superCatFromGarfield = garfield;

        //add
        /**
         * extends 无法进行add操作，除null
         * 因为进行add操作插入的元素类型必须适应或强制转换为T即任意类型，因此只有null
         */
        extendsCatFromCat.add(null);
        /*extendsCatFromCat.add(new Cat());
        extendsCatFromCat.add(new Animal());
        extendsCatFromCat.add(new Garfield());*/

        superCatFromCat.add(new Cat());
        //superCatFromCat.add(new Animal());
        superCatFromCat.add(new Garfield());

        //get
        Cat cat1 = extendsCatFromCat.get(0);
        Cat cat2 = extendsCatFromGarfield.get(0);

        AnimalCatGarfield animalCatGarfield = new AnimalCatGarfield();

    }
}
