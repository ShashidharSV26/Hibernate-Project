package hospital.dao;

import java.util.List;

import hospital.dto.*;

public interface ObservationDao {
	public Observation saveObservation(int e_id, Observation observation);

	public Observation getObservationById(int o_id);

	public boolean deleteObservationId(int o_id);

	public Observation updateObservationById(int o_id, Observation observation);

	public List<Observation> getAllObservations();

	public List<Observation> getObservationsByDoctorname(String name);
}
