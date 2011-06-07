package ahoradorango;

import java.util.Iterator;
import java.util.Set;

public class EstabelecimentoOpinioes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Perfil perfil = new Perfil();
		Set <Estabelecimento> chaves = perfil.getEstabelecimentosOpinioes().keySet();
		for (Estabelecimento chave: chaves ){
			if (chave != null){
				System.out.println(chave);
				System.out.println(perfil.getEstabelecimentosOpinioes().get(chave));
			}
		}
		

	}

}
