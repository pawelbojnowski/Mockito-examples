package pl.pb.junitexamples.Mockito_30_Spying_or_mocking_abstract_classes;

public interface InterfaceExample {

    default String getValue(String value) {
        return "Given value: '" + value + "'";
    }
}
