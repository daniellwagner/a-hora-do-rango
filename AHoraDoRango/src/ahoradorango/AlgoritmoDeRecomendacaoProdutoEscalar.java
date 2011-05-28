package ahoradorango;

import java.util.ArrayList;
import java.util.HashMap;

import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeUsuariosInvalidaException;
import excecoes.MapeamentoUsuarioSemelhancaInvalidoException;
import excecoes.NumeroDeRecomendacoesInvalidoException;
import excecoes.UsuarioInvalidoException;

/**
 * Uma classe que representa o algoritmo de recomendacao que utiliza o produto escalar das opinioes 
 * dos usuarios
 * @author Armstrong Mardilson da Silva Goes, goes.armstrong151@gmail.com
 * @author Daniell Wagner Azevedo de Lima
 * @author Cinthia Sany Franca Xavier
 * @version 1.0
 */
public class AlgoritmoDeRecomendacaoProdutoEscalar 
{
	/**
	 * Calcula o produto escalar das opinioes de dois usuarios
	 * @param usuario1 O primeiro usuario
	 * @param usuario2 O segundo usuario
	 * @param estabelecimentos Uma lista com os estabelecimentos do sistema
	 * @return O produto escalar das opinioes dos dois usuarios passados como argumento
	 * @throws UsuarioInvalidoException Se pelo menos um dos usuarios for nulo
	 * @throws ListaDeEstabelecimentosInvalidaException Se estabelecimentos for igual a null
	 */
	private static int calculaProdutoEscalarOpinioes(Usuario usuario1, Usuario usuario2,
												ArrayList<Estabelecimento> estabelecimentos) 
												throws UsuarioInvalidoException, 
												ListaDeEstabelecimentosInvalidaException
	{
		if (usuario1 == null)
		{
			throw new UsuarioInvalidoException("Usuario 1 nulo.", usuario1);
		}
		
		if (usuario2 == null)
		{
			throw new UsuarioInvalidoException("Usuario 2 nulo.", usuario2);
		}
		
		if (estabelecimentos == null)
		{
			throw new ListaDeEstabelecimentosInvalidaException("Lista de estabelecimentos nula.", estabelecimentos);
		}
		
		// o produto escalar das opinioes dos dois usuarios
		int semelhanca = 0;
		
		// para cada estabelecimento
		for (Estabelecimento estabelecimento: estabelecimentos)
		{
			// adiciona o produto das duas opinioes ao produto escalar
			semelhanca += usuario1.getOpiniao(estabelecimento) * usuario2.getOpiniao(estabelecimento);
		}
		
		return semelhanca;
	}
	
	/**
	 * Calcula as semelhancas entre os usuarios do sistema
	 * @param usuarioBase O usuario sobre o qual vao ser calculadas as semelhancas
	 * @param usuarios A lista de usuarios do sistema
	 * @param estabelecimentos A lista de estabelecimentos do sistema
	 * @return Um mapeamento entre os usuarios do sistema e suas semelhancas 
	 * com o usuario considerado
	 * @throws UsuarioInvalidoException Se usuarioBase for igual a null ou se houver um nulo
	 * na lista de usuarios
	 * @throws ListaDeEstabelecimentosInvalidaException Se estabelecimentos for igual a null
	 * @throws ListaDeUsuariosInvalidaException  Se usuarios for igual a null
	 */
	private static HashMap<Usuario, Integer> determinaSemelhancas(Usuario usuarioBase, 
															ArrayList<Usuario> usuarios, ArrayList<Estabelecimento> estabelecimentos) 
															throws UsuarioInvalidoException, ListaDeEstabelecimentosInvalidaException, ListaDeUsuariosInvalidaException
	{
		if (usuarioBase == null)
		{
			throw new UsuarioInvalidoException("Usuario base nulo.", usuarioBase);
		}
		
		if (usuarios == null)
		{
			throw new ListaDeUsuariosInvalidaException("Lista de usuarios nula.", usuarios);
		}
		
		if (estabelecimentos == null)
		{
			throw new ListaDeEstabelecimentosInvalidaException("Lista de estabelecimentos nula.", estabelecimentos);
		}
		
		// o mapeamento entre usuarios e semelhancas
		HashMap<Usuario, Integer> semelhancas = new HashMap<Usuario, Integer>();
		
		// para cada usuario que nao seja o usuario considerado...
		for (Usuario usuario: usuarios)
		{
			if (!usuarioBase.equals(usuario))
			{
				// calcula a semelhanca e faz o mapeamento
				semelhancas.put(usuario, calculaProdutoEscalarOpinioes(usuarioBase, usuario, estabelecimentos));
			}
			
		}
		
		return semelhancas;
	}
	
	/**
	 * Acha o usuario de gosto mais semelhante ao usuario considerado
	 * @param semelhancas O mapeamento entre usuarios e semelhancas
	 * @return O usuario mais semelhante ou null se nao houver mais nenhum usuario disponivel
	 * @throws MapeamentoUsuarioSemelhancaInvalidoException 
	 */
	private static Usuario achaMaisSemelhante(HashMap<Usuario, Integer> semelhancas) throws MapeamentoUsuarioSemelhancaInvalidoException
	{
		Usuario maisSemelhante = null;
		int maiorSemelhanca = Integer.MIN_VALUE;
		
		if (semelhancas == null)
		{
			throw new MapeamentoUsuarioSemelhancaInvalidoException("Mapeamento usuario-semelhanca nulo.", semelhancas);
		}
		
		// para cada usuario do mapeamento...
		for (Usuario usuario: semelhancas.keySet())
		{
			// se a semelhanca for maior do que a maior semelhanca
			if (semelhancas.get(usuario) > maiorSemelhanca)
			{
				// esta eh agora a maior semelhanca
				maiorSemelhanca = semelhancas.get(usuario);
				// este eh o usuario mais semelhante
				maisSemelhante = usuario;
			}
		}
		
		// remove o usuario mais semelhante para 
		// que nas proximas consultas ele nao seja
		// considerado
		semelhancas.remove(maisSemelhante);
		
		return maisSemelhante;
	}
	
