package ru.job4j.cinema.controller;

import ru.job4j.cinema.model.Account;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.sevice.ImplServiceAccount;
import ru.job4j.cinema.sevice.ImplServiceTicket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PaymentServlet", urlPatterns = "/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] rowAndCell = req.getParameterValues("place");
        List<String> places = new ArrayList<>();
        for (String place : rowAndCell) {
            String[] rowCell = place.split("\\.");
            places.add("ряд " + rowCell[0] + " место " + rowCell[1] + ", ");
        }
        req.setAttribute("places", places);
        req.setAttribute("price", places.size() * 500);

        req.getSession().setAttribute("sessionPlaces", rowAndCell);
        req.getRequestDispatcher("payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Account account = new Account(req.getParameter("name"), req.getParameter("email"), req.getParameter("phone"));
        int idAccount = ImplServiceAccount.instOf().saveAndGetIdOrGetId(account);
        account.setId(idAccount);

        List<Ticket> tickets = new ArrayList<>();
        String[] rowAndCell = (String[]) req.getSession().getAttribute("sessionPlaces");
        for (String place : rowAndCell) {
            String[] rowCell = place.split("\\.");
            Ticket ticket = new Ticket(Integer.parseInt(rowCell[0]), Integer.parseInt(rowCell[1]), idAccount);
            tickets.add(ticket);
        }
        try {
            for (Ticket ticket : tickets) {
                ImplServiceTicket.instOf().save(ticket);
            }
            resp.sendRedirect(req.getContextPath() + "/hall");
        } catch (SQLException exception) {
            req.getRequestDispatcher("warning.jsp").forward(req, resp);
        }
    }
}
