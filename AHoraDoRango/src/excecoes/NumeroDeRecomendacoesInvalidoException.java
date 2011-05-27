package excecoes;

public class NumeroDeRecomendacoesInvalidoException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private int numeroDeRecomendacoes;
	
	public NumeroDeRecomendacoesInvalidoException(String mensagemDoErro, int numeroDeRecomendacoes)
	{
		super(mensagemDoErro + "\nnumero: " + numeroDeRecomendacoes);
		
		this.numeroDeRecomendacoes = numeroDeRecomendacoes;
	}
	
	public int getNumeroDeRecomendacoes()
	{
		return numeroDeRecomendacoes;
	}
}
