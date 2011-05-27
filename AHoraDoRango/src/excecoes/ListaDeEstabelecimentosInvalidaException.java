package excecoes;

import java.util.List;

import ahoradorango.Estabelecimento;

public class ListaDeEstabelecimentosInvalidaException extends Exception
{
	private static final long serialVersionUID = 1L;
	private List<Estabelecimento> listaDeEstabelecimentos;
	
	public ListaDeEstabelecimentosInvalidaException(String mensagemDoErro, List<Estabelecimento> listaDeEstabelecimentos)
	{
		super(mensagemDoErro);
		
		this.listaDeEstabelecimentos = listaDeEstabelecimentos;
	}

	public List<Estabelecimento> getListaDeEstabelecimentos()
	{
		return listaDeEstabelecimentos;
	}
}
