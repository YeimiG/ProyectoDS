<%-- 
    Document   : DatosClientes
    Created on : 24 nov 2024, 2:48:50 a. m.
    Author     : YEIMI
--%>

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
<div data-component="navbar">

<nav class="navbar p-0 fixed-top">
  
  <div>
    <a class="navbar-brand px-1" href="#">
      <img src="http://kris.agentfire2.com/wp-content/mu-plugins/agentfire-shared-library/img/agentfire.svg" 
           class="d-inline-block mt-1" alt="AgentFire Logo" height="40">
    </a>  
  </div> 
  </nav>
  </div>
<div data-component="sidebar">
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
      <a href="#"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Reportes</span></i></a>
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
        <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Registrar Clientes </h1>
                <form action="ClienteServlet">
                    NOMBRE COMPLETO:<br>
                    <input class="form-control" type="text" name="txtNombre"><br>
                    DIRECCION: <br>
                    <input class="form-control" type="text" name="txtDireccion"><br>
                    TELEFONO:<br>
                    <input class="form-control" type="text" name="txtTelefono"><br>
                    CORREO: <br>
                    <input class="form-control" type="text" name="txtCorreo"><br>
                    ID LIBRO: <br>
                    <input class="form-control" type="text" name="txtidLibro"><br>
                    ID USUARIO: <br>
                    <input class="form-control" type="text" name="txtidUsuario"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    
                    <a class="btn btn-primary" href="LibroServlet?accion=listarLibroClientes">Cancelar</a>
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































