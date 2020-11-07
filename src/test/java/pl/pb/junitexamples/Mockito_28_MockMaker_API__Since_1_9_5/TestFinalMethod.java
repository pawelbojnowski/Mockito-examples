package pl.pb.junitexamples.Mockito_28_MockMaker_API__Since_1_9_5;

public class TestFinalMethod {

    public final String someMethod(String any) {
        System.out.println("Executed: MockObject.someMethod()");
        return any;
    }
}
