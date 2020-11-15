package com.studybook.service.login;

import com.studybook.dto.UserDTO;

public interface LoginService {
	public UserDTO loginCheck(UserDTO user) throws Exception;
}
