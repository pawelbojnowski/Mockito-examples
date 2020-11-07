package pl.pb.junitexamples.Mockito_10_Stubbing_consecutive_calls__iterator_style_stubbing_;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("10. Stubbing consecutive calls (iterator-style stubbing)")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);

        when(mockedList.get(2))
                .thenReturn("TEXT 1")
                .thenReturn("TEXT 2")
                .thenReturn("TEXT 3")
                .thenThrow(new RuntimeException());

        //when / than
        //First call:
        assertEquals("TEXT 1", mockedList.get(2));

        //Second call:
        assertEquals("TEXT 2", mockedList.get(2));

        //Third call:
        assertEquals("TEXT 3", mockedList.get(2));

        //Fourth call:
        assertThrows(RuntimeException.class, () -> {
            mockedList.get(2);
        });

    }

    @Test
    public void testAggregationOfReturnStubs() {
        //given
        List<String> mockedList = mock(List.class);

        when(mockedList.get(2))
                .thenReturn("TEXT 1", "TEXT 2", "TEXT 3")
                .thenThrow(new RuntimeException());

        //when / than
        //First call:
        assertEquals("TEXT 1", mockedList.get(2));

        //Second call:
        assertEquals("TEXT 2", mockedList.get(2));

        //Fourth call:
        assertEquals("TEXT 3", mockedList.get(2));

        //Third call:
        assertThrows(RuntimeException.class, () -> {
            mockedList.get(2);
        });

    }
}
