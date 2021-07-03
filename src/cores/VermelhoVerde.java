package cores;

import grafico.Tuplo;
import pt.iscte.guitoo.StandardColor;

public class VermelhoVerde implements EsquemaCores{

	@Override
	public void validarCor(Tuplo tuplo) {
		if(tuplo.getValorY() < 50)
			tuplo.setCor(StandardColor.RED);
		else
			tuplo.setCor(StandardColor.GREEN);
	}
	
	

}
