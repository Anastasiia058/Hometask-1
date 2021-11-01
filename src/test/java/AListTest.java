import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AListTest {

    @Test
    void shouldWeGetAmountOfElementsWhenWeKickOffSize() {
        AList testList = new AList(5);
        testList.add(66);
        testList.add(11);
        assertEquals(2, testList.size());
    }

    @Test
    void shouldBeFalseWhenArraySizeOne() {
        AList testList = new AList(1);
        testList.add(113);
        assertFalse(testList.isEmpty());
    }

    @Test
    void shouldBeTrueWhenArraySizeIsNull() {
        AList testList = new AList(1);
        assertTrue(testList.isEmpty());
    }

    @Test
    void shouldBeTrueWhenArrayContainsElements() {
        AList<Object> testList = new AList(5);
        testList.add(116);
        assertTrue(testList.contains(116));
    }

    @Test
    void shouldWeReturnAnArrayWhenTurnArrayListToArray() {
        AList<Object> testList = new AList(2);
        Object[] testArray = new Object[2];
        assertEquals(Arrays.toString(testArray), Arrays.toString(testList.toArray()));
    }

    @Test
    void shouldBeClearWhenAllElementsAreCleared() {
        AList testList = new AList(5);
        testList.add(66);
        testList.add(11);
        testList.clear();
        assertEquals(0, testList.size());
    }

    @Test
    void shouldWeGetTheElementWhenWeRunGet() {
        AList testList = new AList(5);
        testList.add(66);
        testList.get(0);
        assertEquals(66, testList.get(0));
    }

    @Test
    void shouldWeSetTheElementWhenWeRunSet() {
        AList testList = new AList(5);
        testList.set(3, 102);
        assertEquals(102, testList.set(3, 102));
        assertEquals(102, testList.get(3));
    }

    @Test
    void shouldBeTrueWhenWeAddTheElement() {
        AList testList = new AList(2);
        assertTrue(testList.add(80));
        assertTrue(testList.contains(80));
    }

    @Test
    void shouldWeDeleteTheElementWhenWeRunRemove() {
        AList testList = new AList(5);
        testList.add(2);
        testList.add(7);
        testList.remove(1);
        assertEquals(1, testList.size());
    }

    @Test
    void shouldWeGetSortedArrayListWhenWeUseBubbleSort() {
        AList testList = new AList(4);
        testList.add(33);
        testList.add(12);
        testList.add(102);
        testList.add(2);
        testList.bubbleSort();
        assertEquals("Наш массив: [2, 12, 33, 102], кол-во заполненных ячеек = 4", testList.toString());
    }

    @Test
    void returnToStringWhenWeHadAnArrayList() {
        AList testList = new AList(5);
        testList.add(6);
        testList.add(12);
        assertEquals("Наш массив: [6, 12, null, null, null], кол-во заполненных ячеек = 2", testList.toString());
    }

}