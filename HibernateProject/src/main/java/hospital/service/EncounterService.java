package hospital.service;

import java.util.List;

import hospital.dao.imp.BranchDaoImp;
import hospital.dao.imp.EncounterDaoImp;
import hospital.dto.Branch;
import hospital.dto.Encounter;

public class EncounterService {
	public void saveEncounter(Encounter encounter, int b_id) {
		EncounterDaoImp edi = new EncounterDaoImp();
		Encounter encounter1 = edi.saveEncounter(b_id, encounter);
		if (encounter1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Encounter getEncounterById(int e_id) {
		EncounterDaoImp edi = new EncounterDaoImp();
		Encounter encounter = edi.getEncounterById(e_id);
		if (encounter != null) {
			return encounter;
		} else {
			return null;
		}
	}

	public void deleteEncounterById(int e_id) {
		EncounterDaoImp edi = new EncounterDaoImp();
		boolean flag = edi.deleteEncounterId(e_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Encounter updateEncounterById(int e_id,Encounter encounter) {
		EncounterDaoImp edi = new EncounterDaoImp();
		Encounter encounter1 = edi.updateEncounter(e_id,encounter);
		if (encounter1 != null) {
			return encounter1;
		} else {
			return null;
		}
	}
	
	public List<Encounter> getAllEncounter() {
		EncounterDaoImp edi = new EncounterDaoImp();
		List<Encounter> encounters = edi.getAllEncounters();
		if (encounters != null) {
			return encounters;
		} else {
			return null;
		}
	}
}
