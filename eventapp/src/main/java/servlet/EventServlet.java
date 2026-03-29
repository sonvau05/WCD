
package servlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.persistence.*;
import util.JPAUtil;
import model.Event;
import java.io.IOException;
import java.util.List;

@WebServlet("/events")
public class EventServlet extends HttpServlet{
protected void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException{
EntityManager em=JPAUtil.get().createEntityManager();
List<Event> list=em.createQuery("from Event",Event.class).getResultList();
req.setAttribute("events",list);
req.getRequestDispatcher("events.jsp").forward(req,res);
}
protected void doPost(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException{
String name=req.getParameter("name");
String venue=req.getParameter("venue");
int seats=Integer.parseInt(req.getParameter("seats"));
java.sql.Date date=java.sql.Date.valueOf(req.getParameter("date"));
EntityManager em=JPAUtil.get().createEntityManager();
em.getTransaction().begin();
Event e=new Event();
e.setName(name);
e.setVenue(venue);
e.setSeats_available(seats);
e.setDate(date);
em.persist(e);
em.getTransaction().commit();
res.sendRedirect("events");
}
}
