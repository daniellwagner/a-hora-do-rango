package ahoradorango;

import java.util.ArrayList;
import java.util.HashMap;

import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeUsuariosInvalidaException;
import excecoes.NumeroDeRecomendacoesInvalidoException;

public class AlgoritmoDeRecomendacaoPopularidadeGlobal {
	private static HashMap<Estabelecimento, Integer> determinaPopularidades(
			ArrayList<Estabelecimento> estabelecimentos,
			ArrayList<Usuario> usuarios) {
		HashMap<Estabelecimento, Integer> popularidades = new HashMap<Estabelecimento, Integer>();
		int popularidade = 0;

		for (Estabelecimento estabelecimento : estabelecimentos) {
			for (Usuario usuario : usuarios) {
				popularidade += usuario.getOpiniao(estabelecimento);
			}

			popularidades.put(estabelecimento, popularidade);

			popularidade = 0;
		}

		return popularidades;
	}

	private static ArrayList<Estabelecimento> determinaMaisPopulares(
			int quantidadeRecomendacoes,
			HashMap<Estabelecimento, Integer> popularidades) {
		ArrayList<Estabelecimento> maisPopulares = new ArrayList<Estabelecimento>();
		int maiorPopularidade = Integer.MIN_VALUE;
		Estabelecimento maisPopular = null;

		for (; quantidadeRecomendacoes > 0; quantidadeRecomendacoes--) {
			for (Estabelecimento estabelecimento : popularidades.keySet()) {
				if (popularidades.get(estabelecimento) > maiorPopularidade) {
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

	public static ArrayList<Estabelecimento> geraRecomendacao(
			int quantidadeRecomendacoes,
			ArrayList<Estabelecimento> estabelecimentos,
			ArrayList<Usuario> usuarios)
			throws NumeroDeRecomendacoesInvalidoException,
			ListaDeEstabelecimentosInvalidaException,
			ListaDeUsuariosInvalidaException {
		if (estabelecimentos == null) {
			throw new ListaDeEstabelecimentosInvalidaException(
					"Lista de estabelecimentos nula.", estabelecimentos);
		}

		if (usuarios == null) {
			throw new ListaDeUsuariosInvalidaException(
					"Lista de usuarios nula.", usuarios);
		}

		if (estabelecimentos.size() == 0) {
			throw new ListaDeEstabelecimentosInvalidaException(
					"Lista de estabelecimentos vazia.", estabelecimentos);
		}

		if (usuarios.size() == 0) {
			throw new ListaDeUsuariosInvalidaException(
					"Lista de usuarios vazia.", usuarios);
		}

		if (quantidadeRecomendacoes < 0) {
			throw new NumeroDeRecomendacoesInvalidoException(
					"Numero de recomendacoes negativo.",
					quantidadeRecomendacoes);
		}

		if (quantidadeRecomendacoes > estabelecimentos.size()) {
			throw new NumeroDeRecomendacoesInvalidoException(
					"Numero de recomendacoes maior do que a quantidade de estabelecimentos.",
					quantidadeRecomendacoes);
		}

		HashMap<Estabelecimento, Integer> popularidades = determinaPopularidades(
				estabelecimentos, usuarios);

		return determinaMaisPopulares(quantidadeRecomendacoes, popularidades);
	}
}
