package hospital.dao;

import java.util.List;

import hospital.dto.*;

public interface UserDao {

	public User getUserById(int u_id);

	public boolean deleteUserId(int u_id);

	public User updateUser(int u_id, User user);

	public List<User> getAlluser();

	public List<User> getUserByRole(String role);
}
