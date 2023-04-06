package hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dao.ItemsDao;
import hospital.dto.Branch;
import hospital.dto.Encounter;
import hospital.dto.Hospital;
import hospital.dto.Items;
import hospital.dto.Medorder;

public class ItemsDaoImp implements ItemsDao {

	public Items saveItems(int m_id, Items item) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Medorder medorder = em.find(Medorder.class, m_id);
		if (medorder != null) {
			et.begin();
			em.persist(item);
			et.commit();
			return item;
		} else {
			return null;
		}
	}

	public Items getItemsById(int i_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Items items = em.find(Items.class, i_id);
		et.begin();
		em.persist(items);
		et.commit();
		return items;
	}

	public boolean deleteItemsId(int i_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Items items = em.find(Items.class, i_id);
		if (items != null) {
			et.begin();
			em.remove(items);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Items updateItems(int i_id, Items items) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Items items1 = em.find(Items.class, i_id);
		if (items1 != null) {
			et.begin();
			items.setName(items1.getName());
			items.setCost(items1.getCost());
			items.setQuantity(items1.getQuantity());
			et.commit();
			return items1;
		} else {
			return null;
		}
	}

	

	public List<Items> getAlliItems() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		javax.persistence.Query query = em.createQuery("select i from Items i");
		List<Items> items = query.getResultList();
		et.commit();
		return items;
	}

}
