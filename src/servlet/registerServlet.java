package servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/*
    用户注册模块
 */

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        Object checkCode_session = session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
    
        if(checkCode_session != null && checkCode_session.equals(checkcode)){
            User user = new User();

        }
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
