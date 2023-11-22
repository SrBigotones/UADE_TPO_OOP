package main;

import inicializacion.Inicializador;
import lab.controlador.ControladorLogin;
import lab.excepciones.EmpleadoIncompatible;
import lab.excepciones.EmpleadoNoEncontrado;
import lab.excepciones.LaboratorioNoDisponible;
import lab.excepciones.LaboratorioNoEncontrado;
import lab.excepciones.ProductoQuimicoNoEncontrado;
import lab.modelo.Empresa;

public class Main {

	public static void main(String[] args) throws LaboratorioNoEncontrado, LaboratorioNoDisponible, ProductoQuimicoNoEncontrado, EmpleadoNoEncontrado, EmpleadoIncompatible {
		Empresa empresa = Empresa.getInstance();
		Inicializador.ejecutar(empresa);
		ControladorLogin.getInstance().inicializarLogin();
	}
}
