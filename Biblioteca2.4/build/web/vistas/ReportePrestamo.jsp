<%-- 
    Document   : Reportes
    Created on : 24 nov 2024, 11:35:40 p. m.
    Author     : owen CN
--%>




<%@page import="Modelos.Prestamos"%>
<%@page import="ModelosDao.PrestamosDao"%>
<%@page import="Modelos.Clientes"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModelosDao.ClienteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Menu Cliente</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="css\style.css">

</head>
<body>
<div class="noimprimir" data-component="navbar">

<nav class="navbar p-0 fixed-top">
  
  <div>
    <a class="navbar-brand px-1" href="#">
      <img src="http://kris.agentfire2.com/wp-content/mu-plugins/agentfire-shared-library/img/agentfire.svg" 
           class="d-inline-block mt-1" alt="AgentFire Logo" height="40">
    </a>  
  </div> 
  </nav>
  </div>
<div class="noimprimir" data-component="sidebar">
  <div class="sidebar">
  <ul class="list-group flex-column d-inline-block first-menu">
     <li class="list-group-item pl-3 py-2">
      <a href="#"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Inicio</span></i></a>
    </li> 
    <li class="list-group-item pl-3 py-2">
      <a href="LibroServlet?accion=listarLibroClientes"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Libros</span></i></a>
    </li> 
    
    <li class="list-group-item pl-3 py-2">
      <a href="${pageContext.request.contextPath}/PrestamoServlet?accion=listar"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Prestamos</span></i></a>
    </li> <!-- /.list-group-item -->
    
    <li class="list-group-item pl-3 py-2">
      <a href="#">
        <i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Devolucion</span></i>
      </a>
    </li> <!-- /.list-group-item -->
    
    
    <li class="list-group-item pl-3 py-2">
      <a href=""><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Reportes</span></i></a>
    </li>
    
            <!-- Botón de cerrar sesión -->
    <a href="index.jsp?accion=Logout" class="btn  logout-button">
    <i class="fa fa-sign-out" aria-hidden="true"></i> 
    </a>
    
        
  </ul> <!-- /.first-menu -->
</div> <!-- /.sidebar -->
</div>
    
    



    

<div class="wp-content">
  <div class="container-fluid">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Informe anual de Prestamo</title>
        <script>
            function imprimir(){
                window.print();
            }
        </script>
        <style>
            @media print{
                .noimprimir{
                    display:none;
                }
            }
        </style>
    </head>
    <body>
         <div class="container">
            
            <center><h1>Informe Anual de Prestamo</h1></center>
            <br>
            <button class="noimprimir" onclick="javascript:window.history.back();">Volver</button>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        
                        <th class="text-center">Cliente</th>
                        <th class="text-center">Fecha de Prestamo</th>
                        <th class="text-center">Fecha de Devolucion</th>
                        <th class="text-center">Libro</th>
                        
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
                        <td class="text-center"><%= per.getID_Cliente()%></td>
                        <td class="text-center"><%= per.getFechaPrestamo()%></td>
                        <td class="text-center"><%= per.getFechaDevolucion()%></td>
                        <td class="text-center"><%= per.getID_Libro()%></td>
                        
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <button class="noimprimir" onclick="javascript:window.print();">Imprimir</button>

                    
        </div>
    </body>
</html>

  </div>
</div>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>
</body>
</html>












