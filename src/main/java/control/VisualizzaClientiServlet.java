package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CustomerBean;
import model.CustomerDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VisualizzaClientiServlet", value = "/VisualizzaClientiServlet")
public class VisualizzaClientiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
        RequestDispatcher requestDispatcher = null;

        list = customerDAO.getAllCustomer();
        System.out.println(list.toString());
        request.getSession().setAttribute("customers",list);

        requestDispatcher = request.getRequestDispatcher(response.encodeURL("customers.jsp"));

        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
