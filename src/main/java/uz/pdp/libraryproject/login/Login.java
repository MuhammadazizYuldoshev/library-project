package uz.pdp.libraryproject.login;


import uz.pdp.libraryproject.user.User;
import uz.pdp.libraryproject.user.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        boolean check = UserDao.checkUser(user);
        String roleName = UserDao.getRoleName();
        if (check) {
            HttpSession session = req.getSession(true);
            session.setAttribute("isCreatedSession", true);
            session.setAttribute("userName", userName);
            if (roleName.equals("ADMIN")) {

                resp.sendRedirect("/admin");

            } else if (roleName.equals("USER")) {

                resp.sendRedirect("/user");

            }


        } else {

            printWriter.println("<center> <p style = \"color:red\"> Username or password incorrect !!!</p> </center>");
            req.getRequestDispatcher("login.jsp").include(req, resp);

        }


    }
}
