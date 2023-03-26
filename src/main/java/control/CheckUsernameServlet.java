package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnectionPool;
import model.CustomerBean;
import model.CustomerDAO;
import org.json.JSONObject;
import org.json.JSONString;


@WebServlet(name = "CheckUsernameServlet", value = "/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            CustomerDAO customerDAO = new CustomerDAO();
            String username = request.getParameter("q");
            JSONObject obj = new JSONObject();

        try {
            obj.put("exists",customerDAO.checkUsername(username));

            System.out.println(obj.toString());
                response.setContentType("application/json");

                response.getWriter().append(obj.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
