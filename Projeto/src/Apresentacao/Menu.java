package Apresentacao;

public class Menu {

	/**
	 * Tela inicial
	 */
	public static final String[] INICIO = { "1 - Acessar", "2 - Cadastrar", "3 - Encerrar" };
	/**
	 * Menu para pessoa logada
	 */
	public static final String[] PESSOA = { "1 - Dados", "2 - Avaliações", "3 - Compras","4 - Estabelecimentos", "5 - Sair" };
	/**
	 * Menu de avaliações para visualizar
	 */
	public static final String[] AVALIACOES = { "1 - Funcionário", "2 - Estabelecimento", "3 - Produto","4 - Serviço", "5 - Voltar" };
	public static final String[] AVALIACAO = {"1 - Dados", "2 - Sair"};
	/**
	 * Menu de compras feitas
	 */
	public static final String[] COMPRAS = { "1 - Produtos", "2 - Serviços", "3 - Voltar" };
	/**
	* Menu para estabelecimento
	 */
	public static final String[] ESTABELECIMENTO = { "1 - Dados", "2 - Avaliações", "3 - Compras", "4 - Funcionarios", "5 - Funções", "6 - Sair" };
	public static final String[] FUNCOES = { "1 - Dados", "2 - Excluir", "3 - Sair" };
	public static final String[] FUNCIONARIO = { "1 - Dados", "2 - Alterar função","3 - Avaliações",  "4 - Demitir", "5 - Sair" };
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
