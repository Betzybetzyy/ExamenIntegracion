<%-- 
    Document   : modal
    Created on : 30 nov. 2023, 15:35:40
    Author     : betzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="modalAgenda" tabindex="-1" aria-labelledby="modalAgendaLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalAgendaLabel">Agregar Cita</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="AgendaV2Servlet" method="POST">
                <div class="modal-body">
                    <!-- Campos Select para Rut y Mascota -->
                    <div class="mb-3">
                        <label for="rut" class="form-label">RUT del Dueño</label>
                        <select class="form-select" id="rut" name="rut">
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="mascota" class="form-label">Mascota</label>
                        <select class="form-select" id="mascota" name="mascota">
                            <!-- Opciones cargadas dinámicamente en base al RUT seleccionado -->
                        </select>
                    </div>

                    <!-- Otros campos -->
                    <div class="mb-3">
                        <label for="nombremascota" class="form-label">Nombre de Mascota</label>
                        <input type="text" class="form-control" id="nombremascota" name="nombremascota">
                    </div>
                    <div class="mb-3">
                        <label for="hora" class="form-label">Hora</label>
                        <input type="time" class="form-control" id="hora" name="hora">
                    </div>
                    <div class="mb-3">
                        <label for="fecha" class="form-label">Fecha</label>
                        <input type="date" class="form-control" id="fecha" name="fecha">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary">Guardar Cita</button>
                </div>
            </form>
        </div>
    </div>
</div>
