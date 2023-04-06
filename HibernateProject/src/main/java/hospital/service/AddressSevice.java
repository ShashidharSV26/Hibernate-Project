package hospital.service;

import hospital.dao.imp.AddressDaoImp;
import hospital.dto.Address;

public class AddressSevice {
	public void saveAddress(Address address, int b_id) {
		AddressDaoImp adi = new AddressDaoImp();
		Address address1 = adi.saveAddress(b_id, address);
		if (address1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Address getAddressById(int b_id) {
		AddressDaoImp adi = new AddressDaoImp();
		Address address = adi.getAddressById(b_id);
		if (address != null) {
			return address;
		} else {
			return null;
		}
	}

	public void deleteAddressById(int b_id) {
		AddressDaoImp adi = new AddressDaoImp();
		boolean flag = adi.deleteAddressId(b_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Address updateAddressById(int b_id) {
		AddressDaoImp adi = new AddressDaoImp();
		Address address1 = adi.getAddressById(b_id);
		if (address1 != null) {
			return address1;
		} else {
			return null;
		}
	}
}
