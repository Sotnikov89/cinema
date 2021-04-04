package ru.job4j.cinema.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PaymentServlet", urlPatterns = "/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] rowAndCell = req.getParameterValues("place");
        Map<String, String> places = new HashMap<>();
        for (String place : rowAndCell) {
            String[] rowCell = place.split("\\.");
            places.put(rowCell[0], rowCell[1]);
        }
        req.setAttribute("places", places);
        req.getRequestDispatcher("payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
