package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CustomerBean;
import model.CustomerDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        RequestDispatcher requestDispatcher = null;

        if(username == null || password == null ){

            requestDispatcher = request.getRequestDispatcher("login-error.html");
            requestDispatcher.forward(request,response);

        }

        CustomerBean customer = new CustomerBean();
        CustomerDAO customerDao = new CustomerDAO();

       try{

           customer = customerDao.getCustomerByUsernameAndPassword(username,password);

       }catch(SQLException e){

           e.printStackTrace();
       }

       if(customer != null){


           request.getSession().setAttribute("customer",customer);
           request.getSession().setMaxInactiveInterval(300);

           if(customer.getIsAdmin()==0) {
               String encodedURL = response.encodeURL("index.jsp");
               requestDispatcher = request.getRequestDispatcher(encodedURL);
           }
           else{
               String encodedURL = response.encodeURL("amministratore.jsp");
               requestDispatcher = request.getRequestDispatcher(encodedURL);
           }

       }
       else{
           requestDispatcher = request.getRequestDispatcher("login-error.html");
       }

       requestDispatcher.forward(request,response);

    }
}
