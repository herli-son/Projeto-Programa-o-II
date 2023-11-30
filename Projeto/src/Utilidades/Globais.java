package Utilidades;

import Repositorio.Entidades.Estabelecimento;
import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.Pessoa;
import Repositorio.Entidades.Funcao;
import Repositorio.Entidades.Avaliacao;

/**
 *
 * @author herli
 */
public class Globais {
    /**
     * Pessoa que realizou login
     */
    public static Pessoa Pessoa;
    public static Estabelecimento Estabelecimento;
    public static Funcionario Funcionario;
    public static Funcao Funcao;
    public static Avaliacao Avaliacao;
    public static String Titulo;
    /**
    * Caracteres válidos para cadastrar
    */
    public static final char[] CARACTERESVALIDOS = {
                   'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                   'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                   '0','1','2','3','4','5','6','7','8','9', '_'
    };
    /**
     * Retorna o próximo index disponível
     * @param indexAtual - Index atual selecionado
     * @param tamanhoLista - Tamanho da lista que o index será usado
     * @return Próximo index <br> Se não for possível, retorna o próprio index
     */
    public static int Proximo(int indexAtual, int tamanhoLista) {
        int index = indexAtual + 1;

        if (index < tamanhoLista) {
            return index;
        } else {
            return indexAtual;
        }
    }
    /**
     * Retorna o index anterior disponível
     * @param indexAtual - Index atual selecionado
     * @return Index anterior <br> Se não for possível, retorna o próprio index
     */
    public static int Anterior(int indexAtual) {
        int index = indexAtual - 1;
        if (index >= 0) {
            return index;
        } else {
            return indexAtual;
        }
    }
}
