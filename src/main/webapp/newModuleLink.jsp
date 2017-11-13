<%--
  Created by IntelliJ IDEA.
  User: myriam
  Date: 24/10/17
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Module.Interfaces.IAction" %>
<%@ page import="Module.Interfaces.IModule" %>
<%@ page import="Module.Interfaces.IReaction" %>
<%@ page import="Module.Mediator" %>

<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="css/ModuleList.css">
</head>

<div>
    <h1><span>New</span> module link </h1>

        <form method="GET" name="formulaire" action="${pageContext.request.contextPath}/validation">
            <select name="action" size="1">
            <%
                Mediator mediator= (Mediator) request.getSession().getAttribute("mediator");
                int      x = 0;

                for (IModule module : mediator.modules)
                {
                    for (IAction action : module.getActions())
                    {
            %>
                <option value="<%= x %>"><%= action.Name()%></option>
            <%
                        x++;
                    }
                }
                %>
            </select>
            <select name="reaction" size="1">
            <%
                x = 0;
                for (IModule module : mediator.modules)
                {
                    for (IReaction reaction : module.getReactions())
                    {
                        %>
                        <option value="<%= x %>"><%= reaction.Name() %></option>
                        <%
                        x++;
                    }
                }
            %>

            </select>
            <input type="submit" value="Ok"/>
        </form>
</div>
<div style="position: relative; top: 250px; left: 0px;">
    <h1> <span>List</span> of links</h1>

    <table border="1" cellpadding="10" cellspacing="1" width="100%" style="color: white; font-family: aakar; border-color: ghostwhite" >

        <tr>
            <th width="50%">Action</th>
            <th width="50%">Reaction</th>
        </tr>
        <%
            int index = 0;
            for (String actionName : mediator.getActName())
            {
        %>
        <tr><td><%= actionName%></td>
            <%
                String reactionName = mediator.getReactName().get(index);
                index++;
            %>
            <td><%= reactionName%> </td></tr>
        <%
            }
        %>
    </table>
</div>

</html>
