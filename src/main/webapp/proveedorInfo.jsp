<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Informaci&oacute;n del Proveedor</title>
</head>
<body>
    <h1>Informaci&oacute;n del Proveedor</h1>
    <form action="./ProveedorServlet" method="POST">
        <table>
            <tr>
                <td>ID Proveedor</td>
                <td><input type="text" name="idProveedor" value="${proveedor.id}"/></td>
            </tr>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" value="${proovedor.nombre}" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="action" value="add" />
                    <input type="submit" name="action" value="edit" />
                    <input type="submit" name="action" value="delete" />
                    <input type="submit" name="action" value="search" />
                </td>
            </tr>
        </table>
    </form>
    <br>
    <table border="1">
        <th>ID</th>
        <th>Nombre</th>
        <c:forEach items="${TodoProveedor}" var="prove">
            <tr>
                <td>${prove.idProveedor}</td>
                <td>${prove.nombre}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>