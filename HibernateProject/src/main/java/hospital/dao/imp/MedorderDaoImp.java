package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dao.MedorderDao;
import hospital.dto.Encounter;
import hospital.dto.Medorder;

public class MedorderDaoImp implements MedorderDao{

	public Medorder saveMedorder(int e_id, Medorder medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, e_id);
		if (encounter != null) {
			et.begin();
			em.persist(medorder);
			et.commit();
			return medorder;
		} else {
			return null;
		}
	}

	public Medorder getMedorder(int m_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Medorder medorder = em.find(Medorder.class, m_id);
		et.begin();
		em.persist(medorder);
		et.commit();
		return medorder;
	}

	public boolean deleteMeorderId(int m_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Medorder medorder = em.find(Medorder.class, m_id);
		if (medorder != null) {
			et.begin();
			em.remove(medorder);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Medorder updateMedorder(int m_id, Medorder medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Medorder medorder1 = em.find(Medorder.class, m_id);
		if (medorder1 != null) {
			et.begin();
			medorder1.setDname(medorder.getDname());
			medorder1.setOrderdate(medorder.getOrderdate());
			et.commit();
			return medorder1;
		} else {
			return null;
		}
	}

	public List<Medorder> getAllMedorders() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select m from Medorder m");
		List<Medorder> medorders = query.getResultList();
		et.commit();
		return medorders;
	}

	public List<Medorder> getMeorderByDoctorName(String dname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select m from Medorder m where m.dname");
		query.setParameter(1, dname);
		List<Medorder> medorders = query.getResultList();
		et.commit();
		return medorders;
	}

}
