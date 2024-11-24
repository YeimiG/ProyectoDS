<%-- 
    Document   : Registar
   
    Author     : owen CN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Registrarse</title>
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
    
     <li class="list-group-item pl-3 py-2">
      <a href="Registar.jsp"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Registrar usuario</span></i></a>
    </li>
    
                <!-- Botón de cerrar sesión -->
    <a href="index.jsp?accion=Logout" class=" btn logout-button" >
    <i class="fa fa-sign-out" aria-hidden="true"></i> Salir
    </a>

  </ul> <!-- /.first-menu -->
</div> <!-- /.sidebar -->
</div>

<div class="wp-content">
  <div class="container-fluid">
        <body class="align">

  <div class="grid align__item">

    <div class="register">

      <h2>Inserte los datos</h2>

      <form action="LoginServlet" method="post" class="mt-4">
            <input type="hidden" name="action" value="registrar">
            


        <div class="form__field">
           <label for="usuario">Usuario:</label>
          <input type="text" name="usuario" placeholder="">
        </div>
            
         
            
        <div class="form__field">
           <label for="clave">Contraseña:</label>
          <input type="password" name="clave" placeholder="">
        </div>
           
    
        <div class="form__field">
        <button type="submit" class="form__button">Registrarse</button>
        <a href="MenuAdmin.jsp" class="form__button">Regresar</a>
       </div>

         <c:if test="${not empty param.error}">
                <div class="alert alert-danger mt-3">${param.error}</div>
            </c:if>
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





















