package com.studybook.dao.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studybook.dto.UserDTO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserDTO selectUserForAccount(UserDTO user) throws Exception {
		
		return sqlSession.selectOne("user.selectUserForAccount", user);
	}

}
