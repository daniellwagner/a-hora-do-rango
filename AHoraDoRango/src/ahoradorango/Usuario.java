package ahoradorango;

import java.util.ArrayList;
import java.util.List;

import excecoes.NomeInvalidoException;
import excecoes.PerfilInvalidoException;

/**
 * Uma classe que representa um usuario do sistema de recomendacoes
 * @author Armstrong Mardilson da Silva Goes (goes.armstrong151@gmail.com)
 * @author Cinthia Sany Franca Xavier
 * @author Daniell Wagner Azevedo de Lima
 * @version 1.0
 */
public class Usuario
{
	
	public Usuario() {
		this.perfis = new ArrayList<Perfil>();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	/**
	 * O nome do usuario
	 */
	private String nome;
	/**
	 * O perfil do usuario
	 */
	private List<Perfil> perfis;
	
	/**
	 * @param nome O nome do usuario
	 * @param perfil O perfil do usuario
	 * @throws NomeInvalidoException Se nome for igual a null
	 * @throws PerfilInvalidoException Se perfil for igual a null
	 */
	public Usuario(String nome, Perfil perfil) throws NomeInvalidoException, PerfilInvalidoException
	{
		if (nome == null)
		{
			throw new NomeInvalidoException("Nome nulo.");
		}
		
		if (perfil == null)
		{
			throw new PerfilInvalidoException("Perfil nulo.");
		}
		
		this.nome = nome;
	}

	/**
	 * Devolve o perfil do usuario
	 * @return O perfil
	 */
	public List<Perfil> getPerfis()
	{
		return perfis;
	}

	/**
	 * Devolve o nome do usuario
	 * @return O nome
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Altera a opiniao do usuario sobre um determinado estabelecimento
	 * @param estabelecimento O estabelecimento
	 * @param novaOpiniao A nova opiniao
	 * @throws EstabelecimentoInvalidoException Se estabelecimento for igual a null ou nao estiver no mapeamento 
	 * entre estabelecimentos e opinioes do perfil
	 * @throws OpiniaoInvalidaException Se novaOpiniao for menor do que o minimo permitido ou maior do que o
	 * maximo permitido (veja Perfil)
	 * @throws PerfilNaoAlteravelException Se o perfil do usuario nao puder ser alterado
	 */
	/*
	public void alterarOpiniao(Estabelecimento estabelecimento, Integer novaOpiniao) 
		throws EstabelecimentoInvalidoException, OpiniaoInvalidaException, PerfilNaoAlteravelException {
		
		for (Perfil perfil : perfis) {
			perfil.setOpiniao(estabelecimento, novaOpiniao);
		}
	}
	*/
	
	/**
	 * Informa se o usuario pode ser alterado
	 * @return A informacao
	 */
	/*
	public boolean ehUsuarioAlteravel()
	{
		for (Perfil perfil : perfis) {
			if (perfil.getPerfilAlteravel() == Alteravel.SIM)
				return true;
		}
		return false;
	}
	*/
	
	/**
	 * Altera a permissao de alteracao do usuario
	 * @param novaPermissao A nova permissao
	 * @throws PermissaoDeAlteracaoInvalidaException Se novaPermissao for igual a null
	 */
	/*
	public void mudaPermissaoAlteracao(Alteravel novaPermissao) throws PermissaoDeAlteracaoInvalidaException
	{
		for (Perfil perfil : perfis) {
			perfil.setPerfilAlteravel(novaPermissao);
		}
	}
	*/
	
	/**
	 * Devolve a opiniao do usuario sobre um estabelecimento
	 * @param estabelecimento O estabelecimento
	 * @return A opiniao
	 */
	/*
	public int getOpiniao(Estabelecimento estabelecimento)
	{
		return perfil.getOpiniao(estabelecimento);
	}
	*/
}
