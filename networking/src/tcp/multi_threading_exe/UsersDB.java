package tcp.multi_threading_exe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDB {

	private final static int NUM_USERS = 220;

	private final static List<User> usersList = new ArrayList<>() {
		{
			for (int i = 0; i < NUM_USERS; i++) {
				add(new User());
			}
		}
	};

	private final static Map<Integer, User> users = new HashMap<>() {
		{
			for (int i = 0; i < NUM_USERS; i++) {
				put(usersList.get(i).getId(), usersList.get(i));

			}
		}
	};

	public static User getuserById(int id) {
		return users.get(id);
	}
	
	public static int getNumUser() {
		return NUM_USERS;
	}
	

}
