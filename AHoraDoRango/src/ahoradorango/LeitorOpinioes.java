package ahoradorango;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LeitorOpinioes {

	private String[][] tabelaOpinioes = null;
	private ArrayList<String> linhas = new ArrayList<String>();
	private String line;

	public void leLinhas() throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(
				"opinioes-dos-usuarios-v2.data"));
		for (int i = 0; i < 166; i++) {
			line = buffer.readLine();
			linhas.add(line);
		}
		/*while ((line = buffer.readLine()) != null) {
			linhas.add(line);
		}*/
		buffer.close();
	}
	
	public void ImprimeArrayList(){
		System.out.println("Imprimindo arraylist");
		
		for(int i = 0; i < 166 ; i++){
			System.out.println("Linhas" + "  " + i + "  " + linhas.get(i));
		}
		
	}

	public void criaTabela() {
		tabelaOpinioes = new String[linhas.size()][41];
		for (int linha = 0; linha < linhas.size(); linha++) {
			String[] campos = linhas.get(linha).split(";");
			for (int coluna = 0; coluna < campos.length; coluna++) {
				tabelaOpinioes[linha][coluna] = campos[coluna];
			}
		}
	}

	public void mostraTabela() {
		for (int linha = 0; linha < tabelaOpinioes.length; linha++) {
			System.out.println();
			for (int coluna = 0; coluna < tabelaOpinioes[linha].length; coluna++) {
				System.out.print(tabelaOpinioes[linha][coluna] + ";");
			}
		}
	}
}
