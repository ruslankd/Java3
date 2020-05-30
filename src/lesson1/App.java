package lesson1;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        MyArray<String> stringMyArray = new MyArray<>("abc", "def", "ghi");
        stringMyArray.swapInArray(0, 2);
        System.out.println(stringMyArray);

        MyArray<Integer> integerMyArray = new MyArray<>(1, 2, 3, 4);
        integerMyArray.swapInArray(1, 3);
        System.out.println(integerMyArray);

        ArrayList<String> stringArrayList = stringMyArray.toArrayList();
        System.out.println(stringArrayList);

        ArrayList<Integer> integerArrayList = integerMyArray.toArrayList();
        System.out.println(integerArrayList);

        Box<Apple> appleBox1 = new Box<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        appleBox1.add(apple1);
        appleBox1.add(apple2);
        System.out.println(appleBox1.toString());

        Box<Apple> appleBox2 = new Box<>();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        appleBox2.add(apple3);
        appleBox2.add(apple4);
        appleBox2.add(apple5);
        System.out.println(appleBox2.toString());

        System.out.println("Boxes with apples are equal in weight: " +
                appleBox1.compare(appleBox2));

        System.out.println("Pouring ...");
        appleBox1.pourIn(appleBox2);
        System.out.println(appleBox1.toString());
        System.out.println(appleBox2.toString() + System.lineSeparator());

        Box<Orange> orangeBox = new Box<>();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        orangeBox.add(orange1);
        orangeBox.add(orange2);
        orangeBox.add(orange3);
        System.out.println(orangeBox.toString());

        // Wrong!!!!!
        // appleBox1.add(orange1);
        // orangeBox.pourIn(appleBox1);
        System.out.println("The second box of apples weighs like a box of orange: " +
                appleBox2.compare(orangeBox));
    }
}
