package ahoradorango;

import excecoes.EnderecoInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.TipoDeAlmocoInvalidoException;

public class Estabelecimento {
	private String nome;
	private String endereco;
	private TipoDeAlmoco tipoDeAlmocoServido;

	public Estabelecimento(String nome, String endereco, TipoDeAlmoco tipoDeAlmocoServido) 
		throws NomeInvalidoException, EnderecoInvalidoException, TipoDeAlmocoInvalidoException {
	
		if (nome == null) {
			throw new NomeInvalidoException("Nome nulo.");
		}

		if (nome.trim().equals("")) {
			throw new NomeInvalidoException("Nome contem somente espacos.");
		}

		if (nome.equals("")) {
			throw new NomeInvalidoException("Nome vazio.");
		}

		if (endereco == null) {
			throw new EnderecoInvalidoException("Endereco nulo.");
		}

		if (endereco.trim().equals("")) {
			throw new EnderecoInvalidoException(
					"Endereco contem somente espacos.");
		}

		if (endereco.equals("")) {
			throw new EnderecoInvalidoException("Endereco vazio.");
		}

		if (tipoDeAlmocoServido == null) {
			throw new TipoDeAlmocoInvalidoException("Tipo de almoco nulo.");
		}

		this.nome = nome;
		this.endereco = endereco;
		this.tipoDeAlmocoServido = tipoDeAlmocoServido;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public TipoDeAlmoco getTipoDeAlmocoServido() {
		return tipoDeAlmocoServido;
	}

	@Override
	public String toString() {
		String stringEstabelecimento = "";

		stringEstabelecimento += "nome:           " + nome + "\n";
		stringEstabelecimento += "endereco:       " + endereco + "\n";
		stringEstabelecimento += "tipo de almoco: "
				+ tipoDeAlmocoServido.getNomeTipoDeAlmoco();

		return stringEstabelecimento;
	}

	@Override
	public boolean equals(Object arg0) throws ClassCastException {
		boolean iguais = false;

		if (arg0 instanceof Estabelecimento) {
			Estabelecimento novo = (Estabelecimento) arg0;

			iguais = this.getNome().equals(novo.getNome())
					&& this.getEndereco().equals(novo.getEndereco())
					&& this.getTipoDeAlmocoServido() == novo
							.getTipoDeAlmocoServido();
		} else {
			throw new ClassCastException();
		}

		return iguais;
	}
}
