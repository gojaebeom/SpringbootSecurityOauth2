package com.studybook.dao.login;

import com.studybook.dto.UserDTO;

public interface LoginDAO {
	public UserDTO selectUserForAccount(UserDTO user) throws Exception;
}
