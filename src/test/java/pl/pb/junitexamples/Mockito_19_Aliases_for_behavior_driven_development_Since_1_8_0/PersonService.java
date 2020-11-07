package pl.pb.junitexamples.Mockito_19_Aliases_for_behavior_driven_development_Since_1_8_0;

import pl.pb.junitexamples.utils.Person;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id);
    }
}
