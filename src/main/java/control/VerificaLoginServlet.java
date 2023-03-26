package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CustomerBean;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CustomerBean;
import model.CustomerDAO;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "VerificaLoginServlet", value = "/VerificaLoginServlet")
public class VerificaLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher requestDispatcher = null;

        if(request.getSession().getAttribute("customer")!=null){

            requestDispatcher = request.getRequestDispatcher("acquisto.jsp");
            requestDispatcher.forward(request,response);
        }
        else{
            requestDispatcher = request.getRequestDispatcher("acquisto-error.jsp");
            requestDispatcher.forward(request,response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
