package Arquivos;

import java.io.File;

public class Diretorio {
	/**
	 * Diretórios que são necessários
	 */
	public static final String[] DIRETORIOS = {
			"Dados",
			"Dados//Pessoa",
			"Dados//Estabelecimento",
			"Dados//Funcionario",
			"Dados//Funcao",
			"Dados//Avaliacao",
			"Dados//Avaliacao//Servico",
			"Dados//Avaliacao//Produto",
			"Dados//Avaliacao//Funcionario",
			"Dados//Avaliacao//Estabelecimento",
			"Dados//Reserva",
			"Dados//Reserva//Servico",
			"Dados//Reserva//Produto",
			"Dados//Servico",
			"Dados//Produto",
			"Dados//Insumo",
	};
	/**
	 * Cria todos os diretórios necessários
	 */
	public static void CriarDiretorios() {
		for (String diretorio : DIRETORIOS) {
			File dir = new File(diretorio);
			if(!dir.exists()) {
				dir.mkdir();
			}
		}
	}
	/**
	 * Obtem o diretório que as pessoas serão salvas
	 * @return Diretório da entidade Pessoas
	 */
	public static String Pessoas() {
		return DIRETORIOS[1];
	}
}
