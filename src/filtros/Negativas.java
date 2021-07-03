package filtros;

import grafico.*;

public class Negativas implements Filtro{

	@Override
	public boolean validarFiltro(Tuplo tuplo) {
		if(tuplo.getValorX().equals("NA") || tuplo.getValorX().equals("RE") || Integer.parseInt(tuplo.getValorX()) <= 9)
			return true;
		return false;
	}

}
