<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>HighWay</title>
         <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="public/css/estilos.css"/>
        <link rel="stylesheet" href="public/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="header/menu.jsp"></jsp:include>
        
        <div class="container"><br>
            <form class="form-inline">
                <div class="form-group mb-2">
                    <label class="sr-only">Carretera</label>
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Buscar ubicación carretera">
                </div>
            
            
<select name="lineas">
  <option value="1">Opción 1</option>
  <option value="2">Opción 2</option>
  <option value="3">Opción 3</option>
  <option value="4">Opción 4</option>
  <option value="5">Opción 5</option>
</select>
                <button type="submit" class="btn btn-primary mb-2">Confirm identity</button>
            </form>
        </div>
                        
                        <script>
                            $(function(){
  $('#obtener').click(function(){
    console.log('El texto seleccionado es:',
      $('select[name="lineas"] option:selected').text());
  });
});
                        </script>
                        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    </body>
</html>
