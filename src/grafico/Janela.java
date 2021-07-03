package grafico;

import java.util.ArrayList;
import java.util.List;
import filtros.*;
import figuras.*;
import pt.iscte.guitoo.*;


public class Janela {
	private Window app;
	private StaticText ficheiro;
	private StaticText escala;
	private ConjuntoDados conjuntoDados;
	private Grafico graficoExibir;
	private Option<String> colorOption;
	private Filtro filtroDados;
	private Flag assiduidade;
	private Flag negativas;
	private Flag notas;
	

	public Janela() {
		app = new Window("JGrafas" , 1020, 400, true);
		ficheiro = new StaticText("PCD-Assid.csv", 0, 0);
		escala = new StaticText("1", 0, 0);
		app.addAction("Histograma", new Histograma());
		app.addAction("Dispersão", new Dispersao());
		app.addAction("Linhas", new Linhas());
		assiduidade = app.addFlag("< 20", false);
		notas = app.addFlag("< 50", false);
		negativas = app.addFlag("Negativas", false);
		colorOption = app.addOption("cores", "sem cores", "verde >=50", "amarelo <50 e >= 50");
	}
		
		
	// HISTOGRAMA
		class Histograma extends Action {
			public Histograma() {
				addParameter("Ficheiro", () -> ficheiro.getText(), (a) -> !a.isEmpty());
				addParameter("Escala", () -> escala.getText(), (b) -> !b.isEmpty());
			}
			protected void execute(String[] args) {
				app.clear();
				conjuntoDados = new ConjuntoDados(args[0]);
				if(negativas.isSelected()) {
					filtroDados=new Negativas();
					conjuntoDados.aplicarFiltros(filtroDados);
					conjuntoDados.aplicarEsquemaCores(colorOption.getSelected());
					graficoExibir = new DesenhaHistograma(conjuntoDados, Integer.parseInt(args[1]));
					app.addFigure(graficoExibir);
				}
				else {
				conjuntoDados.aplicarEsquemaCores(colorOption.getSelected());
				graficoExibir = new DesenhaHistograma(conjuntoDados, Integer.parseInt(args[1]));
				app.addFigure(graficoExibir);
				}
			}
		}
		

	// DISPERSAO
		class Dispersao extends Action {
			public Dispersao() {
				addParameter("Ficheiro", () -> ficheiro.getText(), (a) -> !a.isEmpty());
				addParameter("Escala", () -> escala.getText(), (b) -> !b.isEmpty());
			}
			protected void execute(String[] args) {			
				app.clear();
				conjuntoDados = new ConjuntoDados(args[0]);
				if(assiduidade.isSelected()) {
					filtroDados=new Assiduidade();
					conjuntoDados.aplicarFiltros(filtroDados);
					conjuntoDados.aplicarEsquemaCores(colorOption.getSelected());
					graficoExibir = new DesenhaDispersao(conjuntoDados, Integer.parseInt(args[1]));
					app.addFigure(graficoExibir);
				}
				if(notas.isSelected()) {
					filtroDados=new NotaFinal();
					conjuntoDados.aplicarFiltros(filtroDados);
					conjuntoDados.aplicarEsquemaCores(colorOption.getSelected());
					graficoExibir = new DesenhaDispersao(conjuntoDados, Integer.parseInt(args[1]));
					app.addFigure(graficoExibir);
				}
				else {
				conjuntoDados.aplicarEsquemaCores(colorOption.getSelected());
				graficoExibir = new DesenhaDispersao(conjuntoDados, Integer.parseInt(args[1]));
				app.addFigure(graficoExibir);
				}
				
			}
		}

		// LINHAS
		class Linhas extends Action {
			public Linhas() {
				addParameter("Ficheiro", () -> ficheiro.getText(), (a) -> !a.isEmpty());
				addParameter("Escala", () -> escala.getText(), (b) -> !b.isEmpty());
			}
			protected void execute(String[] args) {
				app.clear();
				conjuntoDados = new ConjuntoDados(args[0]);
				conjuntoDados.aplicarEsquemaCores(colorOption.getSelected());
				graficoExibir = new DesenhaLinhas(conjuntoDados, Integer.parseInt(args[1]));
				app.addFigure(graficoExibir);
			}
		}

		
		
		
	public void run() {
		app.open();
	}

	public static void main(String[] args) {
		Janela demo = new Janela();
		demo.run();
	}
}