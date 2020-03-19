//==================================
//        Carrito
//==================================
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



//==================================
//        ubicacion
//==================================
$(document).change(function () {
                var id = document.getElementById("lineas").value;
                console.log(valor);
                $("#mostrar").click(function () {
                    buscarUbicacion(id);
                    
                });

                function buscarUbicacion(id) {
                    var url = "Ubicacion?accion=buscar";

                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: "lineas=" + id,
                        success: function (data, textStatus, jqXHR) {
                            console.log('exito');
                        }
                    })
                }
            });

            //API LEATFLETJS
            var nombre = document.getElementById("data1").value;
            var latitud = document.getElementById("data2").value;
            var longitud = document.getElementById("data3").value;

            if (latitud === "") {
                var map = L.map('mapa').setView([-33.476932, -70.685799], 16);

                L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                }).addTo(map);

                L.marker([-33.476932, -70.685799]).addTo(map)
                        .bindPopup('<strong> AutoPista Central </strong>')
                        .openPopup();
            } else {
                

                //var map = L.map('mapa').setView([29.207616, -81.01902], 16);
                var map = L.map('mapa').setView([latitud, longitud], 14);

                L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                }).addTo(map);

                L.marker([latitud, longitud]).addTo(map)
                        .bindPopup('<strong>' + nombre + '</strong>')
                        .openPopup();
            }