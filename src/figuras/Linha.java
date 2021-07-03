package figuras;

import java.util.*;
import pt.iscte.guitoo.*;

public class Linha implements PolylineFigure{
	private List<Point> pontos;
	private Point localizacao;
	
	public Linha(Point inicio, Point fim) {
		localizacao = Point.ORIGIN;
		pontos = new ArrayList<Point>();
		pontos.add(inicio);
		pontos.add(fim);
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return localizacao;
	}

	@Override
	public List<? extends Location> getPoints() {
		// TODO Auto-generated method stub
		return pontos;
	}

}
