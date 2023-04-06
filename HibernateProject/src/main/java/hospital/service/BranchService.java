package hospital.service;

import java.util.List;

import hospital.dao.imp.BranchDaoImp;
import hospital.dto.Branch;

public class BranchService {
	public void saveBranch(Branch branch, int hospital_id) {
		BranchDaoImp bdi = new BranchDaoImp();
		Branch branch1 = bdi.saveBranch(hospital_id, branch);
		if (branch1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Branch getBranchById(int b_id) {
		BranchDaoImp bdi = new BranchDaoImp();
		Branch branch = bdi.getBranchById(b_id);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}
	}

	public void deleteBranchById(int b_id) {
		BranchDaoImp bdi = new BranchDaoImp();
		boolean flag = bdi.deleteBranchById(b_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Branch updateBranchById(int b_id,Branch branch) {
		BranchDaoImp bdi = new BranchDaoImp();
		Branch branch1 = bdi.updateBranchById(b_id, branch);
		if (branch1 != null) {
			return branch1;
		} else {
			return null;
		}
	}

	public List<Branch> getAllBranch() {
		BranchDaoImp bdi = new BranchDaoImp();
		List<Branch> branchs = bdi.getAllBranch();
		if (branchs != null) {
			return branchs;
		} else {
			return null;
		}

	}
}
