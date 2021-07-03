package figuras;

import java.util.ArrayList;
import java.util.List;

import grafico.*;
import pt.iscte.guitoo.*;

public class DesenhaDispersao extends Grafico{
	private int valorMaximoX = 0;
	private int valorMaximoY = 0;
	private int escala;
	
	public DesenhaDispersao(ConjuntoDados tuplos, int escala) {
		super();
		super.setEscala(escala);
		this.escala=escala;
		for( Tuplo tuplo : tuplos.getListaTuplos()) {
			if (tuplo.getValorY() > valorMaximoY)
				valorMaximoY = tuplo.getValorY();
			if (Integer.parseInt(tuplo.getValorX()) > valorMaximoX)
				valorMaximoX = Integer.parseInt(tuplo.getValorX());
			Circulo circulo = new Circulo (Integer.parseInt(tuplo.getValorX())*escala, -tuplo.getValorY()*escala);
			circulo.setColor(tuplo.getCor());
			addFigure(circulo);
			
			
		}
		EixoY(valorMaximoY, 20);
		EixoX(valorMaximoX*escala, 0);
		for (int intervalo = 0; intervalo < valorMaximoX; intervalo += 10)
			addFigure(new StaticText(intervalo, intervalo * this.escala + this.escala / 2,
				20 ));
	}

}
