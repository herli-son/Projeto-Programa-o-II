package Apresentacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controles.EstabelecimentoControl;
import Controles.FuncaoControl;
import Controles.FuncionarioControl;
import Controles.PessoaControl;
import Controles.Validacoes;
import Repositorio.Entidades.Funcao;
import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.Pessoa;
import Repositorio.Informacoes.FuncaoInfo;
import Repositorio.Informacoes.FuncionarioInfo;
import Repositorio.Informacoes.PessoaInfo;
import Utilidades.Array;
import Utilidades.Globais;

public class AcoesFuncionario {
	
	public AcoesFuncionario()  {
		while (true) {
			try {
				String op = Painel.Opcao(Menu.FUNCIONARIO);
				switch (op) {
				case "1":
					Dados();
					break;
				case "2":
					// Avaliacoes();
					if(Validacoes.EFuncionario())
					Alterar();
					else
						Painel.Erro("Você não pode realizar essa ação.");
					break;
				case "3":
					AcoesAvaliacao.Recebidas("Funcionário", Globais.Funcionario.id);
					break;
				case "4":
					// Avaliacoes();
					if(Validacoes.EFuncionario()) {
					if(Validacoes.PodeDemitir()) {
						FuncionarioControl.Demitir(Globais.Funcionario);
						Globais.Funcionario = null;
						Painel.Informar("Funcionário demitido!");
						return;
					}}
					else
						Painel.Erro("Você não pode realizar essa ação.");
					break;
				case "0":
				case "5":
					Globais.Funcionario = null;
					return;
				}
			} catch (Exception e) {
				Painel.Erro(e.getMessage());
			}
		}
	}
	
	public static void Listar() throws Exception{
		
		if(Validacoes.EFuncionario())
			Manutencao();
		else
			Ver();
	}
	private static void Ver() throws Exception {
		
		do {
			String[][] funcionarios = FuncionarioInfo.GetListInfoArray(BuscarFuncionarios());
			int escolhido = Acoes.EscolherLista(funcionarios, FuncionarioInfo.CAMPOSVISIVEIS, "Funcionario");
			if(escolhido == -1) return;
			Acoes.VerLista(FuncionarioInfo.CAMPOS, funcionarios, FuncionarioInfo.CAMPOSVISIVEIS, escolhido);
		} while (true);
	}
	private static void Manutencao() throws Exception {
		do {
			String[][] funcionarios = BuscarFuncionarios();
 			int escolhido = Acoes.ManutencaoLista(FuncionarioInfo.CAMPOS, FuncionarioInfo.GetListInfoArray(funcionarios), FuncionarioInfo.CAMPOSVISIVEIS, FuncionarioInfo.CAMPOSVISIVEIS, "Funcionário");
			
			switch (escolhido) {
			case 0:
				Cadastrar(funcionarios);
				break;
			case -1:
				return;
			default:
				Globais.Funcionario = FuncionarioInfo.GetEntity(funcionarios[escolhido - 1]);
				new AcoesFuncionario();
			}
		} while (true);
	}

	private static void Cadastrar(String[][] funcionarios) throws Exception {
		String[] nomeFuncionario = new String[funcionarios.length];
		String[] f = Array.Lista(Globais.Estabelecimento.funcoes);
		Funcao[] funcoes = new Funcao[f.length];
		Funcionario funcionario = new Funcionario();
		
		for (int i = 0; i < nomeFuncionario.length; i++) {
			nomeFuncionario[i] = PessoaControl.Ler(funcionarios[i][1]).acesso;
		}
		
		for (int i = 0; i < f.length; i++) {
			funcoes[i] = FuncaoControl.Ler(f[i]);
		}
		
		Pessoa[] pessoas = PessoaControl.LerTodos(nomeFuncionario);
		
		if(pessoas.length == 0)
			throw new Exception("Não existem pessoas cadastradas para contratar.");
		
		int escolhido = Acoes.EscolherLista(PessoaInfo.GetListInfoArray(pessoas), PessoaInfo.CAMPOSIDENTIFICAR, "Pessoa");
		
		if(escolhido == -1) return;
		funcionario.pessoa = pessoas[escolhido].acesso;
		escolhido = Acoes.EscolherLista(FuncaoInfo.GetListInfoArray(funcoes), FuncaoInfo.CAMPOSIDENTIFICAR, "Função");
		funcionario.funcao = funcoes[escolhido].id;
		funcionario.estabelecimento = Globais.Estabelecimento.id;
		FuncionarioControl.Criar(funcionario);
		FuncionarioControl.Contratar(funcionario);
		EstabelecimentoControl.VincularPessoa(Globais.Estabelecimento, funcionario.pessoa);
	}

	public static String[][] BuscarFuncionarios() throws FileNotFoundException, IOException {
		String[] funcionariosVinculados = Array.Lista(Globais.Estabelecimento.funcionarios);
		String[][] funcionarios = new String[funcionariosVinculados.length][FuncionarioInfo.TOTALCAMPOS];

		for (int i = 0; i < funcionarios.length; i++) {
			funcionarios[i] = FuncionarioInfo.GetArray(FuncionarioControl.Ler(funcionariosVinculados[i]));
		}
		return funcionarios;
	}
	
	private static void Dados() throws Exception {
		String[] pessoa = PessoaInfo.GetInfoArray(PessoaControl.Ler(Globais.Funcionario.pessoa));
		String[] funcao = FuncaoInfo.GetArray(FuncaoControl.Ler(Globais.Funcionario.funcao));

		Acoes.Ver(Array.Concatena(PessoaInfo.CAMPOS, FuncaoInfo.CAMPOS), Array.Concatena(pessoa, funcao), new int[] {0, 1, 2, 5, 6});
	}
	private static void Alterar() throws Exception {
		String[] f = Array.Lista(Globais.Estabelecimento.funcoes);
		Funcao[] funcoes = new Funcao[f.length];
		for (int i = 0; i < f.length; i++) {
			funcoes[i] = FuncaoControl.Ler(f[i]);
		}
		int escolhido = Acoes.EscolherLista(FuncaoInfo.GetListInfoArray(funcoes), FuncaoInfo.CAMPOSIDENTIFICAR, "Nova função");
		if(escolhido == -1) return;
		Globais.Funcionario.funcao = funcoes[escolhido].id;
		FuncionarioControl.Atualizar(Globais.Funcionario);
	}
}
