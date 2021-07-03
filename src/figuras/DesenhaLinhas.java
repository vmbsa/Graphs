package figuras;

import java.util.ArrayList;

import grafico.ConjuntoDados;
import grafico.Grafico;
import grafico.Tuplo;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StaticText;

public class DesenhaLinhas extends Grafico{
	private final int WIDTH = 20;
	private int valorMaximoX = 0;
	private int valorMaximoY = 0;
	private int escala;
	private ArrayList<Point> pontos = new ArrayList<Point>();
	
	public DesenhaLinhas(ConjuntoDados tuplos, int escala) {
		super();
		super.setEscala(escala);
		this.escala=escala;
		for( Tuplo tuplo : tuplos.getListaTuplos()) {
			if (tuplo.getValorY() > valorMaximoY)
				valorMaximoY = tuplo.getValorY();
			int i = super.getChildFigures().size();
			Circulo circulo = new Circulo ( (int)(0.5* WIDTH * this.escala), -tuplo.getValorY() * this.escala);
			circulo.move(i * WIDTH * this.escala, 0);
			circulo.setColor(tuplo.getCor());
			pontos.add(circulo.getLocation());
			addFigure(circulo);
			addFigure(new StaticText(tuplo.getValorX(), i * WIDTH * this.escala + WIDTH * this.escala / 2, 20));
		}
		valorMaximoX = (super.getChildFigures().size() * WIDTH * this.escala - WIDTH* this.escala);
		EixoY(valorMaximoY, 20);
		EixoX(valorMaximoX, 0);		
		for(int i=0; i!=pontos.size()-1; i++) {
			Linha linha = new Linha(pontos.get(i), pontos.get(i+1));
			addFigure(linha);
		}
	}
	
}
