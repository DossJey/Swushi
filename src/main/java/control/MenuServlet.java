package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CustomerBean;
import model.ProductBean;
import model.ProductDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "MenuServlet", value = "/MenuServlet")
public class MenuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MenuServlet() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAO();
        ArrayList<ProductBean> list = new ArrayList<ProductBean>();

        CustomerBean customer = new CustomerBean();

        customer = (CustomerBean)request.getSession().getAttribute("customer");

        RequestDispatcher requestDispatcher = null;

        list = productDAO.getProductList();

        System.out.println(list.toString());

        request.setAttribute("products", list);


        if((customer==null)||(customer.getIsAdmin()==0)) {
            requestDispatcher = request.getRequestDispatcher(response.encodeURL("menu.jsp"));
        }
        else{
            requestDispatcher = request.getRequestDispatcher(response.encodeURL("modificamenu.jsp"));
        }


        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
