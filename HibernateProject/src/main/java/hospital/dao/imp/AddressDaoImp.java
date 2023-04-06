package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital.dao.AddressDao;
import hospital.dto.Address;
import hospital.dto.Branch;
import hospital.dto.Hospital;

public class AddressDaoImp implements AddressDao {

	public Address saveAddress(int b_id, Address address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Branch branch = em.find(Branch.class, b_id);
		if (branch != null) {
			et.begin();
			em.persist(address);
			et.commit();
			return address;
		} else {
			return null;
		}

	}

	public Address getAddressById(int a_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Address address = em.find(Address.class, a_id);
		em.persist(address);
		et.commit();
		return address;
	}

	public boolean deleteAddressId(int a_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Address address = em.find(Address.class, a_id);
		if (address != null) {
			et.begin();
			em.remove(address);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Address updateAddress(int a_id, Address address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Address address1 = em.find(Address.class, a_id);
		if (address1 != null) {
			et.begin();
			address1.setStreet(address.getStreet());
			address1.setState(address.getState());
			address1.setCountry(address.getCountry());

			et.commit();
			return address1;
		} else {
			return null;
		}

	}

	public List<Address> getAllAddress() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select a from Address a");
		List<Address> addresses = query.getResultList();
		et.commit();
		return addresses;
	}

}
