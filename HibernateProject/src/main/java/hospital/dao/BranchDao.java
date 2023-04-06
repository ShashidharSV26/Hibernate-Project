package hospital.dao;

import java.util.List;


import hospital.dto.*;

public interface BranchDao {
	
public Branch saveBranch (int hospital_id, Branch branch);
public Branch getBranchById(int b_id);

public boolean deleteBranchById(int b_id);

public Branch updateBranchById(int b_id, Branch branch);

public List<Branch> getAllBranch();
}
