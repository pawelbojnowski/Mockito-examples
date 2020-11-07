package pl.pb.junitexamples.Mockito_6_Verification_in_order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

@DisplayName("6. Verification in order")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);
        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(mockedList);


        //when
        //using a single mock
        mockedList.add("was added first");
        mockedList.add("was added second");

        //than
        //following will make sure that add is first called with "was added first", then with "was added second"
        inOrder.verify(mockedList).add("was added first");
        inOrder.verify(mockedList).add("was added second");
    }

    @Test

    public void testMultipleMockObjects() {
        //given
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //create inOrder object passing any mocks that need to be verified in order
        InOrder inOrder = inOrder(firstMock, secondMock);

        //when
        //using a single mock
        firstMock.add("was called first");
        secondMock.add("was called second");

        //than
        //following will make sure that firstMock was called before secondMock
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }
}
