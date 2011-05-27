package ahoradorango;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class LeitorDeDados {

	public ArrayList<String> readFile(String filename, ArrayList<String> linhas)
			throws Exception {
		String line = null;

		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"lista_estabelecimentos.csv"));
		while ((line = bufferedReader.readLine()) != null) {
			linhas.add(line);
		}

		bufferedReader.close();
		return linhas;
	}
	
	public ArrayList<Estabelecimento> getEstabelecimento() throws Exception{
		ArrayList<String> linhas = new ArrayList<String>();
		Estabelecimento estabelecimento;  
		TipoDeAlmoco tipoAlmoco = null;
		ArrayList<Estabelecimento> arrayEstabelecimentos = new ArrayList<Estabelecimento>();
		LeitorDeDados leitor = new LeitorDeDados();
		leitor.readFile("lista_estabelecimentos.csv", linhas);

		for (int i = 1; i < linhas.size(); i++) {
			String[] campos = linhas.get(i).split(";");
			for (int j = 0; j < campos.length; j = j+3) {
				
				if (campos[j+2].equals("A la carte")){
					tipoAlmoco = TipoDeAlmoco.A_LA_CARTE; 
				}
				
				if (campos[j+2].equals("Prato feito")){
					tipoAlmoco = TipoDeAlmoco.PRATO_FEITO; 
				}
				
				if (campos[j+2].equals("Self-service")){
					tipoAlmoco = TipoDeAlmoco.SELF_SERVICE; 
				}
				
				estabelecimento = new Estabelecimento(campos[j], campos[j+1], tipoAlmoco);
				arrayEstabelecimentos.add(estabelecimento);
				
				//TODO Jogar o nome, endereco e tipo de almoco de estabelecimento na tabela		
			}

		}
		
		return arrayEstabelecimentos;
		
	}

	public void setDadosTabelaEstabelecimento(ArrayList<Estabelecimento> arrayEstabelecimentos){
		TabelaEstabelecimentos tabelaEstabelecimentosAux = new TabelaEstabelecimentos();
		TabelaEstabelecimentos.MyTableModel tabelaEstabelecimentos = tabelaEstabelecimentosAux.new MyTableModel();
		for (int i = 0; i < 39; i++) {
			for (int j2 = 0; j2 < arrayEstabelecimentos.size(); j2++) {
				tabelaEstabelecimentos.setValueAt(arrayEstabelecimentos.get(j2), i, 0);
				tabelaEstabelecimentos.setValueAt(arrayEstabelecimentos.get(j2).getEndereco(), i, 1);
				tabelaEstabelecimentos.setValueAt(arrayEstabelecimentos.get(j2).getTipoDeAlmocoServido(), i, 2);
			}
			
		}
		
	}

}
