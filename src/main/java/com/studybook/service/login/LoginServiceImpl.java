package com.studybook.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybook.dao.login.LoginDAO;
import com.studybook.domain.LoginDTO;
import com.studybook.domain.UserVO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public UserVO loginCheck(LoginDTO login) throws Exception {
		
		return loginDAO.selectUserForAccount(login);
	}

}
