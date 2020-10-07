package nuc.ssm.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ssm.dao.UserDao;

import nuc.ssm.entity.User;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setJctcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public int addUser(User user) {
		String sql="insert into user1(userName,password) values(?,?)";
		Object[] object = new Object[] {user.getUserName(), user.getPassword()};
		int result=jdbcTemplate.update(sql,object); 
		return result;
	}

	public int updateUser(User user) {
		String sql = "update user1 set userName=?,password=? where id=?";
		Object[] params = new Object[] {user.getUserName(),user.getPassword(),user.getId()};
		int result = jdbcTemplate.update(sql,params);
		return result;
	}

	public int deleteUser(int id) {
		String sql="delete from user1 where id=?";
		int result = jdbcTemplate.update(sql,id);
		return result;
	}

	@Override
	public User findUserById(int id) {
		String sql = "select * from user1 where id=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<User> findAllUser() {
		String sql = "select * from user1";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
