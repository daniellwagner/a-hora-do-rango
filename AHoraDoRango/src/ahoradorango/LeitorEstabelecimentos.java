package ahoradorango;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import excecoes.EnderecoInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.TipoDeAlmocoInvalidoException;

public class LeitorEstabelecimentos {
	
	private File arquivoEstabelecimentos;
	private Map<String, Estabelecimento> estabelecimentos;
	private List<String> linhas;
	
	public LeitorEstabelecimentos(File arquivo) throws IOException, 
		NomeInvalidoException, EnderecoInvalidoException, TipoDeAlmocoInvalidoException {
		
		this.arquivoEstabelecimentos = arquivo;
		this.estabelecimentos = new HashMap<String, Estabelecimento>();
		this.linhas = new ArrayList<String>();
		this.readFile();
	}

	public File getArquivoEstabelecimentos() {
		return arquivoEstabelecimentos;
	}

	public void setArquivoEstabelecimentos(File arquivoEstabelecimentos) {
		this.arquivoEstabelecimentos = arquivoEstabelecimentos;
	}

	public List<String> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<String> linhas) {
		this.linhas = linhas;
	}

	public Map<String, Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}
	
	public Object[] getArrayEstabelecimentos(){
		Set<String> chaves = estabelecimentos.keySet();
		Object[] arrayEstabelecimentos = chaves.toArray();
		return arrayEstabelecimentos;
	}

	private void readFile() throws IOException, 
		NomeInvalidoException, EnderecoInvalidoException, TipoDeAlmocoInvalidoException {
		
		String line = null;

		BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivoEstabelecimentos));
		while ((line = bufferedReader.readLine()) != null) {
			linhas.add(line);
		}

		bufferedReader.close();
		this.readEstabelecimentos();
	}
	
	public void readEstabelecimentos() throws NomeInvalidoException, 
		EnderecoInvalidoException, TipoDeAlmocoInvalidoException {
		
		TipoDeAlmoco tipoAlmoco;

		for (int i = 1; i < linhas.size(); i++) {
			String[] campos = linhas.get(i).split(";");
				
			if (campos[2].equals("A la carte")) {
				tipoAlmoco = TipoDeAlmoco.A_LA_CARTE; 
			} 
			else if (campos[2].equals("Prato feito")) {
				tipoAlmoco = TipoDeAlmoco.PRATO_FEITO; 
			} 
			else {
				tipoAlmoco = TipoDeAlmoco.SELF_SERVICE; 
			}
				
			Estabelecimento estabelecimento = new Estabelecimento(campos[0], campos[1], tipoAlmoco);
			estabelecimentos.put(estabelecimento.getNome().toLowerCase(), estabelecimento);
		}
	}
}
