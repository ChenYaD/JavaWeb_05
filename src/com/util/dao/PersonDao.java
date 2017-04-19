package com.util.dao;

import java.sql.SQLException;
import java.util.List;

import com.chen.domain.Person;

public interface PersonDao {
	public void add(Person p)throws SQLException;
	public void update(Person p)throws SQLException;
	public void delete(int id)throws SQLException;
	public Person findById(int id)throws SQLException;
	public List<Person> findAll()throws SQLException;
}
