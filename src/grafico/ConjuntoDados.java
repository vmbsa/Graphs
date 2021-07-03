package grafico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import cores.*;
import filtros.Filtro;
import grafico.*;


public class ConjuntoDados {
	private ArrayList<Tuplo> listaTuplos = new ArrayList<Tuplo>();
	private EsquemaCores esquema;
	
	public ConjuntoDados (String nomeFicheiro) {
		File ficheiro = new File(nomeFicheiro);
		String[] resultados;
		try {
			Scanner scanner = new Scanner(ficheiro);
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				if (linha.contains(", ")) 
					resultados = linha.split(", ");
				else
					resultados = linha.split(",");
				Tuplo tuplo = new Tuplo (resultados[0], Integer.parseInt(resultados[1]));
				listaTuplos.add(tuplo);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ficheiro nao encontrado");
		}
		
	}

	
	//ESQUEMA DE CORES
	public void aplicarEsquemaCores(String nome) {
		if (nome.equals("verde >=50")) {
			esquema = new VermelhoVerde();
			for (Tuplo tuplo : listaTuplos)
				esquema.validarCor(tuplo);
		}
		if (nome.contentEquals("amarelo <50 e >= 50")) {
			esquema = new Amarelo();
			for (Tuplo tuplo : listaTuplos)
				esquema.validarCor(tuplo);
		}
	}
	
	
	//FILTROS
	public void aplicarFiltros(Filtro filtro) {
		ArrayList<Tuplo> filtradosNegativos = new ArrayList<Tuplo>();
		for (int i = 0; listaTuplos.size() > i; i++)
			if (filtro.validarFiltro(listaTuplos.get(i)))
				filtradosNegativos.add(listaTuplos.get(i));
		listaTuplos.removeAll(filtradosNegativos);
	}
	
	
	
	
	//obter lista de tuplos associada a um conjunto de dados
	public ArrayList<Tuplo> getListaTuplos() {
		return listaTuplos;
	}
}
