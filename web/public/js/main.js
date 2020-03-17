(function(){
    'use stritch';
    
    //VARIABLE SELECT CARRETERA
    var carretera = document.getElementById('lineas');
    
    document.addEventListener('DOMContentLoaded', function(){
        //BOTON SELECT PARA AGREGAR CARRETERAS A TABLA.
        var agregar_carretera = document.getElementById('obtener');
        //var carretera = document.getElementById('lineas');
        //TABLA
        var listaCarreteras = document.getElementById('listaCarretera');
        
        //LLAMADO DE FUNCIONES
        agregar_carretera.addEventListener('click', agregarCarretera);
        
        //FUNCIONES
        function agregarCarretera(event){
            event.preventDefault();
            
            if (carretera === '' ) {
                alert('Seleccione una carretera');
            }
            console.log(carretera.value);
            var arregloCarretera = [];
            arregloCarretera.push(carretera.value);
            console.log(arregloCarretera);
            
            listaCarreteras.innerHTML = '<tr><td>';
            for (var i = 0; i < arregloCarretera.length ; i++) {
                listaCarreteras.innerHTML += arregloCarretera[i] + '</td><td><input type="number" class="form-control" name="cantidad" id="cantidad"></td></tr>';
            }
        }
        
        /*function agregarCarretera(){
            var arregloCarretera = [];
            arregloCarretera.push(carretera.value);
            console.log(arregloCarretera);
            
            listaCarreteras.innerHTML = "<tr><td>";
            for (var i = 0; i < arregloCarretera.length ; i++) {
                listaCarreteras.innerHTML += arregloCarretera[i] + "</td></tr>";
            }
        }*/
    });
})();