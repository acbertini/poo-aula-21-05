<%-- 
    Document   : customers
    Created on : May 21, 2018, 8:46:09 PM
    Author     : AnaBertini
--%>

<%@page import="br.com.poo.fatecpg.poo.SampleConnector"%>
<%@page import="br.com.poo.fatecpg.poo.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todos os clientes</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h2>Todos os clientes</h2>
        <div>
            <table>
                <thead>
                    <tr>
                        <td>ID</td><td>NAME</td><td>CREDIT LIMIT</td>
                    </tr>
                </thead>
                <tbody>
                    <%  ArrayList<Customer> list = null;
                        try {
                            list = SampleConnector.getCustomers();
                            for (int i = 0; i < list.size(); i++) {
                                Customer c = list.get(i);
                    %>
                    <tr>
                        <td><%=c.getId()%></td>
                        <td><%=c.getName()%></td>
                        <td><%=c.getCreditLimit()%></td>
                    </tr>
                    <%
                            }
                        } catch (Exception ex) {
                            out.println(ex);
                        }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
