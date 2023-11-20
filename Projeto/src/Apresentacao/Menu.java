package Apresentacao;

public class Menu {

	/**
	 * Tela inicial
	 */
	public static final String[] INICIO = { "1 - Acessar", "2 - Cadastrar", "3 - Encerrar" };
	/**
	 * Menu para pessoa logada
	 */
	public static final String[] PESSOA = { "1 - Meus dados", "2 - Minhas avaliações", "3 - Minhas compras",
			"4 - Meus estabelecimentos", "5 - Estabelecimentos", "6 - Sair" };
	/**
<<<<<<< Updated upstream
	 * Menu de avaliações para visualizar
	 */
	public static final String[] AVALIACOES = { "1 - Funcionarios", "2 - Estabelecimentos", "3 - Produtos",
			"4 - Serviços", "5 - Voltar" };
	/**
	 * Menu de compras feitas
	 */
	public static final String[] COMPRAS = { "1 - Produtos", "2 - Serviços", "3 - Voltar" };

	/**
	 * Dados específicos de uma entidade passada
	 * 
	 * @param infoEntidade  - Campos disponíveis para entidade disponível em
	 *                      Globlais (INFO)
	 * @param dadosEntidade - Dados atuais da entidade passada
	 * @param campos        - Campos que serão retornados na visualização
	 * @return Texto contendo os dados da entidade com os campos passados
	 * @throws Exception Os dados informados não estão na mesma quatidade dos campos
	 *                   info da entidade <br>
	 *                   O index do campo não existe
	 */
	public static String TextoDadosEntidade(String[] infoEntidade, String[] dadosEntidade, int[] campos)
			throws Exception {
		if (infoEntidade.length != dadosEntidade.length)
			throw new Exception("Os dados informados não são suficientes para essa entidade!\nCampos necessários: "
					+ infoEntidade.length + "\nCampos passados: " + dadosEntidade.length);
		String dados = "";
		for (int i : campos) {
			if (i < 0 || i > infoEntidade.length - 1)
				throw new Exception("O index do campo passado não existe. Campo: " + 1);
			dados += infoEntidade[i] + ": " + dadosEntidade[i] + "\n";
		}
		return dados;
	}

	/**
	 * Monta array de opções disponíveis com valor atual
	 * 
	 * @param descricaoOpcoes - Array de opções a serem escolhidas
	 * @return Array montado com as opções
	 * @throws Exception não acontece
	 */
	public static String[] MontaMenuOpcoes(String[] descricaoOpcoes) throws Exception {
		return MontaMenuOpcoes(descricaoOpcoes, new String[0]);
	}

	/**
	 * Monta array de opções disponíveis com valor atual
	 * 
	 * @param descricaoOpcoes - Array de opções a serem escolhidas
=======
<<<<<<< HEAD
	 * Menu para estabelecimento
	 */
	public static final String[] ESTABELECIMENTO = { "1 - Meus dados", "2 - Minhas avaliações", "3 - Minhas compras",
			"4 - Sair" };

	/**
	 * Menu de avaliações para visualizar
	 */
	public static final String[] AVALIACOES = { "1 - Funcionarios", "2 - Estabelecimentos", "3 - Produtos",
			"4 - Serviços", "5 - Voltar" };
	/**
	 * Menu de compras feitas
	 */
	public static final String[] COMPRAS = { "1 - Produtos", "2 - Serviços", "3 - Voltar" };

