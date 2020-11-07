package pl.pb.junitexamples.utils;

public class TestObject {

    public String someMethod(String any) {
        System.out.println("Executed: MockObject.someMethod()");
        return any;
    }

    public void someVoidMethod(String any) {
        System.out.println("Executed: MockObject.someVoidMethod()");
    }

    //----------------------------------------------------------------------

    public String someMethodReturnString() {
        System.out.println("Executed: MockObject.someMethodReturnString()");
        return "someMethod";
    }

    public Long someMethodReturnLong() {
        System.out.println("Executed: MockObject.someMethodReturnLong()");
        return 123l;
    }

    public TestObject someMethodReturnTestObject() {
        System.out.println("Executed: MockObject.someMethodReturnMockObject()");
        return new TestObject();
    }

    public Integer someMethodReturnInteger() {
        System.out.println("Executed: MockObject.someMethodReturnMockObject()");
        return Integer.valueOf(1);
    }

    //----------------------------------------------------------------------

    public void addPerson(Person person) {
        System.out.println("Executed: MockObject.addPerson(" + person + ")");
    }
}
