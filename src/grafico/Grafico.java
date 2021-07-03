package grafico;

import java.util.*;

import figuras.Retangulo;
import pt.iscte.guitoo.*;

public abstract class Grafico implements CompositeFigure {
	private final Point localizacao = new Point(100, 300);
	private List<Figure> figures = new ArrayList<Figure>();
	private int escala;

	@Override
	public Point getLocation() {
		return localizacao;
	}

	@Override
	public List<? extends Figure> getChildFigures() {
		return figures;
	}

	public void addFigure(Figure figure) {
		figures.add(figure);
	}

	public void setEscala(int escala) {
		this.escala = escala;
	}

//CRIAR EIXO DO Y 
	public void EixoY(int altura, int espaco) {
		for (int i = 0; i < altura + espaco; i += espaco)
			figures.add(new StaticText(i, -30, -i * escala));
		Retangulo eixo = new Retangulo(0, altura * escala + 10);
		eixo.move(-10, 0);
		figures.add(eixo);
	}

// CRIAR EIXO DO X
	public void EixoX(int tamanho, int altura) {
		Retangulo eixo = new Retangulo(tamanho + 10, altura);
		eixo.move(-10, 0);
		figures.add(eixo);
	}
}
