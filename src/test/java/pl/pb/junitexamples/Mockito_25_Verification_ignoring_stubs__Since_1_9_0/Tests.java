package pl.pb.junitexamples.Mockito_25_Verification_ignoring_stubs__Since_1_9_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("25. Verification ignoring stubs (Since 1.9.0)")
public class Tests {

    @Test
    public void test() {

        //given
        List<String> mockedListOne = spy(List.class);
        List<String> mockedListTwo = spy(List.class);

        //when
        mockedListOne.size();
        mockedListTwo.size();
        //than

        verify(mockedListOne).size();
        verify(mockedListTwo).size();

        //ignores all stubbed methods:
        verifyNoMoreInteractions(ignoreStubs(mockedListOne, mockedListTwo));

        //creates InOrder that will ignore stubbed
        InOrder inOrder = inOrder(ignoreStubs(mockedListOne, mockedListTwo));
        inOrder.verify(mockedListOne).size();
        inOrder.verify(mockedListTwo).size();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void testDifferentOrderOfExecutionMethod() {

        //given
        List<String> mockedListOne = spy(List.class);
        List<String> mockedListTwo = spy(List.class);

        //when
        mockedListTwo.size(); //<<--
        mockedListOne.size();
        //than

        verify(mockedListOne).size();
        verify(mockedListTwo).size();

        //ignores all stubbed methods:
        verifyNoMoreInteractions(ignoreStubs(mockedListOne, mockedListTwo));

        //creates InOrder that will ignore stubbed
        InOrder inOrder = inOrder(ignoreStubs(mockedListOne, mockedListTwo));
        inOrder.verify(mockedListOne).size();
        inOrder.verify(mockedListTwo).size();
        inOrder.verifyNoMoreInteractions();
    }
}
