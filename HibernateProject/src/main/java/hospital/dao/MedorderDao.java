package hospital.dao;

import hospital.dto.*;

import java.util.List;

public interface MedorderDao {
	public Medorder saveMedorder(int e_id, Medorder medorder);

	public Medorder getMedorder(int m_id);

	public boolean deleteMeorderId(int m_id);

	public Medorder updateMedorder(int m_id, Medorder medorder);

	public List<Medorder> getAllMedorders();

	public List<Medorder> getMeorderByDoctorName(String dname);
}
