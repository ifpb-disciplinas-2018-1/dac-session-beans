package ifpb.dac.web;

import ifpb.dac.service.ServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/cliente"})
public class ServletCliente extends HttpServlet {

//    @Inject
//    @EJB
//    private ExemploServiceLocal service;// = new ExemploServiceLocal();
    @EJB(lookup = "java:global/dac-core/SegundoExemploServiceLocalComInterface")
    private ServiceLocal service;
//    @EJB
//    private ServiceRemote service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCliente at " + request.getContextPath() + "</h1>");
            out.println(String.format("<p> %s </p>", service.transferencia(1, 0)));
            out.println(String.format("<p> %s </p>", service.toString()));
            out.println("</body>");
            out.println("</html>");
        }
    }

}
