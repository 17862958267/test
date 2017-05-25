package cn.studs.register;


import java.util.UUID;
import cn.studs.domain.User;
import cn.studs.utils.BaseDao;
import cn.studs.utils.DSUtils;
import cn.studs.utils.QueryRunner;

public class RegDaoJdbc  extends BaseDao{
	//зЂВс
	public void reg(User user){
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		String sql = "insert into users(id,name,pwd) values(?,?,?)";
		run.update(sql,user.getId(),user.getName(),user.getPwd());
	}
}



