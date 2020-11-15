package com.studybook.dao.register;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studybook.dto.UserDTO;

@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertUser(UserDTO user) throws Exception {
		return sqlSession.insert("register.insertUser", user);
	}

}
