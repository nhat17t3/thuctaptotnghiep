package com.thuctap.DAO;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thuctap.entities.User;


@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User loadUserByUserName(final String username) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from User where username = :username";
		Query query = session.createQuery(sql);
		query.setParameter("username", username);
		
		List<User> users = query.list();
		if(users != null && users.size() > 0) {
			return users.get(0);
		}else {
			return null;
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean checkLogin(User userForm) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from User where username = :username and password = :password";
		Query query = session.createQuery(sql);
		query.setParameter("username", userForm.getUsername());
		query.setParameter("password", userForm.getPassword());
		
		List<User> users = query.list();
		if(users != null && users.size() > 0) {
			return true;
		}else {
			return false;
		}
	}

}
