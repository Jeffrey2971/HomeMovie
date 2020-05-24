package servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/*
    用户登录模块
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User LoginUser = new User();
        LoginUser.setUsername(username);
        LoginUser.setPassword(password);

        UserDao dao = new UserDao();
        User user = dao.login(LoginUser);

        if (user == null){
            request.getRequestDispatcher("/failServlet").forward(request, response);
        }else{
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
