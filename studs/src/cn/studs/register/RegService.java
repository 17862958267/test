package cn.studs.register;

import cn.studs.domain.User;

public class RegService {
	private RegDaoJdbc dao = new RegDaoJdbc();
	public void reg(User user){
		dao.reg(user);
	}
}
