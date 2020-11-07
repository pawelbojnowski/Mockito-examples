package pl.pb.junitexamples.Mockito_13_Spying_on_real_objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("12. Spying on real objects")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = new ArrayList<>();
        List<String> spiedList = spy(mockedList);
        //when
        spiedList.add("one");
        spiedList.add("two");

        //than
        verify(spiedList).add("one");
        verify(spiedList).add("two");
        assertEquals("one", spiedList.get(0));
        assertEquals("two", spiedList.get(1));
    }

    @Test
    public void testMockMethodInSpiedObject() {
        //given
        List<String> mockedList = new ArrayList<>();
        List<String> spiedList = spy(mockedList);
        when(spiedList.size()).thenReturn(100);
        //when
        spiedList.add("one");

        //than
        assertEquals(100, spiedList.size());

        verify(spiedList).add("one");
        assertEquals("one", spiedList.get(0));
    }

    @Test
    public void testMethodStubbing() {
        //given
        List<String> mockedList = new ArrayList<>();
        List<String> spiedList = spy(mockedList);

        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        //when(spiedList.get(0)).thenReturn("one");

        /**
         * You have to use doReturn() for stubbing
         * doReturn|Answer|Throw()
         */
        doReturn("one").when(spiedList).get(0);

        //when - than
        assertEquals("one", spiedList.get(0));
    }
}
