package demo;

import Dao.UserDao.UserDaofinsh;
import Vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //验证二维码
        String username=request.getParameter("username");
        String pwd =request.getParameter("pwd");
        String code= (String) request.getSession().getAttribute("verityCode");
        String vcode=request.getParameter("Vcode");
        String setFree=request.getParameter("keep");

        UserDaofinsh userDao=new UserDaofinsh();

        User u=null;
        //调用User实例化对象 ，调用DAO中findALL函数查找用户账户和密码
        try {
            u=userDao.findAll(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //验证用户名和密码
        if (vcode.equals(code))
        {
            if (u.getUserName()==null)
            {
                System.out.println("用户名不存在");
                request.setAttribute("errorInf","用户名输入错误");
                request.getRequestDispatcher("jsp/error.jsp").forward(request,response);
            }
            else {
                if (pwd.equals(u.getPassword()))
                {
                    request.setAttribute("user","u");

                    System.out.println("欢迎进入主页");

                    //配置一周免密登录
                    if (setFree!=null)
                    {

                        Cookie cookieName=new Cookie("username",username);
                        response.addCookie(cookieName);
                        Cookie cookiePwd=new Cookie("Password",pwd);
                        response.addCookie(cookiePwd);
                        cookieName.setMaxAge(60*60*24*7);
                        cookiePwd.setMaxAge(60*60*24*7);
                    }

                    Cookie cookieRole=new Cookie("Role",u.getRole());
                    response.addCookie(cookieRole);
                    cookieRole.setMaxAge(60*60*24*7);

                    request.getRequestDispatcher("jsp/other/main.jsp").forward(request,response);
                }
                else
                {
                    System.out.println("密码输入错误");
                    request.setAttribute("errorInf","密码输入错误");
                    request.getRequestDispatcher("jsp/other/error.jsp").forward(request,response);

                }
            }
        }
        else {
            System.out.println("验证码输入错误！");
            request.setAttribute("errorInf","验证码错误");
            request.getRequestDispatcher("jsp/other/error.jsp").forward(request,response);
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
