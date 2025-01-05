package HW_14_01_25;

import HW_14_01_25.MyLinkedList.MyLinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @BeforeEach
    void before() {
        System.out.println("Before each..." + this);
        list = new MyLinkedList<>();
    }

    @AfterEach
    void after() {
        System.out.println("After each..." + this);
    }

    @Test
    void listEmptyIfNoElementsAdd() {
        System.out.println("running listEmptyIfNoElementsAdd for " + this);
        assertAll(
                () -> assertNull(list.getHead(), "Head of the list should be null"),
                () -> assertNull(list.getTail(), "Tail of the list should be null"),
                () -> assertEquals(0, list.size(), "Size of the list should be 0")
        );
    }

    @Test
    void listSizeIfElementAdded() {
        System.out.println("running listSizeIfElementAdded for " + this);
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }

        assertEquals(3, list.size(), "Size of the list should be 3");
    }
}
