package hospital.dao;

import java.util.List;


import hospital.dto.*;

public interface EncounterDao {

	public Encounter saveEncounter(int b_id, Encounter encounter);

	public Encounter getEncounterById(int e_id);

	public boolean deleteEncounterId(int e_id);

	public Encounter updateEncounter(int e_id, Encounter encounter);

	public List<Encounter> getAllEncounters();
}
