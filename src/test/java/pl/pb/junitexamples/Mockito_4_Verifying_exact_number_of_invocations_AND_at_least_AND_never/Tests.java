package pl.pb.junitexamples.Mockito_4_Verifying_exact_number_of_invocations_AND_at_least_AND_never;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.noMoreInteractions;

@DisplayName("4. Verifying exact number of invocations / at least x / never")
public class Tests {

    @Test
    public void testTimes() {
        //given
        List mockedList = mock(List.class);

        //when
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");

        //than
        verify(mockedList, times(1)).add("once");
        verify(mockedList, times(2)).add("twice");

        // all invocation
        verify(mockedList, times(3)).add(any());
    }

    @Test
    public void testAtLeastOnce() {
        //given
        List mockedList = mock(List.class);

        //when
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");

        //than
        verify(mockedList, atLeastOnce()).add("once");

        //this will failed, any invocation with "three times"
        //verify(mockedList, atLeastOnce()).add("three times");
    }

    @Test
    public void testAtLeast() {
        //given
        List mockedList = mock(List.class);

        //when
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");

        //than
        verify(mockedList, atLeast(1)).add("once");

        //this will failed, only 2 invocation with "twice"
        //verify(mockedList, atLeast(3)).add("twice");
    }

    @Test
    public void testAtMost() {
        //given
        List mockedList = mock(List.class);

        //when
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("twice");

        //than
        verify(mockedList, atMost(1)).add("once");

        //this will failed, more that 2 invocation with "twice"
        //verify(mockedList, atMost(2)).add("twice");
    }

    @Test
    public void testOnly() {
        //given
        List mockedList = mock(List.class);

        //when
        mockedList.add("once");

        //than
        // will be success only when method is invoke only one time and with specific argument - in this case "once"
        verify(mockedList, only()).add("once");
    }

    @Test
    public void testsNoMoreInteractions() {
        //given
        List mockedList = mock(List.class);

        //when
        mockedList.add("once");

        //than
        verify(mockedList).add("once");
        verify(mockedList, noMoreInteractions()).add("once");

        //will fail, method invoked one more time since last verification
        //mockedList.add("once");
        //verify(mockedList, noMoreInteractions()).add("once");
    }

    @Test
    public void testsCalls() {
        //given
        List mockedList = mock(List.class);
        InOrder verifier = inOrder(mockedList);

        //when
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");

        //than
        verifier.verify(mockedList, calls(1)).add("once");

        //will fail, method invoked only 2 times, expected 3
        verifier.verify(mockedList, calls(3)).add("twice");
    }
}
