<%-- 
    Document   : LoginAdmin
    Created on : 19 nov 2024, 7:22:16 p. m.
    Author     : YEIMI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Sesion</title>
    <link rel="stylesheet" href="css\estilo.css">
</head>
<body class="align">

  <div class="grid align__item">

    <div class="register">

      <svg xmlns="http://www.w3.org/2000/svg" class="site__logo" width="56" height="84" viewBox="77.7 214.9 274.7 412"><defs><linearGradient id="a" x1="0%" y1="0%" y2="0%"><stop offset="0%" stop-color="#79808f"/><stop offset="100%" stop-color="#3a93cb"/></linearGradient></defs><path fill="url(#a)" d="M215 214.9c-83.6 123.5-137.3 200.8-137.3 275.9 0 75.2 61.4 136.1 137.3 136.1s137.3-60.9 137.3-136.1c0-75.1-53.7-152.4-137.3-275.9z"/></svg>

      <h2>Inicia Sesion</h2>

      <form action="LogServlet" method="post" class="mt-4">
            <input type="hidden" name="action" value="loginAdmin">

        <div class="form__field">
            <label for="usuario">Usuario:</label>
          <input type="text" name="usuario" placeholder="username">
        </div>

        <div class="form__field">
           <label for="clave">Contraseña:</label>
          <input type="password" name="clave" placeholder="••••••••••••">
        </div>

        <div class="form__field">
        <button type="submit" class="form__button">Iniciar Sesión</button>
        <a href="index.jsp" class="form__button">Regresar</a>
       </div>
   <%
          String errorMessage = request.getParameter("error");
          if (errorMessage != null) {
      %>
          <p id="errorMessage" style="color:black;"><%= errorMessage %></p>
      <%
          }
      %>
     <script>
      setTimeout(function() {
            var errorMessage = document.getElementById("errorMessage");
            if (errorMessage) {
                errorMessage.style.display = "none";
            }
        }, 3000);
  </script>
      </form>



    </div>

  </div>

</body>
</html>