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
        <jsp:include page="header/menu.jsp"></jsp:include><br>
            <div class="container-fluid">
                <h1>${parameter}</h1>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">

                    <!--<form id="fomrulario">-->

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">RUT</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="txtRut" placeholder="12345678-9">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Nombre</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="txtNombre">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Dirección</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="txtDireccion">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Comprado por</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="txtCompradoPor">
                            </div>
                        </div>

                        <p>Seleccione <strong>carretera</strong>, indique la cantidad y agregue al pedido.</p>

                        <div class="form-row align-items-center">
                            <div class="col-auto">
                                <select class="form-control mb-4" name="cboCarretera" id="lineas">
                                    <option disabled selected>Seleccione carretera</option>    
                                    <c:forEach var="x" items="${carreteras}">
                                        <option value="${x.getIdCarretera()}">${x.getNombre()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-auto">
                                <a href="#" id="obtener" class="btn btn-info col-auto">Agregar a carro</a>

                            </div>
                        </div>

                    <!--</form>-->

                    <table id="carreterasSeleccionadas" class="table table-striped">
                        <thead>
                            <tr>
                                <th class="col-sm-4">Carretera</th>
                                <th class="col-sm-3">Cantidad</th>
                                <th class="col-sm-2">Acción</th>
                            </tr>
                        </thead>
                        <tbody id="listaCarretera">
                            <c:forEach var="c" items="${carro}">
                                <tr>
                                    <td>${c.getCarreteraID().getNombre()}</td>
                                    <td>
                                        <input type="hidden" class="form-control text-center" value="${c.getCarreteraID().getIdCarretera()}" id="idCarretera" />
                                        <input type="text" class="form-control text-center" value="${c.getCantidad()}" name="cantidad" id="cantidad" />
                                    </td>
                                    <td>
                                        <input type="hidden" class="form-control text-center" value="${c.getCarreteraID().getIdCarretera()}" id="idPista" />
                                        <a href="#" class="btn btn-outline-danger" id="btnDelete">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                    <div class="col-md-7">
                        <h4><strong>Total a Pagar:</strong> <span>$${totalPagar}</span></h4>
                    </div>
                    <div class="col-auto">
                        <a href="Controlador?accion=GenerarCompra" class="btn btn-info btn-block">Realizar Pago</a>
                    </div>
                    
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script>
            $(document).change(function () {
                var id = document.getElementById("lineas").value;
                console.log(id);
                $("div #obtener").click(function () {
                    console.log(id);
                    if (id != null) {
                        agregarACarro(id);
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Oops...',
                            text: 'Ha sucedido un error!',
                        })
                    }


                });
                function agregarACarro(id) {
                    console.log('ingreso');
                    var url = "Controlador?accion=agregarCarro";
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: "lineas=" + id,
                        success: function (data, textStatus, jqXHR) {
                            location.href="Controlador?accion=home";
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            Swal.fire({
                                icon: 'error',
                                title: 'Oops...',
                                text: 'Ha sucedido un error!',
                            })
                        }
                    })
                }
            });
            
            $(document).ready(function (){
               //Obtener atributo para eliminar.
               $("tr #btnDelete").click(function(){
                   var idCarro = $(this).parent().find("#idPista").val();
                   
                   //Mensajes
                   Swal.fire({
                       title: '¿Estas seguro que deseas eliminar del carro?',
                       text: 'Puedes volver a agregar en cualquier momento',
                       icon: 'warning',
                       showCancelButton: true,
                       confirmButtonColor: '#28a745',
                       cancelButtonColor: '#d33',
                       confirmButtonText: 'Eliminar',
                       cancelButtonText: 'Cancelar'
                   }).then((result) => {
                       if(result.value){
                            eliminar(idCarro);
                            Swal.fire({
                                icon: 'success',
                                title: 'Eliminado exitosamente'
                            }) .then((result) => {
                               if(result.value){
                                   parent.location.href = "Controlador?accion=home";
                               } 
                            });
                       }else{
                           Swal.fire({
                               icon: 'error',
                               title: 'Error al eliminar del carro'
                           });
                       }
                   })
               });
               
               function eliminar(idCarro){
                   var url = "Controlador?accion=eliminar";
                   console.log(idCarro);
                   $.ajax({
                       type: 'POST',
                       url: url,
                       data: "idPista="+ idCarro,
                       success: function (data, textStatus, jqXHR) {
                           console.log('elimino');
                        }
                   })
               }
               
               $("tr #cantidad").blur(function(){
                   var idCarretera = $(this).parent().find("#idCarretera").val();
                   var cantidad = $(this).parent().find("#cantidad").val();
                   var url = "Controlador?accion=actualizarCantidad";
                   
                   $.ajax({
                       type: 'POST',
                       url: url,
                       data: "idCarretera="+idCarretera +"&cantidad="+cantidad,
                       success: function (data, textStatus, jqXHR) {
                           location.href = "Controlador?accion=home";
                        }
                   })
               });
            });


        </script>


    </body>
</html>
