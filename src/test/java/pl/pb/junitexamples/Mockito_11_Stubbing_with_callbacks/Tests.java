package pl.pb.junitexamples.Mockito_11_Stubbing_with_callbacks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import pl.pb.junitexamples.utils.TestObject;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("11. Stubbing with callbacks")
public class Tests {

    @Test
    public void test() {
        //given
        TestObject mockedList = mock(TestObject.class);

        when(mockedList.someMethod(any())).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocation) {
                        Object[] args = invocation.getArguments();
                        System.out.println(String.format("Arguments: %s", args[0]));

                        Object mock = invocation.getMock();
                        System.out.println(String.format("Mock object: %s", mock.toString()));

                        return "called with arguments: " + Arrays.toString(args);
                    }
                });

        //when - than
        assertEquals("called with arguments: [foo]", mockedList.someMethod("foo"));
        System.out.println(mockedList.someMethod("foo"));
    }

    @Test
    public void testLambdaApproach() {
        //given
        TestObject mockedList = mock(TestObject.class);

        when(mockedList.someMethod(any())).thenAnswer(
                invocation -> {
                    Object[] args = invocation.getArguments();
                    System.out.println(String.format("Arguments: %s", args[0]));

                    Object mock = invocation.getMock();
                    System.out.println(String.format("Mock object: %s", mock.toString()));

                    return "called with arguments: " + Arrays.toString(args);
                });

        //when - than
        assertEquals("called with arguments: [foo]", mockedList.someMethod("foo"));
        System.out.println(mockedList.someMethod("foo"));
    }
}
