package pl.pb.junitexamples.Mockito_36_Java_8_Lambda_Matcher_Support_Since_2_1_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@DisplayName("36. Java 8 Lambda Matcher Support (Since 2.1.0)")
public class Tests {

    @Test
    public void testVerify() {
        //given
        List<String> mockedList = mock(List.class);

        //when
        // verify a list only had strings of a certain length added to it
        mockedList.add("TEXT");
        mockedList.addAll(asList("TEXT1", "TEXT2", "TEXT3"));


        //than
        // note - this will only compile under Java 8
        verify(mockedList, times(1)).add(argThat(string -> string.length() < 5));

        // Java 7 equivalent - not as neat
        verify(mockedList, times(1)).add(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String string) {
                return string.length() < 5;
            }
        }));
    }

    //todo
    @Test
    public void testWhen() {
        //given
        List<String> mockedList = mock(List.class);

        // this can also be used when defining the behaviour of a mock under different inputs
        // in this case if the input list was fewer than 3 items the mock returns null
        when(mockedList.addAll(argThat(list -> list.size() == 1))).thenReturn(true);

        //when / than
        assertTrue(mockedList.addAll(asList("TEXT1")));
        assertFalse(mockedList.addAll(asList("TEXT1", "TEXT2")));

    }
}
