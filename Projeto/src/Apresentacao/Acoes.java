package Apresentacao;

import Utilidades.Globais;
import Utilidades.Array;

public class Acoes {

	/**
	 * Tela inicial do aplicativo
	 */
	public static void Acesso() {
		boolean encerrar = false;
		while (!encerrar) {
			try {

				String op = Painel.Opcao(Menu.INICIO);
				switch (op) {
				case "1":
					Pessoa.Acessar();
					break;
				case "2":
					Pessoa.Cadastrar();
					break;
				case "0":
				case "3":
					encerrar = true;
				}
			} catch (Exception e) {
				Painel.Erro(e.getMessage());
			}
		}
	}

	/**
	 * Atualiza dados de uma entidade
	 * 
	 * @param infoEntidade - Campos de info da entidade atualizada
	 * @param dados        - Valor atual da entidade
	 * @return Entidade com novos valores
	 * @throws Exception Existem mais dados do que a info necessita
	 */
	public static String[] Atualizar(String[] infoEntidade, String[] dados, int[] campos) throws Exception {
		String[] atualizado = dados.clone();
		String[] camposAlterar = new String[campos.length];
		String[] valoresAlterar = new String[campos.length];

		for (int i = 0; i < camposAlterar.length; i++) {
			camposAlterar[i] = Array.ConcatenarCampos(infoEntidade, new int[] { campos[i] });
			valoresAlterar[i] = Array.ConcatenarCampos(atualizado, new int[] { campos[i] });
		}

		while (true) {
			
			String op = Painel.Opcao(Menu.MontaMenuOpcoes(
					Array.Concatena(camposAlterar, new String[] { "Cancelar", "Salvar" }), valoresAlterar));
			int i = Integer.parseInt(op) - 1;
			String valor;
			if (i == camposAlterar.length || i == -1)
				return dados;
			else if (i == camposAlterar.length + 1)
				return atualizado;
			else {
				valor = Painel.Entrada("Novo valor para " + camposAlterar[i] + ": ");
				if (valor != null) {
					atualizado[campos[i]] = valor;
					valoresAlterar[i] = valor;
				}
			}
		}
	}

	/**
	 * Ver dados de uma entidade passando campos específicos
	 * 
	 * @param infoEntidade - Info da entidade que será visualizada
	 * @param dados        - Dados da entidade
	 * @param campos       - Campos que serão visualizados
	 * @throws Exception Os dados não corresponde a uma entidade ou o campo não
	 *                   existe para essa entidade
	 */
	public static void Ver(String[] infoEntidade, String[] dados, int[] campos) throws Exception {
		Painel.Informar(Menu.TextoDadosEntidade(infoEntidade, dados, campos));
	}

