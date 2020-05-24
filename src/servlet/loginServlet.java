package servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    用户登录模块
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 封装user对象
        User LoginUser = new User();
        LoginUser.setUsername(username);
        LoginUser.setPassword(password);
        // 调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(LoginUser);
        // 判断user
        if (user == null) {
            // 登录失败
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            // 登陆成功
            // 存储数据
//            request.setAttribute("user", user);
            request.getSession().setAttribute("user", user);
            // 转发

            request.getRequestDispatcher("/successServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
