package Entidades;

import Utilidades.Util;
import javax.swing.JOptionPane;

public class Pessoa {

    private static final int CAMPOS = 4;
    /**
     * DADOS[x][0] - Acesso <br>
     * DADOS[x][1] - Nome <br>
     * DADOS[x][2] - Sobrenome <br>
     * DADOS[x][3] - Senha <br>
     */
    public static String[][] DADOS = new String[0][CAMPOS];
    /**
     * 0 - Acesso <br>
     * 1 - Nome <br>
     * 2 - Sobrenome <br>
     * 3 - Senha <br>
     */
    public static final String[] NOMECAMPOS = {"Acesso", "Nome", "Sobrenome", "Senha"};

    /**
     * Obtem os dados da pessoa vinculada ao acesso passado
     *
     * @param acesso - Chave única da pessoa
     * @return Dados do acesso
     * @throws Exception Caso não exista nenhuma pessoa com o acesso informado
     */
    public static String[] DadosPessoa(String acesso) throws Exception {

        for (String[] dado : DADOS) {
            if (dado[0].equals(acesso)) {
                return dado;
            }
        }
        throw new Exception("Não existe pessoa com esse acesso;");
    }

    /**
     * Retorna um dado de uma pessoa específica
     *
     * @param acesso - Chave de identificação da pessoa
     * @param campo - Informação da pessoa que será retornada
     * @return Dado solicitado da pessoa com o acesso informado
     * @throws Exception <br>
     * Pessoa com o acesso não existe <br>
     * O campo informado não existe
     */
    public static String CampoPessoa(String acesso, String campo) throws Exception {
        for (String[] dado : DADOS) {
            if (dado[0].equals(acesso)) {
                return dado[Campo(campo)];
            }
        }
        throw new Exception("Não existe pessoa com esse acesso;");
    }
    /**
     * Adiciona uma nova pessoa no vetor de dados
     * @param acesso - Acesso da nove pessoa
     * @param nome - Nome da nova pessoa
     * @param sobrenome - Sobrenome da nova pessoa
     * @param senha - Senha da nova pessoa
     * @throws Exception <br>
     *         Caso o acesso já exista no sistema <br>
     *         Caso tente usar caracteres especiais para o acesso
     */
    public static void NovaPessoa(String acesso, String nome, String sobrenome, String senha) throws Exception {

        for (int i = 0; i < acesso.length(); i++) {
            if (!((acesso.charAt(i) >= 'a' && acesso.charAt(i) <= 'z')
                    || (acesso.charAt(i) >= 'A' && acesso.charAt(i) <= 'Z')
                    || (acesso.charAt(i) >= '0' && acesso.charAt(i) <= '9'))) {
                throw new Exception("Não é possível cadastrar caracteres especiais para o acesso!");
            }
        }

        try {
            CampoPessoa(acesso, NOMECAMPOS[0]);
            throw new Exception("Já existe uma pessoa com esse acesso. O acesso é único");
        } catch (Exception e) {
            //Não trata a excessão, pois significa que não tem outra pessoa com o mesmo acesso.
        }

        String[] dado = {acesso, nome, sobrenome, senha};
        DADOS = Util.AdicionarDado(dado, DADOS, CAMPOS);
        JOptionPane.showMessageDialog(null, "Pessoa cadastrada!");
    }
    /**
     * Mostrar menu com dados de acesso passados
     * @param acesso - Acesso da pessoa
     * @param senha - Senha da pessoa
     * @return Menu com todas as informações
     * @throws Exception 
     */
    public static String MenuDadosAcesso(String acesso, String senha) {
        String menu = NOMECAMPOS[0] + ": " + acesso + "\n"
                + NOMECAMPOS[3] + ": ";
        return menu;
    }
    /**
     * Mostrar menu com os dados passados durante o cadastro
     * @param acesso - Acesso da pessoa
     * @param nome - Nome da pessoa
     * @param sobrenome - Sobrenome da pessoa
     * @param senha - Senha da pessoa
     * @return Menu com todas as informações
     */
    public static String MenuDadosCadastro(String acesso, String nome, String sobrenome, String senha) {
        String menu = NOMECAMPOS[0] + ": " + acesso + "\n"
                + NOMECAMPOS[1] + ": " + nome + "\n"
                + NOMECAMPOS[2] + ": " + sobrenome + "\n"
                + NOMECAMPOS[3] + ": " + senha;
        return menu;
    }
    /**
     * Valida o acesso da pessoa
     * @param acesso - Chave única da pessoa
     * @param senha - Senha da pessoa para acessar
     * @return Se a pessoa acertar sua senha, retornará TRUE
     * @throws Exception Caso a pessoa não exista, retorna a excessão
     */
    public static boolean AcessarPessoa(String acesso, String senha) throws Exception {
        if (CampoPessoa(acesso, NOMECAMPOS[3]).equals(senha)) {
            return true;
        }
        return false;
    }

    /**
     * Busca o index do campo no vetor de dados caso o campo exista
     *
     * @param campo - Campo que será buscado
     * @return Index do vetor onde se encontra o campo passado
     * @throws Exception O campo passado não existe
     */
    private static int Campo(String campo) throws Exception {
        for (int i = 0; i < CAMPOS; i++) {
            if (NOMECAMPOS[i].equals(campo)) {
                return i;
            }
        }
        throw new Exception("O campo informado não existe");
    }
}
