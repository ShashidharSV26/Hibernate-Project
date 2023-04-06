package hospital.service;

import java.util.List;

import hospital.dao.imp.PersonDaoImp;
import hospital.dao.imp.PersonDaoImp;
import hospital.dto.Person;
import hospital.dto.Person;

public class PersonService {
	public void savePerson(Person person, int e_id) {
		PersonDaoImp pdi = new PersonDaoImp();
		Person person1 = pdi.savePerson(e_id, person);
		if (person1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Person getPersonById(int p_id) {
		PersonDaoImp pdi = new PersonDaoImp();
		Person person = pdi.getPersonById(p_id);
		if (person != null) {
			return person;
		} else {
			return null;
		}
	}
	
	public void deletePersonById( int p_id) {
		PersonDaoImp pdi = new PersonDaoImp();
		boolean flage = pdi.deletepersonId(p_id);
		if (flage) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Unfortunatly data not found..!");
		}
	}

	public Person updatePersonById(int p_id,Person person) {
		PersonDaoImp pdi = new PersonDaoImp();
		Person person1 = pdi.updatePerson(p_id, person);
		if (person1 != null) {
			return person1;
		} else {
			return null;
		}
	}
	
	public List<Person> getAllPerson() {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getAllPerson();
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
	
	public List<Person> getPersonByGender(String p_gender) {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getPersonByGender(p_gender);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
	
	public List<Person> getPersonByAge(int p_age) {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getPersonByAge(p_age);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
	
	public List<Person>  getPersonByPhone(long p_phone) {
		PersonDaoImp pdi = new PersonDaoImp();
		List<Person> persons = pdi.getPersonByPhone(p_phone);
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
}
