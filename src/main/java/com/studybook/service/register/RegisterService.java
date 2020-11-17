package com.studybook.service.register;

import com.studybook.domain.UserVO;

public interface RegisterService {
	public int insertUser(UserVO user) throws Exception;
	
	public int selectUserAccount(String account) throws Exception;
}
