package Module;

import Module.Exception.ModuleException;
import Module.Interfaces.IAction;
import Module.Interfaces.IReaction;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validation")
public class ModuleLink extends HttpServlet {

    private int _actionIndex;
    private int _reactionIndex;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        _actionIndex =  Integer.parseInt(request.getParameter("action"));
        _reactionIndex = Integer.parseInt(request.getParameter("reaction"));

        makeLink(request);
        response.sendRedirect("/newLink");
    }

    private void makeLink(HttpServletRequest request)
    {
        Mediator med = (Mediator)request.getSession().getAttribute("mediator");
        med.initList();
        IAction action = med.getActions().get(_actionIndex);
        IReaction reaction = med.getReactions().get(_reactionIndex);
        med.addActName(action.Name());
        med.addReactName(reaction.Name());

        try {
            action.LinkTo(reaction);
        } catch (ModuleException e) {
            e.printStackTrace();
        }
    }
}
