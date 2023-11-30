package Apresentacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controles.EstabelecimentoControl;
import Controles.Validacoes;
import Repositorio.Entidades.Estabelecimento;
import Repositorio.Informacoes.EstabelecimentoInfo;
import Utilidades.Globais;

public class AcoesEstabelecimento {

	public AcoesEstabelecimento() {
		while (true) {
			Globais.Titulo = "Estabelecimento";
			try {
				String op = Painel.Opcao(Menu.ESTABELECIMENTO);
				switch (op) {
				case "1":
					Dados();
					break;
				case "2":
					// Avaliaçoes
					AcoesAvaliacao.Recebidas("Estabelecimento", Globais.Estabelecimento.id);
					break;
				case "3":
					// Minhas Compras
					Painel.Informar("Em desenvolvimento");
					break;
				case "4":
					// Funcionarios
					AcoesFuncionario.Listar();
					break;
				case "5":
					// Funções
					AcoesFuncao.Listar();
					break;
				case "0":
				case "6":
					// Sair
					Globais.Estabelecimento = null;
					return;
				}
			} catch (Exception e) {
				Painel.Erro(e.getMessage());
			}
		}
	}

	public static String Cadastrar() throws Exception {
		Globais.Titulo = "Cadastro de estabelecimento";
		String[] estabelecimento = new String[] { "", "_______________", "_______________", "_______________",
				"_______________", "_______________" };
		int[] campos = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < campos.length; i++) {
			estabelecimento[campos[i]] = Painel
					.Entrada(Menu.TextoDadosEntidade(EstabelecimentoInfo.CAMPOS, estabelecimento, campos)
							+ "\nDigite o valor para " + EstabelecimentoInfo.CAMPOS[campos[i]] + ": ");
			if (estabelecimento[campos[i]] == null)
				return null;
		}
		do {
			estabelecimento = Acoes.VerAlterarCancelar(EstabelecimentoInfo.CAMPOS, estabelecimento, campos, campos);
			if (estabelecimento == null)
				return null;
		} while (!Validacoes.CadastroEstabelecimento(EstabelecimentoInfo.GetEntity(estabelecimento)));
		Controles.EstabelecimentoControl.Criar(EstabelecimentoInfo.GetEntity(estabelecimento));
		Painel.Informar("Cadastro realizado!");
		return estabelecimento[1];
	}

	private static void Dados() throws Exception {
		Globais.Titulo = "Dados do estabelecimento";
		String[] estabelecimentoArray = EstabelecimentoInfo.GetInfoArray(Globais.Estabelecimento);

		if (Validacoes.EFuncionario()) {
			estabelecimentoArray = Acoes.VerAlterar(EstabelecimentoInfo.CAMPOS, estabelecimentoArray,
					EstabelecimentoInfo.CAMPOSVISIVEIS, EstabelecimentoInfo.CAMPOSEDITAVEIS);
			Estabelecimento estabelecimentoEntidade = EstabelecimentoInfo.GetEntity(estabelecimentoArray,
					EstabelecimentoInfo.GetArray(Globais.Estabelecimento));
			Controles.EstabelecimentoControl.Atualizar(estabelecimentoEntidade);
			Globais.Estabelecimento = EstabelecimentoInfo.Copiar(estabelecimentoEntidade);
		} else {
			Acoes.Ver(EstabelecimentoInfo.CAMPOS, estabelecimentoArray, EstabelecimentoInfo.CAMPOSEDITAVEIS);
		}
	}

	public static void Listar() throws Exception {

		do {
			Globais.Titulo = "Lista de estabelecimentos do sistema";
			String[][] estabelecimentos = BuscarEstabelecimentos();
			int escolhido = Acoes.ManutencaoLista(EstabelecimentoInfo.CAMPOS,
					EstabelecimentoInfo.GetListInfoArray(estabelecimentos), EstabelecimentoInfo.CAMPOSVISIVEIS,
					EstabelecimentoInfo.CAMPOSIDENTIFICAR, "Estabelecimento");

			switch (escolhido) {
			case 0:
				Cadastrar();
				break;
			case -1:
				return;
			default:
				Globais.Estabelecimento = EstabelecimentoInfo.GetEntity(estabelecimentos[escolhido - 1]);
				new AcoesEstabelecimento();
			}
		} while (true);
	}

	private static String[][] BuscarEstabelecimentos() throws FileNotFoundException, IOException {
		Estabelecimento[] estab = EstabelecimentoControl.LerTodos();
		String[][] estabelecimentos = new String[estab.length][EstabelecimentoInfo.TOTALCAMPOS]; 
		
		for (int i = 0; i < estabelecimentos.length; i++) {
			estabelecimentos[i] = EstabelecimentoInfo.GetArray(estab[i]);
		}
		return estabelecimentos;
	}
}
