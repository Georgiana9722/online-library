package com.library.online_library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.online_library.database.BookStoreConstants;
import com.library.online_library.database.ResponseCode;
import com.library.online_library.database.UsersDatabaseConstants;
import com. library.online_library.model.User;
import com. library.online_library.model.UserRole;
import com. library.online_library.service.UserService;
import com. library.online_library.service.UserServiceImpl;


public class CustomerRegisterServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        res.setContentType(BookStoreConstants.CONTENT_TYPE_TEXT_HTML);

        String pWord = req.getParameter(UsersDatabaseConstants.COLUMN_PASSWORD);
        String fName = req.getParameter(UsersDatabaseConstants.COLUMN_FIRSTNAME);
        String lName = req.getParameter(UsersDatabaseConstants.COLUMN_LASTNAME);
        String addr = req.getParameter(UsersDatabaseConstants.COLUMN_ADDRESS);
        String phNo = req.getParameter(UsersDatabaseConstants.COLUMN_PHONE);
        String mailId = req.getParameter(UsersDatabaseConstants.COLUMN_EMAILID);
        User user = new User();
        user.setEmailId(mailId);
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setPassword(pWord);
        user.setPhone(Long.parseLong(phNo));
        user.setAddress(addr);
        try {
            String respCode = userService.register(UserRole.CUSTOMER, user);
            System.out.println(respCode);
            if (ResponseCode.SUCCESS.name().equalsIgnoreCase(respCode)) {
                RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
                rd.include(req, res);
                pw.println("<table class=\"tab\"><tr><td>User Registered Successfully</td></tr></table>");
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("CustomerRegister.html");
                rd.include(req, res);
                pw.println("<table class=\"tab\"><tr><td>" + respCode + "</td></tr></table>");
                pw.println("Sorry for interruption! Try again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}