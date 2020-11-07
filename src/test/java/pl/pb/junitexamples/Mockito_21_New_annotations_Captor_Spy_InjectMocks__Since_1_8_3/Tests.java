package pl.pb.junitexamples.Mockito_21_New_annotations_Captor_Spy_InjectMocks__Since_1_8_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pb.junitexamples.utils.Person;
import pl.pb.junitexamples.utils.PersonRepository;
import pl.pb.junitexamples.utils.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@DisplayName("21. New annotations: @Captor, @Spy, @InjectMocks (Since 1.8.3)")
@ExtendWith(MockitoExtension.class)
public class Tests {

    @Captor
    ArgumentCaptor<Long> inputArgumentCaptor;
    @Spy
    private PersonRepository personRepository;
    @InjectMocks
    private PersonService personService;

    @Test
    public void test() {
        //given
        //personRepository.findById(...) returns: new Person("Raul", "Gonzales")

        //when
        Person result = personService.findById(1l);

        //than
        verify(personRepository).findById(inputArgumentCaptor.capture());
        assertEquals(Long.valueOf(1), inputArgumentCaptor.getValue());

        assertEquals("Raul", result.getFirstName());
        assertEquals("Gonzales", result.getLastName());
    }
}
