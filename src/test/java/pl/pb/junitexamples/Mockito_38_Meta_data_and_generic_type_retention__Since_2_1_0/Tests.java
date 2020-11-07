package pl.pb.junitexamples.Mockito_38_Meta_data_and_generic_type_retention__Since_2_1_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@DisplayName("38. Meta data and generic type retention (Since 2.1.0)")
public class Tests {

    @Test
    public void test() throws NoSuchMethodException {
        Class<?> mockType = mock(MyClass.class).getClass();

        assertTrue(mockType.isAnnotationPresent(MyAnnotation.class));
        assertTrue(mockType.getDeclaredMethod("bar").getGenericReturnType() instanceof ParameterizedType);
    }
}
