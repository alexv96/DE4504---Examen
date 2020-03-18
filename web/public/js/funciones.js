//==================================
//        Carrito
//==================================


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