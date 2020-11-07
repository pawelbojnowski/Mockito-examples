package pl.pb.junitexamples.Mockito_19_Aliases_for_behavior_driven_development_Since_1_8_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import pl.pb.junitexamples.utils.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("19. Aliases for behavior driven development (Since 1.8.0)")
public class Tests {

    @Test
    public void test() {
        //given
        PersonRepository personRepository = mock(PersonRepository.class);
        PersonService personService = new PersonService(personRepository);

        Person expected = new Person("Alessandro", "Del Piero");
        when(personRepository.findById(anyLong())).thenReturn(expected);
        //when
        Person result = personService.getPersonById(1L);

        //then
        assertEquals(expected, result);
        verify(personRepository).findById(1l);
    }

    @Test
    public void testWithBDDMockito() {
        //given
        PersonRepository personRepository = mock(PersonRepository.class);
        PersonService personService = new PersonService(personRepository);
        Person expected = new Person("Alessandro", "Del Piero");
        // -- BDDMockito --
        BDDMockito.given(personRepository.findById(anyLong())).willReturn(expected);

        //when
        Person result = personService.getPersonById(1L);

        //then
        assertEquals(expected, result);
        // -- BDDMockito --
        BDDMockito.then(personRepository).should().findById(1l);
    }
}
