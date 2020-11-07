package pl.pb.junitexamples.Mockito_17_Resetting_mocks__Since_1_8_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@DisplayName("17. Resetting mocks (Since 1.8.0)")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("test value");

        //when - than
        assertEquals("test value", mockedList.get(1));

        //reset
        reset(mockedList);

        //when - than
        assertNull(mockedList.get(1));

    }
}
