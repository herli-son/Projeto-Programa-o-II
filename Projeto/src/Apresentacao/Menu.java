package Apresentacao;

import Entidades.Pessoa;
import javax.swing.JOptionPane;

public class Menu {

    /**
     * Tela inicial
     */
    public static final String[] INICIO = {"1 - Acessar", "2 - Cadastrar", "3 - Encerrar"};
    /**
     * MEnu para pessoa logada
     */
    public static final String[] PESSOA = {
        "1 - Meus dados",
        "2 - Minhas avaliações",
        "3 - Minhas compras",
        "4 - Meus estabelecimentos",
        "5 - Estabelecimentos",
        "6 - Sair"
    };

    /**
     * Menu para alterar dados de uma pessoa
     */
    public static String[] AlterarPessoa(Entidades.Pessoa pessoa) {
        return new String[]{
            "1 - Acesso: " + pessoa.acesso,
            "2 - Nome: " + pessoa.nome,
            "3 - Sobrenome: " + pessoa.sobrenome,
            "4 - Senha: " + pessoa.senha,
            "5 - Salvar",
            "6 - Cancelar"};
    }

    /**
     * Mostrar menu com dados de acesso passados
     *
     * @param acesso - Acesso da pessoa
     * @param senha - Senha da pessoa
     * @return Menu com todas as informações
     * @throws Exception
     */
    public static String DadosAcessoPessoa(String acesso, String senha) {
        String menu = "Acesso: " + acesso + "\n"
                + "Senha: " + senha;
        return menu;
    }

    /**
     * Mostrar menu com os dados passados durante o cadastro
     *
     * @param acesso - Acesso da pessoa
     * @param nome - Nome da pessoa
     * @param sobrenome - Sobrenome da pessoa
     * @param senha - Senha da pessoa
     * @return Menu com todas as informações
     */
    public static String DadosCadastroPessoa(Entidades.Pessoa pessoa) {
        String menu = "Acesso: " + pessoa.acesso + "\n"
                + "Nome: " + pessoa.nome + "\n"
                + "Sobrenome: " + pessoa.sobrenome + "\n"
                + "Senha: " + pessoa.senha;
        return menu;
    }
}
