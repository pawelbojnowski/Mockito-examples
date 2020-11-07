package pl.pb.junitexamples.Mockito_19_Aliases_for_behavior_driven_development_Since_1_8_0;

import pl.pb.junitexamples.utils.Person;

public class PersonRepository {
    public Person findById(Long id) {
        return new Person("", "");
    }
}
