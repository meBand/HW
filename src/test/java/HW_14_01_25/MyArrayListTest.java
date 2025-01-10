package HW_14_01_25;

import HW_14_01_25.MyArrayList.MyArrayList;

import HW_14_01_25.paramResolver.MyArrayListParamResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс для тестирования MyArrayList
 * <p>
 * использовал DI предоставляемое jUnit 5, а также AssertJ
 */

@ExtendWith({
        MyArrayListParamResolver.class
})
public class MyArrayListTest {

    private static final String[] strs = {"is", "a", "simple", "string", "array"};

    /**
     * set(index, e)
     * remove(index)
     * subList(fromIndex, toIndex)
     */

    @Nested
    class SizeTest {

        @Test
        void sizeIfListEmpty(MyArrayList<?> list) {
            assertThat(list.size()).isEqualTo(0);
        }

        @Test
        void sizeIfListFilled(MyArrayList<String> list) {
            list.add(strs);
            assertThat(list.size()).isEqualTo(strs.length);
        }

        @Test
        void sizeIfElementRemoved(MyArrayList<String> list) {
            list.add(strs);
            list.remove(0);
            assertThat(list.size()).isEqualTo(strs.length-1);
        }
    }

    @Nested
    class AddTest {

        @Test
        void addOneElement(MyArrayList<String> list) {
            list.add(strs[0]);
            assertThat(list.get(0)).isEqualTo(strs[0]);
        }

        @Test
        void addOneElementByIndex(MyArrayList<String> list) {
            list.add(strs);
            String check = "check";
            int index = 1;
            list.add(index, check);
            assertAll(
                    () -> assertThat(list.size()).isEqualTo(strs.length + 1),
                    () -> assertThat(list.get(index)).isEqualTo(check)
            );
        }

        @Test
        void addSomeElement(MyArrayList<String> list) {
            list.add(strs);
            for (int i = 0; i < list.size(); i++) {
                assertThat(list.get(i)).isEqualTo(strs[i]);
            }
        }

        @Test
        void addSomeElementByIndex(MyArrayList<String> list) {
            list.add(strs);
            int index = 1;
            list.add(index, strs);
            for (int i = 0; i < list.size(); i++) {
                int finalI = i;
                assertAll(
                        () -> assertThat(list.size()).isEqualTo(strs.length*2),
                        () -> assertThat(strs).contains(list.get(finalI))
                );
            }
        }

        @Test
        void addElementIfIndexOfBound(MyArrayList<String> list) {
            assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, strs[0]));
        }
    }

    @Nested
    class GetTest {

        @Test
        void getElementIfListEmpty(MyArrayList<String> list) {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        }

        @Test
        void getElementIfIndexOfBound(MyArrayList<String> list) {
            list.add(strs);
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
        }

        @Test
        void getElementTest(MyArrayList<String> list) {
            list.add(strs);
            for (int i = 0; i < list.size(); i++) {
                assertThat(list.get(i)).isEqualTo(strs[i]);
            }
        }
    }

    @Nested
    class SetTest {

        @Test
        void SetIfListEmpty(MyArrayList<String> list) {
            assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "check"));
        }

        @Test
        void SetIfIndexOfBound(MyArrayList<String> list) {
            list.add(strs);
            assertThrows(IndexOutOfBoundsException.class, () -> list.set(list.size(), "check"));
        }

        @Test
        void SetIfListFilled(MyArrayList<String> list) {
            list.add(strs);
            int index = 0;
            String check = "check";
            list.set(index, check);
            assertThat(list.get(index)).isEqualTo(check);
        }
    }

    @Nested
    class RemoveTest {

    }

    @Nested
    class SubListTest {

    }
}
