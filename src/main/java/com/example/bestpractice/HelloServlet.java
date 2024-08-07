package com.example.bestpractice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet("/myservlet")
public class HelloServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(HelloServlet.class);
    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.setProperty("hibernate.validator.apply_to_ddl", "false");
            configuration.setProperty("hibernate.validator.autoregister_listeners", "false");
            sessionFactory = configuration.buildSessionFactory();
            LOGGER.info("Hibernate SessionFactory initialized successfully.");
        } catch (Exception e) {
            LOGGER.error("Error initializing Hibernate", e);
            throw new ServletException("Error initializing Hibernate", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/input.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            int id = Integer.parseInt(idStr);

            User user = new User();
            user.setId(id);
            user.setName(name);

            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

            LOGGER.info("User saved successfully with ID: " + id);
            request.setAttribute("id", id);
            request.setAttribute("name", name);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid ID format: " + idStr, e);
            request.setAttribute("error", "Invalid ID format. Please enter a valid integer.");
            request.getRequestDispatcher("/input.jsp").forward(request, response);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("An error occurred while saving the user", e);
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/input.jsp").forward(request, response);
        } finally {
            session.close();
        }
    }

    @Override
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
            LOGGER.info("Hibernate SessionFactory closed.");
        }
    }
}
