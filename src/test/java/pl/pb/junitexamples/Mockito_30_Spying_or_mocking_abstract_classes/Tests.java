package pl.pb.junitexamples.Mockito_30_Spying_or_mocking_abstract_classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("30. Spying or mocking abstract classes (Since 1.10.12, further enhanced in 2.7.13 and 2.7.14)")
public class Tests {

    @Test
    public void testAbstractClass() {
        //given
        //convenience API, new overloaded spy() method:
        SomeAbstract spy = spy(SomeAbstract.class);

        //when
        String result = spy.getStringValue("TEST_VALUE");

        //when
        assertEquals("Given value: 'TEST_VALUE'", result);
    }

    @Test
    public void testInterface() {
        //given
        //Mocking abstract methods, spying default methods of an interface (only available since 2.7.13)
        InterfaceExample function = spy(InterfaceExample.class);

        //when
        String result = function.getValue("TEST_VALUE");

        //when
        assertEquals("Given value: 'TEST_VALUE'", result);
    }

    @Test
    public void testAbstractClassWithDefaultAnswer() {
        //given
        //Robust API, via settings builder:
        OtherAbstract mocked = mock(OtherAbstract.class, withSettings()
                .useConstructor().defaultAnswer(CALLS_REAL_METHODS));

        //when
        String result = mocked.getValue("TEST_VALUE");

        //when
        assertEquals("Given value: 'TEST_VALUE'", result);
    }

    @Test
    public void testConstructorAbstractClass() {
        //given
        //Mocking an abstract class with constructor arguments (only available since 2.7.14)
        SomeAbstract mocked = mock(SomeAbstract.class, withSettings()
                .useConstructor(123).defaultAnswer(CALLS_REAL_METHODS));

        //when
        int result = mocked.getIntValue();

        //when
        assertEquals(123, result);
    }

    @Test
    public void testInnerAbstractClass() {
        //given
        //Mocking a non-static inner abstract class:
        OuterInstance outerInstance = new OuterInstance();
        OuterInstance.InnerAbstract mocked = mock(OuterInstance.InnerAbstract.class,
                withSettings().useConstructor().outerInstance(outerInstance).defaultAnswer(CALLS_REAL_METHODS)
        );

        //when
        String result = mocked.getValue("TEST_VALUE");

        //when
        assertEquals("Given value: 'TEST_VALUE'", result);
    }
}
