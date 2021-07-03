package figuras;

import java.util.*;

import grafico.Tuplo;
import pt.iscte.guitoo.*;

public class Retangulo implements PolylineFigure{
	private List<Point> pontos;
	private Color cor;
	private Point localizacao;
	
	public Retangulo(int largura, int altura) {
		localizacao = Point.ORIGIN;
		pontos = new ArrayList<>(4);
		pontos.add(Point.ORIGIN);
		pontos.add(new Point(largura, 0));
		pontos.add(new Point(largura, -altura));
		pontos.add(new Point(0, -altura));
		cor=StandardColor.WHITE;
	}

	@Override
	public Point getLocation() {
		return localizacao;
	}

	@Override
	public List<Point> getPoints() {
		return Collections.unmodifiableList(pontos);
	}

	@Override
	public Color getFillColor() {
		return cor;
	}

	public void setColor(Color color) {
		this.cor = color;
	}

	public void move(int x, int y) {
		localizacao = localizacao.sum(x, y);
	}

	
	
	
	
	
	
	
	

}
