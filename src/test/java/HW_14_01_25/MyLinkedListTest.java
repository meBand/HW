package HW_14_01_25;

import HW_14_01_25.MyLinkedList.MyLinkedList;

import HW_14_01_25.paramResolver.ListParamResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({
        ListParamResolver.class
})
class MyLinkedListTest {

    private MyLinkedList list;
    private String[] str = {"is", "a", "simple", "string", "array"};

    @BeforeEach
    void before(MyLinkedList<String> list) {
        this.list = list;
    }

    @Test
    void listEmptyIfNoElementsAdd() {
        assertAll(
                () -> assertThat(list.head()).isNull(),
                () -> assertThat(list.tail()).isNull(),
                () -> assertThat(list.size()).isEqualTo(0)
        );
    }

    @Test
    void listSizeIfElementAdded() {
        list.add(str);
        assertThat(list.size()).isEqualTo(str.length);
    }

    //todo составить список тестов и реализовать
}
