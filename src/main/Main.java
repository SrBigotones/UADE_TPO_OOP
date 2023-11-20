package main;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import interfazGrafica.Login;
import lab.modelo.Empresa;

public class Main {

	public static void main(String[] args) {
		Login login = new Login();
		login.setSize(400,500); 
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
	}

}
