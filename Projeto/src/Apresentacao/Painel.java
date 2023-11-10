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

    public static final int SIM = 0;
    public static final int NAO = 1;
    public static final int CANCELAR = 2;
    /**
     * Painel com opção de sim ou não
     * @param mensagem - Mensagem que será exibida
     * @param titulo - Ação que está sendo feita
     * @return <b>True</b> - Selecionou sim <br> <b>False</b> - Selecionou não
     */
    public static boolean SimOuNao(String mensagem, String titulo) {
        int op = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return op == JOptionPane.YES_OPTION;
    }
    /**
     * Painel padrão de entrada de dados
     * @param mensagem - Dados que está sendo entrado
     * @return Dado informado
     */
    public static String Entrada(String mensagem) {   
        return JOptionPane.showInputDialog(null, mensagem, "Informe:", JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * Painel de seleção de opção
     * @param opcoes - Opções disponíveis para selecionar
     * @return Index da opção começando em 1
     */
    public static String Opcao(String[] opcoes){
        JList lista = new JList(opcoes);
        lista.setBackground((Color) UIManager.get("OptionPane.background"));
        JOptionPane.showMessageDialog(null, lista, "Selecione:",JOptionPane.PLAIN_MESSAGE);
        return String.valueOf(lista.getSelectedIndex() + 1);
    }
    /**
     * Painel de exibição de erro
     * @param mensagem - Erro que será exibido
     */
    public static void Erro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Painel de exibição de informação
     * @param mensagem - Informação que será exibida
     */
    public static void Informar(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação!", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Painel de mostrar um item de uma lista contendo as opções anterior e próximo
     * @param dados - Dado que está sendo exibido
     * @param titulo - O que está sendo exibido
     * @return 0 - Anterior <br> 1 - Sair <br> 2 - Próximo
     */
    public static int DadosLista(String dados, String titulo) {
        Object[] options = {"Anterior", "Sair", "Próximo"};
        return JOptionPane.showOptionDialog(null, dados, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    /**
     * Painel de escolha de item em comobox para escolhas unicas
     * @param mensagem - O que deve ser escolhido?
     * @param dados - Lista de escolhas disponíveis
     * @return Escolha feita <br> Null - Não escolheu nada
     */
    public static String Escolha(String mensagem, String[] dados) {

        Object valor = JOptionPane.showInputDialog(null, mensagem, "Escolha:", JOptionPane.PLAIN_MESSAGE, null, dados, dados[0]);
        return valor != null ? String.valueOf(valor) : null;
    }
}
