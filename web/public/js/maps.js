function iniciarMap(){
    var coord = {lat:1 ,long:1};
    var map = new google.maps.Map(document.getElementById('map'),{
        zoom: 10,
        center: coord
    });
    
    var marker = new google.maps.Marker({
        position: coord,
        map: map
    });
}