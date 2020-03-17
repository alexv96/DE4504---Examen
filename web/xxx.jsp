<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>HighWay</title>
         <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="public/css/estilos.css"/>
        <link rel="stylesheet" href="public/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    </head>
    <body>
        <jsp:include page="header/menu.jsp"></jsp:include>
        
        <div class="container">
            <fieldset class="border p-2">
                <legend class="w-auto">Datos de la Empresa</legend>
                        
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Rut</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="txtRut" id="txtRut"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Nombre</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="txtNombre" id="txtNombre"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Dirección</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="txtDireccion" id="txtDireccion"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Comprado por</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="txtComprado" id="txtComprado"/>
                        </div>
                    </div>
            </fieldset>
                        
                    <div class="form-group">
                        <label>Seleccione <strong>carretera</strong>, indique la cantidad y agregue al pedido.</label>
                        <select class="form-control col-md-6" id="cboCarretera" name="cboCarretera">
                        <c:forEach var="carreteras" items="${requestScope.carreteras}">
                              <option value="${carreteras.getIdCarretera()}">${carreteras.getNombre()}</option>
                            </c:forEach>
                        </select>
                        <div class="col-md-3">
                            <input type="button" class="btn btn-primary" name="btnAgregar" value="Agregar"/>

                        </div>
                    </div>
                
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Forma de Pago</label>
                            <c:forEach var="pagos" items="${requestScope.pagos}">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="pago" id="${pagos.getIdTipoPago()}" value="option1">
                                    <label class="form-check-label">${pagos.getDescripcion()}</label>
                                </div>
                            </c:forEach>
                        </div>
                        
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Tipo de Despacho</label>
                            
                            <c:forEach var="despachos" items="${requestScope.despachos}">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="${despachos.getIdTipoDespacho()}" value="option1">
                                    <label class="form-check-label">${despachos.getDescripcion()}</label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

            
            <table class="table table-stripped">
                <thead>
                    <tr>
                        <th>Carretera</th>
                        <th>Cantidad</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="carreteras" items="${requestScope.carreteras}">
                        <tr>
                            <td>${carreteras.getNombre()}</td>
                            <td>1</td>
                            <td>+ -</td>
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
            
            <h3><strong>Total a pagar: </strong></h3>
        </div>
        
        <script src="public/js/bootstrap.min.js"></script>
        <script src="public/js/bienvenida.js"></script>
    </body>
</html>
