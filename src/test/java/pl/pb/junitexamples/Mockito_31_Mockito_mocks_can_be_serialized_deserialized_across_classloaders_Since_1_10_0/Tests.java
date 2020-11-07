package pl.pb.junitexamples.Mockito_31_Mockito_mocks_can_be_serialized_deserialized_across_classloaders_Since_1_10_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;
import static org.mockito.mock.SerializableMode.ACROSS_CLASSLOADERS;

@DisplayName("31. Mockito mocks can be serialized / deserialized across classloaders (Since 1.10.0)")
public class Tests {

    @Test
    public void test() {
        // use regular serialization
        List<String> mockedList = mock(List.class, withSettings().serializable());
        // use serialization across classloaders
        List<String> mockedList2 = mock(List.class, withSettings().serializable(ACROSS_CLASSLOADERS));
    }
}
