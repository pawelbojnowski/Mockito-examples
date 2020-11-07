package pl.pb.junitexamples.Mockito_26_Mocking_details__Improved_in_2_2_x;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.MockingDetails;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("26. Mocking details (Improved in 2.2.x)")
public class Tests {

    @Test
    public void testIfObjectIsMockedOrSpied() {
        List<String> list = new ArrayList<>();
        List<String> spiedList = spy(List.class);
        List<String> mockedList = mock(List.class);


        assertFalse(mockingDetails(list).isMock());
        assertTrue(mockingDetails(spiedList).isSpy());
        assertFalse(!mockingDetails(mockedList).isMock());

    }


    @Test
    public void testDetailsOfMockedObject() {
        List<String> mockedList = mock(List.class);


        //Getting details like type to mock or default answer:
        MockingDetails details = mockingDetails(mockedList);
        assertEquals(List.class, details.getMockCreationSettings().getTypeToMock());
        assertEquals(Answers.RETURNS_DEFAULTS, details.getMockCreationSettings().getDefaultAnswer());

    }

    @Test
    public void testDetailsMockInteractions() {

        //Given
        List<String> mockedList = mock(List.class);
        when(mockedList.get(1)).thenReturn("EXAMPLE_TEXT");

        //when
        mockedList.size();
        mockedList.add("2");

        //Getting invocations and stubbings of the mock:
        MockingDetails details = mockingDetails(mockedList);
        assertEquals("[list.size();, list.add(\"2\");]", details.getInvocations().toString());
        assertEquals("[list.get(1); stubbed with: [Returns: EXAMPLE_TEXT]]", details.getStubbings().toString());

        System.out.println(mockingDetails(mockedList).printInvocations());
        /**
         * Example result:
         * [Mockito] Interactions of: Mock for List, hashCode: 17600354
         *  1. list.size();
         *   -> at pl.pb.junitexamples.Mockito_26_Mocking_details__Improved_in_2_2_x.Tests.testIfObjectIsMockedOrSpied2(Tests.java:51)
         *  2. list.add("2");
         *   -> at pl.pb.junitexamples.Mockito_26_Mocking_details__Improved_in_2_2_x.Tests.testIfObjectIsMockedOrSpied2(Tests.java:52)
         * [Mockito] Unused stubbings of: Mock for List, hashCode: 17600354
         *  1. list.get(1);
         *   - stubbed -> at pl.pb.junitexamples.Mockito_26_Mocking_details__Improved_in_2_2_x.Tests.testIfObjectIsMockedOrSpied2(Tests.java:48)
         */
    }
}
