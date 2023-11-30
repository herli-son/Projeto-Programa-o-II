package Servicos;

import java.io.File;

public class Diretorio {
	/**
	 * Diretórios que são necessários
	 */
	public static final String[] DIRETORIOS = { "Dados", "Dados//Pessoa", "Dados//Estabelecimento",
			"Dados//Funcionario", "Dados//Funcao", "Dados//Avaliacao",
			"Dados//Reserva", "Dados//Reserva//Servico", "Dados//Reserva//Produto", "Dados//Servico", "Dados//Produto",
			"Dados//Insumo", };

	/**
	 * Cria todos os diretórios necessários
	 */
	public static void CriarDiretorios() {
		for (String diretorio : DIRETORIOS) {
			File dir = new File(diretorio);
			if (!dir.exists()) {
				dir.mkdir();
			}
		}
	}
	
	public static String ID() {
		return DIRETORIOS[0];
	}
	/**
	 * Obtem o diretório que as pessoas serão salvas
	 * 
	 * @return Diretório da entidade Pessoas
	 */
	public static String Pessoas() {
		return DIRETORIOS[1];
	}
	
	/**
	 * Obtem o diretório que os estabelecimentos serão salvos
	 * 
	 * @return Diretório da entidade estabelecimento
	 */
	public static String Estabelecimento() {
		return DIRETORIOS[2];
	}
	public static String Funcionario() {
		return DIRETORIOS[3];
	}
	public static String Funcao() {
		return DIRETORIOS[4];
	}
	public static String Avaliacao() {
		return DIRETORIOS[5];
	}
}
