package hospital.dao;

import java.util.List;

import hospital.dto.*;

public interface PersonDao {
public Person savePerson(int e_id, Person person);

public Person getPersonById(int p_id);

public boolean deletepersonId(int p_id);

public Person updatePerson(int p_id, Person person);

public List<Person> getAllPerson();

public List<Person> getPersonByGender(String p_gender);

public List<Person> getPersonByAge(int p_age);

public List<Person> getPersonByPhone(long p_phone);



}
