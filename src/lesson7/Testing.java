package lesson7;

import java.lang.reflect.InvocationTargetException;

public interface Testing {
    void start(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException;
}
