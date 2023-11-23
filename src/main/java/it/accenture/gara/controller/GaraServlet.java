package it.accenture.gara.controller;

import it.accenture.gara.dao.GaraDao;
import it.accenture.gara.dao.fake.GaraDaoFake;
import it.accenture.gara.model.Gara;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/gara")
public class GaraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GaraDao garaDao;

    public GaraServlet() {
        garaDao = new GaraDaoFake();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "new":
                nuovoForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "list":
            default:
                vistaGare(request, response);
                break;
            case "delete":
                eliminaGare(request, response);
                vistaGare(request,response);
                break;
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert":
                creaGara(request, response);
                break;
            case "update":
                aggiornaGara(request, response);
                break;
        }

       vistaGare(request,response);

    }

    private void vistaGare(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Gara> listaGara = garaDao.findAll();
        request.setAttribute("listaGare", listaGara);
        request.getRequestDispatcher("gara/gara-list.jsp").forward(request, response);
    }

    private void nuovoForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("gara/gara-form.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Gara exitGara = garaDao.findById(id);
        request.setAttribute("gara", exitGara);
        request.getRequestDispatcher("gara/gara-form.jsp").forward(request, response);
    }

    private void creaGara(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nomeGara");
        String luogo = request.getParameter("luogo");
        LocalDate dataGara = LocalDate.parse(request.getParameter("data"));
        LocalDate dataSvolta = LocalDate.parse(request.getParameter("svolta"));
        Gara nuovaGara = new Gara(id, nome, luogo, dataGara, dataSvolta);
        garaDao.save(nuovaGara);
    }

    private void aggiornaGara(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nomeGara");
        String luogo = request.getParameter("luogo");
        LocalDate dataGara = LocalDate.parse(request.getParameter("data"));
        LocalDate dataSvolta = LocalDate.parse(request.getParameter("svolta"));
        Gara garaUpdate = new Gara(id, nome, luogo, dataGara, dataSvolta);
        garaDao.update(id, garaUpdate);
    }

    private void eliminaGare(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        garaDao.delete(id);
    }
}

