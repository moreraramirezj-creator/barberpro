package com.moreraramirezj.barberpro.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("BarberPro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("BarberPro - Sistema de gestión", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextArea resumen = new JTextArea(
                "Módulos principales:\n"
                        + "- Clientes\n"
                        + "- Servicios\n"
                        + "- Citas\n"
                        + "- Calendario semanal y mensual\n"
                        + "- Lista de espera\n"
                        + "- Horarios\n"
                        + "- Confirmaciones por correo"
        );
        resumen.setEditable(false);
        resumen.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resumen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(titulo, BorderLayout.NORTH);
        panel.add(new JScrollPane(resumen), BorderLayout.CENTER);

        add(panel);
    }
}
