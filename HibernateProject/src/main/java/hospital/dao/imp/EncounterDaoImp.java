package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dao.EncounterDao;
import hospital.dto.Branch;
import hospital.dto.Encounter;

public class EncounterDaoImp implements EncounterDao {

	public Encounter saveEncounter(int b_id, Encounter encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Branch branch = em.find(Branch.class, b_id);
		if (branch != null) {
			et.begin();
			em.persist(encounter);
			et.commit();
			return encounter;
		} else {
			return null;
		}
	}

	public Encounter getEncounterById(int e_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, e_id);
		et.begin();
		em.persist(encounter);
		et.commit();
		return encounter;
	}

	public boolean deleteEncounterId(int e_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, e_id);
		if (encounter != null) {
			et.begin();
			em.remove(encounter);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Encounter updateEncounter(int e_id, Encounter encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter1 = em.find(Encounter.class, e_id);
		if (encounter1 != null) {
			encounter1.setReasion(encounter.getReasion());
			encounter1.setDoj(encounter.getDoj());
			encounter1.setDodis(encounter.getDodis());
			et.begin();
			et.commit();
			return encounter1;
		} else {
			return null;
		}
	}

	public List<Encounter> getAllEncounters() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select e from Encounter e");
		List<Encounter> encounters = query.getResultList();
		et.commit();
		return encounters;
	}

}
