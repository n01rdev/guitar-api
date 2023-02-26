<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Guitar Management</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<video id="background-video" autoplay loop muted poster="">
    <source src="${pageContext.request.contextPath}/assets/video/background.mp4" type="video/mp4">
</video>
<header>
    <h1><span>G</span>uitar <span>M</span>anagement</h1>
</header>
<section>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <label for="userName">Usuario</label>
        <input type="text" name="userName" id="userName" required/>
        <label for="password" id="passwordLabel">Contraseña</label>
        <input type="password" name="userPass" id="password" required/>
        <input type="submit" value="Iniciar Sesión" id="submit"/>
    </form>
</section>

</body>
</html>