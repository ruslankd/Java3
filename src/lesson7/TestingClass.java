package lesson7;

import lesson7.TestAnnotation.AfterSuite;
import lesson7.TestAnnotation.BeforeSuite;
import lesson7.TestAnnotation.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestingClass implements Testing {
    @Override
    public void start(Class<?> clazz)
            throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method [] methods = clazz.getDeclaredMethods();
        Constructor [] constructors = clazz.getConstructors();
        Object obj = constructors[0].newInstance();
        checkBeforeAndAfterSuite(methods);

        ArrayList<Method> testMethod = new ArrayList<>();
        Method afterSuiteMethod = null;

        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(obj, method.getParameters());
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethod.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteMethod = method;
            }
        }

        for (int i = 10; i > 0; i--) {
            for (Method method : testMethod) {
                if (i == method.getAnnotation(Test.class).priority()) {
                    method.invoke(obj, method.getParameters());
                }
            }
        }

        if (afterSuiteMethod != null) {
            afterSuiteMethod.invoke(obj, afterSuiteMethod.getParameters());
        }
    }

    private void checkBeforeAndAfterSuite(Method [] methods) {
        int numberBeforeSuite = 0;
        int numberAfterSuite = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                numberBeforeSuite++;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                numberAfterSuite++;
            }
        }
        if ((numberAfterSuite > 1) || (numberBeforeSuite > 1)) {
            throw new RuntimeException();
        }
    }
}
