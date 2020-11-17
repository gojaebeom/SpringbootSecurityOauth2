package com.studybook.dao.login;

import com.studybook.domain.LoginDTO;
import com.studybook.domain.UserVO;

public interface LoginDAO {
	public UserVO selectUserForAccount(LoginDTO login) throws Exception;
}
