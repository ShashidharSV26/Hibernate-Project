package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import hospital.dao.BranchDao;
import hospital.dto.Address;
import hospital.dto.Branch;
import hospital.dto.Hospital;

public class BranchDaoImp implements BranchDao {

	public Branch saveBranch(int hospital_id, Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital hospital = em.find(Hospital.class, hospital_id);
		if (hospital != null) {
			et.begin();
			em.persist(branch);
			et.commit();
			return branch;
		} else {
			return null;
		}
	}

	public Branch getBranchById(int b_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Branch branch = em.find(Branch.class, b_id);
		em.persist(branch);
		et.commit();
		return branch;
	}

	public boolean deleteBranchById(int b_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Branch branch = em.find(Branch.class, b_id);
		if (branch != null) {
			et.begin();
			em.remove(branch);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Branch updateBranchById(int b_id, Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Branch branch1 = em.find(Branch.class, b_id);
		if (branch1 != null) {
			et.begin();
			branch1.setB_name(branch.getB_name());
			branch1.setB_phno(branch.getB_phno());
			branch1.setB_email(branch.getB_email());

			et.commit();
			return branch1;
		} else {
			return null;
		}

	}

	public List<Branch> getAllBranch() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select s from Branch s");
		List<Branch> branch = query.getResultList();
		et.commit();
		return branch;

	}

}
