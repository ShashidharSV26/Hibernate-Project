package hospital.service;

import java.util.List;

import hospital.dao.imp.UserDaoImp;
import hospital.dto.User;

public class UserService {
	
	public User getUserById(int u_id) {
		UserDaoImp udi = new UserDaoImp();
		User user = udi.getUserById(u_id);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public void deleteUserById(int u_id) {
		UserDaoImp udi = new UserDaoImp();
		boolean flag = udi.deleteUserId(u_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public User updateUserById(int u_id , User user) {
		UserDaoImp udi = new UserDaoImp();
		User user1 = udi.updateUser(u_id, user);
		if (user1 != null) {
			return user1;
		} else {
			return null;
		}
	}

	public List<User> getAllUser() {
		UserDaoImp udi = new UserDaoImp();
		List<User> users = udi.getAlluser();
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}
	
	public List<User> getUserByRole(String role) {
		UserDaoImp udi = new UserDaoImp();
		List<User> users = udi.getUserByRole(role);
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}
}
