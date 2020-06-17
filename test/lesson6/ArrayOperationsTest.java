package lesson6;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayOperationsTest {

    private ArrayOperations array;

    @BeforeEach
    public void init() {
        array = new ArrayOperations();
    }

    @Test
    public void testArrayAfterFour() {
        array.setArray(new Integer [] { 1, 2, 4, 4, 2, 3, 4, 1, 7 });
        Assertions.assertArrayEquals((new Integer[]{1, 7}), array.arrayAfterFour());
    }

    @Test
    public void testArrayAfterFour2() {
        array.setArray(new Integer[] { 1, 7, 2, 9, 0, 3, 6, 7});
        Assertions.assertThrows(RuntimeException.class, () -> array.arrayAfterFour());
    }

    @Test
    public void testArrayAfterFour3() {
        Assertions.assertFalse(array.setArray(new Integer[0]));
    }

    @Test
    public void testCheckOneAndFour() {
        array.setArray(new Integer[] {1, 1, 1, 4, 4, 1, 4, 4});
        Assertions.assertTrue(array.checkOneAndFour());
    }

    @Test
    public void testCheckOneAndFour2() {
        array.setArray(new Integer[] {1, 1, 1, 1, 1});
        Assertions.assertFalse(array.checkOneAndFour());
    }

    @Test
    public void testCheckOneAndFour3() {
        array.setArray(new Integer[] {1, 4, 4, 1, 1, 4, 3});
        Assertions.assertFalse(array.checkOneAndFour());
    }

}