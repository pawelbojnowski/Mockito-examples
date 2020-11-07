package pl.pb.junitexamples.Mockito_16_Real_partial_mocks_Since_1_8_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pb.junitexamples.utils.TestObject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("16. Real partial mocks (Since 1.8.0)")
public class Tests {

    @Test
    public void testCallMockedMethodInSpiedObject() {
        //given
        TestObject mockedList = spy(TestObject.class);
        //you can create partial mock with spy() method:
        doReturn("mocked value").when(mockedList).someMethod(any());

        //when - than
        assertEquals("mocked value", mockedList.someMethod("text"));
    }

    @Test
    public void testCallRealMethodInMockedObject() {
        //given
        TestObject mockedList = mock(TestObject.class);
        //you can enable partial mock capabilities selectively on mocks:
        //Be sure the real implementation is 'safe'.
        //If real implementation throws exceptions or depends on specific state of the object then you're in trouble.
        when(mockedList.someMethod(any())).thenCallRealMethod();

        //when - than
        assertEquals("text", mockedList.someMethod("text"));
    }
}
