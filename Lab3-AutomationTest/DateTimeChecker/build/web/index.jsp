<%-- 
    Document   : open
    Created on : Oct 24, 2022, 8:58:12 AM
    Author     : lthutrang
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date Time Checker</title>
        <style>
            a:link, a:visited {
                background-color: white;
                color: black;
                border: 2px solid green;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
            }

            a:hover, a:active {
                background-color: green;
                color: white;
            }
        </style>
    </head>
    <body>
        <h2>Open Date Time Checker:</h2>
        <a href="<c:url value="/check?op=form"/>" >Date Time Checker</a>
    </body>
</html>
