package Controles;

import java.io.File;

public class Diretorio {
	/**
	 * Diretórios que são necessários
	 */
	public static final String[] DIRETORIOS = { "Dados", "Dados//Pessoa", "Dados//Estabelecimento",
			"Dados//Funcionario", "Dados//Funcao", "Dados//Avaliacao", "Dados//Avaliacao//Servico",
			"Dados//Avaliacao//Produto", "Dados//Avaliacao//Funcionario", "Dados//Avaliacao//Estabelecimento",
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

	/**
	 * Obtem o diretório que as pessoas serão salvas
	 * 
	 * @return Diretório da entidade Pessoas
	 */
	public static String Pessoas() {
		return DIRETORIOS[1];
	}
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	
	/**
	 * Obtem o diretório que os estabelecimentos serão salvos
	 * 
	 * @return Diretório da entidade estabelecimento
	 */
	public static String Estabelecimento() {
		return DIRETORIOS[2];
	}
=======
>>>>>>> e333595d01ec86a72a570431dcbd688c5b77b728
>>>>>>> Stashed changes
}
