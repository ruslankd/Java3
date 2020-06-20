package lesson7;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args)
            throws InvocationTargetException, IllegalAccessException, InstantiationException {
        TestingClass testingClass = new TestingClass();
        testingClass.start(TestClass.class);
    }
}
