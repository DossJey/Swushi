package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import model.ProductBean;
import model.ProductDAO;
import model.CarrelloBean;
import model.ProductcartBean;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CarrelloServlet", value = "/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductBean product = new ProductBean();
        ProductDAO productDAO = new ProductDAO();


        int code = Integer.parseInt(request.getParameter("codice"));
        int quantita = Integer.parseInt(request.getParameter("quantita"));
        double totale = 0;

        product = productDAO.getProductById(code);

        ProductcartBean productcartBean = new ProductcartBean(product.getIdprod(), product.getNome(), product.getPrezzo(), product.getDescrizione(), quantita);
        CarrelloBean carrelloBean = new CarrelloBean();
        ArrayList<ProductcartBean> lista = new ArrayList<ProductcartBean>();

        if (request.getSession().getAttribute("carrello") == null) {


            lista.add(productcartBean);
            carrelloBean.setProducts(lista);

            for(ProductcartBean p : lista){
                totale = totale + (p.getPrezzo()*p.getQuantita());
            }

            request.getSession().setAttribute("carrello", carrelloBean);
            request.getSession().setAttribute("totale", totale);
            System.out.println(product.toString());
            System.out.println(quantita);


        } else {

            carrelloBean = (CarrelloBean) request.getSession().getAttribute("carrello");
            totale = (double)request.getSession().getAttribute("totale");
            lista = carrelloBean.getProducts();
            boolean trovato = false;
            for (ProductcartBean p : lista) {

                if (productcartBean.getIdprod() == p.getIdprod()) {

                    p.setQuantita(p.getQuantita() + productcartBean.getQuantita());
                    totale = totale + (productcartBean.getPrezzo()*productcartBean.getQuantita());
                    trovato = true;
                }


            }
            if (!trovato) {
                lista.add(productcartBean);
                totale = totale+(productcartBean.getPrezzo()* productcartBean.getQuantita());

            }
        }
        request.getSession().setAttribute("totale", totale);
        System.out.println("PREZZO TOTALE" +totale);
        String encodedURL = response.encodeURL("cart.jsp");

        response.sendRedirect(request.getContextPath() + "/cart.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
