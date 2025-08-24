package com.library.online_library.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.online_library.database.BooksDatabaseConstants;
import com.library.online_library.service.UserService;
import com.library.online_library.service.UserServiceImpl;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Exemplu simplu (în loc de DB)
        if ("admin".equals(username) && "admin123".equals(password)) {
            // setăm sesiune și redirect către admin
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", "ADMIN");
            resp.sendRedirect("adminHome.jsp");
        } else if ("customer".equals(username) && "cust123".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", "CUSTOMER");
            resp.sendRedirect("customerHome.jsp");
        } else {
            // dacă e invalid
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
