package uz.pdp.libraryproject.login;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebFilter("")
public class Filter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();


        HttpSession session = request.getSession();
        Boolean isCreatedSession = (Boolean) session.getAttribute("isCreatedSession");


        if (Objects.nonNull(isCreatedSession) || isPublicPage(path)) {
            chain.doFilter(req, resp);
        } else {
            response.getWriter().println("<h1 style='text-align : center; color : red'>Please Login First</h1>");
            req.getRequestDispatcher("login.jsp").include(request, response);
        }


    }


    private boolean isPublicPage(String path) {

        List<String> publicPages = Arrays.asList("login.jsp", "/home-page.jsp","/", "/login", "/logout");

        return publicPages.contains(path);
    }
}

