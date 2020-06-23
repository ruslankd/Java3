package lesson7;

import lesson7.TestAnnotation.AfterSuite;
import lesson7.TestAnnotation.BeforeSuite;
import lesson7.TestAnnotation.Test;

public class TestClass {

    @AfterSuite
    void init() {
        System.out.println("@AfterSuite method");
    }

    @Test(priority = 7)
    void test1() {
        System.out.println("@Test method (7)");
    }

    @Test
    void test2() {
        System.out.println("@Test method (default)");
    }

    @Test(priority = 10)
    void test3() {
        System.out.println("@Test method (10)");
    }

    @Test(priority = 2)
    void test4() {
        System.out.println("@Test method (2)");
    }

    @BeforeSuite
    void close() {
        System.out.println("@BeforeSuite method");
    }

    void foo() {
        System.out.println("bla bla bla");
    }

}
