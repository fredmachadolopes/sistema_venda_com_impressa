package br.com.loja.controller;

import java.time.LocalDate;

public class CodigoTransacoes {
	
	public static String gerarCodigo() {
		String codigo = "" + LocalDate.now().getYear();

		char[] letras = new char[5];
		int[] numeros = new int[5];
		for (int i = 0; i < 5; i++) {
			letras[i] = (char) Math.round(65 + (25 * Math.random()));
			numeros[i] = (int) Math.round(9 * Math.random());
		}

		if (Math.round(1 * Math.random()) == 1) {

			for (int i = 0; i < 5; i++) {
				codigo += letras[i] + "" + numeros[i];

			}

		} else {

			for (int i = 0; i < 5; i++) {
				codigo += numeros[i] + "" + letras[i];

			}

		}
		
		return codigo;
	}

}
