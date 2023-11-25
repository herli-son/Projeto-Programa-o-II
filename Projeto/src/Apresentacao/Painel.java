package Apresentacao;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author herli
 */
public class Painel {
	/**
	 * Painel com opção de sim ou não
	 * 
	 * @param mensagem - Mensagem que será exibida
	 * @param titulo   - Ação que está sendo feita
	 * @return <b>True</b> - Selecionou sim <br>
	 *         <b>False</b> - Selecionou não
	 */
	public static boolean SimOuNao(String mensagem) {
		int op = JOptionPane.showConfirmDialog(null, mensagem, "Visualização de dados", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		return op == JOptionPane.YES_OPTION;
	}

	/**
	 * Painel com opção de sim, não, cancelar
	 * 
	 * @param mensagem - Mensagem que será exibida
	 * @param titulo   - Ação que está sendo feita
	 * @return 0 - Sim <br>
	 *         1 - Não <br>
	 *         2 - Cancelar
	 */
	public static int SimOuNaoOuCancelar(String mensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem, "Visualização de dados", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 * Painel padrão de entrada de dados
	 * 
	 * @param mensagem - Dados que está sendo entrado
	 * @return Dado informado
	 */
	public static String Entrada(String mensagem) {
		return JOptionPane.showInputDialog(null, mensagem, "Informe.", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Painel de seleção de opção
	 * 
	 * @param opcoes - Opções disponíveis para selecionar
	 * @return Index da opção começando em 1
	 */
	public static String Opcao(String[] opcoes) {
		JList<Object> lista = new JList<Object>(opcoes);
		lista.setBackground((Color) UIManager.get("OptionPane.background"));
		JOptionPane.showMessageDialog(null, lista, "Selecione:", JOptionPane.PLAIN_MESSAGE);
		return String.valueOf(lista.getSelectedIndex() + 1);
	}

	/**
	 * Painel de exibição de erro
	 * 
	 * @param mensagem - Erro que será exibido
	 */
	public static void Erro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Painel de exibição de informação
	 * 
	 * @param mensagem - Informação que será exibida
	 */
	public static void Informar(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Informação!", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Painel de mostrar um item de uma lista contendo as opções anterior e próximo
	 * 
	 * @param informacao - Dado que está sendo exibido
	 * @param titulo     - O que está sendo exibido
	 * @return 0 - Anterior <br>
	 *         1 - Sair <br>
	 *         2 - Próximo
	 */
	public static int VerDadoLista(String informacao) {
		Object[] options = { "Anterior", "Sair", "Próximo" };
		return JOptionPane.showOptionDialog(null, informacao, "Exibindo dado de uma lista.", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

	/**
	 * Painel de mostrar um item de uma lista contendo as opções anterior e próximo
	 * 
	 * @param informacao - Dado que está sendo exibido
	 * @param titulo     - O que está sendo exibido
	 * @return 0 - Anterior <br>
	 *         1 - Alterar <br>
	 *         2 - Excluir <br>
	 *         3 - Sair <br>
	 *         4 - Próximo
	 */
	public static int AcessarDadoLista(String informacao) {
		Object[] options = { "Anterior", "Acessar", "Sair", "Próximo" };
		return JOptionPane.showOptionDialog(null, informacao, "Manutenção de lista.", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

	/**
	 * Escolher uma opção de uma lista de opções
	 * 
	 * @param dados - Opções a escolher
	 * @return Opção escolhida <br>
	 *         -1 - Cancelou
	 */
	public static int EscolherDadoLista(String[] opcao) {

		int index = 0;
		Object escolhido = JOptionPane.showInputDialog(null, "Selecione para visualizar.", "Lista",
				JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
		if(escolhido == null)
			return -1;
		
		for (String op : opcao) {
			if (escolhido.toString().equals(op)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	/**
	 * Escolher uma opção de uma lista de opções
	 * 
	 * @param dados - Opções a escolher
	 * @return Opção escolhida <br>
	 *         0 - Adicionar
	 */
	public static int EscolherAdicionarDadoLista(String[] dados) {

		int index = 0;
		String[] opcao = Utilidades.Array.Concatena(new String[] { "Adicionar" }, dados);
		Object escolhido = JOptionPane.showInputDialog(null, "Selecione para visualizar: ", "Lista",
				JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
		
		if(escolhido == null)
			return -1;
		
		for (String op : opcao) {
			if (escolhido.toString().equals(op)) {
				return index;
			}
			index++;
		}
		return -1;
	}
}
