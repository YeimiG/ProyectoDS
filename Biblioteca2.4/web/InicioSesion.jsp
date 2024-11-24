<%-- 
    Document   : InicioSesion
    Created on : 19 nov 2024, 12:05:50 p. m.
    Author     : YEIMI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Glassmorphism Login Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css\style_login.css">
</head>
<body>
    <form action="LogServlet" method="post">
        <h3>Login Here</h3>

        <input type="hidden" name="action" value="login">

        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" placeholder="username">

        <label for="clave">Contraseña:</label>
        <input type="password" id="clave" name="clave" placeholder="••••••••••••">

        <button type="submit">Log In</button>
        <a href="index.jsp" class="button">Regresar</a>

        <%
        // Manejo del mensaje de error desde el servidor
        String errorMessage = request.getParameter("error");
        if (errorMessage != null) {
        %>
            <p id="errorMessage" style="color: black;"><%= errorMessage %></p>
        <%
        }
        %>
           <script>
        // Ocultar el mensaje de error después de 3 segundos
        setTimeout(function() {
            var errorMessage = document.getElementById("errorMessage");
            if (errorMessage) {
                errorMessage.style.display = "none";
            }
        }, 3000);
    </script>
    </form>


</body>
</html>


