<%@ page import="Module.Mediator" %>
<%@ page import="Module.Authentification.FBConnection" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
    String accessToken = fbConnection.getAccessToken(request.getParameter("code"));
    accessToken = accessToken.substring(13);

    Map<String, String[]> param = new HashMap<String, String[]>();
    param.put("accessToken", new String[] {accessToken});
    if (request.getParameter("error") == null && request.getParameter("code") != null) {
        boolean bool = ((Mediator) (request.getSession().getAttribute("mediator"))).initModule("Facebook", param);
        if (bool)
        {
%>
<script>
    window.location = "http://localhost:8080/newLink";
</script>
        <%
    }
        else {
%>
    <p>Connection failed, please Retry</p>
    <a href = "http://localhost:8080/">TRY AGAIN</a>
        <%
        }
    }
%>
</body>
</html>
