package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.PrenotazioneBean;
import model.PrenotazioneDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VisualizzaPrenotazioniServlet", value = "/VisualizzaPrenotazioniServlet")
public class VisualizzaPrenotazioniServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
        ArrayList<PrenotazioneBean> list = (ArrayList<PrenotazioneBean>)prenotazioneDAO.getPrenotazioni();

        RequestDispatcher requestDispatcher = null;

        request.getSession().setAttribute("prenotazioni",list);

        requestDispatcher = request.getRequestDispatcher(response.encodeURL("prenotazioni.jsp"));

        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
