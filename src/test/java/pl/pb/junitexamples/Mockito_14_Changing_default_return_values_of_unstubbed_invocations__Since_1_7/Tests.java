package pl.pb.junitexamples.Mockito_14_Changing_default_return_values_of_unstubbed_invocations__Since_1_7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import pl.pb.junitexamples.utils.TestObject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("14. Changing default return values of unstubbed invocations (Since 1.7)")
public class Tests {

    @Test
    public void testMockMethodWithReturnsSmartNulls() {
        //given
        TestObject mockObject = mock(TestObject.class, RETURNS_SMART_NULLS);

        //when - than
        assertEquals("", mockObject.someMethodReturnString());
        assertEquals(0L, mockObject.someMethodReturnLong());
        assertTrue(mockingDetails(mockObject).isMock());
    }

    @Test
    public void testMockMethodWithReturnsDeepStubs() {
        //given
        TestObject mockObject = mock(TestObject.class, RETURNS_DEEP_STUBS);

        //when - than
        assertEquals(null, mockObject.someMethodReturnString());
        assertEquals(0l, mockObject.someMethodReturnLong());
        assertTrue(mockingDetails(mockObject).isMock());
    }

    @Test
    public void testMockMethodWithReturnsDefaults() {
        //given
        TestObject mockObject = mock(TestObject.class, RETURNS_DEFAULTS);

        //when - than
        assertEquals(null, mockObject.someMethodReturnString());
        assertEquals(0l, mockObject.someMethodReturnLong());
        assertEquals(null, mockObject.someMethodReturnTestObject());

    }

    @Test
    public void testMockMethodWithReturnsMocks() {
        //given
        TestObject mockObject = mock(TestObject.class, RETURNS_MOCKS);

        //when - than
        assertEquals("", mockObject.someMethodReturnString());
        assertEquals(0L, mockObject.someMethodReturnLong());
        assertTrue(mockingDetails(mockObject).isMock());
    }


    @Test
    public void testMockMethodWithReturnsSelf() {
        //given
        TestObject mockObject = mock(TestObject.class, RETURNS_SELF);

        //when - than
        assertEquals(null, mockObject.someMethodReturnString());
        assertEquals(0L, mockObject.someMethodReturnLong());
        assertEquals(mockObject, mockObject.someMethodReturnTestObject());
    }


    @Test
    public void testMockMethodWithCustomAnswer() {
        //given
        TestObject realObject = new TestObject();

        TestObject mockObject = mock(TestObject.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                if (invocation.getMethod().getReturnType().equals(String.class)) {
                    return "Returned custom String";
                }

                if (invocation.getMethod().getReturnType().equals(Long.class)) {
                    return Long.MAX_VALUE;
                }

                if (invocation.getMethod().getReturnType().equals(TestObject.class)) {
                    return realObject;
                }

                throw new UnsupportedOperationException();
            }
        });


        //when - than
        assertEquals("Returned custom String", mockObject.someMethodReturnString());
        assertEquals(9223372036854775807L, mockObject.someMethodReturnLong());
        assertEquals(realObject, mockObject.someMethodReturnTestObject());
        assertThrows(UnsupportedOperationException.class, () -> {
            mockObject.someMethodReturnInteger();
        });
    }
}
