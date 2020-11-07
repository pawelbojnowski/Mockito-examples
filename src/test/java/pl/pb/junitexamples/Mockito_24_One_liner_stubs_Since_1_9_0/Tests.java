package pl.pb.junitexamples.Mockito_24_One_liner_stubs_Since_1_9_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pb.junitexamples.utils.Person;
import pl.pb.junitexamples.utils.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("24. One-liner stubs (Since 1.9.0)")
public class Tests {

    private PersonRepository personRepository = when(mock(PersonRepository.class).findById(any()))
            .thenReturn(new Person("Sergio", "Ramos"))
            .getMock();

    @Test
    public void test() {
        assertEquals(new Person("Sergio", "Ramos"), personRepository.findById(1l));
    }
}
