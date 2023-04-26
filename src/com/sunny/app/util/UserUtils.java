package com.sunny.app.util;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {

	// 세션체크
	public static int sessionCheck(HttpServletRequest req) {
		 Integer userNumber = (Integer)req.getSession().getAttribute("userNumber");
		 if(userNumber == null) {
			 return 0;
		 }else return userNumber;
	}
}
