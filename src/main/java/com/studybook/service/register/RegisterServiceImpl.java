package com.studybook.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybook.dao.register.RegisterDAO;
import com.studybook.dto.UserDTO;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;

	@Override
	public int insertUser(UserDTO user) throws Exception {
		
		registerDAO.insertUser(user);
		
		return 0;
	}

}
