<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HighWay</title>
        <!-- Bootstrap CSS -->

        <link rel="stylesheet" href="public/css/bootstrap.min.css"/>
        <link href="public/css/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css" />
        <link href="public/css/whatsapp.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header/menu.jsp"></jsp:include>

            <div class="container"><br>
                <form method="POST" action="Ubicacion?accion=buscar">
                    <div class="form-inline">
                        <div class="form-group mb-2">
                            <label class="sr-only">Carretera</label>
                            <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Buscar ubicación carretera">
                        </div>
                        <div class="form-group mx-sm-3 mb-2">
                            <select class="form-control col-auto" name="lineas" id="lineas">
                            <c:forEach var="x" items="${carreteras}">
                                <option value="${x.getIdCarretera()}">${x.getNombre()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <!--<a href="#" id="mostrar" class="btn btn-info col-auto">Buscar</a>-->
                    <input type="submit" name="accion" value="buscar" class="btn btn-outline-info" />
                </div>
            </form>

            <div id="mapa" class="mapa"></div>

            <div id="precios">
                <h3><strong>Precio:</strong> <span class="formato" id="valor">${ubicacion.getValor()}</span></h3>
                    <div class="ocultar" style="display: none;">
                        <input type="hidden" value="${ubicacion.getNombre()}" id="data1"/>
                        <input type="hidden" value="${ubicacion.getUbicacionID().getLatitud()}" id="data2"/>
                        <input type="hidden" value="${ubicacion.getUbicacionID().getLongitud()}" id="data3"/>
                    </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>
        <script src="public/js/funciones.js" type="text/javascript"></script>

    </body>
</html>
