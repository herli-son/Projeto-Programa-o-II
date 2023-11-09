package Utilidades;

import Entidades.Pessoa;
import javax.swing.JOptionPane;

public class Menu {
    
    /**
     * Tela inicial
     */
    public static void Acesso() {
        String menu = "1 - Acessar\n"
                + "2 - Cadastrar\n"
                + "3 - Encerrar";
        boolean encerrar = false;
        while (!encerrar) {
            String op = JOptionPane.showInputDialog(menu);
            if (op == null || (!op.equals("1") && !op.equals("2") && !op.equals("3"))) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            } else if (op.equals("3")) {
                encerrar = true;
            } else {
                switch (op) {
                    case "1":
                        Acessar();
                        break;
                    case "2":
                        Cadastrar();
                        break;
                }
            }
        }
    }
    /**
     * Menu de acesso
     */
    private static void Acessar() {
        String acesso = "", senha = "";
        try {
            acesso = JOptionPane.showInputDialog(Pessoa.MenuDadosAcesso(acesso, senha) + "\nDigite o acesso: ");
            if (acesso == null) {
                return;
            }
            senha = JOptionPane.showInputDialog(Pessoa.MenuDadosAcesso(acesso, senha) + "\nDigite a senha: ");
            if (senha == null) {
                return;
            }
            if (Pessoa.AcessarPessoa(acesso, senha)) {
                PessoaAcessada();
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Menu de cadastro de pessoa
     */
    private static void Cadastrar() {
        String acesso = "", senha = "", nome = "", sobrenome = "";
        acesso = JOptionPane.showInputDialog(Pessoa.MenuDadosCadastro(acesso, nome, sobrenome, senha) + "\nDigite o  acesso: ");
        if (acesso == null) {
            return;
        }
        nome = JOptionPane.showInputDialog(Pessoa.MenuDadosCadastro(acesso, nome, sobrenome, senha) + "\nDigite o  nome: ");
        if (nome == null) {
            return;
        }
        sobrenome = JOptionPane.showInputDialog(Pessoa.MenuDadosCadastro(acesso, nome, sobrenome, senha) + "\nDigite o  sobrenome: ");
        if (sobrenome == null) {
            return;
        }
        senha = JOptionPane.showInputDialog(Pessoa.MenuDadosCadastro(acesso, nome, sobrenome, senha) + "\nDigite a senha: ");
        if (senha == null) {
            return;
        }
        try {
            Pessoa.NovaPessoa(acesso, nome, sobrenome, senha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * Menu com as opções disponíveis para pessoa
     */
    private static void PessoaAcessada() {
        JOptionPane.showMessageDialog(null, "Acessado!");
    }
}
