<%-- 
    Document   : prestamos
    Created on : 19 nov 2024, 9:22:44 p. m.
    Author     : YEIMI
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelos.Prestamos"%>
<%@page import="java.util.List"%>
<%@page import="ModelosDao.PrestamosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Prestamos</h1>
            
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">CANTIDAD PRESTADA</th>
                        <th class="text-center">FECHA PRESTAMO</th>
                        <th class="text-center">FECHA DEVOLUCION</th>
                        
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PrestamosDao dao=new PrestamosDao();
                    List<Prestamos>list=dao.listar();
                    Iterator<Prestamos>iter=list.iterator();
                    Prestamos per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getID_Prestamo()%></td>
                        <td class="text-center"><%= per.get_CantidadPrestada()%></td>
                        <td class="text-center"><%= per.getFechaPrestamo()%></td>
                       
                        <td><%= per.getFechaDevolucion()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="PrestamoServlet?accion=editar&id=<%= per.getID_Prestamo()%>">Editar</a>
                            <a class="btn btn-danger" href="PrestamoServlet?accion=eliminar&id=<%= per.getID_Prestamo()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>

