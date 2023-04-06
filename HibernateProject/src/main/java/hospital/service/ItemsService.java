package hospital.service;

import java.util.List;

import hospital.dao.imp.BranchDaoImp;
import hospital.dao.imp.ItemsDaoImp;
import hospital.dto.Branch;
import hospital.dto.Items;

public class ItemsService {
	public void saveItems(Items items, int m_id) {
		ItemsDaoImp idi = new ItemsDaoImp();
		Items items1 = idi.saveItems(m_id, items);
		if (items1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Items getItemsById(int i_id) {
		ItemsDaoImp idi = new ItemsDaoImp();
		Items items = idi.getItemsById(i_id);
		if (items != null) {
			return items;
		} else {
			return null;
		}
	}

	public void deleteItemsById(int i_id) {
		ItemsDaoImp idi = new ItemsDaoImp();
		boolean flag = idi.deleteItemsId(i_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Items updateItemsById(int i_id) {
		ItemsDaoImp idi = new ItemsDaoImp();
		Items items1 = idi.getItemsById(i_id);
		if (items1 != null) {
			return items1;
		} else {
			return null;
		}
	}

	public List<Items> getAlliItems() {
		ItemsDaoImp idi = new ItemsDaoImp();
		List<Items> items = idi.getAlliItems();
		if (items != null) {
			return items;
		} else {
			return null;
		}
	}
}
