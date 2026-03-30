package com.tracker.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.persistence.*;
import java.io.IOException;
import com.tracker.entity.JobPosting;
import java.util.List;

@WebServlet("/jobs")
public class JobServlet extends HttpServlet {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobPU");

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        List<JobPosting> list = em.createQuery("SELECT j FROM JobPosting j", JobPosting.class).getResultList();
        req.setAttribute("jobs", list);
        req.getRequestDispatcher("job-list.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        JobPosting job = new JobPosting();
        job.setTitle(req.getParameter("title"));
        job.setCompany(req.getParameter("company"));
        job.setLocation(req.getParameter("location"));
        job.setDate_posted(req.getParameter("date"));

        tx.begin();
        em.persist(job);
        tx.commit();

        resp.sendRedirect("jobs");
    }
}