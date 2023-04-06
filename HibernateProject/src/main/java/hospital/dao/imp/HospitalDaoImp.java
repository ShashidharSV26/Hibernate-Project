package hospital.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dao.HospitalDao;
import hospital.dto.Hospital;

public class HospitalDaoImp implements HospitalDao {

	public Hospital saveHospital(Hospital hospital) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(hospital);
		et.commit();
		return hospital;
	}

	public Hospital getHospitalBYId(int hospital_id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Hospital hospital = em.find(Hospital.class, hospital_id);
		et.commit();
		return hospital;
	}

	public boolean deletehospitalById(int hospital_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital hospital = em.find(Hospital.class, hospital_id);
		if (hospital != null) {
			et.begin();
			em.remove(hospital);
			et.commit();
			return true;
		} else {
			return false;
		}

	}

	public Hospital updateHospitalById(int hospital_id, Hospital hospital) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital hospital1 = em.find(Hospital.class, hospital_id);
		if (hospital1 != null) {
			et.begin();
			hospital1.setHospital_name(hospital.getHospital_name());
			hospital1.setHospital_Website(hospital.getHospital_Website());
			et.commit();
			return hospital1;
		} else {
			return null;
		}
	}

}
