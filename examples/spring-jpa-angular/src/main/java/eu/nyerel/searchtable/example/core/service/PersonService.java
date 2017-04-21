package eu.nyerel.searchtable.example.core.service;

import eu.nyerel.searchtable.example.core.entity.PersonEntity;
import eu.nyerel.searchtable.example.core.repository.PersonRepository;
import eu.nyerel.searchtable.example.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(long id) {
        PersonEntity entity = personRepository.getOne(id);
        return convertEntity(entity);
    }

    public Page<Person> getAllPeople(Pageable pageable) {
        return personRepository.findAll(pageable).map(this::convertEntity);
    }

    private Person convertEntity(PersonEntity entity) {
        Person person = new Person();
        BeanUtils.copyProperties(entity, person);
        return person;
    }

}
