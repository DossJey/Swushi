package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CustomerBean;
import model.CustomerDAO;
import model.EmailValidator;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EmailValidator m = new EmailValidator();
        CustomerBean customer = new CustomerBean();
        customer.setNome(request.getParameter("Nome"));
        customer.setCognome(request.getParameter("Cognome"));
        customer.setUsername(request.getParameter("Username"));
        customer.setEmail(request.getParameter("Email"));
        customer.setPassword(request.getParameter("Password"));

        CustomerDAO customerDAO = new CustomerDAO();

        RequestDispatcher requestDispatcher = null;

        try {
                    if( (m.validateEmail(customer.getEmail()))&&(!customer.getUsername().equals(""))&&(!customer.getNome().equals(""))&&(!customer.getCognome().equals(""))&&(!customer.getPassword().equals("")) ) {
                        System.out.println("email  valida: "+ customer.getEmail());
                        customerDAO.doSave(customer);
                        requestDispatcher = request.getRequestDispatcher(response.encodeURL("index.jsp"));
                    }else{

                        System.out.println("email non valida");
                        requestDispatcher = request.getRequestDispatcher(response.encodeURL("register-error.jsp"));
                    }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(customer);
        requestDispatcher.forward(request, response);
    }
}
