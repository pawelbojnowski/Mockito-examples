package pl.pb.junitexamples.Mockito_28_MockMaker_API__Since_1_9_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("28. MockMaker API (Since 1.9.5)")
public class Tests {

    /**
     * Both test required file: src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker which contains:
     * mock-maker-inline
     */

    @Test
    public void testMockFinalClass() {
        //given
        TestFinalClass mockedList = mock(TestFinalClass.class);
        //when
        when(mockedList.someMethod(eq("INPUT_TEXT"))).thenReturn("RETURN_TEXT");

        //than
        assertEquals("RETURN_TEXT", mockedList.someMethod("INPUT_TEXT"));
    }

    @Test
    public void test() {
        //given
        TestFinalMethod mockedList = mock(TestFinalMethod.class);
        //when
        when(mockedList.someMethod(eq("INPUT_TEXT"))).thenReturn("RETURN_TEXT");

        //than
        assertEquals("RETURN_TEXT", mockedList.someMethod("INPUT_TEXT"));
    }
}
