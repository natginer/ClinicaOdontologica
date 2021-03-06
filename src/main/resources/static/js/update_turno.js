window.addEventListener('load', function () {


    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {

        const formData = {

            id: document.querySelector('#id').value,
            fecha: document.querySelector('#fecha'). value,
            paciente:{
                    dni: document.querySelector('#paciente').value
            },
            odontologo: {
                    matricula:document.querySelector('#odontologo').value
            }
            }

           console.log(formData)

        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })


    function findBy(id) {
          const url = '/turnos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let turno = data;
                 document.querySelector('#id').value = turno.id;
                 document.querySelector('#fecha').value = turno.fecha;
                 document.querySelector('#paciente').value = turno.paciente.dni;
                 document.querySelector('#odontologo').value = turno.odontologo.matricula;


              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }