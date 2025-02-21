//Esta funcion carga una imagen local en la pagina HTML

function readURL(input){
    if (input.files && input.files[0]){
        //Nos pasaron un archivo tipo imagen
        var lector = new FileReader();
        lector.onload = function(e) {
            $("#blah").attr("src",e.target.result).height(200);
        };
        lector.readAsDataURL(input.files[0]);   
    }
}