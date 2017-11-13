package Module.Authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainMenu extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String code="";

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        code = req.getParameter("code");
        if (code == null || code.equals("")) {
            res.sendRedirect("index.jsp");
            throw new RuntimeException(
                    "ERROR: Didn't get code parameter in callback.");
        }
    }
}