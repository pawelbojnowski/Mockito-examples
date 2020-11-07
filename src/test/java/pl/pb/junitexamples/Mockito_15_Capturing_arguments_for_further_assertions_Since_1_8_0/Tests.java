package pl.pb.junitexamples.Mockito_15_Capturing_arguments_for_further_assertions_Since_1_8_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pl.pb.junitexamples.utils.Person;
import pl.pb.junitexamples.utils.TestObject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("15. Capturing arguments for further assertions (Since 1.8.0)")
public class Tests {

    @Test
    public void test() {
        //given
        TestObject mockedTestObject = mock(TestObject.class);
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);

        //when
        mockedTestObject.addPerson(new Person("Wayne", "Rooney"));

        //than
        verify(mockedTestObject).addPerson(argument.capture());

        assertEquals("Wayne", argument.getValue().getFirstName());
        assertEquals("Rooney", argument.getValue().getLastName());
    }
}
