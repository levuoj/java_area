<%--
  Created by IntelliJ IDEA.
  User: Oraekia
  Date: 23/10/17
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="Module.Authentification.FBConnection" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    FBConnection fbConnection = new FBConnection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Java Facebook Login</title>
    <style>
        body {
            background-color: #736280;
        }
    </style>
</head>
<body style="text-align: center; margin: 0 auto;">
<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1464343446996105',
      xfbml      : true,
      version    : 'v2.10'
    });
    FB.AppEvents.logPageView();
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
<div>
    <a href="<%=fbConnection.getFBAuthUrl()%>"> <img style="margin-top: 138px;" src="images/facebookloginbutton.png" />
    </a>
</div>
</body>
</html>