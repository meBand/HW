package HW_14_01_25;

import HW_14_01_25.MyLinkedList.MyLinkedList;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MyLinkedListTest {

    private MyLinkedList<Integer> integerMyLinkedList;
    private MyLinkedList<String> stringMyLinkedList;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all...\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all...");
    }

    @BeforeEach
    void before() {
        System.out.println("Before each..." + this);
        integerMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList = new MyLinkedList<>();
    }

    @AfterEach
    void after() {
        System.out.println("After each..." + this);
        System.out.println();
    }

    @Test
    void listEmptyIfNoElementsAdd() {
        System.out.println("running listEmptyIfNoElementsAdd for " + this);
        assertAll(
                () -> assertThat(integerMyLinkedList.head()).isNull(),
                () -> assertThat(integerMyLinkedList.tail()).isNull(),
                () -> assertThat(integerMyLinkedList.size()).isEqualTo(0)
        );
    }

    @Test
    void listSizeIfElementAdded() {
        System.out.println("running listSizeIfElementAdded for " + this);
        for (int i = 1; i <= 10; i++) {
            integerMyLinkedList.add(i);
        }
        assertThat(integerMyLinkedList.size()).isEqualTo(10);
    }

    //todo составить список тестов и реализовать
    //todo рефакторинг неймов переменных
}
