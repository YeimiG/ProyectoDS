<%-- 
    Document   : editlibro
    Created on : 19 nov 2024, 10:38:34 a. m.
    Author     : YEIMI
--%>
<%@page import="Modelos.Libros"%>
<%@page import="ModelosDao.LibrosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Editar Libro</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="css\style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div data-component="navbar">

<nav class="navbar p-0 fixed-top">
  
  <div><a class="navbar-brand px-1" href="#"><img src="http://kris.agentfire2.com/wp-content/mu-plugins/agentfire-shared-library/img/agentfire.svg" class="d-inline-block mt-1" alt="AgentFire Logo" height="40"></a>

    
  </div> 
  
  </div>



<div data-component="sidebar">
  <div class="sidebar">
  <ul class="list-group flex-column d-inline-block first-menu">
     <li class="list-group-item pl-3 py-2">
      <a href="MenuAdmin.jsp"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Inicio</span></i></a>
    </li> 
    <li class="list-group-item pl-3 py-2">
      <a href="LibroServlet?accion=listar"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Libros</span></i></a>
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
      <a href="ClienteServlet?accion=listar"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Clientes</span></i></a>
      
    </li>
    
    <li class="list-group-item pl-3 py-2">
      <a href="#"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Reportes</span></i></a>
    </li>
        </li>
        <a href="index.jsp?accion=Logout" class="btn  logout-button">
    <i class="fa fa-sign-out" aria-hidden="true"></i> 

  </ul> <!-- /.first-menu -->
</div> <!-- /.sidebar -->
</div>

<div class="wp-content">
  <div class="container-fluid">
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              LibrosDao dao=new LibrosDao();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Libros p=(Libros)dao.list(id);
          %>
            <h1>Modificar Libros</h1>
            <form action="LibroServlet">
                TITULO:<br>
                <input class="form-control" type="text" name="txtTitulo" value="<%= p.get_Titulo()%>"><br>
                GENERO: <br>
                <input class="form-control" type="text" name="txtGenero" value="<%= p.getGenero()%>"><br>
                AUTOR:<br>
                <input class="form-control" type="text" name="txtAutor" value="<%= p.getAutor()%>"><br>
                CANTIDAD LIBRO: <br>
                <input class="form-control" type="text" name="txtCantidadLibro" value="<%= p.get_CantidadLibro()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= p.getID_Libro()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="LibroServlet?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
  </div>
</div>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>
</body>
</html>


