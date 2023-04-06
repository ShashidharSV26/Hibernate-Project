package hospital.dao;

import hospital.dto.*;

public interface HospitalDao {

	public Hospital saveHospital(Hospital hospital);

	public Hospital getHospitalBYId(int hospital_id);

	public boolean deletehospitalById(int hospital_id);

	public Hospital updateHospitalById(int hospital_id, Hospital hospital);
}
