package pl.pb.junitexamples.utils;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.findById(id);
    }

    public void Update(Person person) {
        //this method does some updated
    }
}
