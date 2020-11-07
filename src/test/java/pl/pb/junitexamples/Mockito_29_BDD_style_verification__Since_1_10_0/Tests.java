package pl.pb.junitexamples.Mockito_29_BDD_style_verification__Since_1_10_0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@DisplayName("29. BDD style verification (Since 1.10.0)")
public class Tests {

    @Test
    public void test() {
        //given
        List<String> mockedList = mock(List.class);
        BDDMockito.given(mockedList.size()).willReturn(1);

        //when
        int size = mockedList.size();

        //than
        BDDMockito.then(mockedList).should(times(1)).size();
    }
}
