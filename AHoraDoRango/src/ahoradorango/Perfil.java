package ahoradorango;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import excecoes.EstabelecimentoInvalidoException;
import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeOpinioesEDeEstabelecimentosIncompativeisException;
import excecoes.ListaDeOpinioesInvalidaException;
import excecoes.MomentoInvalidoDaCriacaoDoPerfilException;
import excecoes.OpiniaoInvalidaException;
import excecoes.PerfilNaoAlteravelException;
import excecoes.PermissaoDeAlteracaoInvalidaException;

/**
 * Uma classe que representa o perfil de um usuario
 * 
 * @author Armstrong Mardilson da Silva Goes (goes.armstrong151@gmail.com)
 * @author Cinthia Sany Franca Xavier
 * @author Daniell Wagner Azevedo de Lima
 * @version 1.0
 */
public class Perfil {
	/**
	 * Um mapeamento entre os estabelecimentos e as opinioes do usuario
	 */
	private Map<Estabelecimento, Integer> estabelecimentosOpinioes;
	/**
	 * O momento da criacao do perfil (data e hora)
	 */
	private GregorianCalendar momentoCriacaoDoPerfil;
	/**
	 * O menor valor possivel de uma opiniao
	 */
	public static final int MENOR_OPINIAO_POSSIVEL = -5;
	/**
	 * O maior valor possivel de uma opiniao
	 */
	public static final int MAIOR_OPINIAO_POSSIVEL = 5;
	/**
	 * Um indicador da permissao de alteracao do perfil
	 */
	private Alteravel perfilAlteravel;

	/**
	 * O construtor inicializa perfilAlteravel como Alteravel.NAO e considera
	 * que a opiniao sobre o i-esimo estabelecimento esta na i-esima posicao do
	 * array das opinioes.
	 * 
	 * @param opinioes
	 *            As opinioes do usuario
	 * @param estabelecimentos
	 *            A lista de estabelecimentos considerada
	 * @param momentoCriacaoDoPerfil
	 *            O momento da criacao do perfil (data e hora)
	 * @throws ListaDeOpinioesInvalidaException
	 *             Se opinioes for igual a null ou estiver vazia
	 * @throws OpiniaoInvalidaException
	 *             Se pelo menos um dos valores contidos em opinioes nao for
	 *             valido (menor do que o minimo permitido ou maior do que o
	 *             maximo permitido)
	 * @throws ListaDeEstabelecimentosInvalidaException
	 *             Se estabelecimentos for igual a null ou estiver vazia
	 * @throws ListaDeOpinioesEDeEstabelecimentosIncompativeisException
	 *             Se o numero de opinioes for diferente do numero de
	 *             estabelecimentos
	 * @throws MomentoInvalidoDaCriacaoDoPerfilException
	 *             Se momentoCriacaoDoPerfil for igual a null
	 */
	public Perfil(ArrayList<Integer> opinioes,
			ArrayList<Estabelecimento> estabelecimentos,
			GregorianCalendar momentoCriacaoDoPerfil)
			throws ListaDeOpinioesInvalidaException, OpiniaoInvalidaException,
			ListaDeEstabelecimentosInvalidaException,
			ListaDeOpinioesEDeEstabelecimentosIncompativeisException,
			MomentoInvalidoDaCriacaoDoPerfilException {
		if (opinioes == null) {
			throw new ListaDeOpinioesInvalidaException(
					"Lista de opinioes nula.");
		}

		if (opinioes.size() == 0) {
			throw new ListaDeOpinioesInvalidaException(
					"Lista de opinioes vazia.");
		}

		if (estabelecimentos == null) {
			throw new ListaDeEstabelecimentosInvalidaException(
					"Lista de estabelecimentos nula.", null);
		}

		if (estabelecimentos.size() == 0) {
			throw new ListaDeEstabelecimentosInvalidaException(
					"Lista de estabelecimentos vazia.", estabelecimentos);
		}

		if (opinioes.size() != estabelecimentos.size()) {
			throw new ListaDeOpinioesEDeEstabelecimentosIncompativeisException(
					"Numero de opinioes diferente do numero de estabelecimentos.");
		}

		if (momentoCriacaoDoPerfil == null) {
			throw new MomentoInvalidoDaCriacaoDoPerfilException(
					"Momento da criacao do perfil nulo.");
		}

		for (Integer opiniao : opinioes) {
			if (opiniao < MENOR_OPINIAO_POSSIVEL) {
				throw new OpiniaoInvalidaException(
						"A lista de opinioes passada como argumento continha um"
								+ " valor de opiniao menor do que o permitido.");
			}

			if (opiniao > MAIOR_OPINIAO_POSSIVEL) {
				throw new OpiniaoInvalidaException(
						"A lista de opinioes passada como argumento continha um"
								+ " valor de opiniao maior do que o permitido.");
			}
		}

		estabelecimentosOpinioes = new HashMap<Estabelecimento, Integer>();

		for (int iter = 0; iter < opinioes.size(); iter++) {
			estabelecimentosOpinioes.put(estabelecimentos.get(iter),
					opinioes.get(iter));
		}

		this.momentoCriacaoDoPerfil = momentoCriacaoDoPerfil;

		perfilAlteravel = Alteravel.NAO;
	}
	
