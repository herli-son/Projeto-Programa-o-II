package Apresentacao;

import Servicos.Arquivo;
import Servicos.Validacoes;
import Utilidades.Copiar;
import Utilidades.Globais;

public class Acoes {

    public static void Acesso() {
        boolean encerrar = false;
        while (!encerrar) {
            String op = Painel.Opcao(Menu.INICIO);
            switch (op) {
                case "1":
                    AcessarPessoa();
                    break;
                case "2":
                    CadastrarPessoa();
                    break;
                case "3":
                    encerrar = true;
            }
        }
    }

    private static void AcessarPessoa() {
        String acesso = "", senha = "";
        try {
            acesso = Painel.Entrada(Menu.DadosAcessoPessoa(acesso, senha) + "\nDigite o acesso: ");
            if (acesso == null) {
                return;
            }
            senha = Painel.Entrada(Menu.DadosAcessoPessoa(acesso, senha) + "\nDigite a senha: ");
            if (senha == null) {
                return;
            }
            if (Validacoes.AcessoPessoa(acesso, senha)) {
                Pessoa();
            }
        } catch (Exception e) {
            Painel.Erro(e.getMessage());
        }
    }

    private static void CadastrarPessoa() {
        Entidades.Pessoa pessoa = new Entidades.Pessoa();
        pessoa.acesso = "_______________";
        pessoa.nome = "_______________";
        pessoa.sobrenome = "_______________";
        pessoa.senha = "_______________";
        pessoa.acesso = Painel.Entrada(Menu.DadosCadastroPessoa(pessoa) + "\nDigite o  acesso: ");
        if (pessoa.acesso == null) {
            return;
        }
        pessoa.nome = Painel.Entrada(Menu.DadosCadastroPessoa(pessoa) + "\nDigite o  nome: ");
        if (pessoa.nome == null) {
            return;
        }
        pessoa.sobrenome = Painel.Entrada(Menu.DadosCadastroPessoa(pessoa) + "\nDigite o  sobrenome: ");
        if (pessoa.sobrenome == null) {
            return;
        }
        pessoa.senha = Painel.Entrada(Menu.DadosCadastroPessoa(pessoa) + "\nDigite a senha: ");
        if (pessoa.senha == null) {
            return;
        }
        do {
            while (Painel.SimOuNao(Menu.DadosCadastroPessoa(pessoa) + "\nAlterar alguma informação?", "Alterar cadastro?")) {
                pessoa = AtualizaPessoa(pessoa);
            }
        } while (!Validacoes.CadastroPessoa(pessoa));
        try {
            Arquivos.Pessoa.Criar(pessoa);
            Painel.Informar("Cadastro realizado!");
        } catch (Exception e) {
            Painel.Erro(e.getMessage());
        }
    }

    private static void Pessoa() {
        boolean sair = false;
        while (!sair) {
            String op = Painel.Opcao(Menu.PESSOA);
            switch (op) {
                case "1":
                    DadosPessoa();
                    break;
                case "2":
                    Painel.Informar("Em Desenvolvimento");
                    break;
                case "3":
                    Painel.Informar("Em Desenvolvimento");
                    break;
                case "4":
                    Painel.Informar("Em Desenvolvimento");
                    break;
                case "5":
                    Painel.Informar("Em Desenvolvimento");
                    break;
                case "6":
                    Globais.PessoaLogada = null;
                    sair = true;
                    break;
            }
        }
    }

    private static Entidades.Pessoa AtualizaPessoa(Entidades.Pessoa pessoa) {
        Entidades.Pessoa pessoaAux = Copiar.Pessoa(pessoa);
        String valor;
        boolean sair = false;
        while (!sair) {
            String op = Painel.Opcao(Menu.AlterarPessoa(pessoaAux));
            switch (op) {
                case "1":
                    valor = Painel.Entrada("Novo acesso: ");
                    if (valor != null) {
                        pessoaAux.acesso = valor;
                    }
                    break;
                case "2":
                    valor = Painel.Entrada("Novo nome: ");
                    if (valor != null) {
                        pessoaAux.nome = valor;
                    }
                    break;
                case "3":
                    valor = Painel.Entrada("Novo sobrenome: ");
                    if (valor != null) {
                        pessoaAux.sobrenome = valor;
                    }
                    break;
                case "4":
                    valor = Painel.Entrada("Nova senha: ");
                    if (valor != null) {
                        pessoaAux.senha = valor;
                    }
                    break;
                case "5":
                    pessoa = pessoaAux;
                    sair = true;
                    break;
                case "6":
                    sair = true;
                    break;
            }
        }
        return pessoa;
    }

    private static void DadosPessoa() {
        while (Painel.SimOuNao(Menu.DadosCadastroPessoa(Globais.PessoaLogada) + "\nAlterar?", "Seus dados:")) {
            Globais.PessoaLogada = AtualizaPessoa(Globais.PessoaLogada);
            try {
                Arquivos.Pessoa.Atualizar(Globais.PessoaLogada);

            } catch (Exception e) {
                Painel.Erro(e.getMessage());
            }
        }
    }
}
