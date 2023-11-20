package lab.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	
	public Login() {
        super("LOGIN");
        this.setLayout(new BorderLayout());

        JLabel bienvenida = new JLabel("Bienvenido" , SwingConstants.CENTER);
        bienvenida.setFont(new Font("Arial", Font.PLAIN, 56)); 

        JTextField usuario = new JTextField("Nombre de Usuario");
        usuario.setMargin(new Insets(5, 10, 5, 10));
        
        
        JButton iniciarSesionButton = new JButton("Iniciar Sesion");

        Font buttonFont = new Font(iniciarSesionButton.getFont().getName(), Font.PLAIN, 22);

        JPanel bienvenidaPanel = new JPanel();
        bienvenidaPanel.setLayout(new BorderLayout());
        bienvenidaPanel.setBorder(new EmptyBorder(60,0,60,0));
        bienvenidaPanel.add(bienvenida);

        setLayout(new BorderLayout());
        add(bienvenidaPanel, BorderLayout.PAGE_START);
        
        
        JPanel centroPanel = new JPanel();
        centroPanel.setLayout(new GridLayout(3, 1, 10, 10));
        centroPanel.setBorder(new EmptyBorder(20,20,20,20));
        centroPanel.add(usuario);

        JPanel botonPanel = new JPanel();
        botonPanel.setBorder(new EmptyBorder(0,0,20,0));
        botonPanel.add(iniciarSesionButton);

        add(centroPanel, BorderLayout.CENTER);
        add(botonPanel, BorderLayout.PAGE_END);
        
        
        setResizable(false);
    }
}
