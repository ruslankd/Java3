package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> box;
    private float weight;

    public Box() {
        this.box = new ArrayList<>();
        this.weight = 0.0f;
    }

    public float getWeight() {
        return this.weight;
    }

    public void add(T fruit) {
        this.box.add(fruit);
        this.weight += fruit.getWeight();
    }

    public boolean compare(Box<?> box) {
        return this.weight == box.getWeight();
    }

    public void pourIn(Box<T> box) {
        for (T t : this.box) {
            box.add(t);
        }
        this.box.clear();
        weight = 0.0f;
    }

    @Override
    public String toString() {
        return "Box{" +
                "weight = " + weight +
                '}';
    }
}
