package com.gaonsoft.mcs.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gaonsoft.mcs.user.domain.User;
import com.gaonsoft.mcs.user.domain.UserKey;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User";
		return (List<User>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(UserKey id){
		return entityManager.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUserId(String userId) {
		String hql = "FROM User as u WHERE u.userId = ?";
		List<User> result = (List<User>)entityManager.createQuery(hql).setParameter(1,  userId).getResultList();
		if(result.isEmpty()) {
			return new User();
		}
		return result.get(0);
	}

	@Override
	public List<User> readAuthority(String userId) {
		// 권한 테이블을 검색해서 리턴
		// 권한이 별도로 없어서 필요없음 
		return null;
	}
}
