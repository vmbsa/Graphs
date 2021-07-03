package filtros;

import grafico.Tuplo;

public class Assiduidade implements Filtro{

	@Override
	public boolean validarFiltro(Tuplo tuplo) {
		if(Integer.parseInt(tuplo.getValorX()) < 20)
			return true;
		return false;
	}
	
}