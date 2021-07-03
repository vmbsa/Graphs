package figuras;

import java.util.*;

import grafico.*;
import pt.iscte.guitoo.*;

public class DesenhaHistograma extends Grafico {
	private final int WIDTH = 20;
	private int valorMaximo = 0;
	private int escala;

	public DesenhaHistograma(ConjuntoDados tuplos, int escala) {
		super();
		super.setEscala(escala);
		this.escala = escala;
		for (Tuplo tuplo : tuplos.getListaTuplos()) {
			int i = super.getChildFigures().size();
			Retangulo novoRetangulo = new Retangulo(WIDTH * this.escala, tuplo.getValorY() * this.escala);
			novoRetangulo.move(i * WIDTH * this.escala, 0);
			addFigure(novoRetangulo);
			novoRetangulo.setColor(tuplo.getCor());
			addFigure(new StaticText(tuplo.getValorX(), i * WIDTH * this.escala + WIDTH * this.escala / 2,
						WIDTH * this.escala - 10));
			if (tuplo.getValorY() > valorMaximo)
				valorMaximo = tuplo.getValorY();
		}
		EixoY(valorMaximo, 20);
		
	}

}
