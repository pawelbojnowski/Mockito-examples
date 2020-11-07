package pl.pb.junitexamples.Mockito_9_Shorthand_for_mocks_creation_Mock_annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

@DisplayName("9. Shorthand for mocks creation - @Mock annotation")
public class Tests {

    @Mock
    private List<String> classFieldMockObject;
    @Mock
    private List<String> methodArgumentMockObject;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testClassFieldMockObject() {
        //when
        classFieldMockObject.add("one");

        //than
        verify(classFieldMockObject).add("one");
    }
}
