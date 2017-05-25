package cn.studs.login;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.studs.domain.User;
import cn.studs.utils.BaseDao;
import cn.studs.utils.QueryRunner;

public class LoginDaoJdbc extends BaseDao {
	public User login(User user) {
		String sql = "select id,name,pwd from users where name=? and pwd=?";
		user = run.query(sql, new BeanHandler<User>(User.class), user.getName(), user.getPwd());
		return user;
	}
}