package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ProductDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModificaMenuServlet", value = "/ModificaMenuServlet")
public class ModificaMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAO();
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        int idProdotto = Integer.parseInt(request.getParameter("codice"));
        System.out.println("Prezzo: "+ prezzo);
        System.out.println("CODICE: "+ idProdotto);
        RequestDispatcher requestDispatcher = null;
        try {
            productDAO.modificaPrezzo(prezzo,idProdotto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String encodedURL = response.encodeURL("modificamenu.jsp");

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
