package figuras;

import pt.iscte.guitoo.*;

public class Circulo implements EllipseFigure {
	private int diametro = 7;
	private Point localizacao;
	private Color cor;

	public Circulo(int x, int y) {
		localizacao = new Point(x, y);
		this.cor = StandardColor.WHITE;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return localizacao;
	}

	@Override
	public Color getFillColor() {
		return this.cor;
	}

	public void setColor(Color cor) {
		this.cor = cor;
	}

	@Override
	public int getHeight() {
		return diametro;
	}

	@Override
	public int getWidth() {
		return diametro;
	}

	public void move(int x, int y) {
		localizacao = localizacao.sum(x, y);
	}
}
