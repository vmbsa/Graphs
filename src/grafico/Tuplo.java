package grafico;

import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.StandardColor;

public class Tuplo {
	private String valorx;
	private int valory;
	private Color cor;
	
	public Tuplo(String valorx, int valory) {
		this.valorx=valorx;
		this.valory=valory;
		cor=StandardColor.WHITE;
	}

	public String getValorX() {
		return valorx;
	}

	public int getValorY() {
		return valory;
	}

	public Color getCor() {
		return this.cor;
	}
	
	public void setCor(Color color) {
		this.cor=color;
	}
	
	

}
