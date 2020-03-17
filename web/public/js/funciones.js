<script>
            $(document).change(function () {
                var id = document.getElementById("lineas").value;
                console.log(id);
                $("#obtener").click(function () {
                    console.log(id);
                    if (id != null) {
                        agregarACarro(id);
                    }
                });
                function agregarACarro(id) {
                    console.log('ingreso');
                    console.log(id);
                    var url = "Controlador?accion=agregarCarro";
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: "lineas=" + id,
                        success: function (data, textStatus, jqXHR) {
                            //location.href = "Controlador?accion=home";
                            console.log(id);
                        }
                    })
                }
            });




        </script>