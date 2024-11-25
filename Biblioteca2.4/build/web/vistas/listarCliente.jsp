<%-- 
    Document   : listarCliente
    Created on : 23 nov 2024, 11:15:55 p. m.
    Author     : YEIMI
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelos.Clientes"%>
<%@page import="java.util.List"%>
<%@page import="ModelosDao.ClienteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Listar Libros</title>
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
                        <a href="PrestamoServlet?accion=listar"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Prestamos</span></i></a>
                    </li> <!-- /.list-group-item -->

                    <li class="list-group-item pl-3 py-2">
                        <a href="#">
                            <i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Devolucion</span></i>
                        </a>
                    </li> <!-- /.list-group-item -->


                    <li class="list-group-item pl-3 py-2">
                        <a href="ClienteServlet?accion=listarCliente"><i class="fa fa-user-o" aria-hidden="true"><span class="ml-2 align-middle">Clientes</span></i></a>

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
                        <h1>Clientes</h1>

                        <br>
                        <br>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">ID</th>
                                    <th class="text-center">NOMBRE</th>
                                    <th class="text-center">DIRECCION</th>
                                    <th class="text-center">TELEFONO</th>
                                    <th class="text-center">CORREO</th>
                                    <th class="text-center">ACCIONES</th>
                                </tr>

                            </thead>
                            <%
                                ClienteDao dao = new ClienteDao();
                                List<Clientes> list = dao.listar();
                                Iterator<Clientes> iter = list.iterator();
                                Clientes per = null;
                                while (iter.hasNext()) {
                                    per = iter.next();

                            %>

                            <tbody>
                                <tr>
                                    <td class="text-center"><%= per.getID_Cliente()%></td>
                                    <td class="text-center"><%= per.get_Nombre()%></td>
                                    <td class="text-center"><%= per.getDireccion()%></td>
                                    <td class="text-center"><%= per.getTelefono()%></td>
                                    <td><%= per.getCorreo()%></td>
                                    <td class="text-center">
                                        <a class="btn btn-warning" href="LibroServlet?accion=editar&id=<%= per.getID_Libro()%>">Editar</a>
                                        <a class="btn btn-danger" href="LibroServlet?accion=eliminar&id=<%= per.getID_Libro()%>">Eliminar</a>
                                    </td>
                                </tr>
                                <%}%>

                            </tbody>
                        </table>
                        <a href="MenuAdmin.jsp" class="form__button">Regresar</a>

                    </div>
                </body>


            </div>
        </div>
        <!-- partial -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>
    </body>
</html>


