package excecoes;

/**
 * Uma excecao lancada quando um endereco invalido eh passado como argumento
 * @author Armstrong Mardilson da Silva Goes (goes.armstrong151@gmail.com)
 * @author Cinthia Sany Franca Xavier
 * @author Daniell Wagner Azevedo de Lima
 * @version 1.0
 */
public class EnderecoInvalidoException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param mensagemDoErro A mensagem do erro
	 */
	public EnderecoInvalidoException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