	public Perfil() {
	}

	public void setEstabelecimentosOpinioes(Map<Estabelecimento, Integer> estabelecimentosOpinioes) {
		this.estabelecimentosOpinioes = estabelecimentosOpinioes;
	}

	public void setMomentoCriacaoDoPerfil(GregorianCalendar momentoCriacaoDoPerfil) {
		this.momentoCriacaoDoPerfil = momentoCriacaoDoPerfil;
	}

	/**
	 * Devolve o mapeamento entre estabelecimentos e opinioes
	 * 
	 * @return O mapeamento
	 */
	public Map<Estabelecimento, Integer> getEstabelecimentosOpinioes() {
		return estabelecimentosOpinioes;
	}

	/**
	 * Devolve a opiniao sobre um determinado estabelecimento
	 * 
	 * @param estabelecimento
	 *            O estabelecimento
	 * @return A opiniao
	 */
	public int getOpiniao(Estabelecimento estabelecimento) {
		return estabelecimentosOpinioes.get(estabelecimento);
	}

	/**
	 * Devolve o momento em que foi criado o perfil (data e hora)
	 * 
	 * @return O momento
	 */
	public GregorianCalendar getMomentoCriacaoDoPerfil() {
		return momentoCriacaoDoPerfil;
	}

	/**
	 * Devolve o indicador da permissao de alteracao do perfil
	 * 
	 * @return O indicador
	 */
	public Alteravel getPerfilAlteravel() {
		return perfilAlteravel;
	}

	/**
	 * Muda o valor da permissao de alteracao do perfil
	 * 
	 * @param perfilAlteravel
	 *            O novo valor da permissao
	 * @throws PermissaoDeAlteracaoInvalidaException
	 *             Se perfilAlteravel for igual a null
	 */
	public void setPerfilAlteravel(Alteravel perfilAlteravel)
			throws PermissaoDeAlteracaoInvalidaException {
		if (perfilAlteravel == null) {
			throw new PermissaoDeAlteracaoInvalidaException(
					"Permissao de alteracao nula.");
		}

		this.perfilAlteravel = perfilAlteravel;
	}

	/**
	 * Altera a opiniao sobre um determinado estabelecimento
	 * 
	 * @param estabelecimento
	 *            O estabelecimento
	 * @param novaOpiniao
	 *            A novaOpiniao sobre o dado estabelecimento
	 * @throws EstabelecimentoInvalidoException
	 *             Se estabelecimento for igual a null ou nao estiver no
	 *             mapeamento entre estabelecimentos e opinioes
	 * @throws OpiniaoInvalidaException
	 *             Se novaOpiniao for menor do que o minimo permitido ou maior
	 *             do que o maximo permitido
	 * @throws PerfilNaoAlteravelException
	 *             Se o perfil nao puder ser alterado
	 */
	public void setOpiniao(Estabelecimento estabelecimento, Integer novaOpiniao)
			throws EstabelecimentoInvalidoException, OpiniaoInvalidaException,
			PerfilNaoAlteravelException {
		if (perfilAlteravel == Alteravel.NAO) {
			throw new PerfilNaoAlteravelException("Perfil nao alteravel.");
		}

		if (estabelecimento == null) {
			throw new EstabelecimentoInvalidoException("Estabelecimento nulo.",
					estabelecimento);
		}

		if (!estabelecimentosOpinioes.containsKey(estabelecimento)) {
			throw new EstabelecimentoInvalidoException(
				"Estabelecimento nao contido na lista de estabelecimentos do perfil.",
				estabelecimento);
		}

		if (novaOpiniao < MENOR_OPINIAO_POSSIVEL) {
			throw new OpiniaoInvalidaException(
					"Valor de opiniao menor do que o permitido.");
		}

		if (novaOpiniao > MAIOR_OPINIAO_POSSIVEL) {
			throw new OpiniaoInvalidaException(
					"Valor de opiniao maior do que o permitido.");
		}

		estabelecimentosOpinioes.put(estabelecimento, novaOpiniao);
	}
}
