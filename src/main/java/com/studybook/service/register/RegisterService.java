package com.studybook.service.register;

import com.studybook.dto.UserDTO;

public interface RegisterService {
	public int insertUser(UserDTO user) throws Exception;
	
	public int selectUserAccount(String account) throws Exception;
}
