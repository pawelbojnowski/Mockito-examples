package pl.pb.junitexamples.Mockito_9_Shorthand_for_mocks_creation_Mock_annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@DisplayName("9. Shorthand for mocks creation - @Mock annotation with Junit 5")
@ExtendWith(MockitoExtension.class)
public class TestsMockitoJUnitRunnerAnnotationJunit5 {

    @Mock
    List<String> propertyMockObject;

    @Test
    public void testPropertyMockObject2() {
        //when
        propertyMockObject.add("one");

        //than
        verify(propertyMockObject).add("one");
    }
}
