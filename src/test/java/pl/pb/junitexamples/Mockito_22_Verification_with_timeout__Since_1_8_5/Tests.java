package pl.pb.junitexamples.Mockito_22_Verification_with_timeout__Since_1_8_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@DisplayName("22. Verification with timeout (Since 1.8.5)")
public class Tests {

    @Test
    public void test() {
        //given
        ExternalService externalService = mock(ExternalService.class);

        //when
        externalService.someMethod(1000);

        //than
        verify(externalService, timeout(1000)).someMethod(eq(1000));
    }

    @Test
    public void testMoreThanOneExecution() {
        //given
        ExternalService externalService = mock(ExternalService.class);

        //when
        externalService.someMethod(1000);
        externalService.someMethod(2000);
        externalService.someMethod(2000);
        externalService.someMethod(3000);
        externalService.someMethod(3000);
        externalService.someMethod(3000);

        //than
        verify(externalService, timeout(1000).atLeastOnce()).someMethod(eq(1000));
        verify(externalService, timeout(2000).times(2)).someMethod(eq(2000));
        //expect minimum 2 execution but was 3 - test accepted
        verify(externalService, timeout(3000).atLeast(2)).someMethod(eq(3000));
    }
}
