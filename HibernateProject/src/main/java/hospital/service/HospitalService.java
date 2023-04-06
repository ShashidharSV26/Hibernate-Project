package hospital.service;

import hospital.dao.imp.HospitalDaoImp;
import hospital.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
		HospitalDaoImp hdi = new HospitalDaoImp();
		Hospital hospital1 = hdi.saveHospital(hospital);
		if (hospital1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Hospital getHospitalById(int hospital_id) {
		HospitalDaoImp hdi = new HospitalDaoImp();
		Hospital hospital = hdi.getHospitalBYId(hospital_id);
		if (hospital != null) {
			return hospital;
		} else {
			return null;
		}
	}

	public void deleteHospitalById(int hospital_id) {
		HospitalDaoImp hdi = new HospitalDaoImp();
		boolean flag = hdi.deletehospitalById(hospital_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Hospital updaHospitalById(int hospital_id, Hospital hospital) {
		HospitalDaoImp hdi = new HospitalDaoImp();
		Hospital hospital1 = hdi.updateHospitalById(hospital_id, hospital);
		if (hospital1 != null) {
			return hospital1;
		} else {
			return null;
		}
	}
}
