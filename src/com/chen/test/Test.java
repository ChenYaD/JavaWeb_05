package com.chen.test;

import java.sql.SQLException;

import com.chen.domain.Person;
import com.util.dao.PersonDao;
import com.util.dao.PersonDaoImpl;

public class Test {

	public static void main(String[] args) throws SQLException {
		PersonDao pd = new PersonDaoImpl();
		pd.add(new Person("–°∫Ï", 33,"º””Õ"));
	}

}
