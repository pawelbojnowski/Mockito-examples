package pl.pb.junitexamples.Mockito_35_Custom_verification_failure_message_Since_2_1_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("35. Custom verification failure message (Since 2.1.0)")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);

        //when
        mockedList.add("A");

        //than
        // will print a custom message on verification failure
        verify(mockedList, description("--> This will print on failure")).size();

        // will work with any verification mode
        verify(mockedList, times(2).description("--> add() should be called twice")).add("A");
    }
}
