package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.PrenotazioneBean;
import model.PrenotazioneDAO;

import java.io.IOException;
import java.sql.SQLException;
import model.EmailValidator;

@WebServlet(name = "PrenotazioneServlet", value = "/PrenotazioneServlet")
public class PrenotazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrenotazioneBean prenotazioneBean = new PrenotazioneBean();
        EmailValidator m = new EmailValidator();

        prenotazioneBean.setEmail(request.getParameter("email"));
        prenotazioneBean.setNome(request.getParameter("nome"));
        prenotazioneBean.setGiorno(request.getParameter("giorno"));
        prenotazioneBean.setCellulare((request.getParameter("cellulare")));
        prenotazioneBean.setOra(request.getParameter("ora"));
        prenotazioneBean.setPersone(Integer.parseInt(request.getParameter("persone")));
       System.out.println(prenotazioneBean.toString());
        PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();

        try {
            if(m.validateEmail(prenotazioneBean.getEmail())) {
                System.out.println("Prenotazione salvata.");
                prenotazioneDAO.doSave(prenotazioneBean);
            }
            else{
                RequestDispatcher requestDispatcher = null;
                requestDispatcher = request.getRequestDispatcher(response.encodeURL("register-error.jsp"));
                requestDispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //String encodedURL = response.encodeURL("cart.jsp");

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
