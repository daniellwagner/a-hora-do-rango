package excecoes;

import ahoradorango.Estabelecimento;

public class EstabelecimentoInvalidoException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private Estabelecimento estabelecimentoErro;
	
	public EstabelecimentoInvalidoException(String mensagemDoErro, Estabelecimento estabelecimentoErro)
	{
		super(mensagemDoErro);
		
		this.estabelecimentoErro = estabelecimentoErro;
	}

	public Estabelecimento getEstabelecimentoErro()
	{
		return estabelecimentoErro;
	}
}
