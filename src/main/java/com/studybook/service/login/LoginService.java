package com.studybook.service.login;

import com.studybook.domain.LoginDTO;
import com.studybook.domain.UserVO;

public interface LoginService {
	public UserVO loginCheck(LoginDTO login) throws Exception;
}
