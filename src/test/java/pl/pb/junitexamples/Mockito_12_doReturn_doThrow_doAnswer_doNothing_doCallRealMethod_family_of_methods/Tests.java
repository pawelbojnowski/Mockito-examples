package pl.pb.junitexamples.Mockito_12_doReturn_doThrow_doAnswer_doNothing_doCallRealMethod_family_of_methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pb.junitexamples.utils.TestObject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("12. doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() family of methods")
public class Tests {

    @Test
    public void testDoReturn() {
        //given
        TestObject mockedList = mock(TestObject.class);
        doReturn("Text")
                .when(mockedList)
                .someMethod(eq("test"));

        //when
        String result = mockedList.someMethod("test");

        //than
        assertEquals("Text", result);
    }

    @Test
    public void testDoThrow() {

        //given
        TestObject mockedList = mock(TestObject.class);
        RuntimeException runtimeException = new RuntimeException();
        doThrow(runtimeException)
                .when(mockedList)
                .someMethod(eq("test"));

        //when
        RuntimeException result = assertThrows(RuntimeException.class, () -> {
            mockedList.someMethod("test");
        });

        //than
        assertEquals(runtimeException, result);
    }

    @Test
    public void testDoAnswer() {

        //given
        TestObject mockedList = mock(TestObject.class);
        doAnswer(invocation -> "Text")
                .when(mockedList)
                .someMethod(eq("test"));

        //when
        String result = mockedList.someMethod("test");

        //than
        assertEquals("Text", result);
    }

    @Test
    public void testDoThrowClass() {

        //given
        TestObject mockedList = mock(TestObject.class);
        doThrow(RuntimeException.class)
                .when(mockedList)
                .someMethod(eq("test"));

        //when
        RuntimeException result = assertThrows(RuntimeException.class, () -> {
            mockedList.someMethod("test");
        });

        //than
        assertEquals(RuntimeException.class, result.getClass());
    }

    @Test
    public void testDoNothing() {

        //given
        TestObject mockedList = mock(TestObject.class);
        doNothing()
                .when(mockedList)
                .someVoidMethod(eq("test"));

        //when
        mockedList.someVoidMethod("test");

        //In console log should not be display: "Executed: MockObject.someVoidMethod()"
    }

    @Test
    public void testDoCallRealMethod() {

        //given
        TestObject mockedList = mock(TestObject.class);
        doCallRealMethod()
                .when(mockedList)
                .someMethod(eq("test"));

        //when
        String result = mockedList.someMethod("test");

        //than
        assertEquals("test", result);

    }

    @Test
    public void testDoCallRealMethod_VoidMethod() {

        //given
        TestObject mockedList = mock(TestObject.class);

        doCallRealMethod()
                .when(mockedList)
                .someVoidMethod(eq("test"));

        //when
        mockedList.someVoidMethod("test");

        //than
        //In console log should be display: "Executed: MockObject.someVoidMethod()"

    }
}
