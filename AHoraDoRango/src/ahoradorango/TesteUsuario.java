package ahoradorango;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import excecoes.EnderecoInvalidoException;
import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeOpinioesEDeEstabelecimentosIncompativeisException;
import excecoes.ListaDeOpinioesInvalidaException;
import excecoes.MomentoInvalidoDaCriacaoDoPerfilException;
import excecoes.NomeInvalidoException;
import excecoes.OpiniaoInvalidaException;
import excecoes.PerfilInvalidoException;
import excecoes.TipoDeAlmocoInvalidoException;

public class TesteUsuario {
	
	 
	/**
	 * @param args
	 * @throws TipoDeAlmocoInvalidoException 
	 * @throws EnderecoInvalidoException 
	 * @throws NomeInvalidoException 
	 * @throws MomentoInvalidoDaCriacaoDoPerfilException 
	 * @throws ListaDeOpinioesEDeEstabelecimentosIncompativeisException 
	 * @throws ListaDeEstabelecimentosInvalidaException 
	 * @throws OpiniaoInvalidaException 
	 * @throws ListaDeOpinioesInvalidaException 
	 * @throws PerfilInvalidoException 
	 */
	
	
	public static void main(String[] args) throws NomeInvalidoException, EnderecoInvalidoException, TipoDeAlmocoInvalidoException, ListaDeOpinioesInvalidaException, OpiniaoInvalidaException, ListaDeEstabelecimentosInvalidaException, ListaDeOpinioesEDeEstabelecimentosIncompativeisException, MomentoInvalidoDaCriacaoDoPerfilException, PerfilInvalidoException {
		Estabelecimento estabelecimento = new Estabelecimento("Bar de juliao", "Cova da onca", TipoDeAlmoco.A_LA_CARTE);
		ArrayList<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
		ArrayList<Integer> opinioes = new ArrayList<Integer>();
		estabelecimentos.add(estabelecimento);
		opinioes.add(3);
		GregorianCalendar momentoCriacao = new GregorianCalendar(1999, 12, 12);
		
		Perfil perfil = new Perfil(opinioes, estabelecimentos, momentoCriacao);
		Usuario usuario = new Usuario("joao", perfil);
		usuario.getNome();
		estabelecimento.getNome();
		estabelecimento.getEndereco();
		estabelecimento.getTipoDeAlmocoServido();
		

	}

}
