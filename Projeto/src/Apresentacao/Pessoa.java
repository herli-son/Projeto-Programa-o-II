package Apresentacao;

import Servicos.Validacoes;
import Utilidades.Copiar;
import Utilidades.Globais;

/**
 *
 * @author herli
 */
public class Pessoa {
    
    public static void Pessoa(){
        while (true) {
            String op = Painel.Opcao(Menu.PESSOA);
            switch (op) {
                case "1":
                    Dados();
                    break;
                case "2":
                    Avaliacoes();
                    break;
                case "3":
                    Compras();
                    break;
                case "4":
                    //Lista de estabelecimentos vinculados à pessoa
                    break;
                case "5":
                    Painel.Informar("Em Desenvolvimento");
                    break;
                case "6":
                    Globais.PessoaLogada = null;
                    return;
            }
        }
    }
    
    public static void Acessar() {
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
    public static void Cadastrar() {
        Entidades.Pessoa pessoa = new Entidades.Pessoa();
        int op;

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
            
            do {                
                op = Painel.SimOuNaoOuCancelar(Menu.DadosCadastroPessoa(pessoa) + "\nAlterar alguma informação?", "Alterar cadastro?");
                
                if(op == 0) pessoa = Atualiza(pessoa);
                else if( op == 2) return;
                
            } while (op == 0);
            
        } while (!Validacoes.CadastroPessoa(pessoa));
        
        try {
            Servicos.Pessoa.Criar(pessoa);
            Painel.Informar("Cadastro realizado!");
        } catch (Exception e) {
            Painel.Erro(e.getMessage());
        }
    }
    private static Entidades.Pessoa Atualiza(Entidades.Pessoa pessoa) {
        Entidades.Pessoa pessoaAux = Copiar.Pessoa(pessoa);
        String valor;
        while (true) {
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
                    return pessoaAux;
                case "6":
                    return pessoa;
            }
        }
    }
    private static void Dados() {
        while (Painel.SimOuNao(Menu.DadosCadastroPessoa(Globais.PessoaLogada) + "\nAlterar?", "Seus dados:")) {
            Globais.PessoaLogada = Atualiza(Globais.PessoaLogada);
            try {
                Servicos.Pessoa.Atualizar(Globais.PessoaLogada);

            } catch (Exception e) {
                Painel.Erro(e.getMessage());
            }
        }
    }
    private static void Avaliacoes() {
        while (true) {
            String op = Painel.Opcao(Menu.AVALIACOES);
            switch (op) {
                case "1":
                    //Avaliações feitas a funcionários
                break;
                case "2":
                    //Avaliações feitas a estabelecimentos
                break;
                case "3":
                    //Avaliações feitas a produtos
                break;
                case "4":
                    //Avaliações feitas a serviçõs
                break;
                case "5":
                return;
            }
        }
    }
    
    private static void Compras() {
        while (true) {
            String op = Painel.Opcao(Menu.COMPRAS);
            switch (op) {
                case "1":
                    //Compras de produtos
                    break;
                case "2":
                    //Compras de Serviços
                    break;
                case "3":
                    return;
            }
        }
    }
}
