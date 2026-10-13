package com.moreraramirezj.barberpro.service;

public class EmailService {
    public void enviarConfirmacion(String destinatario, String mensaje) {
        if (destinatario == null || destinatario.isBlank()) {
            throw new IllegalArgumentException("El destinatario es obligatorio.");
        }
        // Implementación real se conectará con SMTP o una API de correo en la siguiente etapa.
    }
}
