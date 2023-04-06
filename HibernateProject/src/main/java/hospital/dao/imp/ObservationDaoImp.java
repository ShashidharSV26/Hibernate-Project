package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dao.ObservationDao;
import hospital.dto.Address;
import hospital.dto.Branch;
import hospital.dto.Encounter;
import hospital.dto.Medorder;
import hospital.dto.Observation;
import hospital.dto.Person;

public class ObservationDaoImp implements ObservationDao {

	public Observation saveObservation(int e_id, Observation observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, e_id);
		if (encounter != null) {
			et.begin();
			em.persist(observation);
			et.commit();
			return observation;
		} else {
			return null;
		}
	}

	public Observation getObservationById(int o_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Observation observation = em.find(Observation.class, o_id);
		et.begin();
		em.persist(observation);
		et.commit();
		return observation;
	}

	public boolean deleteObservationId(int o_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Observation observation = em.find(Observation.class, o_id);
		if (observation != null) {
			et.begin();
			em.remove(observation);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Observation updateObservationById(int o_id, Observation observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Observation observation1 = em.find(Observation.class, o_id);
		if (observation1 != null) {
			et.begin();
			observation1.setDname(observation.getDname());
			observation1.setRobservation(observation.getRobservation());
			et.commit();
			return observation1;
		} else {
			return null;
		}
	}

	public List<Observation> getAllObservations() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select o from Observation o");
		List<Observation> observations = query.getResultList();
		et.commit();
		return observations;
	}

	public List<Observation> getObservationsByDoctorname(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select o from Observation o where o.dname");
		query.setParameter(1, name);
		List<Observation> observations = query.getResultList();
		et.commit();
		return observations;
	}

}
