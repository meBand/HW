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

}
