package cores;

import grafico.Tuplo;
import pt.iscte.guitoo.StandardColor;

public class Amarelo implements EsquemaCores{

	@Override
	public void validarCor(Tuplo tuplo) {
		if(Integer.parseInt(tuplo.getValorX()) < 50) {
			tuplo.setCor(StandardColor.YELLOW);}
		else
			tuplo.setCor(StandardColor.WHITE);
	}

}
