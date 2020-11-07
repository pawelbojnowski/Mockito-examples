package pl.pb.junitexamples.Mockito_5_Stubbing_void_methods_with_exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@DisplayName("5. Stubbing void methods with exceptions")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);

        //when
        doThrow(new RuntimeException()).when(mockedList).clear();

        //than
        assertThrows(RuntimeException.class, () -> {
            //following throws RuntimeException:
            mockedList.clear();
        });
    }
}
