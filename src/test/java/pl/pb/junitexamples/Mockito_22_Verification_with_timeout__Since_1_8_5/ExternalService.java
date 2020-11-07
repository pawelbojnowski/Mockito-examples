package pl.pb.junitexamples.Mockito_22_Verification_with_timeout__Since_1_8_5;

public class ExternalService {
    public void someMethod(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
