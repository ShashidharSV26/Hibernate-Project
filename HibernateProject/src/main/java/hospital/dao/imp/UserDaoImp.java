package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital.dao.UserDao;
import hospital.dto.User;

public class UserDaoImp implements UserDao {

	public User getUserById(int u_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = em.find(User.class, u_id);
		et.begin();
		em.persist(user);
		et.commit();
		return user;
	}

	public boolean deleteUserId(int u_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = em.find(User.class, u_id);
		if (user != null) {
			et.begin();
			em.remove(user);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public User updateUser(int u_id, User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User user1 = em.find(User.class, u_id);
		if (user1 != null) {
			et.begin();
			user1.setU_name(user.getU_name());
			user1.setU_phno(user.getU_phno());
			user1.setPassword(user.getPassword());
			user1.setRole(user.getRole());
			et.commit();
			return user1;
		} else {
			return null;
		}
	}

	public List<User> getAlluser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select u from User u");
		List<User> users = query.getResultList();
		et.commit();
		return users;
	}

	public List<User> getUserByRole(String role) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, role);
		List<User> users = query.getResultList();
		et.commit();
		return users;
	}

}
