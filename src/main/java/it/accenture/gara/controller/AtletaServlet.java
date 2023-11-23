package it.accenture.gara.controller;

import it.accenture.gara.dao.AtletaDao;
import it.accenture.gara.dao.fake.AtletaDaoFake;
import it.accenture.gara.model.Atleta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/atleta")
public class AtletaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AtletaDao atletaDao;

    public AtletaServlet() {
        atletaDao = new AtletaDaoFake();
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
                vistaAtleti(request, response);
                break;
            case "delete":
                eliminaAtleti(request, response);
                vistaAtleti(request,response);
                break;
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");


        switch (action) {
            case "insert":
                creaAtleta(request, response);
                break;
            case "update":
                aggiornaAtleta(request, response);
                break;
        }

        vistaAtleti(request,response);
    }

    private void vistaAtleti(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Atleta> listaAtleti = atletaDao.findAll();
        request.setAttribute("listaAtleta", listaAtleti);
        request.getRequestDispatcher("atleta/atleta-list.jsp").forward(request, response);
    }

    private void nuovoForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("atleta/atleta-form.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Atleta existAtleta = atletaDao.findById(id);
        request.setAttribute("atleta", existAtleta);
        request.getRequestDispatcher("atleta/atleta-form.jsp").forward(request, response);
    }

    private void creaAtleta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String categoria = request.getParameter("categoria");
        String societa = request.getParameter("societa");
        Atleta nuovoAtleta = new Atleta(id, nome, cognome, categoria, societa);
        atletaDao.save(nuovoAtleta);
    }


    private void aggiornaAtleta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String categoria = request.getParameter("categoria");
        String societa = request.getParameter("societa");

        Atleta updateAtleta = new Atleta(id, nome, cognome, categoria, societa);
        atletaDao.update(id, updateAtleta);
    }

    private void eliminaAtleti(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        atletaDao.delete(id);
    }
}
