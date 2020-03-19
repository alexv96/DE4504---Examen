<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Highway - Ayuda</title>
        <link rel="stylesheet" href="public/css/bootstrap.min.css"/>
        <link href="public/css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/whatsapp.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/837ecb9d5c.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="header/menu.jsp"></jsp:include>
        <div class="container mt-2">
            <main>
                <h1 class="titulo">¿Como realizar compras?</h1>
                <ol>
                    <li>Seleccionar la carretera a comprar y presionar buscar</li>
                    <li>Seleccionar cantidad de tickets a comprar.</li>
                    <li>Ingresar sus datos personales</li>
                    <li>Presionar realizar compra.</li>
                </ol>
                
                <h1 class="titulo">Eliminar tickets del carro</h1>
                <ul>
                    <li>Presionar en eliminar.</li>
                    <li>Seleccionar en la ventana emergente eliminar.</li>
                </ul>
                
                <h1 class="titulo">¿Como ver la ubicación de las carreteras?</h1>
                <ul>
                    <li>Ir a <strong>ubicacion</strong>.</li>
                    <li>Seleccionar carretera y presionar buscar</li>
                    <li>Espere a que cargue el mapa y verá la ubicación y el precio.</li>
                </ul>
                
                <h1 class="titulo">¿Necesitas ayuda?</h1>
                <p>Contactate ingresando a tráves de nuestro icono de WhatsApp <i class="fab fa-whatsapp"></i> y uno de nuestros ejecutivos te repsonderá a la brevedad.</p>
            </main>
        </div>
    </body>
</html>
