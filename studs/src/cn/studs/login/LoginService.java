package cn.studs.login;

import cn.studs.domain.User;

public class LoginService {
	private LoginDaoJdbc dao = new LoginDaoJdbc();
	public User login(User user){
		return dao.login(user);
	}
}
