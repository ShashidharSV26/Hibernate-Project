package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital.dao.PersonDao;
import hospital.dto.Address;
import hospital.dto.Encounter;
import hospital.dto.Hospital;
import hospital.dto.Medorder;
import hospital.dto.Person;

public class PersonDaoImp implements PersonDao{

	public Person savePerson(int e_id, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter=em.find(Encounter.class, e_id);
		if(encounter!=null) {
			et.begin();
			em.persist(person);
			et.commit();
			return person;
		}else {
			return null;
		}
	}

	public Person getPersonById(int p_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Person person = em.find(Person.class, p_id);
		et.begin();
		em.persist(person);
		et.commit();
		return person;
	}

	public boolean deletepersonId(int p_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Person person = em.find(Person.class, p_id);
		if (person != null) {
			et.begin();
			em.remove(person);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Person updatePerson(int p_id, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Person person1 = em.find(Person.class, p_id);
		if (person1 != null) {
			et.begin();
			person1.setP_name(person.getP_name());
			person1.setP_address(person.getP_address());
			person1.setP_phno(person.getP_phno());	
			et.commit();
			return person1;
		} else {
			return null;
		}
	
	}

	public List<Person> getAllPerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select p from Person p");
		List<Person> persons = query.getResultList();
		et.commit();
		return persons;
	
	}

	public List<Person> getPersonByGender(String p_gender) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select p from Person p where p_gender=?1");
		query.setParameter(1, p_gender);
		List<Person> persons = query.getResultList();
		et.commit();
		return persons;
	}

	public List<Person> getPersonByAge(int p_age) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select p from Person p where p_age=?1");
		query.setParameter(1, p_age);
		List<Person> persons = query.getResultList();
		et.commit();
		return persons;
	}

	public List<Person> getPersonByPhone(long p_phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select p from Person p where p_phone=?1");
		query.setParameter(1, p_phone);
		List<Person> persons = query.getResultList();
		et.commit();
		return persons;
	}

}
