package pl.pb.junitexamples.Mockito_32_Better_generic_support_with_deep_stubs__Since_1_10_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pb.junitexamples.utils.Person;

import java.util.ArrayList;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;

@DisplayName("32. Better generic support with deep stubs (Since 1.10.0)")
public class Tests {

    @Test
    public void test() {
        //given
        Lines mockedList = mock(Lines.class, RETURNS_DEEP_STUBS);
        //when

        //than
        Person line = mockedList.iterator().next();
    }

    class Lines extends ArrayList<Person> {
        //...
    }
}
