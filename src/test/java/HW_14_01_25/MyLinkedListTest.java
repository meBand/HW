package HW_14_01_25;

import HW_14_01_25.MyLinkedList.MyLinkedList;

import HW_14_01_25.paramResolver.ListParamResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс для тестирования MyLinkedList
 * <p>
 * использовал DI предоставляемое jUnit 5, use AssertJ
 */


@ExtendWith({
        ListParamResolver.class
})
class MyLinkedListTest {

    /**
     * getNext(node)
     * getPrev(node)
     * set(index, T)
     * remove(index)
     * removeAll()
     * sublist(indexStart, indexEnd)
     */

    private static final Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
    private static final String[] strs = {"is", "a", "simple", "string", "array"};

    @Nested
    class HeadTest {

        @Test
        void headIfNoElementAdd(MyLinkedList<?> list) {
            assertThat(list.head()).isNull();
        }

        @Test
        void headIfOneElementAdd(MyLinkedList<String> list) {
            list.add(strs[0]);
            assertAll (
                    () -> assertThat( list.get(list.head()) ).isEqualTo(strs[0]),
                    () -> assertThrows( NullPointerException.class, () -> list.getNext(list.head()) ),
                    () -> assertThrows( NullPointerException.class, () -> list.getPrev(list.head()) )
            );
        }

        @Test
        void headIfSomeElementAdd(MyLinkedList<String> list) {
            list.add(strs);
            assertAll (
                    () -> assertThat( list.get(list.head()) ).isEqualTo(strs[0]),
                    () -> assertThat( list.getNext(list.head()) ).isEqualTo(strs[1]),
                    () -> assertThrows( NullPointerException.class, () -> list.getPrev(list.head()) )
            );
        }
    }

    @Nested
    class TailTest {

        @Test
        void headIfNoElementAdd(MyLinkedList<?> list) {
            assertThat(list.tail()).isNull();
        }

        @Test
        void headIfOneElementAdd(MyLinkedList<String> list) {
            list.add(strs[0]);
            assertAll (
                    () -> assertThat( list.get(list.tail()) ).isEqualTo(strs[0]),
                    () -> assertThrows( NullPointerException.class, () -> list.getNext(list.tail()) ),
                    () -> assertThrows( NullPointerException.class, () -> list.getPrev(list.tail()) )
            );
        }

        @Test
        void headIfSomeElementAdd(MyLinkedList<String> list) {
            list.add(strs);
            assertAll (
                    () -> assertThat( list.get(list.tail()) ).isEqualTo(strs[strs.length - 1]),
                    () -> assertThat( list.getPrev(list.tail()) ).isEqualTo(strs[strs.length - 2]),
                    () -> assertThrows( NullPointerException.class, () -> list.getNext(list.tail()) )
            );
        }
    }

    @Nested
    class SizeTest {

        @Test
        void sizeIfNoElementsAdd(MyLinkedList<?> list) {
            assertThat(list.size()).isEqualTo(0);
        }

        @Test
        void sizeIfOneElementAdd(MyLinkedList<String> list) {
            list.add(strs[0]);
            assertThat( list.size() ).isEqualTo(1);
        }

        @Test
        void sizeIfSomeElementAdd(MyLinkedList<String> list) {
            list.add(strs);
            assertThat( list.size() ).isEqualTo(strs.length);
        }

        @Test
        void sizeIfRemoveElement(MyLinkedList<String> list) {
            list.add(strs);
            list.remove(0);
            assertThat(list.size()).isEqualTo(strs.length - 1);
        }

        @Test
        void sizeIfRemoveAllElement(MyLinkedList<String> list) {
            list.add(strs);
            list.removeAll();
            assertThat(list.size()).isEqualTo(0);
        }
    }

    @Nested
    class AddTest {

        @Test
        void addOneElement(MyLinkedList<String> list) {
            list.add(strs[0]);
            assertThat( list.get(0) ).isEqualTo(strs[0]);
        }

        @Test
        void addElementByIndex(MyLinkedList<String> list) {
            list.add(strs);
            for (int i = 0; i < strs.length-1; i++) {
                list.add(i, strs[i]);
                assertThat( list.get(i) ).isEqualTo(strs[i]);
                list.remove(i);
            }
        }

        @Test
        void addArrayOfElement(MyLinkedList<String> list) {
            list.add(strs);
            for (int i = 0; i < strs.length; i++) {
                assertThat( list.get(i) ).isEqualTo(strs[i]);
            }
        }

        @Test
        void addArrayOfElementByIndex(MyLinkedList<String> list) {
            list.add(strs);
            list.add(0, strs);
            assertThat(list.size()).isEqualTo(strs.length*2);
            for (int i = 0; i < list.size(); i++) {
                assertThat(strs).contains(list.get(i));
            }
        }
    }

    @Nested
    class GetTest {

        @Test
        void getElementByIndexIfListEmpty(MyLinkedList<?> list) {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        }

        @Test
        void getElementByIndex(MyLinkedList<String> list) {
            list.add(strs);
            for (int i = 0; i < list.size(); i++) {
                assertThat(list.get(i)).isEqualTo(strs[i]);
            }
        }

        @Test
        void getElementByNode(MyLinkedList<String> list) {
            list.add(strs);
            for (int i = 0; i < list.size(); i++) {
                assertThat( list.get(list.getNode(i)) ).isEqualTo(strs[i]);
            }
        }

        @Test
        void getNodeByIndex(MyLinkedList<String> list) {
            list.add(strs);
            for (int i = 0; i < list.size(); i++) {
                assertThat( list.get(list.getNode(i)) ).isEqualTo(strs[i]);
            }
        }

        @Test
        void getNextElementByNode(MyLinkedList<String> list) {
            list.add(strs);
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    int finalI = i;
                    assertThrows( NullPointerException.class, () -> list.getNext(list.getNode(finalI)) );
                } else {
                    assertThat( list.getNext(list.getNode(i)) ).isEqualTo( list.get(i+1) );
                }
            }
        }

        @Test
        void getPrevElementByNode(MyLinkedList<String> list) {
            list.add(strs);
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    int finalI = i;
                    assertThrows( NullPointerException.class, () -> list.getPrev(list.getNode(finalI)) );
                } else {
                    assertThat( list.getPrev(list.getNode(i)) ).isEqualTo( list.get(i-1) );
                }
            }
        }
    }

    @Nested
    class SetTest {
        
    }

    @Nested
    class RemoveTest {

    }

    @Nested
    class SubListTest {

    }

    //todo составить список тестов и реализовать
}
