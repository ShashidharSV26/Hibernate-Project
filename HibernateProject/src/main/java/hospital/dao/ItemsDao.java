
package hospital.dao;

import java.util.List;
import hospital.dto.*;


public interface ItemsDao {
	public Items saveItems(int m_id, Items item);

	public Items getItemsById(int i_id);

	public boolean deleteItemsId(int i_id);

	public Items updateItems(int i_id, Items person);

	public List<Items> getAlliItems();
}
