package com.studybook.dao.register;

import com.studybook.dto.UserDTO;

public interface RegisterDAO {
	public int insertUser(UserDTO user) throws Exception;
}
