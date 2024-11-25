<%-- 
    Document   : addprestamo
    Created on : 25 nov 2024, 10:40:16 a. m.
    Author     : YEIMI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Agregar Prestamo</title>
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
      <a href="#"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Inicio</span></i></a>
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

  </ul> <!-- /.first-menu -->
</div> <!-- /.sidebar -->
</div>

<div class="wp-content">
  <div class="container-fluid">
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Prestamo</h1>
                <form action="PrestamoServlet">
                    CANTIDAD A PRESTAR:<br>
                    <input class="form-control" type="text" name="txtCantidadPrestada"><br>
                    FECHA PRESTAMO: <br>
                    <input class="form-control" type="text" name="txtFechaPrestamo"><br>
                    FECHA DEVOLUCION:<br>
                    <input class="form-control" type="text" name="txtFechaDevolucion"><br>
                    ID LIBRO: <br>
                    <input class="form-control" type="text" name="txtidLibro"><br>
                    ID CLIENTE: <br>
                    <input class="form-control" type="text" name="txtidCliente"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    
                    <a class="btn btn-primary" href="LibroServlet?accion=listarLibroClientes">Regresar</a>
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

