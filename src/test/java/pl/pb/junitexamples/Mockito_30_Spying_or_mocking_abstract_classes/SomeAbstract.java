package pl.pb.junitexamples.Mockito_30_Spying_or_mocking_abstract_classes;

public abstract class SomeAbstract {

    private int intValue;


    public SomeAbstract() {
    }

    public SomeAbstract(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue(String value) {
        return "Given value: '" + value + "'";
    }
}
