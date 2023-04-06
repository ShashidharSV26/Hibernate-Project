package hospital.service;

import java.util.List;

import hospital.dao.imp.ObservationDaoImp;
import hospital.dao.imp.ObservationDaoImp;
import hospital.dto.Observation;
import hospital.dto.Observation;

public class ObservationService {
	public void saveObservation(Observation observation, int e_id) {
		ObservationDaoImp odi = new ObservationDaoImp();
		Observation observation1 = odi.saveObservation(e_id, observation);
		if (observation1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Observation getObservationById(int o_id) {
		ObservationDaoImp odi = new ObservationDaoImp();
		Observation observation = odi.getObservationById(o_id);
		if (observation != null) {
			return observation;
		} else {
			return null;
		}
	}

	public void deleteObservationById(int o_id) {
		ObservationDaoImp odi = new ObservationDaoImp();
		boolean flag = odi.deleteObservationId(o_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Observation updateObservationById(int o_id, Observation observation) {
		ObservationDaoImp odi = new ObservationDaoImp();
		Observation observation1 = odi.updateObservationById(o_id, observation);
		if (observation1 != null) {
			return observation1;
		} else {
			return null;
		}
	}

	public List<Observation> getAllObservation() {
		ObservationDaoImp odi = new ObservationDaoImp();
		List<Observation> observations = odi.getAllObservations();
		if (observations != null) {
			return observations;
		} else {
			return null;
		}
	}

	public List<Observation> getObservationsByDoctorname(String name) {
		ObservationDaoImp odi = new ObservationDaoImp();
		List<Observation> observations = odi.getObservationsByDoctorname(name);
		if (observations != null) {
			return observations;
		} else {
			return null;
		}
	}
}
