package pl.pb.junitexamples.Mockito_3_Argument_matchers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("3. How about some stubbing? when()")
public class TestsWhen {

    @Test
    public void testAny() {
        //given
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //than
        assertEquals("element", mockedList.get(2));
    }

    @Test
    public void testEq() {
        //given
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(eq(3))).thenReturn("element");

        //than
        assertEquals("element", mockedList.get(3));
    }

    @Test
    public void testArgThat() {
        //given
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.contains(argThat(new ArgumentMatcher<Object>() {
            @Override
            public boolean matches(Object o) {
                return ((int) o) == 3;
            }
        }))).thenReturn(true);

        //than
        assertEquals(true, mockedList.contains(3));
    }
}
