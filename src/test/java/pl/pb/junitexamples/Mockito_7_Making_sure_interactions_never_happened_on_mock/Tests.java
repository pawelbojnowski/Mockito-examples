package pl.pb.junitexamples.Mockito_7_Making_sure_interactions_never_happened_on_mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("7. Making sure interaction(s) never happened on mock")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);

        //when
        //using mocks - only mockOne is interacted
        mockedList.add("one");

        //than
        //ordinary verification
        verify(mockedList).add("one");
        //verify that method was never called on a mock
        verify(mockedList, never()).add("two");
    }

    @Test
    public void testVerificationMoreThanOneMockObject() {
        //given
        List<String> mockedList = mock(List.class);
        List<String> mockedOtherList = mock(List.class);

        //when
        //using mocks - only mockOne is interacted
        mockedList.add("one");
        mockedOtherList.add("three");

        //than
        //ordinary verification
        verify(mockedList).add("one");
        verify(mockedList).add("three");

        //verify that method was never called on a mock
        verify(mockedList, never()).add("two");
    }
}