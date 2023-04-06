package hospital.service;

import java.util.List;

import hospital.dao.imp.BranchDaoImp;
import hospital.dao.imp.MedorderDaoImp;
import hospital.dto.Branch;
import hospital.dto.Medorder;

public class MedorderService {
	public void saveMedorder(Medorder medorder, int e_id) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		Medorder medorder1 = mdi.saveMedorder(e_id, medorder);
		if (medorder1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Medorder getMedorderById(int m_id) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		Medorder medorder = mdi.getMedorder(m_id);
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}

	public void deleteMedorderById(int m_id) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		boolean flag = mdi.deleteMeorderId(m_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Medorder updateMedorderById(int m_id,Medorder medorder) {
		MedorderDaoImp mdi = new MedorderDaoImp();
		Medorder medorder1 = mdi.updateMedorder(m_id,medorder);
		if (medorder1 != null) {
			return medorder1;
		} else {
			return null;
		}
	}
	
	public List<Medorder> getAllBranch() {
		MedorderDaoImp bdi = new MedorderDaoImp();
		List<Medorder> medorder = bdi.getAllMedorders();
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}
	
	public List<Medorder> getMeorderByDoctorName(String dname) {
		MedorderDaoImp bdi = new MedorderDaoImp();
		List<Medorder> medorder = bdi.getMeorderByDoctorName(dname);
		if (medorder != null) {
			return medorder;
		} else {
			return null;
		}
	}
}
