package ahoradorango;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeUsuariosInvalidaException;
import excecoes.NumeroDeRecomendacoesInvalidoException;

public class AlgoritmoDeRecomendacaoPopularidadeGlobal
{
	/**
	 * Retorna um mapa com o estabelecimento e a sua popularidade
	 * @param estabelecimentos
	 * @param usuarios
	 * @return
	 */
	private HashMap<String, Integer> popularidades;
	
	public HashMap<String, Integer> determinaPopularidades(LeitorOpinioes leitorOpinioes)
	{
		popularidades = new HashMap<String, Integer>();
		
		HashMap<String, Integer> estabelecimentosOpinioes = new HashMap<String, Integer>();
		Object[][] tabelaPerfis = leitorOpinioes.getTableOpinioes();
		
		 
		for (int linhas = 0; linhas < tabelaPerfis.length; linhas++){
			String estabelecimentos = (String) tabelaPerfis[linhas][2];
			Object opinioes = tabelaPerfis[linhas][3];
			estabelecimentosOpinioes.put(estabelecimentos, opinioes);
		}
		Set<String> chaves = estabelecimentosOpinioes.keySet();
		int somaOpinioes = 0;
		for (String chave: chaves){
			for (String chaveaux: chaves){
				if (chave.equals(chaveaux)){
					somaOpinioes = somaOpinioes + estabelecimentosOpinioes.get(chave);
					popularidades.put(chave, somaOpinioes);
				}
				
			}
		}
	
		
		return popularidades;
	}
	
	public void iteraPopularidades(){
		
		Set<String> chaves = popularidades.keySet();
		
		for(String chave: chaves){
			System.out.println("Chave  " + chave + "Valor  " + popularidades.get(chave) );
		}
		
	}
	
	
	/**
	 * Retorna os estabelecimentos mais populares
	 * @param quantidadeRecomendacoes
	 * @param popularidades
	 * @return
	 *//*
	private static ArrayList<Estabelecimento> determinaMaisPopulares(int quantidadeRecomendacoes, HashMap<String, Integer> popularidades)
	{
		ArrayList<Estabelecimento> maisPopulares = new ArrayList<Estabelecimento>();
		int maiorPopularidade = Integer.MIN_VALUE;
		String maisPopular = null;
		
		for (; quantidadeRecomendacoes > 0; quantidadeRecomendacoes--)
		{
			for (String estabelecimento: popularidades.keySet())
			{
				if (popularidades.get(estabelecimento) > maiorPopularidade)
				{
					maiorPopularidade = popularidades.get(estabelecimento);
					maisPopular = estabelecimento;
				}
			}
			
			maisPopulares.add(maisPopular);
			popularidades.remove(maisPopular);
			maiorPopularidade = Integer.MIN_VALUE;
		}
		
		return maisPopulares;
	
	}
*/	
	/**
	 * Gera a recomendacao para o usuario
	 * @param quantidadeRecomendacoes
	 * @param estabelecimentos
	 * @param usuarios
	 * @param leitorOpinioes 
	 * @return
	 * @throws NumeroDeRecomendacoesInvalidoException
	 * @throws ListaDeEstabelecimentosInvalidaException
	 * @throws ListaDeUsuariosInvalidaException
	 *//*
	public static ArrayList<Estabelecimento> geraRecomendacao(int quantidadeRecomendacoes, 
											ArrayList<Estabelecimento> estabelecimentos,
											ArrayList<Usuario> usuarios, LeitorOpinioes leitorOpinioes) throws NumeroDeRecomendacoesInvalidoException, 
																		 ListaDeEstabelecimentosInvalidaException, 
																		 ListaDeUsuariosInvalidaException
	{
		if (estabelecimentos == null)
		{
			throw new ListaDeEstabelecimentosInvalidaException("Lista de estabelecimentos nula.", estabelecimentos);
		}
		
		if (usuarios == null)
		{
			throw new ListaDeUsuariosInvalidaException("Lista de usuarios nula.", usuarios);
		}
		
		if (estabelecimentos.size() == 0)
		{
			throw new ListaDeEstabelecimentosInvalidaException("Lista de estabelecimentos vazia.", estabelecimentos);
		}
		
		if (usuarios.size() == 0)
		{
			throw new ListaDeUsuariosInvalidaException("Lista de usuarios vazia.", usuarios);
		}
		
		if (quantidadeRecomendacoes < 0)
		{
			throw new NumeroDeRecomendacoesInvalidoException("Numero de recomendacoes negativo.", quantidadeRecomendacoes);
		}
		
		if (quantidadeRecomendacoes > estabelecimentos.size())
		{
			throw new NumeroDeRecomendacoesInvalidoException("Numero de recomendacoes maior do que a quantidade de estabelecimentos.", 
					quantidadeRecomendacoes);
		}
		
		
		HashMap<String, Integer> popularidades = determinaPopularidades(leitorOpinioes);
		
		return determinaMaisPopulares(quantidadeRecomendacoes, popularidades);
*/	}

