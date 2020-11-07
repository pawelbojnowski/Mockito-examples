package pl.pb.junitexamples.Mockito_37_Java_8_Custom_Answer_Support__Since_2_1_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pb.junitexamples.utils.Person;
import pl.pb.junitexamples.utils.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@DisplayName("37. Java 8 Custom Answer Support (Since 2.1.0)")
public class Tests {

    @Test
    public void test() {
        //given
        PersonService mockedList = mock(PersonService.class);
        //when

        doAnswer(invocation -> {
            return new Person("Luka", "Modrić");
        }).when(mockedList).findById(any());

        //than
        // answer by returning `Person("Luka", "Modrić")` every time
        assertEquals("Luka", mockedList.findById(1l).getFirstName());
        assertEquals("Modrić", mockedList.findById(1l).getLastName());
    }

    @Test
    public void testInvocationArgument() {
        //given
        PersonService mockedList = mock(PersonService.class);
        //when

        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            if (id == 1l) {
                return new Person("Grzegorz", "Krychowiak");
            } else if (id == 2l) {
                return new Person("Luka", "Modrić");
            }
            return null;
        }).when(mockedList).findById(any());

        //than
        // answer by returning `Person("Luka", "Modrić")` every time
        assertEquals("Person{firstName='Grzegorz', lastName='Krychowiak'}", mockedList.findById(1l).toString());
        assertEquals("Person{firstName='Luka', lastName='Modrić'}", mockedList.findById(2l).toString());
        assertNull(mockedList.findById(3l));
    }
}
