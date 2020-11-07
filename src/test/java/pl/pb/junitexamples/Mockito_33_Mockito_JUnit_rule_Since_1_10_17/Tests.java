package pl.pb.junitexamples.Mockito_33_Mockito_JUnit_rule_Since_1_10_17;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockingDetails;

@DisplayName("33. Mockito JUnit rule (Since 1.10.17)")

public class Tests {

    //JUnit 4 rules and runners don't work in JUnit 5
    //IN Junit 5 we need to user @ExtendWith(MockitoExtension.class)
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule().silent();

    @Mock
    private List<String> mockedList;

    @Test
    public void test() {

        //than
        assertTrue(mockingDetails(mockedList).isMock());
    }
}
