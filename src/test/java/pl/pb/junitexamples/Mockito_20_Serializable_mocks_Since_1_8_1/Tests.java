package pl.pb.junitexamples.Mockito_20_Serializable_mocks_Since_1_8_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("20. Serializable mocks (Since 1.8.1)")
public class Tests {

    @Test
    public void testMock() {
        //given
        List<String> serializableMock = mock(List.class, withSettings().serializable());
        when(serializableMock.get(1)).thenReturn("foo");
        //when
        String result = serializableMock.get(1);
        //than
        assertEquals("foo", result);
    }

    @Test
    public void testSpy() {
        //given
        List<String> spy = mock(ArrayList.class, withSettings()
                .spiedInstance(new ArrayList<String>())
                .defaultAnswer(CALLS_REAL_METHODS)
                .serializable());

        spy.add("foo");

        //when
        String result = spy.get(0);
        //than
        verify(spy).add(eq("foo"));
        assertEquals("foo", result);


    }
}
