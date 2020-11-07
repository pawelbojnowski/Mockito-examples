package pl.pb.junitexamples.Mockito_9_Shorthand_for_mocks_creation_Mock_annotation;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

@DisplayName("9. Shorthand for mocks creation - @Mock annotation with Junit 4")
@RunWith(MockitoJUnitRunner.class)
public class TestsMockitoJUnitRunnerAnnotationJunit4 {

    @Mock
    private List<String> propertyMockObject;

    @Test
    public void testPropertyMockObject() {
        //when
        propertyMockObject.add("one");

        //than
        verify(propertyMockObject).add("one");
    }
}
