<%--
  Created by IntelliJ IDEA.
  User: levuoj
  Date: 10/24/17
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Module.Mediator" %>
<%@ page import="Module.Authentification.FBConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        body {
            width: 100%;
            min-height: 900px;
            margin: 3em auto;
            background: linear-gradient(135deg, rgba(247, 202, 201, 1) 0%, rgba(146, 168, 209, 1) 100%);
            letter-spacing: 1px;
        }
        h1 {
            color: white;
            text-align: center;
        }
        h2 {
            color: blueviolet;
            text-align: center;
        }
        p {
            font-family: verdana;
            font-size: 20px;
        }
        img {
            display: block;
            margin: 0 auto;
        }
    </style>

    <link rel="icon" type="image/ico" href="images/pheonix.ico" />
    <title>Connected</title>
</head>
<body>
<h1>Area</h1>
<h2 id="dispTime"></h2>

<script type="text/javascript">
    setInterval(function(){
        document.getElementById('dispTime').innerHTML = new Date().toLocaleTimeString();
    }, 1000);
</script>

<%
    FBConnection fbConnection = new FBConnection();
    String ret = request.getParameter("module");
    if (ret != null) {
        boolean bool = ((Mediator) (request.getSession().getAttribute("mediator"))).initModule(ret, request.getParameterMap());

        if (bool)
        {
%>
            <p>Good, you're connected to <%= ret %>!</p>
            <a href="<%=fbConnection.getFBAuthUrl()%>"> <img style="margin-top: 138px;" src="images/facebookloginbutton.png" />
<%
    }
        else {
%>
            <p>Connection failed, please Retry</p>
            <a href = "http://localhost:8080">TRY AGAIN</a>
<%
        }
    }
%>


</body>
</html>