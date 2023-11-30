package Apresentacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controles.EstabelecimentoControl;
import Controles.FuncaoControl;
import Controles.Validacoes;
import Repositorio.Entidades.Funcao;
import Repositorio.Informacoes.FuncaoInfo;
import Utilidades.Array;
import Utilidades.Globais;

public class AcoesFuncao {
	public AcoesFuncao() {
		while (true) {
			Globais.Titulo = "Função";
			try {
				String op = Painel.Opcao(Menu.FUNCOES);
				switch (op) {
				case "1":
					Dados();
					break;
				case "2":
					if (Validacoes.EFuncionario()) {
						if (Validacoes.PodeEscluirFuncao()) {
							FuncaoControl.Deletar(Globais.Funcao);
							Globais.Funcao = null;
							return;
						}
					} else {
						Painel.Erro("Você não pode realizar essa ação;");
					}
					break;
				case "0":
				case "3":
					Globais.Funcao = null;
					return;
				}
			} catch (Exception e) {
				Painel.Erro(e.getMessage());
			}
		}
	}

	public static void Listar() throws Exception {

		if (Validacoes.EFuncionario())
			Manutencao();
		else
			Ver();
	}

	private static void Ver() throws Exception {

		do {
			Globais.Titulo = "Lista de funções";
			String[][] funcoes = BuscarFuncoes();
			int escolhido = Acoes.EscolherLista(funcoes, FuncaoInfo.CAMPOSVISIVEIS, "Funções");
			if (escolhido == -1)
				return;
			Acoes.VerLista(FuncaoInfo.CAMPOS, funcoes, FuncaoInfo.CAMPOSVISIVEIS, escolhido);
		} while (true);
	}

	public static void Manutencao() throws Exception {

		do {
			Globais.Titulo = "Lista de funções";
			String[][] funcoes = BuscarFuncoes();
			int escolhido = Acoes.ManutencaoLista(FuncaoInfo.CAMPOS, FuncaoInfo.GetListInfoArray(funcoes),
					FuncaoInfo.CAMPOSVISIVEIS, FuncaoInfo.CAMPOSIDENTIFICAR, "Função");

			switch (escolhido) {
			case 0:
				Cadastrar();
				break;
			case -1:
				return;
			default:
				Globais.Funcao = FuncaoInfo.GetEntity(funcoes[escolhido - 1]);
				new AcoesFuncao();
			}
		} while (true);
	}

	private static void Cadastrar() throws Exception {
		Globais.Titulo = "Cadastro de função";
		String[] funcao = new String[] { "", "_______________", "_______________", Globais.Estabelecimento.id };
		int[] campos = FuncaoInfo.CAMPOSEDITAVEIS;
		for (int i = 0; i < campos.length; i++) {
			funcao[campos[i]] = Painel.Entrada(Menu.TextoDadosEntidade(FuncaoInfo.CAMPOS, funcao, campos)
					+ "\nDigite o valor para " + FuncaoInfo.CAMPOS[campos[i]] + ": ");
			if (funcao[campos[i]] == null)
				return;
		}

		funcao = Acoes.VerAlterarCancelar(FuncaoInfo.CAMPOS, funcao, FuncaoInfo.CAMPOSEDITAVEIS,
				FuncaoInfo.CAMPOSEDITAVEIS);
		if (funcao == null)
			return;
		funcao[0] = FuncaoControl.Criar(FuncaoInfo.GetEntity(funcao)).funcao;
		funcao[0] = String.valueOf(Integer.parseInt(funcao[0]) - 1);
		EstabelecimentoControl.VincularFuncao(FuncaoInfo.GetEntity(funcao));
		Painel.Informar("Cadastro realizado!");
	}

	private static String[][] BuscarFuncoes() throws FileNotFoundException, IOException {
		String[] ids = Array.Lista(Globais.Estabelecimento.funcoes);
		String[][] funcoes = new String[ids.length][FuncaoInfo.TOTALCAMPOS];

		for (int i = 0; i < ids.length; i++) {
			funcoes[i] = FuncaoInfo.GetArray(Controles.FuncaoControl.Ler(ids[i]));
		}
		return funcoes;
	}

	private static void Dados() throws Exception {
		Globais.Titulo = "Informação da função";
		String[] funcaoInfoArray = FuncaoInfo.GetArray(Globais.Funcao);
		if (Validacoes.EFuncionario()) {
			funcaoInfoArray = Acoes.VerAlterar(FuncaoInfo.CAMPOS, funcaoInfoArray, FuncaoInfo.CAMPOSVISIVEIS,
					FuncaoInfo.CAMPOSEDITAVEIS);
			Funcao funcaoEntidade = FuncaoInfo.GetEntity(funcaoInfoArray);
			Controles.FuncaoControl.Atualizar(funcaoEntidade);
			Globais.Funcao = FuncaoInfo.Copiar(funcaoEntidade);
		} else {
			Acoes.Ver(FuncaoInfo.CAMPOS, funcaoInfoArray, FuncaoInfo.CAMPOSVISIVEIS);
		}
	}
}
