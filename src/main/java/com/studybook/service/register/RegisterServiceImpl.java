package com.studybook.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybook.dao.register.RegisterDAO;
import com.studybook.domain.UserVO;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;

	@Override
	public int insertUser(UserVO user) throws Exception {
		return registerDAO.insertUser(user);
	}

	@Override
	public int selectUserAccount(String account) throws Exception {
		return registerDAO.selectUserAccount(account);
	}

}