	/**
	 * Gera apenas uma recomendacao de cada vez
	 * @param usuarioRecebedor O usuario que vai receber a recomendacao
	 * @param usuarioOpinador O usuario que vai dar a recomendacao
	 * @param recomendacoes A lista das recomendacoes que vao ser dadas ao usuario
	 * @param estabelecimentos Os estabelecimentos do sistema
	 * @return Uma recomendacao ou null se nao for possivel dar mais nenhuma recomendacao
	 */
	private static Estabelecimento daRecomendacao(Usuario usuarioRecebedor, Usuario usuarioOpinador, 
													ArrayList<Estabelecimento> recomendacoes, 
													ArrayList<Estabelecimento> estabelecimentos)
	{
		int melhorOpiniao = Integer.MIN_VALUE;
		Estabelecimento estabelecimentoMelhorOpiniao = null;
	
		// para cada estabelecimento
		for (Estabelecimento estabelecimento: estabelecimentos)
		{
			// a recomendacao nao pode ser repetida
			if (!recomendacoes.contains(estabelecimento) &&
				// o usuario recebedor nao pode conhecer o estabelecimento
			    usuarioRecebedor.getOpiniao(estabelecimento) == 0 &&
			    // o usuario opinador precisa conhecer e gostar do estabelecimento
			    usuarioOpinador.getOpiniao(estabelecimento) > 0 && 
			    // a opiniao precisa ser a melhor
			    usuarioOpinador.getOpiniao(estabelecimento) > melhorOpiniao)
			{
				estabelecimentoMelhorOpiniao = estabelecimento;
			}
		}
		
		return estabelecimentoMelhorOpiniao;
	}
	
	/**
	 * 
	 * @param quantidadeRecomendacoes A quantidade (maxima) de recomendacoes que devem ser geradas
	 * @param usuario O usuario que vai receber as recomendacoes
	 * @param estabelecimentos Os estabelecimentos do sistema
	 * @param usuarios Os usuarios do sistema
	 * @return Uma lista de recomendacoes
	 * @throws UsuarioInvalidoException
	 * @throws NumeroDeRecomendacoesInvalidoException
	 * @throws ListaDeEstabelecimentosInvalidaException
	 * @throws ListaDeUsuariosInvalidaException
	 * @throws MapeamentoUsuarioSemelhancaInvalidoException
	 */
	public static ArrayList<Estabelecimento> geraRecomendacao(int quantidadeRecomendacoes, Usuario usuario, ArrayList<Estabelecimento> estabelecimentos,
																							ArrayList<Usuario> usuarios) throws UsuarioInvalidoException,
																														 NumeroDeRecomendacoesInvalidoException, 
																														 ListaDeEstabelecimentosInvalidaException, 
																														 ListaDeUsuariosInvalidaException, 
																														 MapeamentoUsuarioSemelhancaInvalidoException
	{
		if (quantidadeRecomendacoes < 0)
		{
			throw new NumeroDeRecomendacoesInvalidoException("Numero de recomendacoes negativo.", quantidadeRecomendacoes);
		}
		
		if (usuario == null)
		{
			throw new UsuarioInvalidoException("Usuario invalido.", usuario);
		}
		
		if (estabelecimentos == null)
		{
			throw new ListaDeEstabelecimentosInvalidaException("Lista de estabelecimentos nula.", estabelecimentos);
		}
		
		if (usuarios == null)
		{
			throw new ListaDeUsuariosInvalidaException("Lista de usuarios nula.", usuarios);
		}
		
		if (quantidadeRecomendacoes > estabelecimentos.size())
		{
			throw new NumeroDeRecomendacoesInvalidoException("Numero de recomendacoes maior do que o numero de estabelecimentos",
													quantidadeRecomendacoes);
		}
		
		// o mapeamento de semelhancas
		HashMap<Usuario, Integer> semelhancas = determinaSemelhancas(usuario, usuarios, estabelecimentos);
		Usuario maisSemelhante = null;
		// o mais novo estabelecimento da recomendacao
		Estabelecimento novoEstabelecimentoRecomendacao = null;
		// a lista de recomendacoes
		ArrayList<Estabelecimento> recomendacoes = new ArrayList<Estabelecimento>();
		
		maisSemelhante = achaMaisSemelhante(semelhancas);
		
		// enquanto for necessario adicionar recomendacoes e
		// ainda houver usuarios disponiveis
		while (quantidadeRecomendacoes > 0 && maisSemelhante != null)
		{
			// recebe uma recomendacao
			novoEstabelecimentoRecomendacao = daRecomendacao(usuario, maisSemelhante, recomendacoes, estabelecimentos);
			
			// se a recomendacao for nula, entao o usuario que da as recomendacoes nao pode dar mais nenhuma recomendacao...
			if (novoEstabelecimentoRecomendacao == null)
			{
				// recebe o proximo usuario mais semelhante
				maisSemelhante = achaMaisSemelhante(semelhancas);
			}
			// caso contrario...
			else
			{
				// adiciona a nova recomendacao a lista de recomendacoes 
				recomendacoes.add(novoEstabelecimentoRecomendacao);
				quantidadeRecomendacoes--;
			}
		}
		
		return recomendacoes;
	}
}
