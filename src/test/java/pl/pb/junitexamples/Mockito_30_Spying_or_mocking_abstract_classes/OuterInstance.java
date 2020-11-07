package pl.pb.junitexamples.Mockito_30_Spying_or_mocking_abstract_classes;

public class OuterInstance {

    public abstract class InnerAbstract {
        public String getValue(String value) {
            return "Given value: '" + value + "'";
        }
    }
}
