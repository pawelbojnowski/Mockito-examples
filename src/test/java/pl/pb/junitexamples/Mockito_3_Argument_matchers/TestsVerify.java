package pl.pb.junitexamples.Mockito_3_Argument_matchers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

@DisplayName("3. How about some stubbing? verify()")
public class TestsVerify {

    @Test
    public void testAny() {
        //given
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //when
        mockedList.get(2);

        //than
        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());
    }

    @Test
    public void testEq() {
        //given
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");


        //when
        mockedList.get(2);

        //than
        //you can also verify using an argument matcher
        verify(mockedList).get(eq(2));
    }

    @Test
    public void testArgThat() {
        //given
        //You can mock concrete classes, not just interfaces
        LinkedList<String> mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //when
        mockedList.add("element");

        //than
        //you can also verify using an argument matcher
        verify(mockedList).add(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String s) {
                return s.equals("element");
            }
        }));

    }
}
