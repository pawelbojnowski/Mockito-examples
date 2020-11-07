package pl.pb.junitexamples.Mockito_1_Let_s_verify_some_behaviour;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("1. Let's verify some behaviour!")
public class Tests {

    @Test
    public void test() {
        //given
        //mock creation
        List mockedList = mock(List.class);

        //when
        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //than
        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
