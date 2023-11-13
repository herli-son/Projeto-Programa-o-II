package Controles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	/**
	 * Extensão dos arquivos que será salvos
	 */
	public static final String EXTENSAO = ".txt";

	/**
	 * Criar arquivo
	 * 
	 * @param path - Arquivo que serpa criado
	 * @throws IOException Não conseguiu criar o arquivo
	 */
	public static void Criar(String path) throws IOException {
		File arquivo = new File(path);
		arquivo.createNewFile();
	}

	/**
	 * Exclui o arquivo passado
	 * 
	 * @param path - Arquivo que será excluído
	 * @return Conseguiu deletar? True or False
	 */
	public static boolean Deletar(String path) {
		File arquivo = new File(path);
		return arquivo.delete();
	}

	/**
	 * Altera a informação de um arquivo
	 * 
	 * @param path   - Arquivo que será alterado
	 * @param linhas - Dados que serão inseridos
	 * @throws FileNotFoundException O arquivo não foi encontrado
	 */
	public static void Atualizar(String path, String[] linhas) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(path);
		for (String linha : linhas) {
			pw.println(linha == null ? "" : linha);
		}
		pw.flush();
		pw.close();
	}

	/**
	 * Obtem dados de um arquivo em um array de String
	 * 
	 * @param path - Arquivo que será lido
	 * @return Dados do arquivo lido
	 * @throws FileNotFoundException Arquivo não foi encontrado
	 */
	public static String[] Ler(String path, int quantidadeCampos) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String[] dados = new String[quantidadeCampos];

		for (int i = 0; i < quantidadeCampos; i++) {
			dados[i] = br.readLine();
		}
		br.close();
		return dados;
	}
}
