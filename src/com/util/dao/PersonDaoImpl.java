package com.util.dao;
/**
 * 使用开源工具DBUtils实现jdbc的增删改查。
 */
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.chen.domain.Person;
import com.util.db.DBUtils;

public class PersonDaoImpl implements PersonDao {
	private QueryRunner runner = null;
	public PersonDaoImpl() {
		runner = new QueryRunner();
	}
	
	@Override
	public void add(Person p) throws SQLException {
		String sql = "insert into Person(name,age,description)values(?,?,?)";
		runner.update(DBUtils.getConnection(), sql, p.getName(),p.getAge(),p.getDescription());
		
	}

	@Override
	public void update(Person p) throws SQLException {
		String sql = "update Person set name=?,age=?,description=? where id=?";
		runner.update(DBUtils.getConnection(),sql, p.getName(),p.getAge(),p.getDescription(),p.getId());
		
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "delete from Person where id = ?";
		runner.update(DBUtils.getConnection(), sql, id);
	}

	@Override
	public Person findById(int id) throws SQLException {
		//使用BeanHandler查询一个对象
		String sql = "select from name,age,description from Person where id=?";
		Person p = runner.query(DBUtils.getConnection(), sql, new BeanHandler<>(Person.class), id);
		return p;
		
	}

	@Override
	public List<Person> findAll() throws SQLException {
		String sql = "select name,age,description from Person";
		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) runner.query(DBUtils.getConnection(), sql, new BeanHandler<>(Person.class));
		return persons;
	}

}
