<%-- 
    Document   : home
    Created on : 5 nov. 2023, 22:03:49
    Author     : betzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="shared/header.jsp" %>
<main class="container">
    <div class="row" >
        <h3>Agenda</h3>
        <div class="table-responsive">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalAgenda">
                Agendar hora
            </button>
            <table class="table table-striped table-sm mt-3">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Responsable (RUT)</th>
                        <th>Tipo de Mascota</th>
                        <th>Edad</th>
                        <th>Nombre de Mascota</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</main>

<%@ include file="shared/modalAgenda.jsp" %>
<script>
    document.getElementById('modalAgenda').addEventListener('show.bs.modal', function () {
        fetch('OwnerServlet')
                .then(response => response.json())
                .then(owners => {
                    var selectOwner = document.getElementById('rut');
                    selectOwner.innerHTML = '<option value="">Seleccione un dueño</option>';
                    owners.forEach(function (owner) {
                        var option = document.createElement('option');
                        option.value = owner.rut; // Asumiendo que cada dueño tiene un atributo 'rut'
                        option.textContent = owner.name + " (" + owner.rut + ")";
                        selectOwner.appendChild(option);
                    });
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Error al cargar los dueños');
                });

        fetch('PetServlet')
                .then(response => response.json())
                .then(pets => {
                    console.log('PETS ------* ',{pets}); // Esto muestra el objeto correctamente
                    window.allPets = pets; // Esto debería asignar el array a window.allPets
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Error al cargar las mascotas');
                });
    });

    document.getElementById('rut').addEventListener('change', function () {
        var selectedRut = this.value;
        var selectPet = document.getElementById('mascota');
        selectPet.innerHTML = '<option value="">Seleccione una mascota</option>';

        if (selectedRut) {
            var filteredPets = window.allPets.filter(pet => pet.rut === selectedRut); // Usar 'pet.rut' para filtrar

            filteredPets.forEach(function (pet) {
                var option = document.createElement('option');
                option.value = pet.id; // Usar 'pet.nombremascota' como el valor
                option.textContent = pet.nombremascota + " - " + pet.tipomascota; // Texto del option
                selectPet.appendChild(option);
            });
        }
    });

</script>

<%@ include file="shared/footer.jsp" %>
