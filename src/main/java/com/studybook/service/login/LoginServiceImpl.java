package com.studybook.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybook.dao.login.LoginDAO;
import com.studybook.dto.UserDTO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public UserDTO loginCheck(UserDTO user) throws Exception {
		
		return loginDAO.selectUserForAccount(user);
	}

}
