package filtros;

import grafico.Tuplo;

public class NotaFinal implements Filtro{

	@Override
	public boolean validarFiltro(Tuplo tuplo) {
		if(tuplo.getValorY() < 50)
			return true;
		return false;
	}
	

}
