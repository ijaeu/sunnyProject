package com.sunny.app.find.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;

public class ResetPasswordController  implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userNumber = (int) req.getAttribute("userNumber");
        
        req.setAttribute("userNumber", userNumber);
        
        req.getRequestDispatcher("/app/user/rePwOk.jsp").forward(req, resp);
	}
}
