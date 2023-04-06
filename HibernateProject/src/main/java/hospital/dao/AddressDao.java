package hospital.dao;

import java.util.List;

import hospital.dto.*;

public interface AddressDao {
	public Address saveAddress(int b_id, Address address);

	public Address getAddressById(int a_id);

	public boolean deleteAddressId(int a_id);

	public Address updateAddress(int a_id, Address address);

	public List<Address> getAllAddress();
}
