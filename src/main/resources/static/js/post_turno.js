window.addEventListener('load', function(e) {
e.preventDefault()
const formulario = document.querySelector('#add_new_turno');

        const url = '/odontologos';
              const settings = {
                method: 'GET'
              }

              fetch(url,settings)
              .then(response => response.json())
              .then(data => {
                 for(odontologo of data){
                    let o = odontologo.nombre + " " + odontologo.apellido + " " +odontologo.matricula;

                    let select = document.getElementById('odontologo_select')

                    let option = document.createElement("OPTION"),
                    txt= document.createTextNode(o)
                    option.appendChild(txt)
                    select.insertBefore(option, select.lastChild)

                    }
                    })


   formulario.addEventListener('submit', function(event) {
   event.preventDefault();

            const odontologo_total= document.querySelector('#odontologo_select').value

            const formData = {
                fechaTurno: document.querySelector('#fecha').value,
                dni: document.querySelector('#paciente_select').value,
                matricula: odontologo_total.split(" ")[2]
            }

            console.log(formData)

        const urlPost = '/turnos';
        const settingsPost = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(urlPost, settingsPost)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                 '<button type="button" class="close" data-dismiss="alert"></button>' +
                 '<strong>Turno agregado</strong> </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

        }).catch(error => {

              let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                               '<button type="button" class="close" data-dismiss="alert"></button>' +
                               '<strong> Error intente nuevamente</strong> </div>'

              document.querySelector('#response').innerHTML = errorAlert;
              document.querySelector('#response').style.display = "block";
              resetUploadForm();});
    });


    function resetUploadForm(){
        document.querySelector('#fecha').value = "";
        document.querySelector('#paciente_select').value = "";
        document.querySelector('#odontologo_select').value = "";


    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnoList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    });
} )


