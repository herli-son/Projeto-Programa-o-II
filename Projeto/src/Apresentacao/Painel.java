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
     * Painel com opção de sim, não, cancelar
     * @param mensagem - Mensagem que será exibida
     * @param titulo - Ação que está sendo feita
     * @return 0 - Sim <br> 1 - Não <br> 2 - Cancelar
     */
    public static int SimOuNaoOuCancelar(String mensagem, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
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
     * @param informacao - Dado que está sendo exibido
     * @param titulo - O que está sendo exibido
     * @return 0 - Anterior <br> 1 - Sair <br> 2 - Próximo
     */
    public static int DadosLista(String informacao, String titulo) {
        Object[] options = {"Anterior", "Sair", "Próximo"};
        return JOptionPane.showOptionDialog(null, informacao, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    /**
     * Painel de mostrar um item de uma lista contendo as opções anterior, próximo e alterar
     * @param informacao - Dado que está sendo exibido
     * @param titulo - O que está sendo exibido
     * @return 0 - Anterior <br> 1 - Sair <br> 2 - ALterar <br> 3 - Próximo
     */
    public static int DadosListaAlterar(String informacao, String titulo) {
        Object[] options = {"Anterior", "Sair", "Alterar", "Próximo"};
        return JOptionPane.showOptionDialog(null, informacao, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
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
    /**
     * Mostra informação a respeito dos dados de uma entidade passada
     * @param dados - Entidade formatada en array
     * @param tipo - Tipo da entidade
     * @return Opção escolhida <br>
     * 0 - Anterior <br> 1 - Sair <br> 2 - Próximo
     * @throws Exception Existem dados demais ou dados insuficientes para mostrar
     */
    public static int VerDadoLista(String[] dados, String tipo) throws Exception{
        String mensagem = "";
        int op;
        
        switch (tipo) {
            case "Pessoa":
                    mensagem = Servicos.Pessoa.MontaDadosInfo(dados);
                break;
        }
         return DadosLista(mensagem, tipo);      
    }
    /**
     * Mostra informação a respeito dos dados de uma entidade passada com possibilidade de alteração
     * @param dados - Entidade formatada en array
     * @param tipo - Tipo da entidade
     * @return Opção escolhida <br>
     * 0 - Anterior <br> 1 - Sair <br> 2 - ALterar <br> 3 - Próximo
     * @throws Exception Existem dados demais ou dados insuficientes para mostrar
     */
    public static int AlterarDadoLista(String[] dados, String tipo) throws Exception{
        String mensagem = "";
        
        switch (tipo) {
            case "Pessoa":
                    mensagem = Servicos.Pessoa.MontaDadosInfo(dados);
                break;
        }
         return DadosListaAlterar(mensagem, tipo);      
    }
}