	/**
	 * Ver dados de uma entidade
	 * 
	 * @param infoEntidade - Info da entidade que será visualizada
	 * @param dados        - Dados da entidade
	 * @throws Exception Os dados não corresponde a uma entidade
	 */
	public static void Ver(String[] infoEntidade, String[] dados) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		Ver(infoEntidade, dados, campos);
	}

	/**
	 * Ver dados de uma entidade possibilitando alteração de campos específicos
	 * 
	 * @param infoEntidade - Info da entidade que será visualizada
	 * @param dados        - Dados da entidade
	 * @param campos       - Campos que serão visualizados e alterados
	 * @return Entidade alterada
	 * @throws Exception Os dados não corresponde a uma entidade ou o campo não
	 *                   existe para essa entidade
	 */
	public static String[] VerAlterar(String[] infoEntidade, String[] dados, int[] camposVer, int[] camposAlterar)
			throws Exception {
		while (Painel.SimOuNao(Menu.TextoDadosEntidade(infoEntidade, dados, camposVer)))
			dados = Atualizar(infoEntidade, dados, camposAlterar);
		return dados;
	}

	/**
	 * Ver dados de uma entidade possibilitando alteração
	 * 
	 * @param infoEntidade - Info da entidade que será visualizada
	 * @param dados        - Dados da entidade
	 * @return Entidade alterada
	 * @throws Exception Os dados não corresponde a uma entidade
	 */
	public static String[] VerAlterar(String[] infoEntidade, String[] dados) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		return VerAlterar(infoEntidade, dados, campos, campos);
	}

	/**
	 * Ver campos específicos de um conjunto de uma mesma entidade com os campos
	 * desejados
	 * 
	 * @param infoEntidade  - Info da entidade que será visualizada
	 * @param dados         - Lista de entidade
	 * @param campos        - Campos de informação que serão visualizados
	 * @param camposMostrar - Campo para identificar um item da lista
	 * @throws Exception O campo não existe no array <br>
	 *                   Os dados não tem quantidade de campos correspondente a info
	 */
	public static void VerLista(String[] infoEntidade, String[][] dados, int[] campos, int[] camposIdentificar)
			throws Exception {
		int index, opcao;
		String[] itens = new String[dados.length];
		for (int i = 0; i < dados.length; i++) {
			itens[i] = Array.ConcatenarCampos(dados[i], camposIdentificar);
		}
		do {
			index = Painel.EscolherDadoLista(itens);
			if (index == -1)
				return;
			do {
				opcao = Painel.VerDadoLista(Menu.TextoDadosEntidade(infoEntidade, dados[index], campos));
				switch (opcao) {
				case 0:
					index = Globais.Proximo(index, dados.length);
					break;
				case 2:
					index = Globais.Anterior(index);
					break;
				}
			} while (opcao != 1 && opcao != -1);
		} while (true);
	}

	/**
	 * Ver campos específicos de um conjunto de uma mesma entidade
	 * 
	 * @param infoEntidade  - Info da entidade que será visualizada
	 * @param dados         - Lista de entidade
	 * @param camposMostrar - Campo para identificar um item da lista
	 * @throws Exception O campo não existe no array <br>
	 *                   Os dados não tem quantidade de campos correspondente a info
	 */
	public static void VerLista(String[] infoEntidade, String[][] dados, int[] camposIdentificar) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		VerLista(infoEntidade, dados, campos, camposIdentificar);
	}

	/**
	 * 
	 * @param infoEntidade
	 * @param dados
	 * @throws Exception
	 */
	public static void VerLista(String[] infoEntidade, String[][] dados) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		VerLista(infoEntidade, dados, campos, new int[] { 0 });
	}

	/**
	 * Ver campos específicos de um conjunto de uma mesma entidade com os campos
	 * desejados com apossibilidade de alterar
	 * 
	 * @param infoEntidade  - Info da entidade que será visualizada
	 * @param dados         - Lista de entidade
	 * @param campos        - Campos de informação que serão visualizados
	 * @param camposMostrar - Campo para identificar um item da lista
	 * @return Index da lista que foram alterados
	 * @throws Exception O campo não existe nos dados <br>
	 *                   Os dados informados não estão na mesma quatidade dos
	 *                   camposinfo da entidade <br>
	 */
	public static int AcessarLista(String[] infoEntidade, String[][] dados, int[] campos, int[] camposIdentificar,
			int index) throws Exception {

		do {
			int opcao = Painel.AcessarDadoLista(Menu.TextoDadosEntidade(infoEntidade, dados[index], campos));
			switch (opcao) {
			case 0:
				index = Globais.Anterior(index);
				break;
			case 1:
				return index;
			case 3:
				index = Globais.Proximo(index, dados.length);
				break;
			default:
				return -2;
			}
		} while (true);
	}

	/**
	 * Ver campos específicos de um conjunto de uma mesma entidade com
	 * apossibilidade de alterar
	 * 
	 * @param infoEntidade  - Info da entidade que será visualizada
	 * @param dados         - Lista de entidade
	 * @param camposMostrar - Campo para identificar um item da lista
	 * @return Index da lista que foram alterados
	 * @throws ExceptionO campo não existe nos dados <br>
	 *                    Os dados informados não estão na mesma quatidade dos
	 *                    camposinfo da entidade <br>
	 */
	public static int AcessarLista(String[] infoEntidade, String[][] dados, int[] camposIdentificar, int index) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		return AcessarLista(infoEntidade, dados, campos, camposIdentificar, index);
	}

	/**
	 * 
	 * @param infoEntidade
	 * @param dados
	 * @return
	 * @throws Exception
	 */
	public static int AcessarLista(String[] infoEntidade, String[][] dados, int index) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		return AcessarLista(infoEntidade, dados, campos, campos, index);
	}
	public static int AcessarLista(String[] infoEntidade, String[][] dados) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		return AcessarLista(infoEntidade, dados, campos, campos, 0);
	}

	/**
	 * Mostrar a entidade com possibilidade de var ou alterar, cancelar cancela a
	 * ação que está sendo feita podendo passar os campos que serão vistos e
	 * alterados
	 * 
	 * @param infoEntidade - Entidade que será mostrada
	 * @param dados        - Dados da entidade
	 * @param campos       - Campos que serão exibidos
	 * @return Entidade atualizada
	 * @throws Exception Os dados informados não estão na mesma quatidade dos
	 *                   camposinfo da entidade <br>
	 *                   O index do campo não existe
	 */
	public static String[] VerAlterarCancelar(String[] infoEntidade, String[] dados, int[] campos, int[] camposAlterar)
			throws Exception {
		int op;
		do {
			op = Painel.SimOuNaoOuCancelar(
					Menu.TextoDadosEntidade(infoEntidade, dados, campos) + "\nAlterar alguma informação?");
			if (op == 0)
				dados = Acoes.Atualizar(infoEntidade, dados, camposAlterar);
			else if (op == 2 || op == -1)
				return null;

		} while (op == 0);
		return dados;
	}

	/**
	 * Mostrar a entidade com possibilidade de var ou alterar, cancelar cancela a
	 * ação que está sendo feita
	 * 
	 * @param infoEntidade - Entidade que será mostrada
	 * @param dados        - Dados da entidade
	 * @return Entidade atualizada
	 * @throws Exception Os dados informados não estão na mesma quatidade dos
	 *                   camposinfo da entidade <br>
	 *                   O index do campo não existe
	 */
	public static String[] VerAlterarCancelar(String[] infoEntidade, String[] dados) throws Exception {
		int[] campos = new int[infoEntidade.length];
		for (int i = 0; i < campos.length; i++)
			campos[i] = i;
		return VerAlterarCancelar(infoEntidade, dados, campos, campos);
	}

	public static int ManutencaoLista(String[] infoEntidade, String[][] dados, int[] campos, int[] camposIdentificar)
			throws Exception {
		int index;
		String[] itens;
		itens = Array.ConcatenarListaCampos(dados, camposIdentificar);
		do {
			index = Painel.EscolherAdicionarDadoLista(itens);
			if (index < 1)
				return index;
			else {
				return AcessarLista(infoEntidade, dados, campos, camposIdentificar, index - 1) + 1;
			}
		} while (true);
	}
}