	/**
	 * Dados específicos de uma entidade passada
	 * 
	 * @param infoEntidade  - Campos disponíveis para entidade disponível em
	 *                      Globlais (INFO)
	 * @param dadosEntidade - Dados atuais da entidade passada
	 * @param campos        - Campos que serão retornados na visualização
	 * @return Texto contendo os dados da entidade com os campos passados
	 * @throws Exception Os dados informados não estão na mesma quatidade dos campos
	 *                   info da entidade <br>
	 *                   O index do campo não existe
	 */
	public static String TextoDadosEntidade(String[] infoEntidade, String[] dadosEntidade, int[] campos)
			throws Exception {
		if (infoEntidade.length != dadosEntidade.length)
			throw new Exception("Os dados informados não são suficientes para essa entidade!\nCampos necessários: "
					+ infoEntidade.length + "\nCampos passados: " + dadosEntidade.length);
		String dados = "";
		for (int i : campos) {
			if (i < 0 || i > infoEntidade.length - 1)
				throw new Exception("O index do campo passado não existe. Campo: " + 1);
			dados += infoEntidade[i] + ": " + dadosEntidade[i] + "\n";
		}
		return dados;
=======
	 * Menu de avaliações para visualizar
	 */
	public static final String[] AVALIACOES = { "1 - Funcionarios", "2 - Estabelecimentos", "3 - Produtos",
			"4 - Serviços", "5 - Voltar" };
	/**
	 * Menu de compras feitas
	 */
	public static final String[] COMPRAS = { "1 - Produtos", "2 - Serviços", "3 - Voltar" };

	/**
	 * Dados específicos de uma entidade passada
	 * 
	 * @param infoEntidade  - Campos disponíveis para entidade disponível em
	 *                      Globlais (INFO)
	 * @param dadosEntidade - Dados atuais da entidade passada
	 * @param campos        - Campos que serão retornados na visualização
	 * @return Texto contendo os dados da entidade com os campos passados
	 * @throws Exception Os dados informados não estão na mesma quatidade dos campos
	 *                   info da entidade <br>
	 *                   O index do campo não existe
	 */
	public static String TextoDadosEntidade(String[] infoEntidade, String[] dadosEntidade, int[] campos)
			throws Exception {
		if (infoEntidade.length != dadosEntidade.length)
			throw new Exception("Os dados informados não são suficientes para essa entidade!\nCampos necessários: "
					+ infoEntidade.length + "\nCampos passados: " + dadosEntidade.length);
		String dados = "";
		for (int i : campos) {
			if (i < 0 || i > infoEntidade.length - 1)
				throw new Exception("O index do campo passado não existe. Campo: " + 1);
			dados += infoEntidade[i] + ": " + dadosEntidade[i] + "\n";
		}
		return dados;
	}

	/**
	 * Monta array de opções disponíveis com valor atual
	 * 
	 * @param descricaoOpcoes - Array de opções a serem escolhidas
	 * @return Array montado com as opções
	 * @throws Exception não acontece
	 */
	public static String[] MontaMenuOpcoes(String[] descricaoOpcoes) throws Exception {
		return MontaMenuOpcoes(descricaoOpcoes, new String[0]);
>>>>>>> e333595d01ec86a72a570431dcbd688c5b77b728
	}

	/**
	 * Monta array de opções disponíveis com valor atual
	 * 
	 * @param descricaoOpcoes - Array de opções a serem escolhidas
<<<<<<< HEAD
	 * @return Array montado com as opções
	 * @throws Exception não acontece
	 */
	public static String[] MontaMenuOpcoes(String[] descricaoOpcoes) throws Exception {
		return MontaMenuOpcoes(descricaoOpcoes, new String[0]);
	}

	/**
	 * Monta array de opções disponíveis com valor atual
	 * 
	 * @param descricaoOpcoes - Array de opções a serem escolhidas
=======
>>>>>>> e333595d01ec86a72a570431dcbd688c5b77b728
>>>>>>> Stashed changes
	 * @param valores         - Valores que as opções possuem
	 * @return Array montado com as opções e os valores
	 * @throws Exception A quantidade de valores informados é maior que a quantidade
	 *                   de opções
	 */
	public static String[] MontaMenuOpcoes(String[] descricaoOpcoes, String[] valores) throws Exception {
		String[] opcoes = new String[descricaoOpcoes.length];
		int i;
		if (valores.length > opcoes.length)
			throw new Exception("Existem mais valores informados que opções disponíveis. \n Valores: " + valores.length
					+ "\nOpções: " + opcoes.length);
		for (i = 0; i < valores.length; i++)
			opcoes[i] = (i + 1) + " - " + descricaoOpcoes[i] + ": " + valores[i] + "\n";
		for (int j = i; j < opcoes.length; j++)
			opcoes[j] = (j + 1) + " - " + descricaoOpcoes[j] + "\n";
		return opcoes;
	}
}
