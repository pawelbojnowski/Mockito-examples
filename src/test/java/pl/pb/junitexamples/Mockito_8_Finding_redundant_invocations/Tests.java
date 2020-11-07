package pl.pb.junitexamples.Mockito_8_Finding_redundant_invocations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("8. Finding redundant invocations")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);
        //when

        //using mocks
        mockedList.add("one");
        mockedList.add("two");
        //than
        verify(mockedList).add("one");

        //following verification will fail
        verifyNoMoreInteractions(mockedList);
        //Mockito.verifyNoMoreInteractions(mockedList, otherMockObject...);
    }
}
