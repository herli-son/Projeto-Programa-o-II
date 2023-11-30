package Apresentacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controles.AvaliacaoControl;
import Controles.FuncionarioControl;
import Controles.PessoaControl;
import Controles.Validacoes;
import Repositorio.Entidades.Avaliacao;
import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.Pessoa;
import Repositorio.Informacoes.AvaliacaoInfo;
import Repositorio.Informacoes.FuncionarioInfo;
import Utilidades.Array;
import Utilidades.Globais;

public class AcoesAvaliacao {
	public AcoesAvaliacao() {
		while (true) {
			try {
				String op = Painel.Opcao(Menu.AVALIACAO);
				switch (op) {
				case "1":
					Dados();
					break;
				case "0":
				case "2":
					Globais.Avaliacao = null;
					return;
				}
			} catch (Exception e) {
				Painel.Erro(e.getMessage());
			}
		}
	}

	public static void Dados() throws Exception {
		String[] avaliacoesInfoArray = AvaliacaoInfo.GetArray(Globais.Avaliacao);
		avaliacoesInfoArray = Acoes.VerAlterar(AvaliacaoInfo.CAMPOS, avaliacoesInfoArray, AvaliacaoInfo.CAMPOSVISIVEIS,
				AvaliacaoInfo.CAMPOSEDITAVEIS);
		
		Avaliacao avaliacaoEntidade = AvaliacaoInfo.GetEntity(avaliacoesInfoArray);
		Globais.Avaliacao = AvaliacaoInfo.Copiar(avaliacaoEntidade);
		AvaliacaoControl.Atualizar(avaliacaoEntidade);
	}

	public static void Feitas() throws Exception {
		while (true) {
			String[][] avaliacoes = BuscarAvaliacoes();
			int escolhido = Acoes.ManutencaoLista(AvaliacaoInfo.CAMPOS, AvaliacaoInfo.GetListInfoArray(avaliacoes),
					AvaliacaoInfo.CAMPOSVISIVEIS, AvaliacaoInfo.CAMPOSIDENTIFICAR, "Avaliações");

			switch (escolhido) {
			case 0:
				Cadastrar();
				break;
			case -1:
				return;
			default:
				Globais.Avaliacao = AvaliacaoInfo.GetEntity(avaliacoes[escolhido - 1]);
				new AcoesAvaliacao();
			}
		}
	}

	public static void Recebidas(String tipo, String avaliado) throws Exception {

		String[][] dados = new String[0][0];

		switch (tipo) {
		case "Funcionário":
			Avaliacao[] avaliacoes;
			Funcionario func = FuncionarioControl.Ler(avaliado);
			String[] ava = Array.Lista(func.avaliacoes);
			avaliacoes = new Avaliacao[ava.length];
			for (int i = 0; i < ava.length; i++) {
				avaliacoes[i] = AvaliacaoControl.Ler(ava[i]);
			}
			dados = AvaliacaoInfo.GetListInfoArray(avaliacoes);
			break;
		}

		if (dados.length == 0) {
			Painel.Informar("Não existem avaliações feitas para " + tipo);
			return;
		}

		do {
			int escolhido = Acoes.EscolherLista(dados, AvaliacaoInfo.CAMPOSIDENTIFICAR, "Avaliação de " + tipo + ": ");
			if (escolhido == -1)
				return;
			Acoes.VerLista(AvaliacaoInfo.CAMPOS, dados, AvaliacaoInfo.CAMPOSVISIVEIS, escolhido);

		} while (true);

	}

	public static String[][] BuscarAvaliacoes() throws FileNotFoundException, IOException {
		String[] ids = Array.Lista(Globais.Pessoa.avaliacoes);
		String[][] avaliacoes = new String[ids.length][AvaliacaoInfo.TOTALCAMPOS];

		for (int i = 0; i < ids.length; i++) {
			avaliacoes[i] = AvaliacaoInfo.GetArray(AvaliacaoControl.Ler(ids[i]));
			switch (avaliacoes[i][2]) {
			case "Funcionário":
				
				Funcionario func = FuncionarioControl.Ler(avaliacoes[i][1]);
				Pessoa pess = PessoaControl.Ler(func.pessoa);
				avaliacoes[i][1] += " - " + pess.nome + " " + pess.sobrenome;
				break;
			}
		}
		return avaliacoes;
	}

	private static void Cadastrar() throws Exception {
		String op = Painel.Opcao(Menu.AVALIACOES);
		if (op.equals("0") || op.equals("5"))
			return;
		op = Menu.AVALIACOES[Integer.parseInt(op) - 1].substring(Menu.AVALIACOES[Integer.parseInt(op) - 1].indexOf('-') + 2,
				Menu.AVALIACOES[Integer.parseInt(op) - 1].length());

		String[] avaliacao = new String[] { "", "_______________", op, "_______________", "_______________" };
		int[] campos = AvaliacaoInfo.CAMPOSEDITAVEIS;

		do {

			switch (op) {
			case "Funcionário":

				Funcionario[] funcionarios = FuncionarioControl.LerTodos();
				int escolhido = Acoes.EscolherLista(FuncionarioInfo.GetListInfoArray(funcionarios),
						FuncionarioInfo.CAMPOSVISIVEIS, "Funcionário");
				if (escolhido == -1)
					return;
				avaliacao[1] = funcionarios[escolhido].id;
				break;
			}
		} while (!Validacoes.PodeAvaliar(AvaliacaoInfo.GetEntity(avaliacao)));

		for (int i = 0; i < campos.length; i++) {
			avaliacao[campos[i]] = Painel.Entrada(Menu.TextoDadosEntidade(AvaliacaoInfo.CAMPOS, avaliacao, campos)
					+ "\nDigite o valor para " + AvaliacaoInfo.CAMPOS[campos[i]] + ": ");
			if (avaliacao[campos[i]] == null)
				return;
		}
		avaliacao = Acoes.VerAlterarCancelar(AvaliacaoInfo.CAMPOS, avaliacao, AvaliacaoInfo.CAMPOSEDITAVEIS,
				AvaliacaoInfo.CAMPOSEDITAVEIS);
		if (avaliacao == null)
			return;

		AvaliacaoControl.Criar(AvaliacaoInfo.GetEntity(avaliacao));

		Painel.Informar("Avaliação feita!");
	}
}
