package pl.pb.junitexamples.utils;

public class PersonRepository {

    public Person findById(Long id) {
        return new Person("Raul", "Gonzales");
    }
}
