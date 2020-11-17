package com.studybook.dao.register;

import com.studybook.domain.UserVO;

public interface RegisterDAO {
	public int insertUser(UserVO user) throws Exception;

	public int selectUserAccount(String account) throws Exception;
}
