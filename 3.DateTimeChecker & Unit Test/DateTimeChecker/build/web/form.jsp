<%-- 
    Document   : index
    Created on : Oct 24, 2022, 12:43:31 PM
    Author     : lthutrang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date Time Checker</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            .body{
                font-family: Arial;
            }
            a:link,  a:visited {
                background-color: red;
                color: white;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                padding: 0px 20px 0px 20px;
                border-radius: 0px 0px 5px 5px
            }

            a:hover, a:active {
                background-color: #f44336;
            }
        </style>
    </head>
    <body>
        <c:if test="${not empty message}">
            <script>
                alert("${message}");
            </script>
        </c:if>
        <div style="width: 50%; margin: auto">
            <div style="margin-top: 25%"></div>
            <div style="width: 50%; margin: auto;  padding: 3% 2% 2% 2%; border: dimgray solid 3px; position: relative; border-radius: 5px">
                <div style="margin-left: 0; width: 40%; display: inline-block">
                    <img src="Logo.png" alt="" style="width: 100%; margin-left: 3%"/>
                </div>
                <div style="position: absolute;right: 5px; top: -3px;">
                    <a  href="#" onclick="closeConfirm()">
                        <i class="fa" style="font-size:15px">
                            &#xf00d;
                        </i>
                    </a>
                </div>
                <div>
                    <p style="color: dodgerblue; font-size: 30pt; text-align: center;margin-top: 2%; margin-bottom: 5%;">Date Time Checker</p>
                </div>
                <div style="margin-top: -3%; margin-left: 25%;">
                    <form action="<c:url value="/check"/>">
                        <table cellspacing="5" style="margin-bottom: 20px">
                            <tr>
                                <td>Day</td>
                                <td><input id="day" type="text" name="day" value="${day}" style="width: 100px;"></td>
                            </tr>
                            <tr>
                                <td>Month</td>
                                <td><input id="month" type="text" name="month" value="${month}" style="width: 100px;"></td>
                            </tr>
                            <tr>
                                <td>Year</td>
                                <td><input id="year" type="text" name="year" value="${year}" style="width: 100px;"></td>
                            </tr>
                        </table>
                        <button type="button" onclick="document.getElementById('day').value = ''
                                document.getElementById('month').value = ''
                                document.getElementById('year').value = ''" style="width: 70px;">Clear</button>
                        <button type="submit" name="op" value="form_handler" style="width: 70px; margin-left: 12%">Check</button>
                    </form>
                </div>
            </div>
        </div>


        <script>
            function closeConfirm() {
                var txt;
                if (confirm("Are you sure to exit!")) {
                    location.replace("<c:url value="/check?op=close"/>")
                }
            }
        </script>
    </body>
</html>
